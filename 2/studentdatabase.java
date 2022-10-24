import java.sql.*;
import java.util.Scanner;

public class studentdatabase {
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/310lab-2", "root", "dbms21sql21tafa21");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    PreparedStatement preparedStatement;
    Scanner sc = new Scanner(System.in);


    public void StudentDatabase() {
        try {
            System.out.println("Enter name:");
            String name = sc.nextLine();
            System.out.println("Enter sid:");
            String sid = sc.nextLine();
            System.out.println("Enter email:");
            String email = sc.nextLine();
            System.out.println("Enter password:");
            String password = sc.nextLine();

            String query = "insert into studentdatatable(name, sid,email,password) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, sid);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validinfo(String email, String password) {
        boolean bc = false;
        try {
            String query = "select  email, password from studentdatatable ";

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {

                    String Email = rs.getString("email");
                    String pass = rs.getString("password");

                    if (email.equals(Email) && password.equals(pass)) {
                        System.out.println("student log in successful");
                    }
                    bc = true;

                }
            } else {
                System.out.println("Wrong Credentials");
                bc = false;


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bc;
    }
}





