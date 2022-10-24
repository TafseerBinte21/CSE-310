import java.sql.*;
import java.util.Scanner;

public class facultydatabase {
    Connection connection;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/310lab-2", "root", "dbms21sql21tafa21");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    PreparedStatement preparedStatement ;
    Scanner sc = new Scanner(System.in);



    public void FacultyDatabase() {
        try{
            System.out.println("Enter name:");
            String name = sc.nextLine();
            System.out.println("Enter email:");
            String email = sc.nextLine();
            System.out.println("Enter password:");
            String password = sc.nextLine();
            String query = "insert into faculty(name,email,password) values(?,?,?)" ;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

