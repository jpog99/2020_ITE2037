package assignment01;
//fix case 3
import java.util.Calendar;
import java.util.Scanner;

public class TimeTableApp {
	public static void main(String[] args) {
		Lecture lecture[] = new Lecture[10];
		lecture[0] = new Lecture("MONDAY", 1, "OOP", "mr.park", "ITBT808", 20);
		lecture[1] = new Lecture("TUESDAY", 2, "security", "mr.park", "ITBT816", 20);
		lecture[2] = new Lecture("WEDNESDAY", 1, "Datastructure", "mr.park", "ITBT808", 25);
		lecture[3] = new Lecture("THURSDAY", 6, "Network", "mr.yang", "ITBT503", 20);
		lecture[4] = new Lecture("FRIDAY", 9, "computer architecture", "mr.han", "ITBT507", 20);
		lecture[5] = new Lecture("TUESDAY", 5, "Digital logic", "mr.kim", "ITBT401", 15);
		lecture[6] = new Lecture("WEDNESDAY", 2, "OS", "mr.yoon", "ITBT606", 15);
		lecture[7] = new Lecture("THURSDAY", 3, "C-language", "mr.choi", "ITBT503", 20);
		lecture[8] = new Lecture("FRIDAY", 6, "Python", "mr.han", "ITBT504", 15);
		lecture[9] = new Lecture("TUESDAY", 9, "Ski-Board", "mr.kang", "ITBT404", 5);

		Scanner keyboard = new Scanner(System.in);
		String[] weeks = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
		Calendar cal = Calendar.getInstance();
		int StudentNum;
		Student[] stu;
		Student s = new Student(); //reference object
		String stuName;
		int stuCode;
		int enter;
	

		System.out.println("학생수를 입력하세요");
		StudentNum = keyboard.nextInt();
		stu = new Student[StudentNum];
		for(int i=0 ; i<stu.length ; i++) {
			System.out.println((i+1) + " 학생의 이름을 입력하세요 " );
			stuName = keyboard.next();
			System.out.println((i+1) + " 학생의 학번을 입력하세요 " );
			stuCode = keyboard.nextInt();
			stu[i] = new Student(stuName,stuCode);
		}

		do {
			System.out.println("\n============================ 메인 메뉴 ================================");
			System.out.println("학생의 시간표를 입력하려면 1번을 누르세요.");
			System.out.println("특정 과목을 수강하는 학생수를 출력하려면 2번을 누르세요.");
			System.out.println("학생들의 시간표를 비교하려면 3번을 누르세요.");
			System.out.println("학생의 시간표를 지우려면 4번을 누르세요.");
			System.out.println("시간표를 출력하려면 5번을 누르세요.");
			System.out.println("해당 학생의 특정 날짜 시간표를 출력하려면 6번을 누르세요.");
			System.out.println("프로그램을 종료하려면 7번을 누르세요.");
			System.out.println("========================================================================");
			enter = keyboard.nextInt();
			int studentID;
			
			switch (enter) {
			case 1:
				
				System.out.println("시간표를 입력할 학생의 학번을 입력하새요");
				studentID = keyboard.nextInt();
				
				//check if ID exist or not and create a reference to the corresponding ID
				for(int i=0 ; i<stu.length ; i++) {
					if(studentID==stu[i].getStudentCode()) { 
						s = stu[i]; break;
					}else
						s = null;
				}
				
				if(s != null) {
					System.out.println("다음 중 추가할 시간표의 번호를 입력하새요");
					showClass();
					int choice = keyboard.nextInt();
					if(choice>10 || choice<1) 
						System.out.println("그런 시간표의 번호가 없읍니다.");
					else
						s.setScheduleInformation(lecture[choice-1]);
				}
				else 
					System.out.println("입력한 학생의 학번이 찾을 수 없읍니다.");
				break;
				
			case 2:
				keyboard.nextLine();
				System.out.println("과목의 이름을 입력하새요");
				String lectName = keyboard.nextLine();
				for(int i=0 ; i<lecture.length ; i++) {
					if(lectName.equals(lecture[i].getLectureName())) 
						System.out.println(lectName +" 과목을 수강하는 학생의 수는  " +  lecture[i].getEnrolled() );
				}
				break;
				
			case 3:
				Student s1 = new Student();
				Student s2 = new Student();
				
				System.out.println("시간표를 비교할 첫번째 학생의 학번을 입력하새요");
				studentID = keyboard.nextInt();
				for(int i=0 ; i<stu.length ; i++) {
					if(studentID==stu[i].getStudentCode()) {s1 = stu[i];break;}
					else s1=null;
				}
				System.out.println("두번째 학생의 학번을 입력하새요");
				studentID = keyboard.nextInt();
				for(int j=0 ; j<stu.length ; j++) {
					if(studentID==stu[j].getStudentCode()) {s2 = stu[j];break;}
					else s2=null;
				}
				
				if(s1 != null)
					s1.equals(s2);
				else if(s1==null && s2!=null)
					System.out.println("첫번째 학생의 학번을 찾을 수 없읍니다.");
				else
					System.out.println("두 학생의 학번을 찾을 수 없읍니다.");
				
				break;
				
			case 4:
				System.out.println("시간표를 삭제할 학생의 학번을 입력하새요");
				studentID = keyboard.nextInt();
				
				for(int i=0 ; i<stu.length ; i++) {
					if(studentID==stu[i].getStudentCode()) { 
						s = stu[i]; break;
					}else
						s = null;
				}
				
				if(s!=null) {
					System.out.println("지울 시간표의 요일을 입력하새요");
					String day = keyboard.next();
					System.out.println("지울 시간표의 시간을 입력하새요");
					int time = keyboard.nextInt();
					s.deleteSchedule(day.toUpperCase(), time);
					System.out.println(s.showTimetable());
				}else
					System.out.println("입력한 학생의 학번이 찾을 수 없읍니다.");
				
				break;

			case 5:
				System.out.println("시간표를 출력할 학생의 학번을 입력하새요 ");
				studentID = keyboard.nextInt();
				
				for(int i=0 ; i<stu.length ; i++) {
					if(studentID==stu[i].getStudentCode()) { 
						s = stu[i]; break;
					}else
						s = null;
				}
				
				if(s!=null) 
					System.out.println(s.showTimetable());
				else
					System.out.println("입력한 학생의 학번이 찾을 수 없읍니다.");
				
				
				break;
				
			case 6:
				System.out.println("출력할 학생의 학번을 입력하새요");
				studentID = keyboard.nextInt();
				
				for(int i=0 ; i<stu.length ; i++) {
					if(studentID==stu[i].getStudentCode()) { 
						s = stu[i]; break;
					}else
						s = null;
				}
				
				if (s!=null) {
					System.out.println("Enter date (yyyymmdd);");
					cal = s.setInputDate();
					int date = cal.get(Calendar.DAY_OF_WEEK);
					System.out.println(s.oneDaySchedule(weeks[date-1]));
				}else 
					System.out.println("입력한 학생의 학번이 찾을 수 없읍니다.");
				
				
				break;
				
			case 7:
				System.out.println("Program Terminated.");
				System.exit(0);
				break;

			default:
				System.out.println("Try Again");
				break;
			}

		} while (true);
	}

	private static void showClass() {
		System.out.println("(1)  OOP - 월요일 - 1교시");
		System.out.println("(2)  security - 화요일 - 2교시");
		System.out.println("(3)  Datastructure - 수요일 - 1교시");
		System.out.println("(4)  Network - 목요일 - Period 6");
		System.out.println("(5)  computer architecture - 금요일 - 8교시");
		System.out.println("(6)  Digital design - 화요일 - 5교시");
		System.out.println("(7)  OS - 수요일 - 2교시");
		System.out.println("(8)  C-language - 목요일 - 3교시");
		System.out.println("(9)  Python - 금요일 - 6교시");
		System.out.println("(10)  Ski-Board - 화요일 - 9교시");
		
	}
}
