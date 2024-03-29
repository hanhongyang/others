package webadv.s99201105;

import java.util.List;
import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import webadv.s99201105.repository.TeacherRepository;

@Controller

public class HomeController {
	@Value("${welcome.message}")
	private String message;
	@Autowired
	private TeacherRepository tr;
	private List<String> tasks = Arrays.asList("Git", "Maven", "Gradle", "Spring", "Bootstrap", "jQuery", "MyBatis","Redis");
	@GetMapping("/")
public String index(Model model) {
//		model.addAttribute("message", message);
//		model.addAttribute("tasks", tasks);
//	return "welcome";
	return "login";
}
	@GetMapping("/login")
public String inde(Model model) {
		model.addAttribute("teacher_list",tr.findAll());
return "plain_page";
}
	@PostMapping("add")
	public String doAdd(int a,int b,Model model) {
		//System.out.println(a+b);
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("result",a+b);
		return index(model);
	
		
	}
	@PostMapping(value="/ajax",produces={"text/html;charset=UTF-8;"})
	@ResponseBody
	public String ajax() {
		System.out.println("Hello...");
		 return "Ajaxʵ����This is an Ajax example";
	}
	@GetMapping("/test")
	public String test() {
		return "ajax";
	}
}