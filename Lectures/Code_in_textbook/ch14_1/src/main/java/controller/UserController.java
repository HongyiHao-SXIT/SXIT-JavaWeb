package controller;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.UserForm;
import service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Log logger = LogFactory.getLog(UserController.class);
	//将服务层依赖注入到属性userService
	@Autowired
	 public UserService userService;
	/**
	 * 处理登录
	 */
	@PostMapping("/login")
	public String login(UserForm user, HttpSession session, Model model) {
		if(userService.login(user)){
			session.setAttribute("u", user);
			logger.info("成功");
			return "main";//登录成功，跳转到main.jsp
		}else{
			logger.info("失败");
			model.addAttribute("messageError", "用户名或密码错误");
			return "login";
		}	
	}
	/**
	 *处理注册
	 */
	@PostMapping("/register")
	public String register(@ModelAttribute("user") UserForm user) {
		if(userService.register(user)){
			logger.info("成功");
			return "login";//注册成功，跳转到login.jsp
		}else{
			logger.info("失败");
			return "register";//返回register.jsp
		}
	}
}
