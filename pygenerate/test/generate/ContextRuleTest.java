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
public class ContextRuleTest {
    
    public ContextRuleTest() {
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
     * Test of addExpansion method, of class ContextRule.
     */
    @Test
    public void testAddExpansion_String() {
        System.out.println("addExpansion");
        String expansion = "B";
        ContextRule instance = new ContextRule("A");
        instance.addExpansion(expansion);
    }

    /**
     * Test of addExpansion method, of class ContextRule.
     */
    @Test
    public void testAddExpansion_String_float() {
        System.out.println("addExpansion");
        String expansion = "B";
        float weight = 99.0F;
        ContextRule instance = new ContextRule("A");
        instance.addExpansion(expansion, weight);
    }

    /**
     * Test of getRandomExpansion method, of class ContextRule.
     */
    @Test
    public void testGetRandomExpansion() {
        System.out.println("getRandomExpansion");
        ContextRule instance = new ContextRule("A");
        instance.addExpansion("B", 0.01f);
        instance.addExpansion("C", 0.99f);
        instance.addExpansion("D", 0.01f);
        instance.addExpansion("E", 0.01f);
        instance.addExpansion("F", 0.01f);
        instance.addExpansion("G", 10.01f); // heavyweight
        String expResult = "G";
        String result = instance.getRandomExpansion();
        assertEquals(expResult, result);
    }

    /**
     * Test of dump method, of class ContextRule.
     */
    @Test
    public void testDump() {
        System.out.println("dump");
        ContextRule instance = new ContextRule("A");
        instance.addExpansion("B", 0.01f);
        instance.addExpansion("C", 0.99f);
        instance.addExpansion("D", 0.01f);
        instance.addExpansion("E", 0.01f);
        instance.addExpansion("F", 0.01f);
        instance.addExpansion("G", 10.01f); // heavyweight
        instance.dump();

    }
}
