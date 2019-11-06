
public class Clothing extends Product{
	private int size;		//stores the size property for each Clothing objected created
	private String colour;		//stores the colour property for each Clothing objected created
	
	public void setSize(int s){		//set method for size property
		size=s;
	}
	public int getSize(){		//get method for size property
		return size;
	}
	public void setColour(String c){		//set method for colour property
		colour=c;
	}
	public String getColour(){		//get method for colour property
		return colour;
	}
}
