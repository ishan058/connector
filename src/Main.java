import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/user";
        Connection conn = DriverManager.getConnection(url,"root", "root");
        System.out.println("connection success");

        //Fetch data from the database;
//        Statement statement = conn.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * from user WHERE id + 1");
////        System.out.println(resultSet);

        //Prepare statement
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from user WHERE pid =? OR address=?");
        preparedStatement.setInt(1,10);
        preparedStatement.setString(2,"CHITWAN");


        ResultSet resultSet = preparedStatement.executeQuery();


        while(resultSet.next()){
            System.out.println(resultSet.getInt("pid") + " ");
            System.out.println(resultSet.getString("name"));
            System.out.println(" ");
            System.out.println(resultSet.getString("address"));
            System.out.println("\n");
        }
    }
}