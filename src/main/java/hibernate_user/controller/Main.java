package hibernate_user.controller;

import java.util.Scanner;

import hibernate_user.dao.UserDao;
import hibernate_user.dto.User;

public class Main {

	private static Object email;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		User user = new User();
		UserDao dao = new UserDao();

		System.out.println("Enter your choice\n 1)SignUP \n 2)Login");

		switch (scanner.nextInt()) {
		case 1: {
			System.out.println("Enter your id");
			user.setId(scanner.nextInt());

			System.out.println("Enter your Name");
			user.setName(scanner.next());

			System.out.println("Enter your phone");
			user.setPhone(scanner.nextLong());

			System.out.println("Enter your email");
			user.setEmail(scanner.next());

			System.out.println("Enter your password");
			user.setPassword(scanner.next());

			dao.signUp(user);

		}
		case 2: {
			System.out.println("Enter your email");
			String email=scanner.next();
			user.setEmail(email);

			System.out.println("Enter your password");
			String password = scanner.next();
			user.setPassword(password);
			
			
			user.setEmail(email);
			
			User dbUser = dao.login(user);

			if (dbUser != null) {

				if (dbUser.getPassword().equals(password)) {

					System.out.println("Login sucsess");
					System.out.println("Enter your choice \n 1)Display Password \n 2)Upadte Password \n 3)LogOut");
					
					switch (scanner.nextInt()) {
					case 1:
					{
						User user2=dao.displayPassword(email);
						
						System.out.println("Facebook"+user2.getFacebook());
						System.out.println("Instagram"+user2.getInstagram());
						System.out.println(""+user2.getSnapchat());
						System.out.println("The password"+user2.getTwitter());
					}
					case 2:
					{
						System.out.println("Enter the facebook password");
						dbUser.setFacebook(scanner.next());
						System.out.println("Enter the Instagram password");
						dbUser.setFacebook(scanner.next());
						System.out.println("Enter the Snapchat password");
						dbUser.setFacebook(scanner.next());
						System.out.println("Enter the Twitter password");
						dbUser.setFacebook(scanner.next());
					
						User user2=dao.displayPassword(email);						
					}
						

					}

				} else {
					System.out.println("Invalid password");
				}

			} else {
				System.out.println("User Not Found!.........");
			}

		}

		}

	}

}
