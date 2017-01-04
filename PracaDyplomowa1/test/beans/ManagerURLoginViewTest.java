/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcin
 */
public class ManagerURLoginViewTest {
    
    public ManagerURLoginViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of pageoperator method, of class ManagerURLoginView.
     */
    @Test
    public void testPageoperator() {
        System.out.println("pageoperator");
        ManagerURLoginView instance = new ManagerURLoginView();
        String expResult = "";
        String result = instance.pageoperator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class ManagerURLoginView.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        ActionEvent e = null;
        ManagerURLoginView instance = new ManagerURLoginView();
        String expResult = "";
        String result = instance.login(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
