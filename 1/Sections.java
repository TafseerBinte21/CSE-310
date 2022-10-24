
public class Sections {
	private  int section1seat=0;
	private  int section2seat=0;
	private String section1Time="12:30 PM 1:00 PM";
	private String section2Time="2:30 PM 4:00 PM";
	private Student[] section1students=new Student[9];
	private Student[] section2students=new Student[9];
	
	public String toString() {
		
		return "1. Section-01 Sunday: "+section1Time+" "+(9-section1seat)+" seats remaining"+"\n"+"2. Section-02 Sunday: "+section2Time+" "+(9-section2seat)+" seats remaining";
	}
	public Student[] getSection1() {
		return section1students;
	}
	public Student[] getSection2() {
		return section2students;
	}
	public int getSeat(int section) {
		if(section==1) {
			return section1seat;
					
		}
		else if(section==2) {
			return section2seat;
		}
		return 9;
	}
	public void enrol(Student s, int sectionNumber) {
		if(sectionNumber==1) {
			section1students[section1seat]=s;
			section1seat++;
		}
		else if(sectionNumber==2) {
			section2students[section2seat]=s;
			section2seat++;
		}
	}
	public boolean isEnrolledin1(String email) {
		boolean enrolled=false;
		for(int i=0;i<section1seat;i++) {
			if(section1students[i].getEmail().equals(email)) {
				enrolled=true;
				break;
			}
		}
		return enrolled;
	}
	public boolean isEnrolledin2(String email) {
		boolean enrolled=false;
		for(int i=0;i<section2seat;i++) {
			if(section2students[i].getEmail().equals(email)) {
				enrolled=true;
				break;
			}
		}
		return enrolled;
	}
	public void sectionDetails(int sectionNumber) {
		if(sectionNumber==1) {
			for(int i=0;i<section1seat;i++) {
				System.out.println(section1students[i]);
			}
		}
		else if(sectionNumber==2) {
			for(int i=0;i<section2seat;i++) {
				System.out.println(section2students[i]);
			}
		}
		else {
			System.out.println("Wrong section Number");
		}
	}

}
