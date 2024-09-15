
package Backend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String id, pw;
            id = request.getParameter("customerID");
            pw = request.getParameter("password");
            
            System.out.println("ID = " + id);
            System.out.println("Password = " + pw);
            
                CustomerDataModel customer = new CustomerDataModel();
                customer.Read(Integer.parseInt(id));
            
                if(customer.getCustID() < 1 && 
                    (!customer.getPassword().equals(pw))){
                    RequestDispatcher rd = request.getRequestDispatcher("/ErrorLogin.jsp");
                    rd.forward(request, response);
                    }
                else{                   
                    HttpSession ses1;
                    ses1 = request.getSession();
                    ses1.setAttribute("customer", customer);

                    RequestDispatcher rd = request.getRequestDispatcher("/CustomerAccountView.jsp");
                    rd.forward(request, response); 
                }
            //get an instance of the customer data object (new)
            //call get customer method 
            //put the customer on the session object 
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
