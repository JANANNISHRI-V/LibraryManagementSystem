import java.util.ArrayList;

public class Transaction {
    private String transactionId;
    private String bookId;
    private int userId;
    private String borrowDate;
    private String returnDate;

    private static ArrayList<Transaction> transactionList = new ArrayList<>();

    public Transaction(String transactionId, String bookId, int userId, String borrowDate, String returnDate) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        transactionList.add(this);
    }

    public static void viewTransactionHistory() {
        if (transactionList.isEmpty()) {
            System.out.println("No transaction history available.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactionList) {
                System.out.println("Transaction ID: " + transaction.transactionId);
                System.out.println("Book ID: " + transaction.bookId);
                System.out.println("User ID: " + transaction.userId);
                System.out.println("Borrow Date: " + transaction.borrowDate);
                System.out.println("Return Date: " + transaction.returnDate);
                System.out.println();
            }
        }
    }


    public static void recordTransaction(String transactionId, String bookId, int userId, String borrowDate, String returnDate) {
        new Transaction(transactionId, bookId, userId, borrowDate, returnDate);
    }
}
