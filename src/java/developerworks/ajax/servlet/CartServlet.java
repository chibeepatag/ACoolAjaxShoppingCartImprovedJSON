
package developerworks.ajax.servlet;

import developerworks.ajax.store.Cart;
import java.io.IOException;
import javax.servlet.http.*;

import java.util.Enumeration;

/**
 *
 * @author ChibeePatag
 */
public class CartServlet extends HttpServlet {

  /**
   * Updates Cart, and outputs XML representation of contents
   * @param req
   * @param res
   * @throws java.io.IOException
   */
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws java.io.IOException {

    Enumeration headers = req.getHeaderNames();
    while (headers.hasMoreElements()) {
      String header  =(String) headers.nextElement();
      System.out.println(header+": "+req.getHeader(header));
    }

    Cart cart = getCartFromSession(req);

    String action = req.getParameter("action");
    String item = req.getParameter("item");
    
    if ((action != null)) {

      if ("add".equals(action)) {
        cart.addItem(item);

      } else if ("remove".equals(action)) {
        cart.removeItem(item);

      } else if("clearCart".equals(action)){
          removeCartFromSession(req);
          cart = new Cart();
      }
    }

    String cartJSon = cart.toJSon();
    res.setContentType("application/json");
    res.getWriter().write(cartJSon);
  }

    /**
     * Receives get requests and processes it through the post method.
     * @param req
     * @param res
     * @throws IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws java.io.IOException {
    // Bounce to post, for debugging use
    // Hit this servlet directly from the browser to see XML
    doPost(req,res);
  }

  /**
   * This method gets the shopping cart from the session.
   * @param req The HttpServletRequest
   */
  private Cart getCartFromSession(HttpServletRequest req) {

    HttpSession session = req.getSession(true);
    Cart cart = (Cart)session.getAttribute("cart");
   
    if (cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }

    return cart;
 }


private void removeCartFromSession(HttpServletRequest req){
    HttpSession session = req.getSession(true);
    session.removeAttribute("cart");  
}
}