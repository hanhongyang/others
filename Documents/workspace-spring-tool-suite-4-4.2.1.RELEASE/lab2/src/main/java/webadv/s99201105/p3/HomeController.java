package webadv.s99201105.p3;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@Value("${welcome.message}")
	private String message;
	private List<String> tasks = Arrays.asList("Git", "Maven", "Gradle", "Spring", "Bootstrap", "jQuery", "MyBatis","Redis");
	@GetMapping("/")
public String index(Model model) {
			return "welcome"
					;
}
	@PostMapping("add")
	public String doAdd(int a,int b,Model model) {
		//System.out.println(a+b);
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("result",a+b);
		return index(model);
		
		
	}
	@RequestMapping(value="/ajax",produces={"textml;charset=UTF-8;"})

	@ResponseBody
	public String ajax() {
		System.out.println("Hello...");
		 return "AjaxÊµÀý£ºThis is an Ajax example";
	}
	@GetMapping("/test")
	public String test() {
		return "ajax";
	}
}