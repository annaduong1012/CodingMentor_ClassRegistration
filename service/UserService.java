package course.registration.service;

import course.registration.data.Course;
import course.registration.data.User;
import course.registration.db.Database;

public class UserService {
	public static void registerNewUser(String name, String userID, String userPassword) {
		User user = new User(name, userID, userPassword);
		boolean isExistingUser = false;

		// Validate if user existed
		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (userID.equals(Database.USERS_DB.get(i).getUserID())) {
				System.out.println("Account already existed. Please register with a different userID or login.");
				isExistingUser = true;
				break;
			}
		}
		if (!isExistingUser) {
			// add new user to USER_DB
			Database.USERS_DB.add(user);
			System.out.println("Welcome " + name + "! Account Registered Successfully!");
		}
	}

	// loop user DB and check if userID exist or not?
	public static User findUserbyID(String userID) {
		for (User user : Database.USERS_DB) {
			if (userID.equals(user.getUserID())) {
				return user;
			}
		}
		return null;
	}

	public static User validAccount(String userID, String userPassword) {
		User currentUser = findUserbyID(userID);

		if (currentUser == null) {
			System.out.println("Invalid Account, please try again");
		} else if (currentUser.getFailedCount() >= 3) {
			System.out.println("Your account has been locked. Please contact Support to unlock your account.");
		} else if (userPassword.equals(currentUser.getUserPassword())) {
			System.out.println("Welcome " + currentUser.getName() + "! You have logged in successfully.");
			return currentUser;
		} else {
			System.out.println("Invalid password. Please try again");
			int failedCount = currentUser.getFailedCount() + 1;
			currentUser.setFailedCount(failedCount);
		}
		return null;
	}

	public static void showRegisterCourseByUser(User user) {
		System.out.println("Courses registered by " + user.getName() + " :");
		for (Course course : user.getRegisteredCourses()) {
			System.out.println("- " + course.getCourseName());
		}
	}

	public static void registerNewCourses(User user, Course course) {
		if (!CourseService.isRegisteredCourse(user, course)) {
			user.getRegisteredCourses().add(course);
			System.out.println("You have registered course '" + course.getCourseName() + "' successfully.");
		} else {
			System.out.println("You have already registered this course: " + course.getCourseName());
		}

	}
}
