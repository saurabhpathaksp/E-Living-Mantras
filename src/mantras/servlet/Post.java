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

import mantras.experttask.ExpertTask;

/**
 * Servlet implementation class Post
 */
@WebServlet("/Post")
@MultipartConfig
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ExpertTask task;
	@Override

	public void init() throws ServletException
	{
	task=new ExpertTask();	
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Post() {
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
		HttpSession hs=request.getSession(false);
		String id=(String)hs.getAttribute("session_id");
		
		ServletContext sc=getServletContext();
		String projectPath=sc.getRealPath("/");
		
		String newPath=projectPath+"videos";
		System.out.println(newPath);
		
		File f=new File(newPath);
		if(!f.exists())
		{
			f.mkdir();
		}
				
		Part p=request.getPart("file");
	String filename=	p.getSubmittedFileName();
	InputStream is=p.getInputStream();
		
		
		String desc=request.getParameter("desc");
		String caption=request.getParameter("caption");
		
	boolean s1=	task.uploadDoc(is,f,filename);
	boolean s2=task.uploadDb(id,filename,desc,caption);
	
	if(s1 && s2)
	{
		response.sendRedirect("/E-Living_Mantras/expert/experthome.jsp");
	}
		
		
		
		
		
	}

}
