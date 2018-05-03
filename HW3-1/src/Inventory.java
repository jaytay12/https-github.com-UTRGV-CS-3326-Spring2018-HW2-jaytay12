import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Inventory  extends Cars {
	
	int nc = 0; //keeps track of # of Cars in array.
	Cars [] cars = new Cars[100];
	Scanner s = new Scanner(System.in);
	
	
	
	//reads file and stores data into Car array
	public Inventory() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		Connection c = DriverManager.getConnection("jdbc:mysql://35.184.84.73:3306/carmax","root","1234qwer");
		//Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","1234qwer");
		Statement s = c.createStatement();
		ResultSet res = s.executeQuery("select * from cars");
		
		while (res.next())
		{
			cars[nc] = new Cars();
			cars[nc].vin = res.getString("vin");
			cars[nc].brand = res.getString("brand");
			cars[nc].model = res.getString("model");
			cars[nc].year = res.getInt("year");
			cars[nc].mileage = res.getInt("mileage");
			cars[nc].price = res.getDouble("price");
			cars[nc].color = res.getString("color");
			cars[nc].setNew(res.getInt("blandNew")); //.setNew() reads "Y" or "N" to determine whether true or false.
			nc++;
		}
		
		c.close();
	}
	
	
	
	//displays cars if they are brand new.
	public void displayNewInv()
	{
		System.out.println("\nVin\t        Brand\t         Model\t        Year\t        Mileage\t        Price\t        Color\t        New");
		for (int i = 0; i < nc; i++)
		{
			if (cars[i].brandnew == true)
				cars[i].displayCar();
		}
	}
	
	
	
	//displays cars that are not brand new.
	public void displayUsedInv()
	{
		System.out.println("\nVin\t        Brand\t         Model\t        Year\t        Mileage\t        Price\t        Color\t        New");
		for (int i = 0; i < nc; i++)
		{
			if (cars[i].brandnew == false)
				cars[i].displayCar();
		}
	}
	
	
	
	//displays all cars in inventory.
	public void displayInv()
	{
		System.out.println("\nVin\t        Brand\t         Model\t        Year\t        Mileage\t        Price\t        Color\t        New");
		for (int i = 0; i < nc; i++)
			cars[i].displayCar();
	}
	
	
	
	//updates car info in array and adds it into sql.
	public void updateInventoryFile() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		int count = -1;//control, if negative does not update file.
		String bn = " ";
		displayInv();
		System.out.print("\nPlease input VIN: ");
		String answer = s.next();
		
		for (int i  = 0; i < nc; i++)
		{
			if (answer.equals(cars[i].vin)) //compares user input to inventory info.
				count = i;
		}
		
		//updates array and updates text file.
		if (count >= 0)
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			Connection c = DriverManager.getConnection("jdbc:mysql://35.184.84.73:3306/carmax","root","1234qwer");
			//Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","1234qwer");
			Statement s = c.createStatement();
			long res;
			
			Menu menu = new Menu();
			int choice = menu.updateCarMenu();
			switch(choice)
			{
			case 1: cars[count].setBrand();
			//UPDATE cars SET brand = 'Toyota' WHERE vin = 5280k
					res = s.executeLargeUpdate("UPDATE cars SET brand = '" + cars[count].brand + "' WHERE vin = '" + cars[count].vin + "' ");
					break;
			case 2: cars[count].setModel();
					res = s.executeLargeUpdate("UPDATE cars SET model = '" + cars[count].model + "' WHERE vin = '" + cars[count].vin + "' ");
					break;
			case 3: cars[count].setYear();
					res = s.executeLargeUpdate("UPDATE cars SET year = " + cars[count].year + " WHERE vin = '" + cars[count].vin + "' ");
					break;
			case 4: cars[count].setMileage();
					res = s.executeLargeUpdate("UPDATE cars SET mileage = " + cars[count].mileage + " WHERE vin = '" + cars[count].vin + "' ");
					break;
			case 5: cars[count].setPrice();
					res = s.executeLargeUpdate("UPDATE cars SET price = " + cars[count].price + " WHERE vin = '" + cars[count].vin + "' ");
					break;
			case 6: cars[count].setColor();
					res = s.executeLargeUpdate("UPDATE cars SET color = '" + cars[count].color + "' WHERE vin = '" + cars[count].vin + "' ");
					break;
			}
			
			System.out.println("It's updated. Thank you.");
			
			c.close();
		}
		else
			System.out.println("VIN does not exist.");
	}
	
	
	
	//adds new Car info into array and text file.
	public void addNewCar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{	
		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		Connection c = DriverManager.getConnection("jdbc:mysql://35.184.84.73:3306/carmax","root","Abc123ume!");
		//Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","1234qwer");
		Statement st = c.createStatement();
		
		cars[nc] = new Cars();
		System.out.print("\nVIN: ");
		cars[nc].vin = s.next();
		
		System.out.print("Brand: ");
		cars[nc].brand = s.next();
		
		System.out.print("Model: ");
		cars[nc].model = s.next();
		
		System.out.print("Year: ");
		cars[nc].year = s.nextInt();
		
		System.out.print("Mileage: ");
		cars[nc].mileage = s.nextInt();
		
		System.out.print("Price: ");
		cars[nc].price = s.nextDouble();
		
		System.out.print("Color: ");
		cars[nc].color = s.next();
		
		System.out.print("New: ");
		String s1 = s.next();
		int n1 = 0;
		if (s1 == "Y") {
			cars[nc].setNew(1);
			n1 = 1;
		}
		else
			cars[nc].setNew(0);
		
		System.out.println("\nVin\t        Brand\t         Model\t        Year\t        Mileage\t        Price\t        Color\t        New");
		cars[nc].displayCar();
		System.out.println("\nSuccessfully this car has been added");
		long res = st.executeLargeUpdate("INSERT INTO cars VALUES ('" + cars[nc].vin + "', '" + cars[nc].brand + "', '" + cars[nc].model + "', " + cars[nc].year + ", " + cars[nc].mileage + ", " + cars[nc].price + ", '" + cars[nc].color + "', " + n1 + ") ");
		nc++;
		c.close();
	}
	
	
	
	//deletes specified Car.
	public void deleteCar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
			int count = -1;
			String bn = " ";
			displayInv();
			System.out.println();
			System.out.print("\nPlease input VIN to delete: ");
			String s1 = s.next();
			System.out.println();
			for (int i = 0; i < nc; i++)//finds car.
			{
				if (s1.equals(cars[i].vin))
					count = i;
			}
			if (count >= 0)//deletes car from array.
			{
				System.out.println("\nVin\t        Brand\t         Model\t        Year\t        Mileage\t        Price\t        Color\t        New");
				cars[count].displayCar();
				
				cars[count] = null;
				nc--;
				
				if (count == nc) //if deleted item is last on the list.
				{
					//do nothing.
				}
				else 
				{
					for (int i = count; i < nc; i++)
					{
						cars[i] = cars[i + 1];
					}
				}
				
				Class.forName("com.mysql.jdbc.Driver").newInstance(); 
				Connection c = DriverManager.getConnection("jdbc:mysql://35.184.84.73:3306/carmax","root","1234qwer");
				//Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","1234qwer");
				Statement st = c.createStatement();
				
				long res = st.executeLargeUpdate("DELETE FROM cars WHERE vin = '" + s1 + "' ");
				//ResultSet res = st.executeQuery("DELETE FROM cars WHERE vin=" + s1);
				
				c.close();
				
				System.out.println("Successfully this car has been deleted.");
			}
			else
				System.out.println("VIN does not exist.");
	}
	
	
	
	//sorts car by VIN.
	public void sortVIN()
	{
		Cars temp;
		
		for (int i = 0; i < nc; i++)
		{
			int index = i;
			for (int j = i; j < nc; j++)
			{
				int result = cars[j].vin.compareTo(cars[index].vin);
				if (result < 0)
					index = j;
			}
			temp = cars[index];
			cars[index] = cars[i];
			cars[i] = temp;
		}
	}
	
	
	
	//sorts car by brand.
	public void sortBrand()
	{
		Cars temp;
		
		for (int i = 0; i < nc; i++)
		{
			int index = i;
			for (int j = i; j < nc; j++)
			{
				int result = cars[j].brand.compareTo(cars[index].brand);
				if (result < 0)
					index = j;
			}
			temp = cars[index];
			cars[index] = cars[i];
			cars[i] = temp;
		}
	}
	
	
	
	//sorts car by model.
	public void sortModel()
	{
		Cars temp;
		
		for (int i = 0; i < nc; i++)
		{
			int index = i;
			for (int j = i; j < nc; j++)
			{
				int result = cars[j].model.compareTo(cars[index].model);
				if (result < 0)
					index = j;
			}
			temp = cars[index];
			cars[index] = cars[i];
			cars[i] = temp;
		}
	}
	
	
	
	//sorts car by year.
	public void sortYear()
	{	
		Cars temp;
		for (int i = 0; i < nc; i++)
		{
			int index = i;
			for (int j = i; j < nc; j++)
			{
				if (cars[j].year < cars[index].year)
					index = j;
			}
			temp = cars[index];
			cars[index] = cars[i];
			cars[i] = temp;
		}
	}
	
	
	
	//sorts car by mileage.
	public void sortMile()
	{
		Cars temp;
		
		for (int i = 0; i < nc; i++)
		{
			int index = i;
			for (int j = i; j < nc; j++)
				if (cars[j].mileage < cars[index].mileage)
					index = j;
			temp = cars[index];
			cars[index] = cars[i];
			cars[i] = temp;
		}
	}
	
	
	
	//sorts car by price.
	public void sortPrice()
	{
		Cars temp;
		
		for (int i = 0; i < nc; i++)
		{
			int index = i;
			for (int j = i; j < nc; j++)
				if (cars[j].price < cars[index].price)
					index = j;
			temp = cars[index];
			cars[index] = cars[i];
			cars[i] = temp;
		}
	}
	
	
	
	//sorts car by price.
	public void sortColor()
	{
		Cars temp;
		
		for (int i = 0; i < nc; i++)
		{
			int index = i;
			for (int j = i; j < nc; j++)
			{
				int result = cars[j].color.compareTo(cars[index].color);
				if (result < 0)
					index = j;
			}
			temp = cars[index];
			cars[index] = cars[i];
			cars[i] = temp;
		}
	}

}
