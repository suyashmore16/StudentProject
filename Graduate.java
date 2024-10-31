
public class Graduate extends Student{
	private String major;
	
	public Graduate(String n, String id, String m) {
		super(n, id);
		major = m;
	}


	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String print()
	{
		return "Graduate: " + getName() + ", " + getID() + ", " + major;
	}
	
	
	//comparing majors
	public boolean majorEquals(String m) {
		if(m.equalsIgnoreCase(major)) {
			return true;
		}else {
			return false;
		}
	}
}
