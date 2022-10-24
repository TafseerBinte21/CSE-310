import java.util.*;
public class Student {
	private String Name,Email,Password;
	private int SID;
	
	public Student() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter name:");
			String Name=sc.nextLine();
			setName(Name);
			System.out.println("Enter id:");
			int SID=sc.nextInt();
			setSID(SID);
			sc.nextLine();
			System.out.println("Enter email:");
			String Email=sc.nextLine();
			setEmail(Email);
			System.out.println("Enter password:");
			String Pass=sc.nextLine();
			setPassword(Pass);
		}
		
	}
	public void setName(String Name) {
		this.Name=Name;
	}
	public String getName() {
		return this.Name;
	}
	public void setSID(int SID) {
		this.SID=SID;
	}
	public int getSID() {
		return this.SID;
	}
	public void setEmail(String Email) {
		this.Email=Email;
	}
	public String getEmail() {
		return this.Email;
	}
	public void setPassword(String Password) {
		this.Password=Password;
	}
	public String getPassword() {
		return this.Password;
	}
	
	public String toString() {
		return Name+" "+SID;
	}

}
