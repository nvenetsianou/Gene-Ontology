package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.AnnotationDao;
import gr.uoa.bioinf.goDB.daos.GeneGnprodDao;
import gr.uoa.bioinf.goDB.models.GeneGnprod;
import gr.uoa.bioinf.goDB.models.GoClass;
import gr.uoa.bioinf.goDB.models.SearchObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/geneGnprod")
public class GeneGnprodController {

    @Autowired
    AnnotationDao annotationDao;

    @Autowired
    GeneGnprodDao GeneGnprodDao;

    @GetMapping("/search")
    public String search(Model model, @ModelAttribute("searchObject") SearchObject searchObject,
                             BindingResult result) {
        model.addAttribute("organisms", annotationDao.getOrganisms());
        if (searchObject.getGeneTerm() != null) {
            model.addAttribute("results", annotationDao.searchGenes(searchObject));
        } else {
            model.addAttribute("results", null);
        }
        return "geneSearch";
    }

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
