package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.AnnotationDao;
import gr.uoa.bioinf.goDB.models.SearchObject;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    AnnotationDao annotationDao;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("organisms", annotationDao.getOrganisms().size());
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/username")
    @ResponseBody
    public Principal currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal;
    }
}