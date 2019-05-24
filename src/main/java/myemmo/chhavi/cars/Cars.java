package myemmo.chhavi.cars;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chhavi")
public class Cars {

    private String _id;

    private String carname;

    private LocalDate dateofsale;
    
    private String modelno;

    private double price;
    
    
	public Cars() {
		super();
	}

	public Cars(String car_name, LocalDate date_of_sale, String model_no, double price) {
		super();
		this.carname = car_name;
		this.dateofsale = date_of_sale;
		this.modelno = model_no;
		this.price = price;
	}

	public String get_id() {
		return _id;
	}

	public String getCar_name() {
		return carname;
	}

	public void setCar_name(String car_name) {
		this.carname = car_name;
	}

	public LocalDate getDate_of_sale() {
		return dateofsale;
	}

	public void setDate_of_sale(LocalDate date_of_sale) {
		this.dateofsale = date_of_sale;
	}

	public String getModel_no() {
		return modelno;
	}

	public void setModel_no(String model_no) {
		this.modelno = model_no;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cars [car_name=" + carname + ", date_of_sale=" + dateofsale + ", model_no=" + modelno + ", price="
				+ price + "]";
	}
	
}
