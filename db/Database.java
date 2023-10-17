package course.registration.db;

import java.util.ArrayList;
import java.util.Date;

import course.registration.data.Course;
import course.registration.data.Mentor;
import course.registration.data.User;

public class Database {
	public static ArrayList<Mentor> MENTORS_DB = new ArrayList<>();
	public static ArrayList<Course> COURSES_DB = new ArrayList<>();
	public static ArrayList<User> USERS_DB = new ArrayList<>();

	public static void initDB() {
		// initialize mentorDB
		MENTORS_DB.add(new Mentor("Luan Nguyen", "Front-End Developer", "OIVAN"));
		MENTORS_DB.add(new Mentor("Dung Nguyen", "Senior Back-End Developer", "NAB"));
		MENTORS_DB.add(new Mentor("Hai Tran", "BI Analyst", "Canva"));

		// initialize courseDB
		ArrayList<Mentor> teachingMentor1 = new ArrayList<Mentor>();
		teachingMentor1.add(MENTORS_DB.get(0));
		COURSES_DB.add(new Course("Front-End Intensive", new Date(), new Date(), 2000, teachingMentor1));
		
		ArrayList<Mentor> teachingMentor2 = new ArrayList<Mentor>();
		teachingMentor2.add(MENTORS_DB.get(1));
		COURSES_DB.add(new Course("Back-End Intensive", new Date(), new Date(), 3000, teachingMentor2));
		
		ArrayList<Mentor> teachingMentor3 = new ArrayList<Mentor>();
		teachingMentor3.add(MENTORS_DB.get(1));
		teachingMentor3.add(MENTORS_DB.get(2));
		COURSES_DB.add(new Course("Data Intensive", new Date(), new Date(), 2500, teachingMentor3));
	}
}
