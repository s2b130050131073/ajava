import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Leftjoin")
public class Leftjoin extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws IOException, ServletException
{
res.setContentType("text/html");
PrintWriter pw = res.getWriter();
Connection con;
PreparedStatement ps;
ResultSet rs;
String url="jdbc:mysql://localhost:3306/jdbc";
String un="root";
String password="vaishali";
try
{
	Class.forName("com.mysql.jdbc.Driver");
    System.out.println("driver is loaded");
    con=DriverManager.getConnection(url,un,password);
    System.out.println("connected");
    System.out.println("wrapper created");
    ps = con.prepareStatement("SELECT * FROM studentdata NATURAL JOIN account");
rs = ps.executeQuery();
pw.println("<table border=1><tr>");
pw.println("<td>stu_rollno</td>");
pw.println("<td>stu_Name</td>");
pw.println("<td>stu_branch</td>");
pw.println("<td>acc_no</td>");
pw.println("<td>balance</td>");
pw.println("</tr>");
pw.println("</table>");
while(rs.next())
{
Integer stu_rollno = rs.getInt("rollno");
String stu_Name = rs.getString("name");
String stu_branch = rs.getString("branch");
Integer acc_no = rs.getInt("acc_no");
Integer balance = rs.getInt("balance");
pw.println("<table border=1><tr>");
pw.println("<td>"+stu_rollno+"</td>");
pw.println("<td>"+stu_Name+"</td>");
pw.println("<td>"+stu_branch+"</td>");
pw.println("<td>"+acc_no+"</td>");
pw.println("<td >"+balance+"</td>");
pw.println("</tr>");
pw.println("</table>");
}
try
{
con.close();
ps.close();
}
catch(Exception e)
{
pw.println(e);
}
}
catch(SQLException sx)
{
pw.println(sx);
}
catch(ClassNotFoundException cx)
{
pw.println(cx);
}
}
}