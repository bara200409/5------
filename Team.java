package step1;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	String name;
	ArrayList<Student> members = new ArrayList<>();

	public Team(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	void read(Scanner scan, Department dept) {
		int n;
		while (true) {
			n = scan.nextInt();
			if (n == 0) break;
			Student st = dept.findStudent(n);
			members.add(st);
			st.setTeam(this);
		}
	}
	void print() {
		System.out.printf("[%s] ", name);
		for (Student st: members)
			System.out.printf("%s ", st.name);
		System.out.println();
	}
	public boolean matches(String kwd) {
		if (name.equals(kwd))
			return true;
		for (Student st: members)
			if (st.matches(kwd)) return true;
		return false;
	}
	public boolean matches(String[] kwds) {
		// TODO Auto-generated method stub
		for (String kwd: kwds) {
			if (kwd.charAt(0) == '-') {
				if (matches(kwd.substring(1)))
					return false;
				continue;
			}
			if (!this.matches(kwd)) 
				return false;
		}
		return true;
	}
}
