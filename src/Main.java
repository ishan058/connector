import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/user";
        Connection conn = DriverManager.getConnection(url,"root", "root");
        System.out.println("connection success");

        //Patch data from the database;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from user");
        System.out.println(resultSet);

        while(resultSet.next()){
            System.out.println(resultSet.getInt("id") + "");
            System.out.println(resultSet.getString("name"));
            System.out.println(" ");
            System.out.println(resultSet.getString("address"));
            System.out.println("\n");
        }
    }
}