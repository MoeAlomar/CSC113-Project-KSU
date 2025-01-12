import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LibraryTest {
	
	
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

    	 Library library = new Library("Barnes & Noble", 3000);
    	 
    
        do {
            System.out.println("Welcome to " + Library.name + "! Select an option from the menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book");
            System.out.println("4. Display All Books.");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Display All Borrowed Books");
            System.out.println("8. Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addBook(); //asks if book is physical or digital, then asks for book name, author name, ISBN
                    break;
                case 2:
                    removeBook(); //asks for book info then removes the book from the array and sorts the array
                    break;
                case 3:
                    findBook(); //(?)goes through each object in the books array and uses the method equals() to identify the position of the book in the array(?)
                    break;
                case 4:
                	displayAllBooks();
                	break;
                case 5:
                    borrowBook(); //asks for customer details, then adds the book to the customer and removes it from the library, if its digital doesn't remove it from library
                    break;
                case 6:
                    returnBook(); //removes the book from the customer and adds it back to the library, if its digital simply removes it from customer
                    break;
                case 7:
                    displayBorrowedBooks(); //goes through each object in book array (for a specific customer) and displays them
                    break;
                case 8:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Please pick one of the shown numbers.");
            }
        } 
        
        
        
        
        while (choice != 8);
    }

        public static void displayAllBooks() {
        	Library.displayAllBooks();
        }
        public static void addBook() {
        	Scanner input = new Scanner(System.in);
        	
        	System.out.println("What is the book type?:  1) EBook  , 2) PaperBook:");
        	int Type = input.nextInt();
            String type;
            
            if (Type == 1 ) {
            	type = "Ebook";
            	System.out.println("Enter book details:\nTitle:");
            	String name = input.next();
            	System.out.println("Author:");
            	String author = input.next();
            	System.out.println("ISBN:");
            	int ISBN = input.nextInt();
            	System.out.println("Size (MB):");
            	int size = input.nextInt(); 
            	Library.addbook(new eBook(name, author, ISBN,type,size));
            } else if (Type == 2) {
            	type = "PaperBook";
            	System.out.println("Enter book details:\nTitle:");
                String name = input.next();
                System.out.println("Author:");
                String author = input.next();
                System.out.println("ISBN:");
                int ISBN = input.nextInt();
                System.out.println("Number of pages:");
                int pages = input.nextInt();
                System.out.println("Cover type:  1) HardCover , 2) PaperCover:");
                int coverTypeN = input.nextInt();
                String coverType = null;
                if(coverTypeN == 1)
                	coverType = "HardCover";
                else if(coverTypeN == 2) 
                	coverType = "PaperCover";
                
                if (coverTypeN == 1 || coverTypeN == 2) {
                	Library.addbook(new PaperBook(name, author, ISBN,type, pages, coverType));
                } else { System.out.println("Cover type must be either HardCover or PaperCover"); }
            } else {
                System.out.println("Book type must be either EBook or Paperbook");
            }
        
    
    }
        public static void removeBook() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the ISBN of the book: ");
            int ISBN = input.nextInt();
            Library.removebook(ISBN);
        }
        
        public static void findBook() {
            Scanner input = new Scanner(System.in);
            System.out.println("ISBN:  ");
            int ISBN = input.nextInt();
            Book book = Library.findBook(ISBN);
            if (book != null) {
                System.out.println("Book found: " + book);
            } else {
                System.out.println("There is no such book present in the library.");
            }
        }
        
        public static void borrowBook() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter ISBN: ");
            int ISBN = input.nextInt();
            Customer.borrowBook(ISBN);
        }
        
        public static void returnBook() {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter ISBN of the book to return: ");
            int ISBN = input.nextInt();
            Customer.returnBook(ISBN);
        }
        
        
        
        public static void displayBorrowedBooks() {
            System.out.println("Borrowed Books: (" + Customer.BbCounter + ")" );
            Customer.displayBorrowedBooks();
            }
        
        
        
        
        
       
        
        
        
        
        
        
}