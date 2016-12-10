package wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to show the 
 * ClassCastException at runtime test.
 */
public class UnboundedWildcard {
	//Only work for the list of object type.
	static void displayItems(List<Object> list){
	    for (Object listItem : list){
	        System.out.println(listItem);
	    }
	}
	
	//Work for the list of any type.
	static void displayListItems(List<?> list){	//  Unbounded Wildcard!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	    for (Object listItem : list){
	        System.out.println(listItem);
	    }
	}
	
	public static void main(String args[]){
		//Arraylist of Object type.	
		List<Object> list1 = new ArrayList<Object>();
		list1.add("Roxy");
		list1.add("Sandy");
		list1.add("Sunil");
		
		//Arraylist of string type.	
		List<String> list2 = new ArrayList<String>();
		list2.add("Amani");
		list2.add("Pabhjot");
		list2.add("Nidhi");	
		
		//Only accept Object type list.
		System.out.println("List of object " +
				"using displayItems method:");
		displayItems(list1);
		
		//Accept list of any type.
		System.out.println("List of object using " +
				"displayListItems method:");
		displayListItems(list1);
		System.out.println("List of strin using " +
				"displayListItems method:");
		displayListItems(list2);
		
	}
}
