import java.util.*;
public class Tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			StudentDatabase stdatabase=new StudentDatabase();
			FacultyDatabase facdatabase=new FacultyDatabase();
			Sections section=new Sections();
			
			while(true) {
				
				System.out.println("Enter 1 to register as a student"+"\n"+"Enter 2 to login as a student"+"\n"+"Enter 3 to login as a faculty"+"\n"+"Enter 0 to quit");
				int enteredValue=sc.nextInt();
				sc.nextLine();
				if(enteredValue==0) {
					System.out.println("Good Bye.");
					break;
				}
				else if (enteredValue==1) {
					stdatabase.addStudent();
					System.out.println("Thank you for registering. Please log in now");
					
				}
				else if (enteredValue==2) {
					System.out.println("please enter email");
					String email=sc.nextLine();
					System.out.println("please enter password");
					String pass=sc.nextLine();
					Student valid=stdatabase.validinfo(email, pass);
					if (valid!=null) {
						System.out.println(section.toString());
						if(section.isEnrolledin1(valid.getEmail())) {
							System.out.println("You are enrolled in section 1");
						}
						else if(section.isEnrolledin2(valid.getEmail())) {
							System.out.println("You are enrolled in section 2");
						
						}
						else {
						while(true) {
					    
						System.out.println("Please choose a section. \n Press 1 for section 1 and 2 for section 2");
						int sectionNumber=sc.nextInt();
						sc.nextLine();
						int seatStatus=section.getSeat(sectionNumber);
						if(seatStatus<9) {
							section.enrol(valid,sectionNumber);
							break;
						}else {
							
							System.out.println("No seat available. check different section");
						}
						}
					}
						
						
					}else {
						System.out.println("Sorry, you are not registered. Please register first.");
					}
				}
				else if(enteredValue==3) {
					System.out.println("please enter email");
					String email=sc.nextLine();
					System.out.println("please enter password");
					String pass=sc.nextLine();
					Faculty valid=facdatabase.validinfo(email, pass);
					if (valid!=null) {
					System.out.println("Choose section number to see details."
							+ "\n Press 1 to see the details of Section 1"
							+ "\n press 2 to see the details of section 2");
					int sectionChoose=sc.nextInt();
					sc.nextLine();
					section.sectionDetails(sectionChoose);
				}
					else {
						System.out.println("Sorry. wrong credentials");
					}
			}
				else {
					System.out.println("Wrong input");
				}
			}
		}
		
		
	}

}
