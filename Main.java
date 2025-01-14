import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<Contact> contact = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {
			printInfo();
			int choice = getChoice();
			switch(choice) {
				case 1:
					AddContact();
					break;
				case 2:
					ViewContact();
					break;
				case 3:
					SearchContact();
					break;
				case 4:
					UpdateContact();
					break;
				case 5:
					DeleteContact();
					break;
				default:
					System.out.println("Wrong Input");
			}
		}
		
		
	}
	
	public static void printInfo() {
			System.out.println("\n=== Contact Application ===");
	        System.out.println("1. Add a Contact");
	        System.out.println("2. View all Contact");
	        System.out.println("3. Search for a Contact");
	        System.out.println("4. Update a Contact");
	        System.out.println("5. Delete");
	        System.out.print("Enter your choice: ");
	}
	public static int getChoice() {
		try {
			return Integer.parseInt(scan.nextLine());
		}catch (NumberFormatException e) {
			return -1;
		}
	}
	
	private static void AddContact() {
		System.out.println("Enter Contact Details");
		System.out.println("Enter name:");
		String name = scan.nextLine();
		System.out.println("Enter Contact:");
		String number = scan.nextLine();
		System.out.println("Enter email:");
		String email = scan.nextLine();
		contact.add(new Contact(name,number,email));
		System.out.println("Contact Added Successfully");	
	}
	
	private static void ViewContact() {
		if(contact.size()==0) System.out.println("No Contact Found");
		else {
			for(int i=0;i<contact.size();i++) {
				System.out.println((i+1)+"."+contact.get(i));
			}
		}
		
	}
	private static void SearchContact() {
		System.out.println("Enter the Number/Name to Search");
		String search = scan.nextLine().toLowerCase();
		for(int i=0;i<contact.size();i++) {
			Contact c = contact.get(i);
			if(c.getName().toLowerCase().contains(search)||c.getNumber().toLowerCase().contains(search)) {
				System.out.println("Contact found: "+c);	
			}else {
				System.out.println("No Contact Found");
			}
		}
		 
	}
	private static void UpdateContact() {
	
		System.out.println("Enter The Name of Contact for Update");
		String str = scan.nextLine().toLowerCase();
		for(int i=0;i<contact.size();i++) {
			Contact c = contact.get(i);
			if(c.getName().toLowerCase().contains(str)) {
				System.out.println("Details"+ c);
				
				System.out.println("Enter the new Number:");
				String newnum=scan.nextLine();
				boolean numexist = false;
				for(Contact check:contact) {
					if(check.getNumber().equals(newnum)) {
						numexist=true;
						break;
					}
				}
				if(numexist) {
					System.out.println("Error the number was already present");
					return;
				}
				
				System.out.println("Enter the new email:");
				String newemail=scan.nextLine();
				boolean emailexist = false;
				for(Contact check:contact) {
					if(check.getEmail().equals(newemail)) {
						emailexist=true;
						break;
					}
				}
				if(emailexist) {
					System.out.println("Error the email was already present");
					return;
				}
				
				contact.set(i, new Contact(c.getName(),newnum,newemail));
				System.out.println("Updated SuccesFully");
				return;
			}
		}
		
		System.out.println("No contact Found with this name");
	}
	private static void DeleteContact() {
		System.out.println("enter the Name/Number for deleting contact");
		String newname = scan.nextLine().toLowerCase();
		for(int i=0;i<contact.size();i++) {
			Contact c = contact.get(i);
			if(c.getName().toLowerCase().contains(newname)||c.getNumber().toLowerCase().contains(newname)) {
				contact.remove(i);
				System.out.println("Contact Deleted Successfully");
				return;
			}
				
		}
		System.out.println("No Contact found");
		
	}
}



