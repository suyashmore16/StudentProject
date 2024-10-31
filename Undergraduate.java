
public class Undergraduate extends Student{
	private String grade;
	
	public Undergraduate(String n, String id, String g) {
		super(n, id);
		grade = g;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String print()
	{
		return "Undergraduate : " + getName() + ", " + getID() + ", "+ grade;
	}
	
	//comparing grades
	public boolean gradeEquals(String g) {
		if(g.equalsIgnoreCase(grade)) {
			return true;
		}else {
			return false;
		}
	}

}
