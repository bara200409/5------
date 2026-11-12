package step1;  // 강의노트 p.7
import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> stList = new ArrayList<>();;
	ArrayList<Team> teamList = new ArrayList<>();;
	void mymain() {
		readStudents();
		printStudents();
		readTeams();
		printTeams();
		searchTeams();
		search();
	}
	void readTeams() {
		Team t;
		String name;
		while (true) {
			name = scan.next();
			if (name.equals("0")) break;
			t = new Team(name);
			t.read(scan, this);
			teamList.add(t);
		}
	}
	void printTeams() {
		for (Team t: teamList) 
			t.print();
	}
	// 팀 검색
	// A		팀 이름에 매치되는 팀을 출력
	// 김성관		이름의 학생을 포함하는 팀을 모두 출력
	// 2		2학년 학생을 포함하는 팀을 모두 출력
	// 2345		2345에 매치되는 학생을 포함하는 팀을 모두 출력
	void searchTeams() {
		String kwd;
		scan.nextLine();  // 줄바꿈을 읽어서 버림
		while (true) {
			System.out.print("키워드:");
			kwd = scan.nextLine();
			if (kwd.equals("end")) break;
			for (Team t: teamList) {
				String[] kwds = kwd.split(" ");
				if (t.matches(kwds))
					t.print();
			}
		}
	}
	// [5단계] 2017 -2 김
	void search() {
		String kwd;
		scan.nextLine();  // 줄바꿈을 읽어서 버림
		while (true) {
			System.out.print("키워드:");
			kwd = scan.nextLine();
			if (kwd.equals("end")) break;
			for (Student st: stList) {
				String[] kwds = kwd.split(" ");
				if (st.matches(kwds))
					st.print();
			}
		}
	}
	void readStudents() {
		Student st;
		String id;
		while (true) {
			id = scan.next();
			//System.out.println("id: "+id);
			if (id.equals("0")) break;
			st = new Student(id);
			st.read(scan);
			stList.add(st);
		}
	}
	void printStudents() {
		for (Student st: stList) {
			st.print();
		}
	}
	public static void main(String[] args) {
		Department m = new Department();
		m.mymain();
	}
	public Student findStudent(int n) {
		// TODO Auto-generated method stub
		return stList.get(n-1);
	}
}
