  //@MoeAlomar GitHub: https://github.com/MoeAlomar
import java.io.Serializable;

public class eBook extends Book implements Serializable{
	
	protected int size;
	

	public eBook(String name, String author, int ISBN,String type,int size) {
		super(name, author, ISBN,type);
		this.size = size;
	
	}
	public eBook(eBook b) {
		super(b); 
		this.size = b.size;
		
	}
	public int checkSize(Book b) {
		if(b instanceof eBook)
			if(size >((eBook)b).size ) {
				System.out.print(name + " Has Larger Size with: " + size + "MB");
			return size;}
			else System.out.println(b.name + " Has Larger Size with: " + ((eBook)b).size + "MB");
			return ((eBook)b).size;
	}
	public String toString() {
		return super.toString() + " Size: " + size + "MB  \n";
	}
	
}
