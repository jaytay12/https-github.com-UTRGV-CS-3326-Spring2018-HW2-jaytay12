import java.util.Scanner;

public class Cars {
	String vin;
	String brand;
	String model;
	int year;
	int mileage;
	double price;
	String color;
	boolean brandnew;
	Scanner s = new Scanner(System.in);
	
	public void displayCar()
	{
		String s1 = "N";
		if (brandnew == true)
			s1 = "Y";
		System.out.print(vin + "\t" + brand + "\t\t " + model + "\t\t" + year + "\t\t" + mileage + "\t\t");
		System.out.printf("%.2f", price);
		System.out.print("\t\t" + color + "\t\t" + s1 + "\n");
	}
	
	public void setVIN()
	{
		System.out.print("Please input VIN: ");
		vin = s.next();
	}
	
	public void setBrand()
	{
		System.out.print("Please input brand: ");
		brand = s.next();
	}
	
	public void setModel()
	{
		System.out.print("Please input model: ");
		model = s.next();
	}
	
	public void setYear()
	{
		System.out.print("Please input year: ");
		year = s.nextInt();
	}
	
	public void setMileage()
	{
		System.out.print("Please input mileage: ");
		mileage = s.nextInt();
	}
	
	public void setPrice()
	{
		System.out.print("Please input price: ");
		price = s.nextDouble();
	}
	
	public void setColor()
	{
		System.out.print("Please input color: ");
		color = s.next().charAt(0);
	}
	
	public void setNew(int i)
	{
		if ((i).equals("Y"))
			brandnew = true;
		else
			brandnew = false;
	}

}
