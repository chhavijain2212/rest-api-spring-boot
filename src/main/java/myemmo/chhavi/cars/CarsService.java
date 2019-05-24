package myemmo.chhavi.cars;

public interface CarsService {

	Cars findFirstByCarName(String carName);

	void addNewSale(Cars car);

}