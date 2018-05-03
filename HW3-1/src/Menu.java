import java.util.Scanner;
//import java.io.*;

public class Menu {
	Scanner s = new Scanner(System.in);
	
	public Menu()
	{
		
	}

	public int mainMenu()
	{
		int answer;
		do {
			System.out.println("\n1.Log in \n2.Sign Up \n3.Exit");
			System.out.print("\nPlease input your choice: ");
			answer = s.nextInt();
			if (answer < 0 || answer > 4)
				System.out.println("Invalid input. Please select from the following.");
		}while(answer < 0 || answer > 4);
		
		return answer;
	}
	
	public int membrMenu()
	{
		int answer;
		do {
			System.out.println("\n1. Display inventory \n2. Sort cars \n3. Log out");
			System.out.print("\nPlease input your choice: ");
			answer = s.nextInt();
			if (answer < 0 || answer > 4)
				System.out.println("Invalid input. Please select from the following.");
		}while(answer < 0 || answer > 4);
		
		return answer;
	}
	
	public int invMenu()
	{
		int answer;
		do {
			System.out.println("\n1. New \n2. Used");
			System.out.print("\nPlease input your choice: ");
			answer = s.nextInt();
			if (answer < 0 || answer > 4)
				System.out.println("Invalid input. Please select from the following.");
		}while(answer < 0 || answer > 4);
		
		return answer;
	}
	
	public int sortMenu()
	{
		int answer;
		do {
			System.out.println("\n1. Sort by VIN\n2. Sort by Brand\n3. Sort by Model\n4. Sort by Year\n5. Sort by Mileage\n6. Sort by Price\n7. Sort by Color\n");
			System.out.print("Please input your choice: ");
			answer = s.nextInt();
			if (answer < 0 || answer > 8)
				System.out.println("Invalid input. Please select from the following.");
		}while(answer < 0 && answer > 8);
		
		return answer;
	}
	
	public int adminMenu()
	{
		int answer;
		do {
			System.out.println("\n1. Display inventory\n2. Add Car\n3. Delete Car\n4. Update Car\n5. Display Users\n6. Add User\n7. Delete User\n8. Update User\n9. Logout\n");
			System.out.print("Please input your choice: ");
			answer = s.nextInt();
			if (answer < 0 || answer > 10)
				System.out.println("Invalid input. Please select from the following.");
		} while (answer < 0 || answer > 10);
		
		return answer;
	}
	
	public int updateCarMenu()
	{
		int answer;
		do {
			System.out.println("\n1. Update brand \n2. Update model \n3. Update year \n4. Update mileage \n5. Update price \n6. Update color\n");
			System.out.print("Please select option: ");
			answer = s.nextInt();
			if (answer > 7 || answer < 0)
				System.out.println("Invalid input. Please select from the following.");
		} while (answer > 7 || answer < 0);
		System.out.println();
		
		return answer;
	}
	
	public int updateUserMenu()
	{
		int answer;
		do {
			System.out.println("\n1. Update password \n2. Update first name \n3. Update last name \n4. Update email\n");
			System.out.print("Please input: ");
			answer = s.nextInt();
			if (answer > 5 || answer < 0)
				System.out.println("Invalid input. Please select from the following.");
		} while (answer > 5 || answer < 0);
		System.out.println();
		
		return answer;
	}
}
