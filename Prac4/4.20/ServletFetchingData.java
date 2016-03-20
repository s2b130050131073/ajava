import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
@WebServlet("/ServletFetchingData")
public class ServletFetchingData extends HttpServlet
{
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    String url="jdbc:mysql://localhost:3306/jdbc";
    String un="root";
    String password="pooja";
    String tn="",tp="";
    public void init(ServletConfig sc)throws ServletException
    {
        super.init(sc);
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver is loaded");
        con=DriverManager.getConnection(url,un,password);
        System.out.println("connected");
        stmt=con.createStatement();
        System.out.println("wrapper created");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("driver Not Loaded"+cnfe.getMessage());
            return;
        }
        catch(SQLException sqle)
        {
            System.out.println("connection problem"+sqle.getMessage());
            return;
        }
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        doPost(req,res);
    }
     public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<html>");
        out.println("<body><table border='1'>");
        out.println("<th>name</th>");
        out.println("<th>password</th>");
        try
        {
            rs=stmt.executeQuery("select *from emp1");
            while(rs.next())
            {
                tn=rs.getString("name");
                tp=rs.getString("password");
                out.println("<tr>");
                out.println("<td>"+tn+"</td>");
                out.println("<td>"+tp+"</td>");
                out.println("</tr>");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        out.println("</table></body></html>");
    }
}
