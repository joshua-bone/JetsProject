package week2;

public class Jet {
	private String model;
	private int speed;
	private int range;
	private double price;
	
	public Jet() {
		this("Default", 0, 0, 0.0);
	}
	
	public Jet(String model, int speed, int range, double price){
		setModel(model);
		setSpeed(speed);
		setRange(range);
		setPrice(price);
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSpeed() {
		return speed;
	}
	public double getMachSpeed() {
		return speed*0.00130332;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%20s, speed: Mach %2.1f, range: %6d, price: $%10.2f", getModel(), getMachSpeed(), getRange(), getPrice());
	}
}
