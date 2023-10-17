package course.registration.service;

import course.registration.data.Course;
import course.registration.data.Mentor;
import course.registration.data.User;
import course.registration.db.Database;

public class CourseService {

	public static void showAllCourses() {
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			System.out.print((i + 1) + ". " + Database.COURSES_DB.get(i).getCourseName());
			for (Mentor mentor : Database.COURSES_DB.get(i).getTeachingMentors()) {
				System.out.print(" - Mentor: " + mentor.getName());
			}
			System.out.println();
		}

	}

	public static void showCourseDetails(Course selectedCourse) {
		for (Course course : Database.COURSES_DB) {
			if (course.getCourseName().equals(selectedCourse.getCourseName())) {
				System.out.println("- Course: " + course.getCourseName());
				System.out.println("- Begin Date: " + course.getBeginDate());
				System.out.println("- End Date: " + course.getEndDate());
				System.out.println("- Fee: A$ " + course.getFee());
			}
		}
	}

	public static void showMentorInfoByCourse(Course course) {
		for (Mentor mentor : course.getTeachingMentors()) {
			System.out.println("- Mentor Name: " + mentor.getName());
			System.out.println("- Job Title: " + mentor.getExpertise());
			System.out.println("- Workplace: " + mentor.getWorkPlace());
		}
	}

	public static boolean isRegisteredCourse(User user, Course courseToCheck) {
		// to do
		boolean isRegisteredCourse = false;
		for (Course registeredCourse : user.getRegisteredCourses()) {
			if (registeredCourse.equals(courseToCheck)) {
				return true;
			}
		}
		return isRegisteredCourse;
	}

	}

