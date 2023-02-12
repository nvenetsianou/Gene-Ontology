package gr.uoa.bioinf.goDB.controllers;

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
@RequestMapping(path="/goClass")
public class GoClassController {

    @Autowired
    GoClassDao goClassDao;

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
