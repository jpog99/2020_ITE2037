package selfTest;

public class Employee {

	private String name;
	private int age;
	private String position = "Engineer";
	private int salary = 15000;
	private int vacationDays = 20;
	
	public Employee() {}
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Employee(String name, int age, String position, int salary) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
	}
	
	public Employee(String name, int age, String position, int salary, int vacationDays) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = vacationDays;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void outInfo() {
		System.out.println("Name: "+ name);
		System.out.println("Age: "+ age);
		System.out.println("Position: "+ position);
		System.out.println("Salary: "+ salary);
		System.out.println("Vacation Days: "+ vacationDays);
		System.out.println();
	}
	
	public String vacation(int vacationDays) {
		 if(this.vacationDays >= vacationDays) {
			 this.vacationDays -= vacationDays;
			 return "Possible";
		 }
		 else
			 return "Impossible";
	}
	
	public boolean equals(Employee emp2) {
		if(emp2.name.equals(name) && emp2.age==age && emp2.position.equals(position)) 
			return true;
		else
			return false;
	}
	
}
