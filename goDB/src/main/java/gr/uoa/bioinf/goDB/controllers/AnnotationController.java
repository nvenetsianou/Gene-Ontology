package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.AnnotationDao;
import gr.uoa.bioinf.goDB.models.Annotation;
import gr.uoa.bioinf.goDB.models.SearchObject;
import gr.uoa.bioinf.goDB.services.AnnotationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path="/annotation")
public class AnnotationController {

    @Autowired
    AnnotationDao annotationDao;

    @Autowired
    AnnotationService annotationService;

    @GetMapping("/search")
    public String search(Model model, @ModelAttribute("searchObject") SearchObject searchObject,
                         BindingResult result) {
        model.addAttribute("organisms", annotationDao.getOrganisms());
        model.addAttribute("ontologySources",annotationDao.getOntologySources());
        if (searchObject.getGeneTerm() != null || searchObject.getGoClassTerm() != null) {
            model.addAttribute("results", annotationDao.search(searchObject));
        } else {
            model.addAttribute("results", null);
        }
        return "goSearch";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("organisms", annotationDao.getOrganisms());
        model.addAttribute("ontologySources", annotationDao.getOntologySources());
        model.addAttribute("evidences", annotationDao.getEvidences());
        model.addAttribute("annotationQualifiers", annotationService.getQualifiers());
        model.addAttribute("annotation", new Annotation());
        return "addAnnotation";
    }

    @GetMapping("/edit/{geneSymbol}/{goClassAccession}")
    public String edit(Model model, @ModelAttribute("searchObject") SearchObject searchObject,
                       @PathVariable String geneSymbol, @PathVariable String goClassAccession) {
        Annotation annotation = annotationDao.findByGeneSymbolAndGoClassAccession(geneSymbol, goClassAccession);
        model.addAttribute("annotation", annotation);
        model.addAttribute("organisms", annotationDao.getOrganisms());
        model.addAttribute("ontologySources", annotationDao.getOntologySources());
        model.addAttribute("evidences", annotationDao.getEvidences());
        model.addAttribute("annotationQualifiers", annotationService.getQualifiers());
        return "editAnnotation";
    }

    @PostMapping("/persist")
    public void persist(Model model, @ModelAttribute("annotation") Annotation annotation, HttpServletResponse response) throws IOException {
        annotationDao.persist(annotation);
        response.sendRedirect("/annotation/search");
    }

    @PostMapping("/update")
    public void update(Model model, @ModelAttribute("annotation") Annotation annotation, HttpServletResponse response) throws IOException {
        annotationDao.update(annotation);
        response.sendRedirect("/annotation/search");
    }

    @GetMapping("/delete/{geneSymbol}/{goClassAccession}")
    public void delete(@PathVariable String geneSymbol, @PathVariable String goClassAccession, HttpServletResponse response) throws IOException {
        Annotation annotation = annotationDao.findByGeneSymbolAndGoClassAccession(geneSymbol, goClassAccession);
        annotationDao.delete(annotation);
        response.sendRedirect("/annotation/search");
    }

}

