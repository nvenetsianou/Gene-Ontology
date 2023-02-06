package gr.uoa.bioinf.goDB.controllers;

import gr.uoa.bioinf.goDB.daos.GoClassDao;
import gr.uoa.bioinf.goDB.models.GoClass;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class GoClassController {
    @GetMapping("/getAllGOclasses")
    public List<GoClass> getAllGOclasses() {
        return GoClassDao.getAllGOclasses;
    }

    @GetMapping("/getGOclass?id=")
    // TODO
}
