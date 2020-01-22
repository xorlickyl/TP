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
            OWLClass Technology = dataFactory.getOWLClass("#Technology", pm);
            OWLClass Paradigm = dataFactory.getOWLClass("#Paradigm", pm);
            OWLClass Modes = dataFactory.getOWLClass("#Modes_Of_Introduction", pm);

            OWLDataProperty Name_property = dataFactory.getOWLDataProperty("Name",pm);
            OWLDataProperty Description = dataFactory.getOWLDataProperty("Description",pm);
            OWLDataProperty Exploit = dataFactory.getOWLDataProperty("Likelihood_Of_Exploit", pm);
            OWLDataProperty ExtDescription = dataFactory.getOWLDataProperty("Extended_Description",pm);

            OWLObjectProperty Child_of = dataFactory.getOWLObjectProperty("is_child_of", pm);
            OWLObjectProperty OnLang = dataFactory.getOWLObjectProperty("is_for_language", pm);
            OWLObjectProperty OnTech = dataFactory.getOWLObjectProperty("is_technology",pm);
            OWLObjectProperty OnPara = dataFactory.getOWLObjectProperty("is_paradigm",pm);
            OWLObjectProperty Modes_is = dataFactory.getOWLObjectProperty("is_modes_of",pm);

            OWLNamedIndividual LangIdenpendetItem = dataFactory.getOWLNamedIndividual(":LANG_Language-Independent",pm);
            OWLClassAssertionAxiom LI = dataFactory.getOWLClassAssertionAxiom(Languages,LangIdenpendetItem);
            m.addAxiom(o,LI);

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
                                }
                                if(lang.getName()!=null){
                                    OWLNamedIndividual LangOtherItem = dataFactory.getOWLNamedIndividual(":LANG_" + lang.getName(),pm);
                                    OWLClassAssertionAxiom LOI = dataFactory.getOWLClassAssertionAxiom(Languages, LangOtherItem);
                                    m.addAxiom(o, LOI);
                                    OWLObjectPropertyAssertionAxiom lang_is = dataFactory.getOWLObjectPropertyAssertionAxiom(OnLang, CWEItem, LangOtherItem);
                                    m.addAxiom(o, lang_is);
                                }
                        }
                    }
                    if(item.getPlatforms().getTechnology()!=null){
                        for(Technology tech :item.getPlatforms().getTechnology()){
                            if(tech.getServer()!=null){
                                String server =tech.getServer();
                                server = server.replace(" ","_");
                                OWLNamedIndividual TechItem = dataFactory.getOWLNamedIndividual(":"+server,pm);
                                OWLClassAssertionAxiom TI = dataFactory.getOWLClassAssertionAxiom(Technology,TechItem);
                                m.addAxiom(o,TI);
                                OWLObjectPropertyAssertionAxiom tech_is = dataFactory.getOWLObjectPropertyAssertionAxiom(OnTech,CWEItem,TechItem);
                                m.addAxiom(o,tech_is);
                            }
                        }
                    }
                    if(item.getPlatforms().getParadigm()!=null){
                        Paradigm parad = item.getPlatforms().getParadigm();
                        if(parad.getName()!=null) {
                            String paradigm = parad.getName();
                            paradigm = paradigm.replace(" ","_");
                            OWLNamedIndividual ParadigmItem = dataFactory.getOWLNamedIndividual(":"+paradigm, pm);
                            OWLClassAssertionAxiom PI = dataFactory.getOWLClassAssertionAxiom(Paradigm, ParadigmItem);
                            m.addAxiom(o, PI);
                            OWLObjectPropertyAssertionAxiom para_is = dataFactory.getOWLObjectPropertyAssertionAxiom(OnPara, CWEItem, ParadigmItem);
                            m.addAxiom(o, para_is);
                        }
                    }
                }
                if(item.getModes()!=null){
                    if(item.getModes().getIntroduction()!=null){
                        for(Introduction intro : item.getModes().getIntroduction()){
                            if(intro.getPhase()!=null) {
                                /*if(intro.getPhase().equals("Implementation")) {
                                    OWLNamedIndividual IntroducItem = dataFactory.getOWLNamedIndividual(":Implementation",pm);
                                    OWLClassAssertionAxiom III = dataFactory.getOWLClassAssertionAxiom(Modes, IntroducItem);
                                    m.addAxiom(o, III);
                                    OWLObjectPropertyAssertionAxiom intro_imp_is = dataFactory.getOWLObjectPropertyAssertionAxiom(Modes_is, CWEItem, IntroducItem);
                                    m.addAxiom(o, intro_imp_is);
                                }
                                /*if(intro.getPhase().equals("Architecture and Design")) {
                                    OWLNamedIndividual IntroducItem = dataFactory.getOWLNamedIndividual(":Architecture and Design",pm);
                                    OWLClassAssertionAxiom III = dataFactory.getOWLClassAssertionAxiom(Modes, IntroducItem);
                                    m.addAxiom(o, III);
                                    OWLObjectPropertyAssertionAxiom intro_imp_is = dataFactory.getOWLObjectPropertyAssertionAxiom(Modes_is, CWEItem, IntroducItem);
                                    m.addAxiom(o, intro_imp_is);
                                }
                                if(intro.getPhase().equals("Operation")) {
                                    OWLNamedIndividual IntroducItem = dataFactory.getOWLNamedIndividual(":Operation",pm);
                                    OWLClassAssertionAxiom III = dataFactory.getOWLClassAssertionAxiom(Modes, IntroducItem);
                                    m.addAxiom(o, III);
                                    OWLObjectPropertyAssertionAxiom intro_imp_is = dataFactory.getOWLObjectPropertyAssertionAxiom(Modes_is, CWEItem, IntroducItem);
                                    m.addAxiom(o, intro_imp_is);
                                }
                                if(intro.getPhase().equals("Build and Compilation")) {
                                    OWLNamedIndividual IntroducItem = dataFactory.getOWLNamedIndividual(":Build_and_Compilation",pm);
                                    OWLClassAssertionAxiom III = dataFactory.getOWLClassAssertionAxiom(Modes, IntroducItem);
                                    m.addAxiom(o, III);
                                    OWLObjectPropertyAssertionAxiom intro_imp_is = dataFactory.getOWLObjectPropertyAssertionAxiom(Modes_is, CWEItem, IntroducItem);
                                    m.addAxiom(o, intro_imp_is);
                                }
                                if(intro.getPhase().equals("System Configuration")) {
                                    OWLNamedIndividual IntroducItem = dataFactory.getOWLNamedIndividual(":System Configuration",pm);
                                    OWLClassAssertionAxiom III = dataFactory.getOWLClassAssertionAxiom(Modes, IntroducItem);
                                    m.addAxiom(o, III);
                                    OWLObjectPropertyAssertionAxiom intro_imp_is = dataFactory.getOWLObjectPropertyAssertionAxiom(Modes_is, CWEItem, IntroducItem);
                                    m.addAxiom(o, intro_imp_is);
                                }
                                if(intro.getPhase().equals("Installation")) {
                                    OWLNamedIndividual IntroducItem = dataFactory.getOWLNamedIndividual(":Installation",pm);
                                    OWLClassAssertionAxiom III = dataFactory.getOWLClassAssertionAxiom(Modes, IntroducItem);
                                    m.addAxiom(o, III);
                                    OWLObjectPropertyAssertionAxiom intro_imp_is = dataFactory.getOWLObjectPropertyAssertionAxiom(Modes_is, CWEItem, IntroducItem);
                                    m.addAxiom(o, intro_imp_is);
                                }
                                if(intro.getPhase().equals("Requirements")) {
                                    OWLNamedIndividual IntroducItem = dataFactory.getOWLNamedIndividual(":Requirements",pm);
                                    OWLClassAssertionAxiom III = dataFactory.getOWLClassAssertionAxiom(Modes, IntroducItem);
                                    m.addAxiom(o, III);
                                    OWLObjectPropertyAssertionAxiom intro_imp_is = dataFactory.getOWLObjectPropertyAssertionAxiom(Modes_is, CWEItem, IntroducItem);
                                    m.addAxiom(o, intro_imp_is);
                                }*/
                                    String phase = intro.getPhase();
                                    phase = phase.replace(" ","_");
                                    OWLNamedIndividual IntroducItem = dataFactory.getOWLNamedIndividual(":"+phase,pm);
                                    OWLClassAssertionAxiom III = dataFactory.getOWLClassAssertionAxiom(Modes, IntroducItem);
                                    m.addAxiom(o, III);
                                    OWLObjectPropertyAssertionAxiom intro_imp_is = dataFactory.getOWLObjectPropertyAssertionAxiom(Modes_is, CWEItem, IntroducItem);
                                    m.addAxiom(o, intro_imp_is);
                            }
                        }
                    }
                }

            }

            m.saveOntology(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
