package assignment01;

import java.util.Calendar;
import java.util.Scanner;


public class Student {
	private String studentName;
	private int studentCode;
	Lecture timeTable[][] = new Lecture[10][5];

	public enum DAYS {
		MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY;
	}

	public Student() {
		studentName="";
		studentCode=0;
		for (int i=0 ; i<10 ; i++) {
			for (int j=0 ; j<5 ; j++) {
				timeTable[i][j] = new Lecture();
			}
		}
	}

	public Student(String studentName, int studentCode) {
		this.studentName = studentName;
		this.studentCode = studentCode;
		for (int i=0 ; i<10 ; i++) {
			for (int j=0 ; j<5 ; j++) {
				timeTable[i][j] = new Lecture();
			}
		}
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	public void setScheduleInformation(Lecture lecture) {
		int t = lecture.getTime();
		int d = DAYS.valueOf(lecture.getDay()).ordinal();
		if(lecture.getEnrolled() >= lecture.getMaxEnrolled()) 
			System.out.println("\n강의를 추가할 수 없읍니다. : 최대 수강 인원 초과");
		else if(!timeTable[t-1][d].checkLecture()) 
			System.out.println("\n강의를 추가할 수 없읍니다. : Overlapping lecture period.");
		else {
			timeTable[t-1][d] = lecture;
			lecture.incEnrolled();
			System.out.println("\n시간이 정상적으로 추가되었습니다.");
		}
	}
	public String showTimetable() {
		DAYS[] dayVal = DAYS.values();
		String[][] table = new String[11][6];
		String result="";
		for(int i=0 ; i<11 ; i++) {
			for(int j=0 ; j<6 ; j++) {
				if(i==0 && j>=1) table[i][j] = dayVal[j-1].toString(); 
				else if(i>=1 && j==0) table[i][j] = Integer.toString(i);
				else if(i==0 && j==0) table[i][j] = " ";
				else table[i][j] = timeTable[i-1][j-1].getLectureName();
				
				result += String.format("%8s\t",table[i][j]);
			}
			result += "\n";
		}
		return result;
	}

	public boolean equals(Student stu) {
		if(stu==null) {
			System.out.println("두번째 학생의 학번을 찾을 수 없읍니다."); return false;
		}
		boolean temp = true;
		for(int i=0 ; i<10 ; i++) {
			if(temp==false) break;
			for(int j=0 ; j<5 ; j++) {
				if(!(this.timeTable[i][j].equals(stu.timeTable[i][j]))) {
					temp = false;
					break;
				}
			}
		}
		if(temp){
			System.out.println("두 학생의 시간표는 같습니다."); 
			return temp;
		}
		else {
			System.out.println("두 학생의 시간표는 다름니다.");
			return temp;
		}
	}
	
	public void deleteSchedule(String day, int period)
	{
		int d = DAYS.valueOf(day.toUpperCase()).ordinal();
		timeTable[period-1][d].decEnrolled();
		timeTable[period-1][d] = new Lecture();
	}
	
	public Calendar setInputDate()
	{
		Calendar cal = Calendar.getInstance();
		Scanner kb = new Scanner(System.in);
		String date = kb.next();
		int year = Integer.parseInt(date.substring(0,4));
		int month = Integer.parseInt(date.substring(4,6));
		int day = Integer.parseInt(date.substring(6));
		cal.set(year, month-1, day);
		return cal;
	}
	
	public String oneDaySchedule(String day) {
		if (day.equals("SUNDAY") || day.equals("SATURDAY"))
			return "\nThere are no classes on "+ day + "!";
		int d = DAYS.valueOf(day).ordinal();

		System.out.println("\n"+day);
		String oneDay = "";
		for(int i=0 ; i<10 ; i++) {
			oneDay += (timeTable[i][d].getLectureName() + "\n");
		}
		return oneDay;
	}

}
