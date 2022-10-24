import java.sql.*;
import java.util.Scanner;

public class sectiondatabase {
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

    public void sectionDetails(String name, String sid, int section)  {
        try{
            String query = "select count from studentdatatable where name = name, sid = sid";
            preparedStatement = connection.prepareStatement(query);
            int count = preparedStatement.executeUpdate();
            if (count == 9)
                System.out.println("There are no seats remaining.");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    }

