import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DatabaseFunc {
        public User user;
        public void createTable(Connection conn, String table_name){
            Statement statement;
            try{
                String query="create table "+table_name+"(empid SERIAL,name varchar(200),address varchar(200),primary key(empid));";
                statement=conn.createStatement();
                statement.executeUpdate(query);
                System.out.println("Table Created");
            }catch (Exception e){
                System.out.println(e);
            }
        }
    Connection conn = new ConnectionDB().connect_to_db("postgres", "postgres", "Admin");
    public void insert_row(String table_name,String name, String address, String phone, String email, String password){
        Statement statement;

        try {
            String query=String.format("insert into %s(name, address, phone, email, password) values('%s','%s','%s','%s','%s');",table_name, name, address, phone, email, password);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void select_query(String table_name, String email, String password){
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("SELECT * FROM %s WHERE email=email and email='%s' and password=password and password='%s' ", table_name, email, password);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            if (rs.next()){
                System.out.println("Logged");
                System.out.println(rs.getString("id")+" "+(" "));
                System.out.println(rs.getString("name")+" "+(" "));
                System.out.println(rs.getString("address")+" "+(" "));
                System.out.println(rs.getString("phone")+" "+(" "));


                JOptionPane.showMessageDialog(null,"Logged in Successfully","Success!",
                        JOptionPane.INFORMATION_MESSAGE);

                this.user = new User();
            }

            else{
                System.out.println("No user Found");
                JOptionPane.showMessageDialog(null, "Invalid email or password",
                        "Try Again",
                        JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e){
            System.out.println(e);

        }

    }
}