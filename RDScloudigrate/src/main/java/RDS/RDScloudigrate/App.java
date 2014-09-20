package RDS.RDScloudigrate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 

{
	
	private static String connectionString = "jdbc:mysql://rds.cnnmp1jopl3g.us-west-1.rds.amazonaws.com:3306/RDS";
	private static String dbUsername = "sumantmurke";
	private static String dbPassword = "mypassword";
	
    public static void main( String[] args )
    {
    	
        System.out.println( "Wellcome to Amazon RDS" );
        String query;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(connectionString, dbUsername, dbPassword);
            Statement stmt = (Statement) con.createStatement();
            String username = "sumant";
			String password = "password";
			
			query = "SELECT username, password FROM Login WHERE username='" + username + "' AND password='" + password + "';";
            System.out.println("username : "+username+" pwd : "+password);
            stmt.executeQuery(query);
            
            ResultSet rs = stmt.getResultSet();
            rs.beforeFirst();
            
            while(rs.next())
            {
            	System.out.println("User :"+ rs.getString("USERNAME") + " Password :"+ rs.getString("PASSWORD"));
            }
            	
            
            
           // login = rs.first(); //rs.first();
            con.close();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     
        
    }
}
