package mantras.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import mantras.usertask.UserTask;

/**
 * Servlet implementation class Uploadprofile
 */
@WebServlet("/Uploadprofile")
@MultipartConfig
public class Uploadprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserTask task;
	@Override
	public void init() throws ServletException
	{
		task=new UserTask();
	}
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uploadprofile() {
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
		HttpSession hs=request.getSession();
	String id=(String)hs.getAttribute("session_id");
	
	ServletContext sc=getServletContext();
	String path=sc.getRealPath("/");
	
	String newPath=path+id;
	System.out.println(newPath);
	
 File f=new File(newPath);
 if(!f.exists())
 {
	 f.mkdir();
 }
 
 
 Part p=request.getPart("profile");
  String filename=p.getSubmittedFileName();
  
  InputStream is=p.getInputStream();
  boolean status1=task.uploadprofile(f,is,filename);
  boolean status2=task.uploaddb(id,filename);
  if(status1 && status2)
  {
	  response.sendRedirect("/E-Living_Mantras/user/userprofile.jsp");
  }
  
  
  
  
 
 
 
		
	}

}
