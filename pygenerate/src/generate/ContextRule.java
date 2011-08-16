package generate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ContextRule {

    private Map<String, Float> weighting;
    private String rule;
    /**
     * Note using new diamond operator, implies inferred generic types  
     * @param rule_ 
     */
    public ContextRule(String rule_) {
        weighting = new HashMap<>();
        rule = rule_;
    }

    public void addExpansion(String expansion) {
        weighting.put(expansion, 1.0f);
    }

    public void addExpansion(String expansion, float weight) {
        weighting.put(expansion, weight);
    }

    public String getRandomExpansion() {
        String result = null;
        Map<String, Float> temp = weighting;
        Collection<Float> values = temp.values();
        Iterator<Float> it = values.iterator();
        float total = 0;
        double p = Math.random();
        while (it.hasNext()) {
            total += it.next();
        }
        for (Map.Entry entry : temp.entrySet()) {
            if (p < (Float) entry.getValue() / total) {
                result = (String) entry.getKey();
                break;
            } else {
                p -= (Float) entry.getValue() / total;
            }
        }
        return result;
    }

    public void dump() {
        System.out.print(rule + " ->\n");
        for (String rle : weighting.keySet()) {
            System.out.println('\t' + rle);
        }
    }
}
