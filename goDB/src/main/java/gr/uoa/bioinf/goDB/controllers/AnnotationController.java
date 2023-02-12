package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.AnnotationDao;
import gr.uoa.bioinf.goDB.daos.GoClassDao;
import gr.uoa.bioinf.goDB.models.GoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/annotation")
public class AnnotationController {
    @Autowired
    AnnotationDao AnnotationDao;

    @GetMapping("/")
    @ResponseBody
    public List<AnnotationDao> getAllAnnotation() {
        return AnnotationDao.getAllAnnotation();
    }

    @GetMapping("/?geneSymbol/{geneSymbol}")
    @ResponseBody
    public List<AnnotationDao> getAnnotationByGeneSymbol(@PathVariable String geneSymbol) {
        return AnnotationDao.getAnnotationByGeneSymbol(geneSymbol);
    }

    @GetMapping("/?goClassAccession/{goClassAccession}")
    @ResponseBody
    public List<AnnotationDao> getAnnotationByGoClassAccession(@PathVariable String goClassAccession) {
        return AnnotationDao.getAnnotationByGoClassAccession(goClassAccession);
    }

    @GetMapping("/organism/{organism}")
    @ResponseBody
    public List<AnnotationDao> findByOrganism(@PathVariable String organism) {
        return AnnotationDao.findByOrganism(organism);
    }

    @GetMapping("/organismAndSymbol/{organismAndSymbol}")
    @ResponseBody
    public List<AnnotationDao> findByOrganismAndSymbol(@PathVariable String organismAndSymbol) {
        return AnnotationDao.findByOrganismAndSymbol(organismAndSymbol);
    }

    @GetMapping("/organismAndAccession/{organismAndAccession}")
    @ResponseBody
    public List<AnnotationDao> findByOrganismAndAccession(@PathVariable String organismAndAccession) {
        return AnnotationDao.findByOrganismAndAccession(organismAndAccession);
    }

    @GetMapping("/annotationExtension/{annotationExtension}")
    @ResponseBody
    public List<AnnotationDao> findByAnnotationExtension(@PathVariable String annotationExtension) {
        return AnnotationDao.findByAnnotationExtension(annotationExtension);
    }

    @GetMapping("/annotationQualifier/{annotationQualifier}")
    @ResponseBody
    public List<AnnotationDao> findByAnnotationQualifier(@PathVariable String annotationQualifier) {
        return AnnotationDao.findByAnnotationQualifier(annotationQualifier);
    }

    @GetMapping("/evidence/{evidence}")
    @ResponseBody
    public List<AnnotationDao> findByEvidence(@PathVariable String evidence) {
        return AnnotationDao.findByEvidence(evidence);
    }

    @GetMapping("/reference/{reference}")
    @ResponseBody
    public List<AnnotationDao> findByReference(@PathVariable String reference) {
        return AnnotationDao.findByReference(reference);
    }

}

