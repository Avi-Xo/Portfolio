
public class Book extends Product{
	private String genre;		//stores the genre property for each Book objected created
	private String author;		//stores the author property for each Book objected created
	
	public String getAuthor(){		//get method for author property
		return author;
	}
	public void setAuthor(String a){		//set method for author property
		author = a;
	}
	public void setGenre(String g){		//set method for genre property
		genre=g;
	}
	public String getGenre(){		//get method for genre property
		return genre;
	}
}
