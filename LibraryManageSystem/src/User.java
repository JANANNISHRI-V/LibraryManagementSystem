//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Random;
//import java.util.Scanner;
//
//public class User {
//    private String name;
//    private String phoneNumber;
//    private String university;
//    private int userId;
//    private ArrayList<String> borrowedBooks = new ArrayList<>();
//    private static HashMap<Integer, User> userDatabase = new HashMap<>();
//    private static Random random = new Random();
//
//    public User(String name, String phoneNumber, String university) {
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//        this.university = university;
//        this.userId = generateUserId();
//        userDatabase.put(this.userId, this);
//        System.out.println("Welcome, " + name + "! Your user ID is: " + userId);
//    }
//
//    public static User loginUser(int userId) {
//        return userDatabase.get(userId);
//    }
//
//    private int generateUserId() {
//        return 100000 + random.nextInt(900000);
//    }
//
//    public void showMenu() {
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//        do {
//            System.out.println("\nPlease select an option:");
//            System.out.println("1. View All Books");
//            System.out.println("2. Borrow a Book");
//            System.out.println("3. View Transaction History");
//            System.out.println("4. View Author Details");
//            System.out.println("5. Exit");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    Book.viewAllCollections();
//                    break;
//                case 2:
//                    Book.borrowBook(scanner);
//                    break;
//                case 3:
//                    Transaction.viewTransactionHistory();
//                    break;
//                case 4:
//                    Author.viewAuthorDetails();
//                    break;
//                case 5:
//                    System.out.println("Thank you for using the library system. Goodbye!");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        } while (choice != 5);
//    }
//
//	public String getName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class User {
    private int userId;
    private String name;
    private String phoneNumber;
    private String university;
    
    private static ArrayList<User> userList = new ArrayList<>(); // Store all users


    public User(String name, String phoneNumber, String university) {
        this.userId = generateRandomUserId(); 
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.university = university;
        
        userList.add(this);

        System.out.println("User created with User ID: " + this.userId);
    }
    
	public int getUserId() {
		
		return this.userId;
	}

    private int generateRandomUserId() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }

    public void borrowBook(String bookId) {
        String transactionId = "TXN" + generateRandomUserId();
        String borrowDate = getCurrentDate(); // Get today’s date as borrow date
        String returnDate = getReturnDate(); // Calculate return date (10 days from today)

        Transaction.recordTransaction(transactionId, bookId, this.userId, borrowDate, returnDate);
        System.out.println("Book borrowed successfully and transaction recorded.");
    }

    private String getCurrentDate() {
        // Get today’s date in "yyyy-MM-dd" format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(new Date());
    }

    private String getReturnDate() {
        // Get date 10 days from today
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime());
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. View transaction history");
            System.out.println("4. View author details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Book.viewAllCollections(); // Show all books
                    break;
                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    String bookId = scanner.next();
                    borrowBook(bookId); // Borrow a book
                    break;
                case 3:
                    Transaction.viewTransactionHistory(); // Show transaction history
                    break;
                case 4:
                    Author.viewAuthorDetails(); // Show author details
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.out.println("ThankYou for choosing Library Management System !");
                    System.out.println("Come Again !!!");
                    return; // Exit the menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static User loginUser(int userId) {
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null; // User not found
    }


}
