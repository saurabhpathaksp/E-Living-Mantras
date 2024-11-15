package mantras.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mantras.beans.FeedBack_Bean;
import mantras.usertask.UserTask;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserTask task;
	@Override
	public void init() throws ServletException {
		task=new UserTask();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String feedback=request.getParameter("feedback");
		String expertid=request.getParameter("expertid");
		
		Calendar c=Calendar.getInstance();
		int a=c.get(Calendar.DATE);
		int b=c.get(Calendar.MONTH);
		int y=c.get(Calendar.YEAR);
		
		String date=a+"-"+b+"-"+y;
		
		FeedBack_Bean fb=new FeedBack_Bean(userid, expertid, feedback, date);
		boolean status=task.feedback(fb);
		if(status)
		{
			response.sendRedirect("/E-Living_Mantras/user/allexperts.jsp");
		}
		
	}

}
