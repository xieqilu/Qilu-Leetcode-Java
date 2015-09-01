/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	//the testing car class
	private static class Car{
		private String year;
		private String model;
		private String vin;
		private String brand;
		//private int id;
		
		public Car(String year, String model, String vin, String brand){
			this.year = year;
			this.model = model;
			this.vin = vin;
			this.brand = brand;
		}
		
		public String getYear(){return year;}
		public void setYear(String year){
			this.year = year;
		}
		public String getModel(){return model;}
		public void setModel(String model){
			this.model = model;
		}
		public String getVin(){return vin;}
		public void setVin(String vin){
			this.vin = vin;
		}
		public String getBrand(){return this.brand;}
		public void setBrand(String brand){
			this.brand = brand;
		}
		
		//determine if two car object are equal
		@Override
		public boolean equals(Object o){
			if(o == null)
				return false;
			if(o == this)
				return true;
			//getClass() return the class type, so we can compare if class is the same
			if(this.getClass() != o.getClass())
				return false;
			Car c = (Car) o;
			return (this.getBrand().equals(c.getBrand()));
		}
		
		//If the field is integer, we can generate unique hashcode like follows:
		// @Override
		// public int hashCode()
		// {
  //  			final int PRIME = 31;
  //  			int result = 1;
  //  			result = PRIME * result + getId();
  //  			return result;
		// }
		
		//return an unique hashcode for a car object
		@Override
		public int hashCode(){
			return this.getBrand().hashCode();
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Car a = new Car("1996", "TT", "123453", "Audi");
		Car b = new Car("2005", "Q5", "23124134", "Audi");
		Car c = new Car("2007", "Q7", "90890709", "Audi");
		Car d = new Car("2008", "Z4", "09091230", "BMW");
		Car e = new Car("2012", "X3", "2133414", "BMW");
		List<Car> carList = new ArrayList<Car>();
		carList.add(a);
		carList.add(b);
		carList.add(c);
		carList.add(d);
		carList.add(e);
		
		HashSet<Car> set = new HashSet<Car>(carList);
		
		System.out.println("the number of objects in set is "+set.size());
		
		for(Car x : set){
			System.out.println(x.getBrand());
		}
		
		
	}
	
	
}
