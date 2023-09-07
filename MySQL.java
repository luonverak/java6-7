
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL {
    
    Connection connection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java6-7", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
