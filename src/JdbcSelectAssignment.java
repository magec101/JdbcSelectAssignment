import java.sql.*;

/**
 * Main class
 */
public class JdbcSelectAssignment {
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://54.160.179.255/ashoknair7";

    // Database credentials
    static final String USER = "ashoknair7";
    static final String PASS = "ilimi123";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try{
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT emp_id, first_name, last_name, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 4: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("emp_id");
                int age = rs.getInt("age");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First Name: " + first);
                System.out.println(", Last Name: " + last);
            }

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            
            //finally block used to close resources
            try{
                if(stmt!=null) {
                    stmt.close();
                    conn.close();
                }
            } catch(SQLException se2) {
                // nothing we can do
            }
        }

        System.out.println("Goodbye!");
        System.exit(0);
    }
}

