package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.GeneGnprodDao;
import gr.uoa.bioinf.goDB.models.GeneGnprod;
import gr.uoa.bioinf.goDB.models.GoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/geneGnprod")
public class GeneGnprodController {
    @Autowired
    GeneGnprodDao GeneGnprodDao;

    @GetMapping("/")
    @ResponseBody
    public List<GeneGnprod> getAllGeneGnprod() {
        return GeneGnprodDao.getAllGeneGnprod();
    }

    @GetMapping("/?geneGnprod=")
    @ResponseBody
    public List<GeneGnprod> getOneGeneGnprod() {
        return GeneGnprodDao.getOneGeneGnprod();
    }

    @GetMapping("/?organism=")
    @ResponseBody
    public List<GeneGnprod> findByOrganism() {
        return GeneGnprodDao.findByOrganism();
    }

    @GetMapping("/?name=")
    @ResponseBody
    public List<GeneGnprod> findByName() {
        return GeneGnprodDao.findByName();
    }

    @GetMapping("/?synonyms=")
    @ResponseBody
    public List<GeneGnprod> getSynonyms() {
        return GeneGnprodDao.getSynonyms();
    }

    @GetMapping("/?gene_type=")
    @ResponseBody
    public List<GeneGnprod> findByGeneType() {
        return GeneGnprodDao.findByGeneType();
    }

}
