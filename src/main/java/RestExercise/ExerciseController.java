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
@RequestMapping("/")
public class ExerciseController {
	private final ExerciseRepository exerciseRepository = new ExerciseRepository();
	
	@RequestMapping(method = RequestMethod.GET)
	Collection<Exercise> getExercises()
	{
		return exerciseRepository.getAllExercises();
	}
	
	@RequestMapping(value = "/{exerciseId}", method = RequestMethod.GET)
	Exercise getExercise(@PathVariable String exerciseId)
	{
		int id = Integer.parseInt(exerciseId);
		Exercise exercise = exerciseRepository.getExerciseById(id);
		return exercise;
	}
}

