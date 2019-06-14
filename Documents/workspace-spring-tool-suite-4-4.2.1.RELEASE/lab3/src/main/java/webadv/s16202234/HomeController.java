package webadv.s16202234;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import webadv.s16202234.UserRepository.UserRepository;
import webadv.s16202234.entity.User;
import webadv.s99201105.repository.TeacherRepository;

@Controller
public class HomeController implements WebMvcConfigurer {
	private UserRepository tr;
	User us=new User();
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/home").setViewName("welcome");
    }
	@GetMapping("/")
	public String  Login(Model model,String account,String password) {
		model.addAttribute("user", new User());
		return "login";
	}

@PostMapping("/login")
public String check(@Validated User user, BindingResult bindingResult, Model model) {

	if (bindingResult.hasFieldErrors()) {
			
		}else if()
			return "redirect:/welcome";
	}

}