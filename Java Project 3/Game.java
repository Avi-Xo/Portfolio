
public class Game extends Product{
	private int age;		//stores the age property for each Game objected created
	private String platform;		//stores the platform property for each Game objected created
	
	public void setAge(int a){		//set method for age property
		age=a;
	}
	public int getAge(){		//get method for age property
		return age;
	}
	public void setPlatform(String p){		//set method for platform property
		platform=p;
	}
	public String getPlatform(){		//get method for platform property
		return platform;
	}
}