package RestExercise;


import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Cars {	
	public static ArrayList<Car> getCarList()
	{
		String input = "";
		try {
			input = readFile("vehicles.json");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		ArrayList<Car> carList = JsonStringToCarList(input);
		return carList;
	}
	
	public static String readFile(String path) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded);
	}
	
	public static ArrayList<Car> JsonStringToCarList(String jsonString)
	{
		JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
		JsonArray jsa = jsonObject.get("Search").getAsJsonObject().get("VehicleList").getAsJsonArray();
		
		Gson gson = new Gson();

	    Car[] navigationArray = gson.fromJson(jsa, Car[].class);
	    ArrayList<Car> carList = new ArrayList<Car>();
	    for (Car car : navigationArray)
	    {
	    	carList.add(car);
	    }
	    return carList;
	}
	
	public static ArrayList<Car> SortByPriceAsc(ArrayList<Car> carList)
	{
		Collections.sort(carList, (Car p1, Car p2) -> Float.compare(p1.getPrice(), p2.getPrice()));
		return carList;
	}
	
	public static ArrayList<Car> HighestRatedSupplierPerCarType(ArrayList<Car> carList)
	{
		Collections.sort(carList, (Car p1, Car p2) -> p1.getSipp1().compareTo(p2.getSipp1()));
		
		ArrayList<Car> topCars = new ArrayList<Car>();
	    Car topCar = carList.get(0);
	    for (Car car : carList)
	    {
	    	if (!car.getSipp1().equalsIgnoreCase(topCar.getSipp1()))
	    	{
	    		topCars.add(topCar);
	    		topCar = car;
	    	}
	    	if (car.getRating() > topCar.getRating())
	    	{
	    		topCar = car;
	    	}
	    }
	    topCars.add(topCar);
	    Collections.sort(topCars, (Car p1, Car p2) -> Float.compare(p2.getRating(), p1.getRating()));
	    return topCars;
	}
	
	public static ArrayList<Car> SortByCombinedScoreDesc(ArrayList<Car> carList)
	{
		Collections.sort(carList, (Car p1, Car p2) -> Float.compare(p2.getCombinedScore(), p1.getCombinedScore()));
		return carList;
	}
	
	public static List<String> getExercise1StringList(ArrayList<Car> carList)
	{
		ArrayList<Car> sortedCarList = SortByPriceAsc(carList);
		List<String> carStringList = new ArrayList<String>();
		for (Car car : sortedCarList)
		{
			carStringList.add(car.getEx1Output());
		}
		return carStringList;
	}
	
	public static List<String> getExercise2StringList(ArrayList<Car> carList)
	{
		List<String> carStringList = new ArrayList<String>();
		for (Car car : carList)
		{
			carStringList.add(car.getEx2Output());
		}
		return carStringList;
	}
	
	public static List<String> getExercise3StringList(ArrayList<Car> carList)
	{
		ArrayList<Car> topSupplierPerCarType = HighestRatedSupplierPerCarType(carList);
		List<String> carStringList = new ArrayList<String>();
		for (Car car : topSupplierPerCarType)
		{
			carStringList.add(car.getEx1Output());
		}
		return carStringList;
	}
	
	public static List<String> getExercise4StringList(ArrayList<Car> carList)
	{
		ArrayList<Car> carsByScore = SortByCombinedScoreDesc(carList);
		List<String> carStringList = new ArrayList<String>();
		for (Car car : carsByScore)
		{
			carStringList.add(car.getEx1Output());
		}
		return carStringList;
	}

}
