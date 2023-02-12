package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.GeneGnprodDao;
import gr.uoa.bioinf.goDB.models.GeneGnprod;
import gr.uoa.bioinf.goDB.models.GoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/symbol/{symbol}")
    @ResponseBody
    public List<GeneGnprod> getOneGeneGnprod(@PathVariable String symbol) {
        return GeneGnprodDao.getOneGeneGnprod(symbol);
    }

    @GetMapping("/organism/{organism}")
    @ResponseBody
    public List<GeneGnprod> findByOrganism(@PathVariable String organism) {
        return GeneGnprodDao.findByOrganism(organism);
    }

    @GetMapping("/name/{name}")
    @ResponseBody
    public List<GeneGnprod> findByName(@PathVariable String name) {
        return GeneGnprodDao.findByName(name);
    }

    @GetMapping("/synonyms/{synonyms}")
    @ResponseBody
    public List<GeneGnprod> getSynonyms(@PathVariable String synonyms) {
        return GeneGnprodDao.getSynonyms(synonyms);
    }

    @GetMapping("/gType/{gType}")
    @ResponseBody
    public List<GeneGnprod> findByGeneType(@PathVariable String gType) {
        return GeneGnprodDao.findByGeneType(gType);
    }

}
