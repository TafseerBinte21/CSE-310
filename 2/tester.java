import java.sql.*;
import java.util.Scanner;

public class tester {

    public static void main(String[] args) {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/310lab-2", "root", "dbms21sql21tafa21");
            PreparedStatement preparedStatement;
            Scanner sc = new Scanner(System.in);
            studentdatabase stdatabase = new studentdatabase();
            facultydatabase facdatabase = new facultydatabase();
            sectiondatabase secdatabase = new sectiondatabase();
            String section1Time="12:30 PM 1:00 PM";
            String section2Time="2:30 PM 4:00 PM";
            int sec1count1 = 9;
            int sec2count2 = 9;
            while (true) {
                System.out.println("Enter 1 to register as a student" + "\n" + "Enter 2 to login as a student" + "\n" + "Enter 3 to login as a faculty" + "\n" + "Enter 0 to quit");
                int enteredValue = sc.nextInt();
                sc.nextLine();
                if (enteredValue == 0) {
                    System.out.println("Good Bye.");
                    break;
                } else if (enteredValue == 1) {
                    stdatabase.StudentDatabase();
                    System.out.println("Thank you for registering. Please log in now");
                } else if (enteredValue == 2) {
                    System.out.println("please enter email");
                    String Email = sc.nextLine();
                    System.out.println("please enter password");
                    String pass = sc.nextLine();
                    boolean validinfo= stdatabase.validinfo(Email, pass);
                    if (validinfo!=false) {
                        System.out.println("1. Section-01 Sunday: "+section1Time+" "+sec1count1+" seats remaining"+"\n"+"2. Section-02 Sunday: "+section2Time+" "+sec2count2+" seats remaining");
                        System.out.println("Enter 1 to enroll in section-1");
                        System.out.println("Enter 2 to enroll in section-2");
                        int section = sc.nextInt();

                        if (section == 1) {
                            String query = "update studentdatatable set section=?";
                            preparedStatement = connection.prepareStatement(query);
                            preparedStatement.setInt(1,section);
                            preparedStatement.executeUpdate();
                            System.out.println("You are enrolled in section-1");
                            sec1count1--;
                        }
                        else if (section == 2) {
                            String query = "update studentdatatable set section=?";
                            preparedStatement = connection.prepareStatement(query);
                            preparedStatement.setInt(1, section);
                            preparedStatement.executeUpdate();
                            System.out.println("You are enrolled in section-2");
                            sec2count2--;

                        }
                        else{
                            while (true) {
                                System.out.println("Please choose a section. \n Press 1 for section 1 and 2 for section 2");
                                if(sec1count1 == 9 && sec2count2==9) {
                                    System.out.println("No seat available. check different section");
                                    break;
                                }
                            }

                        }

                    } else{
                        System.out.println("Sorry, you are not registered. Please register first.");
                    }
                        }
                else if(enteredValue==3){
                    System.out.println("please enter email");
                    String email=sc.nextLine();
                    System.out.println("please enter password");
                    String pass=sc.nextLine();
                    String query = "select email, password from faculty ";
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(query);


                    if (rs!=null) {
                        while(rs.next())  {
                            String Email = rs.getString("email");
                            String password = rs.getString("password");

                            if (email.equals(Email) && password.equals(pass)) {
                                System.out.println("faculty log in successful");
                            }

                            System.out.println("Choose section number to see details."
                                + "\n Press 1 to see the details of Section 1"
                                + "\n press 2 to see the details of section 2");
                        int sectionChoose=sc.nextInt();
                        sc.nextLine();
                        if (sectionChoose == 1) {

                            query = "select name, sid , section from studentdatatable";
                             st = connection.createStatement();
                             rs = st.executeQuery(query);
                        }
                        else if(sectionChoose == 2) {

                            query = "select name, sid , section from studentdatatable";
                            st = connection.createStatement();
                            rs = st.executeQuery(query);
                        }

                            if (rs!=null) {
                                while(rs.next())  {
                                    int sectioncheck = rs.getInt("section") ;
                                    if(sectionChoose == sectioncheck) {
                                        System.out.println(rs.getString("name") + " " + rs.getString("sid"));
                                    }
                                    }
                                }
                        else {
                            break;
                            }
                    }

                    }
                    else {
                        System.out.println("Sorry. wrong credentials"); }
                }
                else {
                    System.out.println("Wrong Input");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
