package webadv.s99201105.p3;



import java.util.*;

//import org.assertj.core.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	List<String> tasks= Arrays.asList("Maven","Spring Mvc");
	@GetMapping("/task/{id}")
    public Task task(@PathVariable (value="id") int id) {
        return new Task(id,tasks.get(id-1));
	}
}
