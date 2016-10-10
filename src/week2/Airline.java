package week2;

import java.util.ArrayList;

public class Airline {
	private int cash = 5000000;
	private String name = "Rocky Mountain Airlines";
	private String abbr = "RMA"; 
	private ArrayList<Jet> fleet;
	
	//constructors
	public Airline(){
		this.fleet = new ArrayList<Jet>();
	}
	
	public Airline(ArrayList<Jet> fleet){
		this.fleet = fleet;
	}
	
	//methods
	public Jet getFastestJet(){
		Jet fastest = null;
		for (Jet j : this.fleet){
			if (fastest == null || j.getSpeed() > fastest.getSpeed()){
				fastest = j;
			}
		}
		return fastest;
	}
	
	public Jet getJetWithLongestRange(){
		Jet longest = null;
		for (Jet j : this.fleet){
			if (longest == null || j.getRange() > longest.getRange()){
				longest = j;
			}
		}
		return longest;
	}
	
	public void addJet(Jet j){
		fleet.add(j);
	}
	
	public ArrayList<Jet> getFleet(){
		return this.fleet;
	}
	
	
	//factory method for test conditions
	public static Airline getTestFleet(){
		ArrayList<Jet> fleet = new ArrayList<Jet>();
		fleet.add(new Jet("Speed Demon", 3000, 2000, 1000000));
		fleet.add(new Jet("Global Explorer", 800, 24000, 900000));
		fleet.add(new Jet("Darter", 2000, 4000, 700000));
		fleet.add(new Jet("Seymour Sights", 600, 12000, 600000));
		fleet.add(new Jet("Basic Model", 500, 5000, 1000000));
		return new Airline(fleet);
	}	
}
