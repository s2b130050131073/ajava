                                           //Practical: 3.6
//Aim: Consider Bank Table with attributes AccountNo, Customer Name, Balance, Phone and Address. Write a JDBC Program which allows insertion, updation and deletion of record in Bank Table. Print values of all customers whose balance is greater then specified amount.
//Program code:
//STEP 1. Import required packages
import java.sql.*;
import java.util.*;
publicclass bankinfo {

// JDBC driver name and database URL
staticfinal String JDBC_DRIVER ="org.postgresql.Driver";
staticfinal String DB_URL ="jdbc:postgresql://127.0.0.1:5432/s2b1073";

//  Database credentials
staticfinal String USER ="postgres";
staticfinal String PASS ="12345";

publicstaticvoid main(String[] args){
   Connection con =null;

   PreparedStatement stmt =null;
   Statement stmt1 =null;
 Double ph,acno;
        String name,add;
        Double bal;
int i=0;

try{
//STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

//STEP 3: Open a connnection
      System.out.println(" \n Connecting to a  s2b1073 database");
      con = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully");


       Scanner sc=new Scanner(System.in);
while(i!=1){
                System.out.println("\n Enter the operation to be performed:\n \t1.Insert \n \t 2.Update \n \t 3.Delete\n \t4. display values of all customers whose balance is greater then    \n \t5.Exit");
int ch=sc.nextInt();

switch(ch){

case1:
                        stmt=con.prepareStatement("insert into Bank values(?,?,?,?,?)");
                        System.out.print("Enter Account No:");
                        acno=sc.nextDouble();
                        System.out.print("Enter Customer Name:");
                        name=sc.next();
                        System.out.print("Enter balance:");
                        bal=sc.nextDouble();
                        System.out.print("Enter Phone No:");
                        ph=sc.nextDouble();
                        System.out.print("Enter Address:");
                        add=sc.next();
                        stmt.setDouble(1,acno);
                        stmt.setString(2,name);
                        stmt.setDouble(3,bal);
                        stmt.setDouble(4,ph);
                        stmt.setString(5,add);
                        stmt.executeUpdate();
                        System.out.println("Data inserted successfully.");
break;

case2:
                        stmt=con.prepareStatement("update Bank set balance=? where acc_no= ?");
                        System.out.print("Enter Account No:");
                        acno=sc.nextDouble();
                        System.out.print("Enter balance:");
                        bal=sc.nextDouble();
                        stmt.setDouble(2,acno);
                        stmt.setDouble(1,bal);
                        stmt.executeUpdate();
                        System.out.print("Data Updated successfully");
break;
case3:
                        stmt=con.prepareStatement("delete from Bank where acc_no=?");
                        System.out.print("Enter Account No:");
                        acno=sc.nextDouble();
                        stmt.setDouble(1,acno);
                        stmt.executeUpdate();
                        System.out.println("Data Deleted successfully");
break;
case4:
System.out.println("enter amount ");
int Amount = sc.nextInt();
            stmt1 = con.createStatement();
String sql ="select * from bank where balance > "+Amount+"";
            stmt1.executeQuery(sql);
            ResultSet rs = stmt1.executeQuery(sql);

while(rs.next())
{
            acno=rs.getDouble("acc_no");
            name=rs.getString("name");
            bal=rs.getDouble("balance");
            ph=rs.getDouble("ph_no");
            System.out.println("Account number:"+acno);
            System.out.println("Account Name:"+name );
            System.out.println("Account Balance:"+bal);
            System.out.println("Contact Number:"+ph);
            System.out.println();
}
break;

case5:
i=1;
break;

default:
System.out.println("Invalid choice");
break;
}
}
}catch(SQLException se){
//Handle errors for JDBC
      se.printStackTrace();
}catch(Exception e){
//Handle errors for Class.forName
      e.printStackTrace();
}finally{
//finally block used to close resources
try{
if(stmt!=null)
            con.close();
}catch(SQLException se){
}// do nothing
try{
if(con!=null)
            con.close();
}catch(SQLException se){
         se.printStackTrace();
}//end finally try
}//end try
   System.out.println("program completed");
}//end main
}//end

