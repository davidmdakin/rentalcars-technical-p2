package RestExercise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import RestExercise.Cars;

public class ExerciseRepository {
	private List<Exercise> exercises = new ArrayList<Exercise>();
	
	public ExerciseRepository()
	{
		ArrayList<Car> carList = Cars.getCarList();
		exercises.add(new Exercise(1, "Exercise 1", Cars.getExercise1StringList(carList)));
		exercises.add(new Exercise(2, "Exercise 2", Cars.getExercise2StringList(carList)));
		exercises.add(new Exercise(3, "Exercise 3", Cars.getExercise3StringList(carList)));
		exercises.add(new Exercise(4, "Exercise 4", Cars.getExercise4StringList(carList)));
	}
	
	public Exercise getExerciseById(int id)
	{
		if (id > 0 && id <= exercises.size())
		{
			return exercises.get(id-1);
		}
		else
		{
			throw new ExerciseNotFoundException(id);
		}
	}
	
	public List<Exercise> getAllExercises()
	{
		return this.exercises;
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class ExerciseNotFoundException extends RuntimeException {

	public ExerciseNotFoundException(int id) {
		super("Could not find exercise '" + id + "'.");
	}
}