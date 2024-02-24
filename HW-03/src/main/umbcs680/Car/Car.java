package umbcs680.Car;

public class Car {
	private String make = null;
	private String model = null;
	private int mileage = -1;
	private  int year = -1;
	private float price = -1.0f;

	public Car(String make, String model, int year){
		this.make=make;
		this.model=model;
		this.year=year;
	}

//	Use below constructor if using static factory method
//	private Car(String make, String model, int mileage, int year, float price){
//		this.make=make;
//		this.model=model;
//		this.mileage=mileage;
//		this.year=year;
//		this.price=price;
//	}

//  Below is the Static Factory method
//	public static Car createCar(String make, String model, int year){
//		return new Car(make, model, -1, year, -1.0f);
//	}

	public String getMake(){ return this.make; }

	public String getModel(){ return this.model; }

	public int getMileage(){ return this.mileage; }

	public int getYear(){ return this.year; }

	public float getPrice(){ return this.price; }

	public static void main(String[] args) {
		Car inst = new Car("Mazda", "CX-5", 2021);
		//If using static factory method:
		//Car inst = createCar("Mazda", "CX-5", 2021);
		String[] carInfo = {inst.getMake(),
				inst.getModel(),
				Integer.toString(inst.getYear())};
		for (int i = 0; i < carInfo.length; i++) {
			System.out.println(carInfo[i]);
		}
	}
}