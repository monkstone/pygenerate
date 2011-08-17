/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sid
 */
public class ContextFreeTest {
    
    public ContextFreeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addRule method, of class ContextFree.
     */
    @Test
    public void testAddRule_String_String() {
        System.out.println("addRule");
        String rule = "Square";
        String expansion = "Square scale square";
        ContextFree instance = new ContextFree();
        instance.addRule(rule, expansion);
    }

    /**
     * Test of addRule method, of class ContextFree.
     */
    @Test
    public void testAddRule_3args() {
        System.out.println("addRule");
        String rule = "Square";
        String expansion = "Square scale square";
        float weight = 0.5F;
        ContextFree instance = new ContextFree();
        instance.addRule(rule, expansion, weight);
    }

    /**
     * Test of expand method, of class ContextFree.
     */
    @Test
    public void testExpand() {
        System.out.println("expand");
        String rule = "Square";
        String expansion = "Square scale square";
        float weight = 0.5F;
        ContextFree instance = new ContextFree();
        instance.addRule(rule, expansion, weight);
        instance.expand(rule);
    }

    /**
     * Test of setMaxRecursion method, of class ContextFree.
     */
    @Test
    public void testSetMaxRecursion() {
        System.out.println("setMaxRecursion");
        int max = 20;
        ContextFree instance = new ContextFree();
        instance.setMaxRecursion(max);
    }

    /**
     * Test of dump method, of class ContextFree.
     */
    @Test
    public void testDump() {
        System.out.println("dump");
        String rule = "Square";
        String expansion = "Square scale square";
        ContextFree instance = new ContextFree();
        instance.addRule(rule, expansion);
        instance.dump();
    }

    /**
     * Test of renderExpansion method, of class ContextFree.
     */
    @Test
    public void testRenderExpansion() {
        System.out.println("renderExpansion");
        String rule = "Square";
        String expansion = "Square scale square";
        ContextFree instance = new ContextFree();
        instance.addRule(rule, expansion);
        instance.renderExpansion(rule);
    }
}
