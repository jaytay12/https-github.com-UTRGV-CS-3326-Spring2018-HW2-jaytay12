
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu m = Menu();  
		Customers cu = new Customers(“customers.txt”);
		Inventory iv = new Inventory(“inventory.txt”);
		// display menu and implement functions  
		while(true) {  
			m.displayMainMenu();
			.    .    .   } 
		cu.updateCustomersFile(“customers.txt”); 
		iv.updateInventoryFile(“inventory.txt”); 
	}

}
