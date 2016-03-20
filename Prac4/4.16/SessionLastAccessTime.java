

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class SessionLastAccessTime extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 


	{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	out.println("Checking the session:");
	HttpSession session1 = req.getSession(false);
	if(session1 == null)
	{
		out.println("Session does not exists:");
		session1 = req.getSession();
		out.println("Created new session:");
	}
	else
	{
		out.println("Your Session is alredy Exist:");
	}
	}


}
