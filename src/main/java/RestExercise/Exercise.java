package RestExercise;
//import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue
	private long id;
	
	public String name;
	public List<String> exerciseOutput;
	
	public String getName()
	{
		return this.name;
	}
	
	public List<String> getExerciseOutput()
	{
		return this.exerciseOutput;
	}
	
	public Exercise(String name, List<String> exerciseOutput)
	{
		this.name = name;
		this.exerciseOutput = exerciseOutput;
	}
}
