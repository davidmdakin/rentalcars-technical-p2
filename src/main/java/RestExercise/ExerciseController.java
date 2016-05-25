package RestExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import RestExercise.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/{exerciseId}")
public class ExerciseController {
	@RequestMapping(method = RequestMethod.GET)
	Exercise getExercise(@PathVariable String exerciseId)
	{
		int id = Integer.parseInt(exerciseId);
		ArrayList<Car> carList = Cars.getCarList();
		switch (id)
		{
		case 1:
			return new Exercise("Exercise 1", Cars.getExercise1StringList(carList));
		case 2:
			return new Exercise("Exercise 2", Cars.getExercise2StringList(carList));
		case 3:
			return new Exercise("Exercise 3", Cars.getExercise3StringList(carList));
		case 4:
			return new Exercise("Exercise 4", Cars.getExercise4StringList(carList));
		default:
			throw new ExerciseNotFoundException(id);
		}
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class ExerciseNotFoundException extends RuntimeException {

	public ExerciseNotFoundException(int id) {
		super("Could not find exercise '" + id + "'.");
	}
}
