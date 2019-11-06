import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;

/**
 * @author 15-2309
 *
 *avi byrne
 *
 *megan elaine
 *
 *test case is order price items combined=total correct
 */
public class Main {
static Scanner input = new Scanner(System.in);		//scanner is used to capture user input
static ArrayList<Product> inventory = new ArrayList<Product>();		//this arraylist is used to store the objects for each product available in the shop
static ArrayList<Product> basket = new ArrayList<Product>();		//this arraylist is used to store the objects for each product in the users basket
static double transactionTotal=0;		//stores the current total amount to be paid for each transaction
static String purchaseType = "all";		//when users view just one type of product this is used to keep the selected product ID correct
	
	public static void main(String[] args) {		//main method that runs the program. Calls the main menu which then loops until program is closed
		mainMenu();
	}

	public static void mainMenu() {
		System.out.println("**********************************");
		System.out.println("	Main Shopping Menu");
		System.out.println("**********************************");
		System.out.println("Press 1 to View All Products");
		System.out.println("Press 2 to View Books");
		System.out.println("Press 3 to View Clothing");		//displays the available options to the user
		System.out.println("Press 4 to View Games");
		System.out.println("Press 5 to View Basket");
		System.out.println("Press 6 to Clear Basket");
		
		String choice = input.next();
		
		switch(choice){
		
		case "1":{
			if(inventory.size()>0){		//makes sure there are objects present in inventory before attempting to print them
				printAllProducts();
				purchaseType = "all";
				purchase();
				 } 
				 else {
				  System.out.println("No Products Listed");
				  mainMenu();
				  }
			break;
		}
		case "2":{
			if(inventory.size()>0){		//makes sure there are objects present in inventory before attempting to print them
				printBook();
				purchaseType = "book";
				purchase();
				 } 
				 else {
				  System.out.println("No Products Listed");
				  mainMenu();
				  }
			break;
		}
		case "3":{
			if(inventory.size()>0){		//makes sure there are objects present in inventory before attempting to print them
				printClothing();;
				purchaseType = "clothing";
				purchase();
				 } 
				 else {
				  System.out.println("No Products Listed");
				  mainMenu();
				  }
			break;
		}
		case "4":{
			if(inventory.size()>0){		//makes sure there are objects present in inventory before attempting to print them
				printGame();
				purchaseType = "game";
				purchase();
				 } 
				 else {
				  System.out.println("No Products Listed");
				  mainMenu();
				  }
			break;
		}
		case "5":{
			if(basket.size()>0){		//makes sure there are objects present in inventory before attempting to print them
				printBasket();
				purchaseChoice();
				 } 
				 else {
				  System.out.println("Basket is Empty");
				  mainMenu();
				  }
			break;
		}
		case "6":{
			basket.clear();		//clears the basket of objects and returns stock to origional values when transaction is canceled 
			for (Product i: inventory){
				i.setStockTemp(i.getStock());
			}
			mainMenu();
			break;
		}
		case "99":{
			adminMenu();		//calls the hidden admin menu 
			break;
		}
		default:{
			System.out.println("Invalid Entry");		//error message displayed when invalid data is entered
			mainMenu();
		}
		}
		
	}

	public static void adminMenu() {
		System.out.println("****************************");
		System.out.println("Press 1 to Add New Products");
		System.out.println("Press 2 to View Products");
		System.out.println("Press 3 to Edit a Product's Details");		//displays the available options to the user
		System.out.println("Press 4 to Add Preset Items");
		System.out.println("Press 5 to Remove a Product");
		System.out.println("Press 6 to Return to Shopping Menu");
		
		String choice = input.next();
		
		switch(choice){
		
		case "1":{
			addMenu();		//calls the menu for adding new products
			break;
		}
		case "2":{
			if(inventory.size()>0){		//makes sure there are objects present in inventory before attempting to print them
				printAllProducts();
				adminMenu();
				 } 
				 else {
				  System.out.println("No Products Listed");
				  adminMenu();
				  }
			break;
		}
		case "3":{
			if(inventory.size()>0){		//makes sure there are objects present in inventory before attempting to print them
				editProduct();
				adminMenu();
				 } 
				 else {
				  System.out.println("No Products Listed");
				  adminMenu();
				  }
			break;
		}
		case "4":{
			preSet();		//calls a method that adds preset products for ease of testing program
			mainMenu();
			break;
		}
		case "5":{
			if(inventory.size()>0){		//makes sure there are objects present in inventory before attempting to print them
				printAllProducts();
				deleteProduct();
				adminMenu();
				 } 
				 else {
				  System.out.println("No Products Listed");
				  adminMenu();
				  }
			break;
		}
		case "6":{
			mainMenu();		//returns to main menu
			break;
		}
		default:{
			System.out.println("Invalid Entry");		//error message displayed when invalid data is entered
			adminMenu();
		}
		}
	}

	public static void deleteProduct(){
		System.out.println("Please Input ID Number of Product to Delete");
		int choice = 0;
		try{choice = input.nextInt();		//captures the user's input
		}catch(Exception e){
		}
		inventory.remove(choice-1);		//removes the product object that the admin requests
	}

	public static void addMenu() {
		System.out.println("Press 1 to Add New Book");
		System.out.println("Press 2 to Add New Item of Clothing");
		System.out.println("Press 3 to Add New Game");		//displays the available options to the user
		System.out.println("Press 4 to go to Admin Menu");
		System.out.println("Press 5 to Return to Shopping Menu");
		
		String choice = input.next();
		
		switch(choice){
		
		case "1":{
			addBook();		//adds a Book object
			addMenu();
			break;
		}
		case "2":{
			addClothing();		//adds a Clothing object
			addMenu();
			break;
		}
		case "3":{
			addGame();		//adds a Game object
			addMenu();
			break;
		}
		case "4":{
			adminMenu();		//returns to admin menu
			break;
		}
		case "5":{
			mainMenu();		//returns to main menu
			break;
		}
		default:{
			System.out.println("Invalid Entry");		//error message displayed when invalid data is entered
			addMenu();
		}
		}
	
	}
	
	public static void editProduct(){
		printAllProducts();		//prints all products
		
			System.out.println("Please Input ID Number of Product to Edit");
			int index=1;
			int choice = 0;
			try{choice = input.nextInt();		//captures the user's input
			}catch(Exception e){
			}
			
				for(Product i: inventory){		//loops through all objects in inventory to find the requested product
					if(index==choice){
					
						if(i.getType()=="book"){
							System.out.println("Press 1 to Edit Name");
							System.out.println("Press 2 to Edit Price");
							System.out.println("Press 3 to Edit Genre");		//displays the available options to the user
							System.out.println("Press 4 to Edit Author");
							System.out.println("Press 5 to Edit Stock");
							
							String subChoice = input.next();
							Book b = (Book)i;
								
								switch (subChoice){
								
								case "1":{
									System.out.println("Enter New Name");
									try{
										BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
										i.setName(reader.readLine());
									}
									catch(Exception e){
									}
									break;
								}
								case "2":{
									System.out.println("Enter New Price");
									try{i.setPrice(input.nextDouble());
									}catch(Exception e){	
									}
									break;
								}
								case "3":{
									System.out.println("Enter New Genre");
									try{
										BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
										b.setGenre(reader.readLine());
									}
									catch(Exception e){
									}
									break;
								}
								case "4":{
									System.out.println("Enter New Author");
									try{
										BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
										b.setAuthor(reader.readLine());
									}
									catch(Exception e){
									}
									break;
								}
								case "5":{
									System.out.println("Enter New Stock");
									try{i.setStock(input.nextInt());
									}catch(Exception e){
									}
									break;
								}
								default:{
									System.out.println("Invalid Entry");		//error message displayed when invalid data is entered
									editProduct();
								}
							}	
						}
						if(i.getType()=="clothing"){
							System.out.println("Press 1 to Edit Name");
							System.out.println("Press 2 to Edit Price");
							System.out.println("Press 3 to Edit Size");		//displays the available options to the user
							System.out.println("Press 4 to Edit Colour");
							System.out.println("Press 5 to Edit Stock");
							
							String subChoice = input.next();
							Clothing c = (Clothing)i;
								
								switch (subChoice){
								
								case "1":{
									System.out.println("Enter New Name");
									try{
										BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
										i.setName(reader.readLine());
									}
									catch(Exception e){
									}
									break;
								}
								case "2":{
									System.out.println("Enter New Price");
									try{i.setPrice(input.nextDouble());
									}catch(Exception e){
									}
									break;
								}
								case "3":{
									System.out.println("Enter New Size");
									try{c.setSize(input.nextInt());
									}catch(Exception e){
									}
									break;
								}
								case "4":{
									System.out.println("Enter New Colour");
									try{
										BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
										c.setColour(reader.readLine());
									}
									catch(Exception e){;
									}
									break;
								}
								case "5":{
									System.out.println("Enter New Stock");
									try{i.setStock(input.nextInt());
									}catch(Exception e){
									}
									break;
								}
								default:{
									System.out.println("Invalid Entry");		//error message displayed when invalid data is entered
									editProduct();
								}
							}								
						}
						if(i.getType()=="game"){
							System.out.println("Press 1 to Edit Name");
							System.out.println("Press 2 to Edit Price");
							System.out.println("Press 3 to Edit Age Rating");		//displays the available options to the user
							System.out.println("Press 4 to Edit Platform");
							System.out.println("Press 5 to Edit Stock");
							
							String subChoice = input.next();
							Game g = (Game) i;
								
								switch (subChoice){
								
								case "1":{
									System.out.println("Enter New Name");
									try{
										BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
										i.setName(reader.readLine());
									}
									catch(Exception e){
									}
									break;
								}
								case "2":{
									System.out.println("Enter New Price");
									try{i.setPrice(input.nextDouble());
									}catch(Exception e){
									}
									break;
								}
								case "3":{
									System.out.println("Enter New Age Rating");
									try{g.setAge(input.nextInt());
									}catch(Exception e){
									}
									break;
								}
								case "4":{
									System.out.println("Enter New Platform");
									try{
										BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
										g.setPlatform(reader.readLine());
									}
									catch(Exception e){
									}
									break;
								}
								case "5":{
									System.out.println("Enter New Stock");
									try{i.setStock(input.nextInt());
									}catch(Exception e){
									}
									break;
								}
								default:{
									System.out.println("Invalid Entry");		//error message displayed when invalid data is entered
									editProduct();
								}
							}	
						}
					}
					index++;
				}
		}

	public static void purchase(){
		System.out.println("*************************************");
		System.out.println("Press 1 to Add Items to Basket");		//displays the available options to the user
		System.out.println("Press 2 to View Different Items");
		
		String choice = input.next();
		int productId=1;
		double subtotal=0;
		
		switch(choice){
		
		case "1":{
			System.out.println("Please Enter the ID of the Item You Wish to Add to Basket");
			int userChoice = 0;
			try{userChoice = input.nextInt();		//captures the users input
			}catch(Exception e){
				mainMenu();
			}
			
			if(purchaseType.equals("book") || purchaseType.equals("clothing") || purchaseType.equals("game")){		//if user viewed a specific product category this will make sure that the correct product ID will be used
				for(Product i: inventory){
					if(i.getType().equals(purchaseType)){
						if(userChoice==productId){
							System.out.println("Enter the Amount of the Item You Wish to Add to Cart");
							int orderQty = 0;
							
							try{orderQty = input.nextInt();		//captures the amount of an item the user wishes to purchase
							}catch(Exception e){
								mainMenu();
							}
							
							if(orderQty>i.getStockTemp()){
								System.out.println("Insufficient stock. Please try again");
								mainMenu();
							}
							else{
								subtotal = i.getPrice() * orderQty;
								transactionTotal += subtotal;		//adds the cost of the new additions to the user's basket to any existing
								i.setStockTemp((i.getStockTemp()-orderQty));		//updates the current available stock of an item
							}
							if(!basket.contains(i)){
								basket.add(i);		//adds the product object to the user's basket
							}
						}
						productId++;
					}
				 }
			}
				else{
					for(Product i: inventory){
						if(userChoice==productId){
							System.out.println("Enter the Amount of the Item You Wish to Add to Cart");
							int orderQty = 0;
							
							try{orderQty = input.nextInt();		//captures the amount of an item the user wishes to purchase
							}catch(Exception e){
								mainMenu();
							}
							
							if(orderQty>i.getStockTemp()){
								System.out.println("Insufficient stock. Please try again");
								mainMenu();
							}
							else{
								subtotal = i.getPrice() * orderQty;
								transactionTotal += subtotal;		//adds the cost of the new additions to the user's basket to any existing
								i.setStockTemp((i.getStockTemp()-orderQty));		//updates the current available stock of an item
							}
							if(!basket.contains(i)){
								basket.add(i);		//adds the product object to the user's basket
							}
						}
						productId++;
					}
				 }
			purchaseChoice();
		}
		case "2":{
			mainMenu();
			break;
		}
		default:{
			System.out.println("Invalid Entry");		//error message displayed when invalid data is entered
			mainMenu();
			break;
		}
		}
	}
	
	public static void purchaseChoice(){
		System.out.println("*************************************");
		System.out.println("Press 1 to Continue to Payment");		//displays the available options to the user
		System.out.println("Press 2 to Add More Items to Basket");
		
		String choice = input.next();
	
		switch(choice){
	
		case "1":{
			payment();
			break;
		}
		case "2":{
			mainMenu();
			break;
		}
		default:{
			System.out.println("Invalid Entry.");		//error message displayed when invalid data is entered
			purchaseChoice();
			break;
		}
		}
		
	}
	
	public static void payment(){
		printBasket();
		double transactionTotalOrigional = transactionTotal;
		NumberFormat formatter = NumberFormat.getCurrencyInstance();		//formats the displayed amount due to have correct currency symbol and decimal places
		String moneyString = formatter.format(transactionTotal);
		
				System.out.println("Current Amount Due is: " + moneyString + " Enter payment");
				double moneyEntered = 0;
				try{moneyEntered = input.nextDouble();
				}catch(Exception e){
				}
				
				while (moneyEntered<transactionTotal){				//keeps the payment active until total amount due has been paid
					String moneyString2 = formatter.format(transactionTotal-moneyEntered);
					System.out.println("Remaining Amount Due is: " + moneyString2);
					try{moneyEntered = moneyEntered + input.nextDouble();
					}catch(Exception e){
						transactionTotal = transactionTotalOrigional;		//if an error occurs the amount to be paid will reset to correct value
						mainMenu();
					}
				}
				transactionComplete();
	}

	public static void transactionComplete(){
		for (Product i: inventory){
			i.setStock(i.getStockTemp());		//updates stock amount to new total
		}
		basket.clear();		//removes purchased products from the user's basket
		transactionTotal = 0;		//resets the transaction total for the next transaction
	}

	public static void preSet(){
		Clothing c = new Clothing();
		c.setName("Dress");
		c.setPrice(30);
		c.setSize(12);
		c.setColour("Blue");		//adds a Clothing object
		c.setStock(100);
		c.setStockTemp(100);
		c.setType("clothing");
		inventory.add(c);
		
		Clothing c1 = new Clothing();
		c1.setName("Skirt");
		c1.setPrice(40);
		c1.setSize(13);
		c1.setColour("Green");		//adds a Clothing object
		c1.setStock(100);
		c1.setStockTemp(100);
		c1.setType("clothing");
		inventory.add(c1);
		
		Book b = new Book();
		b.setName("Java");
		b.setPrice(35);
		b.setGenre("Education");
		b.setAuthor("Joe");		//adds a Book object
		b.setStock(100);
		b.setStockTemp(100);
		b.setType("book");
		inventory.add(b);
		
		Book b1 = new Book();
		b1.setName("PHP");
		b1.setPrice(45);
		b1.setGenre("Education");
		b1.setAuthor("Jim");		//adds a Book object
		b1.setStock(100);
		b1.setStockTemp(100);
		b1.setType("book");
		inventory.add(b1);
		
		Game g = new Game();
		g.setName("CoD");
		g.setPrice(59.99);
		g.setAge(18);
		g.setPlatform("Xbone");		//adds a Game object
		g.setStock(100);
		g.setStockTemp(100);
		g.setType("game");
		inventory.add(g);
		
		Game g1 = new Game();
		g1.setName("LoL");
		g1.setPrice(3.50);
		g1.setAge(18);
		g1.setPlatform("PC");		//adds a Game object
		g1.setStock(100);
		g1.setStockTemp(100);
		g1.setType("game");
		inventory.add(g1);
	}

	public static void printAllProducts(){
		int productId=1;
		
		System.out.println("**********************************");
		
		for (Product i: inventory){		//loops through the objects in the inventory arraylist and prints the details of each object
			if(i.getType()=="book"){
				Book b = (Book)i;
				System.out.print("ID: " + productId + "\t");
				b.print();
				System.out.print("Author: " + b.getAuthor() + "\t");		//prints Book object specific properties
				System.out.print("Genre: " + b.getGenre() + "\n");
				productId++;
			}
			if(i.getType()=="clothing"){
				Clothing c = (Clothing)i;
				System.out.print("ID: " + productId + "\t");
				c.print();
				System.out.print("Colour: " + c.getColour() + "\t");		//prints Clothing object specific properties
				System.out.print("Size: " + c.getSize() + "\n");
				productId++;
			}
			if(i.getType()=="game"){
				Game g = (Game) i;
				System.out.print("ID: " + productId + "\t");
				g.print();
				System.out.print("Platform: " + g.getPlatform() + "\t");		//prints Game object specific properties
				System.out.print("Age: " + g.getAge() + "\n");
				productId++;
			}
		}
	}
	
	public static void printBasket(){
		int productId=1;
		
		System.out.println("****************Basket******************");
		
		for (Product i: basket){		//loops through the objects in the basket arraylist and prints the details of each object
			if(i.getType()=="book"){
				Book b = (Book)i;
				System.out.print("ID: " + productId + "\t");
				b.printBasket();
				System.out.print("Author: " + b.getAuthor() + "\t");		//prints Book object specific properties
				System.out.print("Genre: " + b.getGenre() + "\n");
				productId++;
			}
			if(i.getType()=="clothing"){
				Clothing c = (Clothing)i;
				System.out.print("ID: " + productId + "\t");
				c.printBasket();
				System.out.print("Colour: " + c.getColour() + "\t");		//prints Clothing object specific properties
				System.out.print("Size: " + c.getSize() + "\n");
				productId++;
			}
			if(i.getType()=="game"){
				Game g = (Game) i;
				System.out.print("ID: " + productId + "\t");
				g.printBasket();
				System.out.print("Platform: " + g.getPlatform() + "\t");		//prints Game object specific properties
				System.out.print("Age: " + g.getAge() + "\n");
				productId++;
			}
		}
	}

	public static void printBook() {
		int productId=1;
		boolean found = false;
		int items = 0;
		
		System.out.println("		************************* Books *************************");
		
		for (Product i: inventory){
			if(i.getType()=="book"){
				Book b = (Book)i;
				System.out.print("ID: " + productId + "\t");
				b.print();
				System.out.print("Author: " + b.getAuthor() + "\t");		//prints Book object specific properties
				System.out.print("Genre: " + b.getGenre() + "\n");
				found = true;
				productId++;
			}
			if(found == false){
				items++;
				if(items == inventory.size()){
					System.out.println("No Books Listed");
				}
			}
		}
	}
	
	public static void printClothing() {
		int productId=1;
		boolean found = false;
		int items = 0;
		
		System.out.println("		************************* Clothing *************************");
		
		for (Product i: inventory){
			if(i.getType()=="clothing"){
				Clothing c = (Clothing)i;
				System.out.print("ID: " + productId + "\t");
				c.print();
				System.out.print("Colour: " + c.getColour() + "\t");		//prints Clothing object specific properties
				System.out.print("Size: " + c.getSize() + "\n");
				found = true;
				productId++;
			}
			if(found == false){
				items++;
				if(items == inventory.size()){
					System.out.println("No Clothing Listed");
				}
			}
		}
	}
	
	public static void printGame() {
		int productId=1;
		boolean found = false;
		int items = 0;
		
		System.out.println("		************************* Games *************************");
		
		for (Product i: inventory){
			if(i.getType()=="game"){
				Game g = (Game) i;
				System.out.print("ID: " + productId + "\t");
				g.print();
				System.out.print("Platform: " + g.getPlatform() + "\t");		//prints Game object specific properties
				System.out.print("Age: " + g.getAge() + "\n");
				found = true;
				productId++;
			}
			if(found == false){
				items++;
				if(items == inventory.size()){
					System.out.println("No Games Listed");
				}
			}
		}
	}
	
	public static void addClothing() {
		Clothing c = new Clothing();
		System.out.println("Enter Clothing Name");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
			c.setName(reader.readLine());
		}
		catch(Exception e){
		}
		System.out.println("Enter Price");
		try{c.setPrice(input.nextDouble());
		}catch(Exception e){
			mainMenu();
		}
		System.out.println("Enter Size");
		try{c.setSize(input.nextInt());
		}catch(Exception e){
			mainMenu();
		}
		System.out.println("Enter Colour");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
			c.setColour(reader.readLine());
		}
		catch(Exception e){
		}
		System.out.println("Enter Stock");
		try{int stock =input.nextInt();
		c.setStock(stock);
		c.setStockTemp(stock);
		}catch(Exception e){
			mainMenu();
		}
		c.setType("clothing");
		inventory.add(c);		//adds the Clothing object to the inventory arraylist
	}

	public static void addBook() {
		Book b = new Book();
		System.out.println("Enter Book Title");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
			b.setName(reader.readLine());
		}
		catch(Exception e){
		}
		System.out.println("Enter Price");
		try{b.setPrice(input.nextDouble());
		}catch(Exception e){
			mainMenu();
		}
		System.out.println("Enter Genre");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
			b.setGenre(reader.readLine());
		}
		catch(Exception e){
		}
		System.out.println("Enter Author");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
			b.setAuthor(reader.readLine());
		}
		catch(Exception e){
		}
		System.out.println("Enter Stock");
		try{b.setStock(input.nextInt());
		}catch(Exception e){
			mainMenu();
		}
		b.setType("book");
		inventory.add(b);		//adds the Book object to the inventory arraylist
	}
	public static void addGame() {
		Game g = new Game();
		System.out.println("Enter Game Title");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
			g.setName(reader.readLine());
		}
		catch(Exception e){
		}
		System.out.println("Enter Price");
		try{g.setPrice(input.nextDouble());
		}catch(Exception e){
			mainMenu();
		}
		System.out.println("Enter Age Rating");
		try{g.setAge(input.nextInt());
		}catch(Exception e){
			mainMenu();
		}
		System.out.println("Enter Platform");	
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		//buffered reader is useful for capturing text user input
			g.setPlatform(reader.readLine());
		}
		catch(Exception e){
		}
		System.out.println("Enter Stock");
		try{g.setStock(input.nextInt());
		}catch(Exception e){
			mainMenu();
		}
		g.setType("game");
		inventory.add(g);		//adds the Game object to the inventory arraylist
	}

}