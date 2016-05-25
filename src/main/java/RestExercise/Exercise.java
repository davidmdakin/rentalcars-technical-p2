package RestExercise;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.VndErrors;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue
	private long id;
	
	public String name;
	public List<String> exerciseOutput;
	
	public long getId() {
        return id;
    }
	
	public String getName()
	{
		return this.name;
	}
	
	public List<String> getExerciseOutput()
	{
		return this.exerciseOutput;
	}
	
	public Exercise(long id, String name, List<String> exerciseOutput)
	{
		this.id = id;
		this.name = name;
		this.exerciseOutput = exerciseOutput;
	}
}

class ExerciseResource extends ResourceSupport {

    private final Exercise exercise;

    public ExerciseResource(Exercise exercise) {
        this.exercise = exercise;
        this.add(linkTo(methodOn(ExerciseController.class).getExercise(Long.toString(exercise.getId()))).withSelfRel());
    }

    public Exercise getExercise() {
        return exercise;
    }
}