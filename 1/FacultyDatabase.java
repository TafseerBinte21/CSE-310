
public class FacultyDatabase {
	public Faculty[] facultyArray=new Faculty[2];
	
	public FacultyDatabase() {
		facultyArray[0]=new Faculty("abdur","abdur.rahman@bracu.ac.bd","abc");
		facultyArray[1]=new Faculty("zaber","zaber.mohammad@bracu.ac.bd","xyz");
	}
	public Faculty validinfo(String email, String pass) {
		Faculty valid=null;
		for (int i=0;i<facultyArray.length;i++) {
			if (facultyArray[i].getemail().equals(email)&& facultyArray[i].getPassword().equals(pass)) {
				valid=facultyArray[i];
				System.out.println("faculty log in successful");
				break;
			}
		}
		return valid;
	}
	
}
