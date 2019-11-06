import java.text.NumberFormat;

public class Product {
	private String name;		//stores the name property for each objected created
	private double price;		//stores the price property for each objected created
	private String type;		//stores the type property for each objected created. This is used to diffrentiate between the different kinds of objects, to print the author property which only appears in Book objects for example
	private int stock;		//stores the stock property for each objected created
	private int stockTemp;		//stores the stock property for each objected created but is use to temporarily store the current transaction stock amount until the transaction is completed or canceled
	
	public void setName(String n){		//set method for name property
		name=n;
	}
	public String getName(){		//get method for name property
		return name;
	}
	public void setPrice(double p){		//set method for price property
		price=p;
	}
	public void setStock(int s){		//set method for stock property
		stock=s;
	}
	public void setStockTemp(int s){		//set method for stockTemp property
		stockTemp=s;
	}
	public double getPrice(){		//get method for price property
		return price;
	}
	public void setType(String t){		//set method for type property
		type=t;
	}
	public String getType(){		//get method for type property
		return type;
	}
	public int getStock(){		//get method for stock property
		return stock;
	}
	public int getStockTemp(){		//get method for stockTemp property
		return stockTemp;
	}
	public void print(){		//print method for objects in the inventory arraylist
		NumberFormat formatter = NumberFormat.getCurrencyInstance();		//formats the displayed amount due to have correct currency symbol and decimal places
		String moneyString = formatter.format(price);
		
		System.out.print("Name: " + name + "\t");
		System.out.print("Price: " + moneyString + "\t");
		System.out.print("Stock: " + stockTemp + "\t");
	}
	public void printBasket(){		//print method for objects in the basket arraylist
		NumberFormat formatter = NumberFormat.getCurrencyInstance();		//formats the displayed amount due to have correct currency symbol and decimal places
		String moneyString = formatter.format(price);
		
		System.out.print("Name: " + name + "\t");
		System.out.print("Price: " + moneyString + "\t");
		System.out.print("Amount in Basket: " + (stock - stockTemp) + "\t");
	}
}
