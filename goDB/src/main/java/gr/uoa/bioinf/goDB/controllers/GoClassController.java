package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.GoClassDao;
import gr.uoa.bioinf.goDB.models.GoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<GoClass> getAllGOclasses() {
        return goClassDao.getAll();
    }

    @GetMapping("/?goClass=")
    @ResponseBody
    public List<GoClass> getOneClass() {
        return goClassDao.getOneClass();
    }

    @GetMapping("?ontologySource=")
    @ResponseBody
    public List<GoClass> findByOntologySource() {
       return goClassDao.findByOntologySource();
    }

    @GetMapping("?definition=")
    @ResponseBody
    public List<GoClass> getDefinition() {
        return goClassDao.getDefinition();
    }

    /*
    @GetMapping("/{id}}") {

    }*/
    // TODO
}
