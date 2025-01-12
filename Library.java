//@MoeAlomar GitHub: https://github.com/MoeAlomar
import java.io.*;  
public class Library {
	public static String name;
	public static Customer Customers[];
	public static Book books[];
	public static int bCount;
	private int cuCount;
	public Library() {}
	// Library Constructor to initialize the arrays
	public Library(String name,int size) {
		this.name = name;
		books = new Book[size];
		bCount = 0;
	
	}
	public String getName() {
		return name;
	}
	public int getbCount() {
		return bCount;
	}
	
	//checks if there is Space in the books array or if the book is already added.
public static boolean addbook(Book b) throws FullOrAddedException{
	for(int i = 0;i<bCount;i++)
	if(bCount == books.length || books[i].equals(b.ISBN)) {
		throw new FullOrAddedException("The library is full or book is already added!");
	}
	if(b instanceof PaperBook)
	books[bCount++] = new PaperBook ((PaperBook) b);
	else if(b instanceof eBook)
		books[bCount++] = new eBook ((eBook) b);
	System.out.println(books[bCount-1]);
	return true;
}
// Removes the given Book from the library and decrements the counter
public static boolean removebook (int ISBN) throws NotFoundException {
	String tempName;
	for(int i = 0;i < bCount;i++) {
		if(books[i].equals(ISBN)) {
			tempName = books[i].name;
			books[i] = books[bCount-1]; 
			System.out.println("Book " + tempName  +" has been removed!");
			bCount--;
			return true;
		}
	}
	throw new NotFoundException ("Book has not been found.");
}

//a method that Searches for a book in the Library using it's name

public static Book findBook(String name) {
	for(int i = 0;i< bCount;i++) {
		if(books[i].name.equalsIgnoreCase(name)|| books[i].author.equalsIgnoreCase(name) 
				|| books[i].type.equalsIgnoreCase(name))
			return books[i];}
		System.out.println("No Books found!");
		return null;
}
//a method that Searches for a book in the Library using it's name & author

public static Book findBook(String name,String author) {
	for(int i = 0;i< bCount;i++) {
		if(books[i].author.equalsIgnoreCase(author) && books[i].name.equalsIgnoreCase(name))
			return books[i];}
		System.out.println("No Books found!");
		return null;	
		}

//a method that Searches for a book in the Library using it's name,author, and ISBN

public static Book findBook(String name,String author,int ISBN) {
	for(int i = 0;i< bCount;i++) {
		if(books[i].author.equalsIgnoreCase(author) && books[i].name.equalsIgnoreCase(name)
				&& books[i].ISBN == ISBN)
			return books[i];}
		System.out.println("No Books found!");
		return null;
}

//a method that Searches for a book in the Library using it's ISBN

public static Book findBook(int ISBN) {
	for(int i = 0;i< bCount;i++) {
		if(books[i].ISBN == ISBN)
			return books[i];
		}
	
		return null;
}
public static void findbook(String type) {
	for(int i= 0;i <bCount;i++) {
	if(type.equalsIgnoreCase("ebook") && books[i] instanceof eBook)
		System.out.println(((eBook)books[i]));
	else if(type.equalsIgnoreCase("PaperBook") && books[i] instanceof PaperBook)
		System.out.println(((PaperBook)books[i]));}
		
}
// a method that Searches for a book in the Library using it's name,author,ISBN,Type
	public static Book findBook(String name,String author,int ISBN,String type) {
		for(int i = 0;i< bCount;i++) {
			if(books[i].author.equalsIgnoreCase(author) && books[i].name.equalsIgnoreCase(name)
					&& books[i].ISBN == ISBN && books[i].type.equalsIgnoreCase(type))
			return books[i];}
		System.out.println("No Books found!");
		return null;
}

	public boolean addCustomer(Customer a) {
		if(cuCount<Customers.length) {
			for (int i = 0; i< Customers.length;i++)
				Customers[cuCount++] = a;
		return true;}
		System.out.println("There is no place for more customers");
		return false;
	}
	public boolean removeCustomer(int a) {
		for(int i = 0; i<cuCount;i++) {
			if (Customers[i].equals(a)) {
				cuCount--;
				Customers[i] = null;
		System.out.println("Customer Removed!");
		return true;}}
		System.out.println("Customer Not Found!");
		return false;
		
	}
	public void showCustomers() {
		for(int i =0; i<cuCount; i++)
		System.out.println(Customers[i]);
	}
	public static String displayAllBooks() {
		if(bCount == 0) {
			System.out.println("there are no books in the Library!");
			return null;}
		
    	System.out.println("All Books in the library: \n");
    	String bk = null;
    	for(int i = 0; i<bCount;i++) {
		
		if(books[i] instanceof eBook)
		bk +=	(eBook)books[i] + "\n"; 
		if(books[i] instanceof PaperBook)
			bk += (PaperBook) books[i] + "\n";}
		return bk;}
	
	public String toString() {
		String L = "Library: (" + name +") \n Books in the Library: "; 
		 for(int i = 0;i<bCount;i++)
			 L += "\n" + books[i];
		 L+= "Customers Registerd in The Library: \n";
		 for(int i = 0;i<cuCount;i++)
		L+=	"\n" + Customers[i];
		 return L;
	}
	//Write-->output  
	public void savetofile(String file) throws IOException{  
	    File f=new File(file);;  
	    FileOutputStream s1=new FileOutputStream(f);  
	    ObjectOutputStream s2= new ObjectOutputStream(s1);  
	    for(int i=0;i<bCount;i++)  
	    s2.writeObject(books[i]);  
	      
	    s1.close();  
	    s2.close();  
	}  
	//read->input  
	public void LoadFromfile(String filename) throws IOException{  
	    int index=0; 
	    File f=new File(filename);  
	    FileInputStream read= new FileInputStream(f);  
	    ObjectInputStream readObject=new ObjectInputStream(read);  
	    try {  
	    while(true) {  
	    try {  
	    Book E=(Book)readObject.readObject();   
	    }catch(ClassNotFoundException e) {  
	        System.out.println(e);  
	      
	    }}  
	      
	}catch(EOFException e) {  
	    System.out.println("End of read");  
	    read.close();  
	    readObject.close();  
	}  
	      
	}  

}

