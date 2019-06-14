package webadv.s99201105.p3;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {		
    private List<String> tasks = Arrays.asList("Jakarta EE", "Maven", "Gradle", "Spring", "Bootstrap", "jQuery", "MyBatis","Redis");    
    @GetMapping("/")
		public String welcome(Model model) {    	
        model.addAttribute("tasks", tasks);  
        return "welcome";		
		}
}
