package resources;

/**
 *
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */

import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.out;

/**
 *
 * @author javier
 */
public class Connection {
    private final String driver;
    private final String port;
    private final String user;
    private final String password;
    private final String db;
    private java.sql.Connection con;
    
    private boolean connect() {
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(port, user, password);
            return true;
        } catch (ClassNotFoundException | SQLException e){
            out.println(e.getMessage());
            return false;
        }
    }
    
    public Connection() {
        this.driver = "org.postgresql.Driver";
        this.db = "laboratorio";
        this.port = "jdbc:postgresql://localhost:5432/"+this.db;
        this.user = "root";
        this.password = "root";
        if (this.connect()) out.println("Connected Successfully");
        else out.println("Failed to connect");
    }
    
    public java.sql.Connection getCon() {
        return this.con;
    }
}
