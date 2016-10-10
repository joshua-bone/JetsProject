package week2;

import java.util.ArrayList;
import java.util.Scanner;

public class JetsProgram {
	private static String padding = "                    ";
	private static String message = ""; 
	private static Scanner keyboard; 
	private static Airline airline;
	
	
	public static String[] logo = {
			"_________ _______ _________ _______ ",
			"\\__    _/(  ____ \\\\__   __/(  ____ \\",
			"   )  (  | (    \\/   ) (   | (    \\/",
			"   |  |  | (__       | |   | (_____ ",
			"   |  |  |  __)      | |   (_____  )",
			"   |  |  | (         | |         ) |",
			"|\\_)  )  | (____/\\   | |   /\\____) |",
			"(____/   (_______/   )_(   \\_______)"
	};
	
	public static String[] menu = {
			"1. List fleet",
			"2. View fastest jet",
			"3. View jet with longest range",
			"4. Add a jet to Fleet",
			"5. Quit"                  
	};
	
	public static void main(String[] args) {
		start();
	}
	
	public static void start(){
		airline = Airline.getTestFleet();
		keyboard = new Scanner(System.in);
		int choice = 0;
		while (choice!=5){
			choice = doMenu();
			keyboard.nextLine(); //clear the newline
			message = ""; //clear the message
			switch(choice){
			case 1: //list fleet
				printLines(20); //clear the console
				printLogo();
				printLines(5);
				System.out.println(padding + "Jets in fleet: \n");
				for (Jet j : airline.getFleet()){
					System.out.println(padding + j);
				}
				printLines(2);
				System.out.println(padding + "Press Enter to Continue...");
				keyboard.nextLine();
				break;
			case 2: //view fastest jet
				message = "Fastest Jet: " + airline.getFastestJet();
				break;
			case 3: //view jet with longest range
				message = "Longest Range: " + airline.getJetWithLongestRange();
				break;
			case 4: //add a jet to fleet
				System.out.print(padding + "Enter the model of the new jet: ");
				String model = keyboard.nextLine();
				System.out.print(padding + "Enter the speed in MPH: ");
				int speed = keyboard.nextInt();
				System.out.print(padding + "Enter the range in miles: ");
				int range = keyboard.nextInt();
				System.out.print(padding + "Enter the price: $");
				double price = keyboard.nextDouble();
				Jet j = new Jet(model, speed, range, price);
				airline.addJet(j);
				message = "Added Jet: " + j;
				break;
			default:
				break;
			}
		}	
	}
	
	public static int doMenu(){
		printLogo();
		printLines(3);
		//print the message line
		System.out.println(padding + message);
		printLines(3);
		//print the menu
		for (String s : menu){
			System.out.println(padding + s);
		}	
		printLines(2);
		System.out.print(padding + "> ");
		
		while (!keyboard.hasNextInt()){
			System.out.print(padding + "> ");
			keyboard.next();
			}
		return keyboard.nextInt();
	}
	
	public static void printLogo(){
		//print enough whitespace to show a new window
		printLines(20);
		
		//print the logo
		for (String s : logo){
			System.out.println(padding + s);
		}
	}
	
	//prints n lines of whitespace
	public static void printLines(int n){
		for (int i = 0; i < n; i++){
			System.out.println();
		}
	}
}
