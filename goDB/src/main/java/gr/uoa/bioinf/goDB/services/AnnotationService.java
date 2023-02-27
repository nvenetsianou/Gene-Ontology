package gr.uoa.bioinf.goDB.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnotationService {

    public List getQualifiers() {
        List<String> qualifiers = new ArrayList<>();
        qualifiers.add("not");
        qualifiers.add("colocalizes_with");
        qualifiers.add("contributes_to");
        return qualifiers;
    }
}
