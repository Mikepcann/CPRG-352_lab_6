package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get Htttp session variable
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = (String) session.getAttribute("username");

        // no username in session
        if (username == null || username.equals("")) {
            // send user to register page
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        // logout action requested
        } else if (action.equals("logout")) {
            // invalidate the session and send to register page
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        // if they have a user name, send them to the shopping list page
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

//        if(action.equals("register")){
//            username = request.getParameter("username");
//            System.out.println(username + ": The user name <=");
//            System.out.println(action + ": The action <=");
//            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
//            return;
//        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String usernameSSN = (String) session.getAttribute("username");
        String usernameLocal = request.getParameter("username");

        if (action.equals("register") && (usernameLocal != null || !usernameLocal.equals(""))) {
            //fetch the username from the form
            
            System.out.println(usernameLocal);
            session.setAttribute("username", usernameLocal);

            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

        if (usernameSSN == null || usernameSSN.equals("")) {
            // send user to registerpage
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
    }
}
