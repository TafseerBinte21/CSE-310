
public class StudentDatabase {
	private Student[] studentArray=new Student[18];
	private int signedup=0;
	public void addStudent() {
		
		if(signedup<18) {
			Student std=new Student();
			studentArray[signedup]=std;
			signedup++;
		}
		else {
			System.out.println("No more capacity left try next semester");
			
		}
	}
	public Student validinfo(String email, String pass) {
		Student valid=null;
		for (int i=0;i<signedup;i++) {
			if (studentArray[i].getEmail().equals(email)&& studentArray[i].getPassword().equals(pass)) {
				valid=studentArray[i];
				System.out.println("student log in successful");
				break;
			}
		}
		return valid;
	}
	
}
