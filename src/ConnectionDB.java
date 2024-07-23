import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private Connection connect_to_db;


    public java.sql.Connection connect_to_db(String dbname, String user, String pass) {
        java.sql.Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);

            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }



        return conn;


    }
    public ConnectionDB() {

    }

}

