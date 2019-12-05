package com.company;

import com.company.object.Weakness_Catalog;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

public class Main {

    public static void main(String[] args)  {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();


        Serializer serializer= new Persister();
        File result = new File("cwec_v3.4.1.xml");


        try {
            Weakness_Catalog weaknesses=serializer.read(Weakness_Catalog.class, result);
            //System.out.println(weaknesses.getWeaknesses().getWeakness().get(0).getDemo_example().getDemo_example_into().get(0).getExample_code().get(0).getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
