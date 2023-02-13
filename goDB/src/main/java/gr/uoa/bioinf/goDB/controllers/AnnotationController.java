package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.AnnotationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/annotation")
public class AnnotationController {
    @Autowired
    AnnotationDao annotationDao;

    @GetMapping("/")
    @ResponseBody
    public List<AnnotationDao> getAllAnnotation() {
        return annotationDao.getAllAnnotation();
    }

    @GetMapping("/?geneSymbol/{geneSymbol}")
    @ResponseBody
    public List<AnnotationDao> getAnnotationByGeneSymbol(@PathVariable String geneSymbol) {
        return annotationDao.getAnnotationByGeneSymbol(geneSymbol);
    }

    @GetMapping("/?goClassAccession/{goClassAccession}")
    @ResponseBody
    public List<AnnotationDao> getAnnotationByGoClassAccession(@PathVariable String goClassAccession) {
        return annotationDao.getAnnotationByGoClassAccession(goClassAccession);
    }

    @GetMapping("/organism/{organism}")
    @ResponseBody
    public List<AnnotationDao> findByOrganism(@PathVariable String organism) {
        return annotationDao.findByOrganism(organism);
    }

    @GetMapping("/organismAndSymbol") //localhost:8080/annotation/organismAndSymbol?organism=1&symbol=2
    @ResponseBody
    public List<AnnotationDao> findByOrganismAndSymbol(@RequestParam String organism, @RequestParam String symbol) {
        return annotationDao.findByOrganismAndSymbol(organism, symbol);
    }

    @GetMapping("/organismAndAccession/")
    @ResponseBody
    public List<AnnotationDao> findByOrganismAndAccession(@RequestParam String organism, @RequestParam String accession) {
        return annotationDao.findByOrganismAndAccession(organism, accession);
    }

    @GetMapping("/annotationExtension/{annotationExtension}")
    @ResponseBody
    public List<AnnotationDao> findByAnnotationExtension(@PathVariable String annotationExtension) {
        return annotationDao.findByAnnotationExtension(annotationExtension);
    }

    @GetMapping("/annotationQualifier/{annotationQualifier}")
    @ResponseBody
    public List<AnnotationDao> findByAnnotationQualifier(@PathVariable String annotationQualifier) {
        return annotationDao.findByAnnotationQualifier(annotationQualifier);
    }

    @GetMapping("/evidence/{evidence}")
    @ResponseBody
    public List<AnnotationDao> findByEvidence(@PathVariable String evidence) {
        return annotationDao.findByEvidence(evidence);
    }

    @GetMapping("/reference/{reference}")
    @ResponseBody
    public List<AnnotationDao> findByReference(@PathVariable String reference) {
        return annotationDao.findByReference(reference);
    }

}

