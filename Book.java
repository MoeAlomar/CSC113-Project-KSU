  //@MoeAlomar GitHub: https://github.com/MoeAlomar
import java.io.Serializable;

public abstract class Book implements Serializable {
protected String name;
protected String author;
protected int ISBN;
protected String type;
public Book(String name,String author,int ISBN,String type) {
	this.name = name;
	this.author = author; 	
	this.ISBN = ISBN;
	this.type = type;
	}
// a copy constructor
public Book (Book b) {
	this.name = b.name;
	this.author = b.author;
	this.ISBN = b.ISBN;
	this.type = b.type;
}
// Gets The name of the Book
public String getName() {
	return name;
}
// Gets The Author's Name
public String getAuthor() {
	return author;
}
public int getIsbn() {
	return ISBN;
}
public boolean equals(int ISBN) { 
	if(this.ISBN == ISBN)
		return true;
	return false;
	}
	
	public abstract int checkSize(Book b);
	
public String toString() {
	
	return "Title: (" + name + ") Author: (" + author + ") ISBN: (" + ISBN + ") Type: (" + type +")";
	
	}

}
