

public class Person {

	private String name;
	
	public Person(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String print()
	{
		return "Person: " + name;
	}

	
	
	public String getMajor() {
		return null;
	}

	public String getID() {
		return null;
	}

	public String getGrade() {
		return null;
	}

	public boolean gradeEquals(String input) {
		return false;
	}

	public boolean majorEquals(String input) {
		return false;
	}
}
