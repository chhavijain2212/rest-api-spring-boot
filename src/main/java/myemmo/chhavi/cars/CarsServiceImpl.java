package myemmo.chhavi.cars;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CarsServiceImpl implements CarsService {
	
	@Autowired
	private CarsRepository repository;
	
	@Override
	public Cars findFirstByCarName(String carName)
	{
		return repository.findFirstByCarname(carName);
	}
	
	@Override
	public void addNewSale(Cars car)
	{
		repository.insert(car);
	}

}
