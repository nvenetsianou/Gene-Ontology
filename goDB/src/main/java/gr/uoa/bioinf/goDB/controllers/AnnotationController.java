package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.AnnotationDao;
import gr.uoa.bioinf.goDB.daos.GoClassDao;
import gr.uoa.bioinf.goDB.models.GoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/?gene_symbol=")
    @ResponseBody
    public List<AnnotationDao> getAnnotationByGeneSymbol() {
        return AnnotationDao.getAnnotationByGeneSymbol();
    }

    @GetMapping("/?go_class_accession=")
    @ResponseBody
    public List<AnnotationDao> getAnnotationByGoClassAccession() {
        return AnnotationDao.getAnnotationByGoClassAccession();
    }

    @GetMapping("/?organism=")
    @ResponseBody
    public List<AnnotationDao> findByOrganism() {
        return AnnotationDao.findByOrganism();
    }

    @GetMapping("/?organism=_and_symbol=")
    @ResponseBody
    public List<AnnotationDao> findByOrganismAndSymbol() {
        return AnnotationDao.findByOrganismAndSymbol();
    }

    @GetMapping("/?organism=_and_accession=")
    @ResponseBody
    public List<AnnotationDao> findByOrganismAndAccession() {
        return AnnotationDao.findByOrganismAndAccession();
    }

    @GetMapping("/?annotation_extension=")
    @ResponseBody
    public List<AnnotationDao> findByAnnotationExtension() {
        return AnnotationDao.findByAnnotationExtension();
    }

    @GetMapping("/?annotation_qualifier=")
    @ResponseBody
    public List<AnnotationDao> findByAnnotationQualifier() {
        return AnnotationDao.findByAnnotationQualifier();
    }

    @GetMapping("/?evidence=")
    @ResponseBody
    public List<AnnotationDao> findByEvidence() {
        return AnnotationDao.findByEvidence();
    }

    @GetMapping("/?reference=")
    @ResponseBody
    public List<AnnotationDao> findByReference() {
        return AnnotationDao.findByReference();
    }

}

