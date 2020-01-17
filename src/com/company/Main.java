package com.company;

import com.company.object.*;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

public class Main {

    public static void main(String[] args)  {
        File OntologyFile = new File("TP-ontology_test.owl");


        Serializer serializer= new Persister();
        File result = new File("cwec_v3.4.1.xml");


        try {
            Weakness_Catalog weaknesses=serializer.read(Weakness_Catalog.class, result);
            //System.out.println(weaknesses.getWeaknesses().getWeakness().get(0).getDemo_example().getDemo_example_into().get(0).getExample_code().get(0).getText());
            OWLOntologyManager m = OWLManager.createOWLOntologyManager();
            OWLOntology o = m.loadOntologyFromOntologyDocument(OntologyFile);
            String base1 = o.getOntologyID().getOntologyIRI().toString();
            String base2 = base1.replaceAll("Optional" ,"");
            String base3 = base2.replaceAll("\\[" , "");
            String base4 = base3.replaceAll("]","");
            String finalbase = base4 + '/';
            PrefixManager pm = new DefaultPrefixManager(finalbase);
            OWLDataFactory dataFactory = m.getOWLDataFactory();

            OWLClass CWEClass = dataFactory.getOWLClass("#CWE", pm);
            OWLClass Languages = dataFactory.getOWLClass("#Languages", pm);
            OWLDataProperty Name_property = dataFactory.getOWLDataProperty("Name",pm);
            OWLDataProperty Description = dataFactory.getOWLDataProperty("Description",pm);
            OWLDataProperty Exploit = dataFactory.getOWLDataProperty("Likelihood_Of_Exploit", pm);
            OWLDataProperty ExtDescription = dataFactory.getOWLDataProperty("Extended_Description",pm);
            //OWLDataProperty Prevalence_Lang = dataFactory.getOWLDataProperty("Prevalence",pm);
            OWLObjectProperty Child_of = dataFactory.getOWLObjectProperty("is_child_of", pm);
           // OWLClass Phase = dataFactory.getOWLClass("#Phase", pm);
           // OWLObjectProperty PhaseObject =dataFactory.getOWLObjectProperty("has_phase",pm);
            OWLNamedIndividual LangIdenpendetItem = dataFactory.getOWLNamedIndividual(":LANG_Language-Independent",pm);
            OWLClassAssertionAxiom LI = dataFactory.getOWLClassAssertionAxiom(Languages,LangIdenpendetItem);
            m.addAxiom(o,LI);
            OWLObjectProperty OnLang = dataFactory.getOWLObjectProperty("is_for_language", pm);


            for(Weakness item :weaknesses.getWeaknesses().getWeakness()) {

                OWLNamedIndividual CWEItem = dataFactory.getOWLNamedIndividual(":" + item.getID(), pm);
                OWLClassAssertionAxiom I = dataFactory.getOWLClassAssertionAxiom(CWEClass, CWEItem);
                m.addAxiom(o, I);
                if (item.getName() != null) {
                    OWLDataPropertyAssertionAxiom name_axiom = dataFactory.getOWLDataPropertyAssertionAxiom(Name_property, CWEItem, item.getName());
                    m.addAxiom(o, name_axiom);
                }
                if (item.getDescription() != null) {
                    OWLDataPropertyAssertionAxiom desc_axiom = dataFactory.getOWLDataPropertyAssertionAxiom(Description, CWEItem, item.getDescription());
                    m.addAxiom(o, desc_axiom);
                }
                if (item.getLikelihood_Of_Exploit() != null) {
                    OWLDataPropertyAssertionAxiom exp_axiom = dataFactory.getOWLDataPropertyAssertionAxiom(Exploit, CWEItem, item.getLikelihood_Of_Exploit());
                    m.addAxiom(o, exp_axiom);
                }
                if (item.getExtended_Description() != null) {
                    OWLDataPropertyAssertionAxiom ext_desc = dataFactory.getOWLDataPropertyAssertionAxiom(ExtDescription, CWEItem, item.getExtended_Description());
                    m.addAxiom(o, ext_desc);
                }
                if (item.getChildren() != null) {
                    for (Child_ID child : item.getChildren().getChild_id()) {
                        OWLNamedIndividual ChildItem = dataFactory.getOWLNamedIndividual(":" + child.getID(), pm);
                        OWLObjectPropertyAssertionAxiom child_of = dataFactory.getOWLObjectPropertyAssertionAxiom(Child_of, CWEItem, ChildItem);
                        m.addAxiom(o, child_of);
                    }
                }
                if(item.getPlatforms()!=null) {
                    if (item.getPlatforms().getLanguage() != null) {
                        for (Language lang : item.getPlatforms().getLanguage()) {
                                if (lang.getName_class() != null) {
                                    OWLObjectPropertyAssertionAxiom lang_is = dataFactory.getOWLObjectPropertyAssertionAxiom(OnLang, CWEItem, LangIdenpendetItem);
                                    m.addAxiom(o, lang_is);
                                    //OWLDataPropertyAssertionAxiom preval = dataFactory.getOWLDataPropertyAssertionAxiom(Prevalence_Lang,LangIdenpendetItem,lang.getPrevalence());
                                    //m.addAxiom(o,preval);
                                }
                                if(lang.getName()!=null){
                                    OWLNamedIndividual LangOtherItem = dataFactory.getOWLNamedIndividual(":LANG_" + lang.getName(),pm);
                                    OWLClassAssertionAxiom LOI = dataFactory.getOWLClassAssertionAxiom(Languages, LangOtherItem);
                                    m.addAxiom(o, LOI);
                                    OWLObjectPropertyAssertionAxiom lang_is = dataFactory.getOWLObjectPropertyAssertionAxiom(OnLang, CWEItem, LangOtherItem);
                                    m.addAxiom(o, lang_is);
                                    //OWLDataPropertyAssertionAxiom preval = dataFactory.getOWLDataPropertyAssertionAxiom(Prevalence_Lang,LangOtherItem,lang.getPrevalence());
                                    //m.addAxiom(o,preval);
                                }
                        }
                    }
                }
                /*
                int counter =0;
                if(item.getModes()!=null){
                        for (Introduction introd : item.getModes().getIntroduction()) {
                            OWLNamedIndividual PhaseItem = dataFactory.getOWLNamedIndividual(":" + item.getID() + "_Phase_" + counter, pm);
                            OWLClassAssertionAxiom PI = dataFactory.getOWLClassAssertionAxiom(Phase, PhaseItem);
                            m.addAxiom(o, PI);
                            OWLObjectPropertyAssertionAxiom ObjectAxiom =dataFactory.getOWLObjectPropertyAssertionAxiom(PhaseObject,CWEItem,PhaseItem);
                            m.addAxiom(o,ObjectAxiom);
                            counter++;

                        }
                }
                */

            }

            m.saveOntology(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
