  //@MoeAlomar GitHub: https://github.com/MoeAlomar
import java.io.*;

public class Customer {
	private String name;
	private int age;
	private int id;
	private static Book Bbooks[] = new Book[100];
	public static int BbCounter;
	static Library LibraryInstance = new Library();

	public Customer(String name, int age, int size) {
		this.name = name;
		this.age = age;
		Bbooks = new Book[Library.books.length];
		BbCounter = 0;
	}

	public Customer() {

	}

	public boolean equals(int a) {
		if (id == a)
			return true;
		return false;
	}

	public static boolean borrowBook(int ISBN) {

		for (int i = 0; i < Library.bCount; i++) {
			if ((Library.books[i].equals(ISBN))) {
				if (Library.books[i] instanceof eBook) {
					Bbooks[BbCounter++] = new eBook((eBook) Library.books[i]);
				} else if (Library.books[i] instanceof PaperBook) {
					Bbooks[BbCounter++] = new PaperBook((PaperBook) Library.books[i]);
				}

				System.out.println(Library.books[i].name + " Book Is Borrowed");
				Library.books[i] = Library.books[Library.bCount - 1];
				Library.books[Library.bCount - 1] = null;
				Library.bCount--;

				return true;
			}
		}
		System.out.println("Book not Found!");
		return false;

	}

	public static boolean returnBook(int ISBN) {
		for (int i = 0; i < BbCounter; i++)
			if (Bbooks[i].ISBN == ISBN) {
				Library.books[Library.bCount++] = Bbooks[i];
				BbCounter--;
				Bbooks[i] = null;
				System.out.println("Book has been Returned!.");
				return true;
			}
		System.out.println("Book Not Found to Return!");
		return false;

	}

	public static boolean displayBorrowedBooks() {
		if (BbCounter != 0) {
			for (int i = 0; i < BbCounter; i++)
				System.out.println(Bbooks[i]);
			return true;
		}

		System.out.println("No Borrowed Books");
		return false;
	}

	public String toString() {
		String b;
		b = "Customer's name: " + name + "/n age: " + age + " ID: " + id + "\n";
		if (BbCounter != 0) {
			for (int i = 0; i < BbCounter; i++)
				b += Bbooks[i] + "\n";
			return b;
		} else
			System.out.println("There are no borrowed Books!");
		return b;
	}

	public void savetofile(String file) throws IOException {
		File f = new File(file);
		FileOutputStream s1 = new FileOutputStream(f);
		ObjectOutputStream s2 = new ObjectOutputStream(s1);
		for (int i = 0; i < BbCounter; i++)
			s2.writeObject(Bbooks[i]);

		s1.close();
		s2.close();
	}

	// read->input
	public void LoadFromfile(String filename) throws IOException {
		int index = 0;
		File f = new File(filename);
		FileInputStream read = new FileInputStream(f);
		ObjectInputStream readObject = new ObjectInputStream(read);
		try {
			while (true) {
				try {
					Library E = (Library) readObject.readObject();
				} catch (ClassNotFoundException e) {
					System.out.println(e);

				}
			}

		} catch (EOFException e) {
			System.out.println("End of read");
			read.close();
			readObject.close();
		}

	}
}
