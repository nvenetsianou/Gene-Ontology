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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String geneSearch(Model model, @ModelAttribute("searchObject") SearchObject searchObject,
                             BindingResult result) {
        if (searchObject.getTerm() != null) {
            model.addAttribute("results", annotationDao.getBySymbolOrName(searchObject.getTerm()));
        } else {
            model.addAttribute("results", null);
        }
        return "home";
    }

    @GetMapping("/home")
    public String goClassSearch(Model model, @ModelAttribute("searchObject") SearchObject searchObject,
                                BindingResult result) {
        if (searchObject.getTerm() != null) {
            model.addAttribute("results", annotationDao.getByAccessionOrDefinition(searchObject.getTerm()));
        } else {
            model.addAttribute("results", null);
        }
        return "home";
    }

    @GetMapping(value = "/username")
    @ResponseBody
    public Principal currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal;
    }
}