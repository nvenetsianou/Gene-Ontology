package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.AnnotationDao;
import gr.uoa.bioinf.goDB.daos.GoClassDao;
import gr.uoa.bioinf.goDB.models.GoClass;
import gr.uoa.bioinf.goDB.models.SearchObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/goClass")
public class GoClassController {

    @Autowired
    AnnotationDao annotationDao;

    @Autowired
    GoClassDao goClassDao;

    @GetMapping("/search")
    public String search(Model model, @ModelAttribute("searchObject") SearchObject searchObject,
                                BindingResult result) {
        model.addAttribute("organisms", annotationDao.getOrganisms());
        if (searchObject.getTerm() != null) {
            model.addAttribute("results", annotationDao.searchGoClasses(searchObject));
        } else {
            model.addAttribute("results", null);
        }
        return "goClassSearch";
    }

    @GetMapping("/")
    @ResponseBody
    public List getAllGOclasses() {
        return goClassDao.getAll();
    }

    @GetMapping("/accession/{accession}")
    @ResponseBody
    public List getOneClass(@PathVariable String accession) {
        return goClassDao.getOneClass(accession);
    }

    @GetMapping("/ontologySource/{ontologySource}")
    @ResponseBody
    public List findByOntologySource(@PathVariable String ontologySource) {
       return goClassDao.findByOntologySource(ontologySource);
    }

    @GetMapping("/definition/{definition}")
    @ResponseBody
    public List<GoClass> getDefinition(@PathVariable String definition) {
        return goClassDao.getDefinition(definition);
    }


}
