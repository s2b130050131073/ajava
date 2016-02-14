
                                    //PRACTICLE 3.5

import java.sql.*;

public class usingProcedure {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/s2b1073";


   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "12345";

   public static void main(String[] args) {
   Connection conn = null;
   CallableStatement cStmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");

      //STEP 4: Execute a query
        System.out.println("Enrollno: 130050131073");
                  cStmt = conn.prepareCall("{call student1()}");
              cStmt.execute();

              System.out.println("Selected Data is:");
              System.out.println();

              ResultSet rs = cStmt.getResultSet();
              System.out.print("id:");
              System.out.print("Name:");
              System.out.print("Branch:");

              while (rs.next())
              {
                System.out.println();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.println();
              } 
           cStmt.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources

      try{
         if(cStmt!=null)
            conn.close();
             cStmt.close();

      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("program completed");
}//end main
}//end


Procedure:
-- Function: student1()

-- DROP FUNCTION student1();

CREATE OR REPLACE FUNCTION student1()
  RETURNS TABLE(id integer, name character varying, branch character varying) AS
$BODY$
DECLARE

BEGIN
RETURN QUERY
   SELECT * FROM student
    WHERE student.branch='CSE';
    RETURN;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION student1()
  OWNER TO postgres;

