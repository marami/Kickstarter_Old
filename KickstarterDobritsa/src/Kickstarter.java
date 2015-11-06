import java.util.List;

public class Kickstarter {

	private static CategoryStorage categoryStorage = new CategoryStorage();
	private static Integer categoryNumber = null;
	private static Integer projectNumber = null;

	public static void main(String[] args) {			
		QuoteStorage quoteStorage = new QuoteStorage();
		System.out.println(quoteStorage.getRandomQuote() + "\n");				
		categoryNumber = chooseCategory();		
		projectNumber = chooseProject(categoryNumber);
		viewProject(projectNumber);		
		//ConsoleInspector.close();
		
	}
	
	public static Integer chooseCategory() {
		categoryStorage.printForChoice();
		System.out.println("\nChoose a category by number: ");		
		Integer categoryNumber = ConsoleInspector.getInt();
		if(categoryNumber == 0) {System.exit(0);}
		System.out.println("You have chosen the category: " + categoryStorage.getCategiry(categoryNumber - 1));		
		return categoryNumber;			
	}
	
	public static Integer chooseProject(Integer categoryNumber) {
		ProjectStorage.setProjectStorage(categoryNumber - 1);
		ProjectStorage.printAllShort();			
		System.out.println("\nChoose a project by number: ");
		Integer projectNumber = ConsoleInspector.getInt();
		if(projectNumber == 0) {chooseCategory();};
		System.out.println("You have chosen the project: " + ProjectStorage.getProject(projectNumber).getName());
		return projectNumber;
	}
	
	public static void viewProject(Integer projectNumber){		
		Project project = new Project();
		project =  ProjectStorage.getProject(projectNumber);
		project.printFull();
		if(ConsoleInspector.getInt() == 0) {chooseProject(categoryNumber);}
	}
}