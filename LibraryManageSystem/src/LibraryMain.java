import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");
        
        while(true) {
        System.out.println("Are you a new user? (yes/no)");
        String userType = scanner.nextLine().trim().toLowerCase();
        
       
        if (userType.equals("yes")) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter your university: ");
            String university = scanner.nextLine();

            User newUser = new User(name, phoneNumber, university);
            System.out.println("Your generated User ID is: " + newUser.getUserId());
            
            newUser.showMenu();
            
        } else if (userType.equals("no")) {
            System.out.print("Enter your User ID: ");
            int userId = scanner.nextInt();

            User existingUser = User.loginUser(userId);
            if (existingUser != null) {
            	 System.out.println("Welcome back, User ID: " + userId);
                existingUser.showMenu();
            }
            else {
                System.out.println("User not found. Please check your User ID.");
            }
        } else {
            System.out.println("Invalid option. Exiting...");
        }
       
        }
    }
    
}
