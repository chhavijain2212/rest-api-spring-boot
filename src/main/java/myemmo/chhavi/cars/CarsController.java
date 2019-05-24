package myemmo.chhavi.cars;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.Valid;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/cars")
public class CarsController {

	@Autowired
    private CarsService service;
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    public String findCarByName(@PathVariable("name") String name)
    {
		Cars car = service.findFirstByCarName(name);
		try {
			return car==null?"{\"message\": \"Not found\"}":mapper.writeValueAsString(car);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "{\"message\":\"Invalid Data returned\"}";
		}
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public String addCarSale(@RequestBody  @Valid String sale)
	{
		try {
			JSONObject json = new JSONObject(sale);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String date = json.getString("date_of_sale");
			json.remove("date_of_sale");
			System.out.println(json.toString());
			Cars car = mapper.readValue(json.toString(), Cars.class);
			car.setDate_of_sale(LocalDate.parse(date,formatter));
			service.addNewSale(car);
			return "{\"message\":\"Added\"}";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{\"message\":\"Invalid json\"}";
		}
		
	}
	
}