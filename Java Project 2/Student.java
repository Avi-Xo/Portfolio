
/**
 * @author Avi Byrne
 * @category Assignment 2
 *
 */
public class Student {
	String name;
	String age;
	String course;
	double balance=250;
	boolean paid = false;
	/*
	 * These variables store all the information of each student object
	 */
	
	public Student(String localName, String localAge){   //constructor to create student objects
		name = localName;
		age = localAge;
	}
	
	public String getName(){    //method to return the student object's name variable
		return name;
	}
	
	public String getAge(){    //method to return the student object's age variable
		return age;
	}
	
	public String getCourse(){    //method to return the student object's course variable
		return course;
	}
	
	public void setCourse(String s){    //method to set the student object's course variable
		course = s;
	}
	
	public void editName(String newName){    //method to set the student object's name variable
		name = newName;
	}
	
	public void editAge(String newAge){    //method to set the student object's age variable
		age = newAge;
	}
	
	public void editPaid(boolean newPaid){    //method to set the student object's paid variable
		paid = newPaid;
	}
	public double getBalance(){    //method to return the student object's balance variable
		return balance;
	}
	
	public boolean havePaid(){    //method to return the student object's paid variable
		return paid;
	}
	
	public void setBalance(){    //method to set the student object's balance variable
		balance=0;
		paid=true;
	}
	
	public void print(){    //method to print each student object required
		System.out.print("Name: \t" + name);
		System.out.print("\t Age: \t" + age);
		System.out.print("\t Course: \t" + course);
		System.out.println("\t Paid: \t" + paid);
	}
}
