package mantras.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mantra.commontask.LoginTask;
import mantras.beans.Login_Credentials;
import mantras.beans.Message;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("uname");
		String pass=request.getParameter("upass");
		
		
		String userinfo=name+"#"+pass;
		Cookie cookie=new Cookie("info", userinfo);
		cookie.setMaxAge(60*60*24*365);
		response.addCookie(cookie);
		
		
		
		System.out.println(name+pass);
		Login_Credentials lc=new Login_Credentials();
		lc.setId(name);
		lc.setPassword(pass);
		
		
		LoginTask task=new LoginTask();
		String type=task.login(lc);
		
		
		
		System.out.println(type);
		if(!type.equalsIgnoreCase("invalid")) 
		{
		HttpSession hs=request.getSession();
		System.out.println(hs.getId());
		hs.setAttribute("session_id", lc.getId());
		hs.setAttribute("role", type);
		
		if(type.equalsIgnoreCase("admin"))
		{
			response.sendRedirect("/E-Living_Mantras/admin/adminhome.jsp");
		}
		else if(type.equalsIgnoreCase("user")) 
		{
			response.sendRedirect("/E-Living_Mantras/user/userhome.jsp");
		}
		else if(type.equalsIgnoreCase("yogaexpert")) 
		{
			response.sendRedirect("/E-Living_Mantras/expert/experthome.jsp");
		}
		else if(type.equalsIgnoreCase("dietician"))
		{
			response.sendRedirect("");
		}
		
		}
		else {
			request.setAttribute("msg", Message.LOGIN_ERROR);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/index.jsp");
		    dispatcher.forward(request, response);
		}
	}

}

