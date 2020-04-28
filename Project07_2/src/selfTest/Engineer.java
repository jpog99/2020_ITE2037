package selfTest;

public class Engineer extends Employee{
	private String workZone;
	private String project;
	
	public Engineer(String name, int employeeNum, String workZone, String project) {
		super(name, employeeNum);
		this.workZone = workZone;
		this.project = project;
	}
	
	public boolean equals(Object obj) {
		if(obj.getClass() == null) return false;
		else if(this.getClass() != obj.getClass()) return false;
		else {
			Engineer temp = (Engineer)obj;
			return super.equals(temp) && this.workZone.equals(temp.workZone) && this.project.equals(temp.project);
		}		
	}
	
	public String toString() {
		return "Name: " + super.getName() + "\nEmp#: " + super.getEmployeeNum() + "\nLocation:  " + super.getDepartment() + ", " + this.workZone;
	}
}
