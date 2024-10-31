
public class Student extends Person{
private String ID;
	
	public Student(String n, String id) {
		super(n);
		ID = id;
	}
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public String print()
	{
		return "Student: " + getName() + ", " + ID;
	}
	}
