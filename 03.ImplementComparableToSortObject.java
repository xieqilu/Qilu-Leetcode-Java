/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	private static class Employee implements Comparable<Employee>{
		//if use default access, it's package-private, any code in the same
		//package can access the member variable directly
		private int id;
		private String firstName;
		private String lastName;
		
		public Employee(int id, String firstName, String lastName){
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = id;
		}
		
		public int getId(){
			return id;
		}
		
		public void setId(int id){
			this.id = id;
		}
		
		public String getFirstName(){
			return firstName;
		}
		
		public void setFirstName(String firstName){
			this.firstName = firstName;
		}
		
		public String getLastName(){
			return lastName;
		}
		
		public void setLastName(String lastName){
			this.lastName = lastName;
		}
		
		// //used to sort the employee by id
		@Override
		public int compareTo(Employee other){
			//if this object is greater than other, return >0
			//if this object is less than other, return <0
			//if this object equals to other, return 0
			return Integer.compare(this.id, other.getId());
		}
		
		//used to sort the employee by last name
		@Override
		public int compareTo(Employee other){
			return this.lastName.compareTo(other.getLastName());
		}
		
		//used to sort the employee by last name then first name
		@Override
		public int compareTo(Employee other){
			int last = this.lastName.compareTo(other.getLastName());
			if(last !=0)
				return last;
			else
				return this.firstName.compareTo(other.getFirstName());
		}
		
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Employee a = new Employee(1,"Larry","Brown");
		Employee b = new Employee(12,"Qilu","Xie");
		Employee c = new Employee(4,"Aron","Brown");
		Employee d = new Employee(7,"Kobe","Araham");
		Employee e = new Employee(3,"Collin","Xie");
		Employee f = new Employee(9,"Lebron","James");
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(a);
		employees.add(b);
		employees.add(c);
		employees.add(d);
		employees.add(e);
		employees.add(f);
		
		Collections.sort(employees);
		
		for(Employee em : employees){
			System.out.println(em.getId()+" "+em.getFirstName()+" "+em.getLastName());
		}
		
//---------------------------------Read input from stdin-------------------------------------------

		// //Read input from stdin line by line, each line represent an employee
		// //The format is id firstName lastName
		// List<Employee> employees = new ArrayList<Employee>();
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String line;
		// while((line = br.readLine())!=null && line.length() !=0){
		// 	String[] input = line.split(" ");
		// 	employees.add(new Employee(Integer.parseInt(input[0]),input[1],input[2]));
		// }
		// Collections.sort(employees);
		// for(Employee em : employees){
		// 	System.out.println(em.getId()+" "+em.getFirstName()+" "+em.getLastName());
		// }
	}
}
