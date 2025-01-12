//@MoeAlomar GitHub: https://github.com/MoeAlomar
public class PaperBook extends Book {
	protected int nPages;
	protected String coverType;

	public PaperBook(String name, String author, int ISBN,String type,int nPages, String coverType) {
		super(name, author, ISBN,type); 
		this.nPages = nPages;
				this.coverType = coverType;
		
		
	}
	public PaperBook(PaperBook b) {
		super(b); 
		this.nPages = b.nPages;
		this.coverType = b.coverType;
		
	}
	public int checkSize(Book b) {
		if(b instanceof PaperBook)
		if(nPages >((PaperBook)b).nPages ) {
			System.out.print(name + " Has more Pages with: " + nPages + " Pages");
		return nPages;}
		else System.out.println(b.name + " Has more Pages with: " + ((PaperBook)b).nPages + " Pages");
		return ((PaperBook)b).nPages;
		}

	public String toString() {
		return super.toString() + " Number of Pages: (" + nPages + ") Cover Type: (" + coverType + ") \n";
	}
}
