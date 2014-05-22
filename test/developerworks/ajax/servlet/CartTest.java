/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package developerworks.ajax.servlet;

import developerworks.ajax.store.Cart;
import developerworks.ajax.store.Catalog;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ChibeePatag
 */
public class CartTest {
    
    public CartTest() {
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

     @Test
     public void toJSon() {
         Cart cart = new Cart();
         cart.addItem("cha001");
         cart.addItem("dog001");
         cart.addItem("dog001");
         
         
         String expected = "{\"cart\": {\"generated\" : \"1390447876796\",\"total\" : \"$209.97\",\"item\" : [{\"code\" : \"cha001\",\"name\" : \"Chair\",\"quantity\" : \"1\",\"price\" : \"$49.99\"},{\"code\" : \"dog001\",\"name\" : \"Dog\",\"quantity\" : \"2\",\"price\" : \"$159.98\"}]}}";
         System.out.println("Expected" + expected);
         System.out.println("Actual" + cart.toJSon());
         assertEquals("Generated the correct JSON", expected, cart.toJSon());
         
     }
}
