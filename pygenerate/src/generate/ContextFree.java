package generate;

import java.util.HashMap;

/**
 * 
 * @author Martin Prout after
 */

public class ContextFree {

    private HashMap<String, ContextRule> rules;
    private int max = 100;
    static int recursion = 0;

    /**
     * Duplicate rules are all weighted, either explicitly or with a default 
     * weight of 1.0f, however actual weighting depends on the total weighting.
     * See the  ContextRule class.
     */

    public ContextFree() {
        rules = new HashMap<>();
    }

    public void addRule(String rule, String expansion) {
        addRule(rule, expansion, 1.0f);
    }
    
    /**
     * Supports rule weighting (default weighting 1.0f)
     * @param rule
     * @param expansion
     * @param weight 
     */

    public void addRule(String rule, String expansion, float weight) {
        if (rules.containsKey(rule)) {
            ContextRule cr = rules.get(rule);
            cr.addExpansion(expansion, weight);
        } else {
            ContextRule cr = new ContextRule(rule);
            cr.addExpansion(expansion, weight);
            rules.put(rule, cr);
        }
    }
    
    /**
     * An absolute recursion limit of 100, or whatever value is set by
     * setMaxRecursion method
     * @param current String for expansion
     */

    public void expand(String current) {
        if (!rules.containsKey(current)) {
            renderExpansion(current);   // output
        } else {
            recursion++;
            ContextRule cr = rules.get(current);
            String[] toExpand = cr.getRandomExpansion().split(" ");
            if (recursion <= max) {
                for (String s : toExpand) {
                    expand(s);
                }
            } else {
                rules.remove(current);
            }
        }
    }
    
    /**
     * Set a different max recursion value (from 100)
     * @param max 
     */
    public void setMaxRecursion(int max){
        this.max = max;
    }
    
    /**
     * dump rules as human readable String to standard out
     */

    public void dump() {
        for (String rule : rules.keySet()) {
            ContextRule cr = rules.get(rule);
            cr.dump();
        }
    }

    // override this function in your derived class for custom behavior
    public void renderExpansion(String s) {
        System.out.print(s + " ");
    }
}
