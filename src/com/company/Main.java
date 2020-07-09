package com.company;

import com.company.object.*;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File OntologyFile = new File("TP-ontology_test.owl");


        Serializer serializer = new Persister();
        File result = new File("cwec_v3.4.1.xml");


        try {
            Weakness_Catalog weaknesses = serializer.read(Weakness_Catalog.class, result);
            OWLOntologyManager m = OWLManager.createOWLOntologyManager();
            OWLOntology o = m.loadOntologyFromOntologyDocument(OntologyFile);
            String base1 = o.getOntologyID().getOntologyIRI().toString();
            String base2 = base1.replaceAll("Optional", "");
            String base3 = base2.replaceAll("\\[", "");
            String base4 = base3.replaceAll("]", "");
            String finalbase = base4 + '/';
            PrefixManager pm = new DefaultPrefixManager(finalbase);
            OWLDataFactory dataFactory = m.getOWLDataFactory();

            OWLClass CWEClass = dataFactory.getOWLClass("#CWE", pm);
            OWLClass Languages = dataFactory.getOWLClass("#Languages", pm);
            OWLClass Technology = dataFactory.getOWLClass("#Technology", pm);
            OWLClass Paradigm = dataFactory.getOWLClass("#Paradigm", pm);
            OWLClass Modes = dataFactory.getOWLClass("#Modes_Of_Introduction", pm);
            OWLClass Consequence = dataFactory.getOWLClass("#Consequence", pm);
            OWLClass Mitigations = dataFactory.getOWLClass("#Potential_Mitigations", pm);
            OWLClass O_Example = dataFactory.getOWLClass("#Observed_Example", pm);
            OWLClass Demo = dataFactory.getOWLClass("#Demo_Example", pm);

            OWLDataProperty Name_property = dataFactory.getOWLDataProperty("Name", pm);
            OWLDataProperty Description = dataFactory.getOWLDataProperty("Description", pm);
            OWLDataProperty Exploit = dataFactory.getOWLDataProperty("Likelihood_Of_Exploit", pm);
            OWLDataProperty ExtDescription = dataFactory.getOWLDataProperty("Extended_Description", pm);
            OWLDataProperty Scope_conseq = dataFactory.getOWLDataProperty("Scope", pm);
            OWLDataProperty Impact_conseq = dataFactory.getOWLDataProperty("Impact", pm);
            OWLDataProperty Note_conseq = dataFactory.getOWLDataProperty("Note", pm);
            OWLDataProperty Strategy_Mitig = dataFactory.getOWLDataProperty("Strategy", pm);
            OWLDataProperty Descript_Mitig = dataFactory.getOWLDataProperty("Description", pm);
            OWLDataProperty Effectiv_Mitig = dataFactory.getOWLDataProperty("Effectiveness", pm);
            OWLDataProperty Phase_Mitig = dataFactory.getOWLDataProperty("Phase", pm);
            OWLDataProperty Intro = dataFactory.getOWLDataProperty("Intro_Text", pm);
            OWLDataProperty Body = dataFactory.getOWLDataProperty("Body_Text", pm);
            OWLDataProperty Example_Code_N = dataFactory.getOWLDataProperty("Example_Code_Nature", pm);
            OWLDataProperty Example_Code_L = dataFactory.getOWLDataProperty("Example_Code_Language", pm);
            OWLDataProperty Example_Code_T = dataFactory.getOWLDataProperty("Example_Code_Text", pm);
            OWLDataProperty Observed_R = dataFactory.getOWLDataProperty("Observed_Reference", pm);
            OWLDataProperty Observed_L = dataFactory.getOWLDataProperty("Observed_Link", pm);
            OWLDataProperty Observed_D = dataFactory.getOWLDataProperty("Observed_Description", pm);

            OWLObjectProperty Child_of = dataFactory.getOWLObjectProperty("is_child_of", pm);
            OWLObjectProperty OnLang = dataFactory.getOWLObjectProperty("is_for_language", pm);
            OWLObjectProperty OnTech = dataFactory.getOWLObjectProperty("is_technology", pm);
            OWLObjectProperty OnPara = dataFactory.getOWLObjectProperty("is_paradigm", pm);
            OWLObjectProperty Modes_is = dataFactory.getOWLObjectProperty("is_modes_of", pm);
            OWLObjectProperty Consequence_is = dataFactory.getOWLObjectProperty("is_consequence", pm);
            OWLObjectProperty Mitigation_is = dataFactory.getOWLObjectProperty("is_mitigation", pm);
            OWLObjectProperty O_Example_is = dataFactory.getOWLObjectProperty("is_observed_example", pm);
            OWLObjectProperty Demo_is = dataFactory.getOWLObjectProperty("is_demo", pm);

            OWLNamedIndividual LangIdenpendetItem = dataFactory.getOWLNamedIndividual(":LANG_Language-Independent", pm);
            OWLClassAssertionAxiom LI = dataFactory.getOWLClassAssertionAxiom(Languages, LangIdenpendetItem);
            m.addAxiom(o, LI);

            for (Weakness item : weaknesses.getWeaknesses().getWeakness()) {
                OWLNamedIndividual CWEItem = dataFactory.getOWLNamedIndividual(":CWE-" + item.getID(), pm);
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
                if (item.getPlatforms() != null) {
                    if (item.getPlatforms().getLanguage() != null) {
                        for (Language lang : item.getPlatforms().getLanguage()) {
                            if (lang.getName_class() != null) {
                                OWLObjectPropertyAssertionAxiom lang_is = dataFactory.getOWLObjectPropertyAssertionAxiom(OnLang, CWEItem, LangIdenpendetItem);
                                m.addAxiom(o, lang_is);
                            }
                            if (lang.getName() != null) {
                                OWLNamedIndividual LangOtherItem = dataFactory.getOWLNamedIndividual(":LANG_" + lang.getName(), pm);
                                OWLClassAssertionAxiom LOI = dataFactory.getOWLClassAssertionAxiom(Languages, LangOtherItem);
                                m.addAxiom(o, LOI);
                                OWLObjectPropertyAssertionAxiom lang_is = dataFactory.getOWLObjectPropertyAssertionAxiom(OnLang, CWEItem, LangOtherItem);
                                m.addAxiom(o, lang_is);
                            }
                        }
                    }
                    if (item.getPlatforms().getTechnology() != null) {
                        for (Technology tech : item.getPlatforms().getTechnology()) {
                            if (tech.getServer() != null) {
                                String server = tech.getServer();
                                server = server.replace(" ", "_");
                                OWLNamedIndividual TechItem = dataFactory.getOWLNamedIndividual(":" + server, pm);
                                OWLClassAssertionAxiom TI = dataFactory.getOWLClassAssertionAxiom(Technology, TechItem);
                                m.addAxiom(o, TI);
                                OWLObjectPropertyAssertionAxiom tech_is = dataFactory.getOWLObjectPropertyAssertionAxiom(OnTech, CWEItem, TechItem);
                                m.addAxiom(o, tech_is);
                            }
                        }
                    }
                    if (item.getPlatforms().getParadigm() != null) {
                        Paradigm parad = item.getPlatforms().getParadigm();
                        if (parad.getName() != null) {
                            String paradigm = parad.getName();
                            paradigm = paradigm.replace(" ", "_");
                            OWLNamedIndividual ParadigmItem = dataFactory.getOWLNamedIndividual(":" + paradigm, pm);
                            OWLClassAssertionAxiom PI = dataFactory.getOWLClassAssertionAxiom(Paradigm, ParadigmItem);
                            m.addAxiom(o, PI);
                            OWLObjectPropertyAssertionAxiom para_is = dataFactory.getOWLObjectPropertyAssertionAxiom(OnPara, CWEItem, ParadigmItem);
                            m.addAxiom(o, para_is);
                        }
                    }
                }
                if (item.getModes() != null) {
                    if (item.getModes().getIntroduction() != null) {
                        for (Introduction intro : item.getModes().getIntroduction()) {
                            if (intro.getPhase() != null) {
                                String phase = intro.getPhase();
                                phase = phase.replace(" ", "_");
                                OWLNamedIndividual IntroducItem = dataFactory.getOWLNamedIndividual(":" + phase, pm);
                                OWLClassAssertionAxiom III = dataFactory.getOWLClassAssertionAxiom(Modes, IntroducItem);
                                m.addAxiom(o, III);
                                OWLObjectPropertyAssertionAxiom intro_imp_is = dataFactory.getOWLObjectPropertyAssertionAxiom(Modes_is, CWEItem, IntroducItem);
                                m.addAxiom(o, intro_imp_is);
                            }
                        }
                    }
                }
                /*Tu je niekde chyba*/
                if (item.getConsequences() != null) {
                    if (item.getConsequences().getConsequence() != null) {
                        int x = 0;
                        for (Consequence conseq : item.getConsequences().getConsequence()) {
                            OWLNamedIndividual ConseqItem = dataFactory.getOWLNamedIndividual(":Consequence_" + item.getID() + "_" + x, pm);
                            OWLClassAssertionAxiom CI = dataFactory.getOWLClassAssertionAxiom(Consequence, ConseqItem);
                            m.addAxiom(o, CI);
                            x++;
                            OWLObjectPropertyAssertionAxiom conseq_id = dataFactory.getOWLObjectPropertyAssertionAxiom(Consequence_is, CWEItem, ConseqItem);
                            m.addAxiom(o, conseq_id);
                            if (conseq.getScope() != null) {
                                List<Scope> ScopeList = conseq.getScope();
                                for (Scope oneScope : ScopeList) {
                                    if (oneScope.getText() != null) {
                                        OWLDataPropertyAssertionAxiom scope_conseq = dataFactory.getOWLDataPropertyAssertionAxiom(Scope_conseq, ConseqItem, oneScope.getText());
                                        m.addAxiom(o, scope_conseq);
                                    }
                                }
                            }
                            if (conseq.getImpact() != null) {
                                List<Impacts> ImapctList = conseq.getImpact();
                                for (Impacts oneImpacts : ImapctList) {
                                    if (oneImpacts.getText() != null) {
                                        OWLDataPropertyAssertionAxiom impact_conseq = dataFactory.getOWLDataPropertyAssertionAxiom(Impact_conseq, ConseqItem, oneImpacts.getText());
                                        m.addAxiom(o, impact_conseq);
                                    }
                                }
                            }
                            if (conseq.getNote() != null) {
                                List<Notes> NoteList = conseq.getNote();
                                for (Notes oneNote : NoteList) {
                                    if (oneNote.getText() != null) {
                                        OWLDataPropertyAssertionAxiom note_conseq = dataFactory.getOWLDataPropertyAssertionAxiom(Note_conseq, ConseqItem, oneNote.getText());
                                        m.addAxiom(o, note_conseq);
                                    }
                                }
                            }
                        }
                    }
                }

                if (item.getMitigations() != null) {
                    int x = 0;
                    if (item.getMitigations().getMitigation() != null) {
                        for (Mitigation mitig : item.getMitigations().getMitigation()) {
                            OWLNamedIndividual MitigItem = dataFactory.getOWLNamedIndividual(":Mitigation_" + item.getID() + "_" + x, pm);
                            OWLClassAssertionAxiom MI = dataFactory.getOWLClassAssertionAxiom(Mitigations, MitigItem);
                            m.addAxiom(o, MI);
                            x++;
                            OWLObjectPropertyAssertionAxiom mitig_id = dataFactory.getOWLObjectPropertyAssertionAxiom(Mitigation_is, CWEItem, MitigItem);
                            m.addAxiom(o, mitig_id);
                            if (mitig.getStrategy() != null) {
                                OWLDataPropertyAssertionAxiom strategy = dataFactory.getOWLDataPropertyAssertionAxiom(Strategy_Mitig, MitigItem, mitig.getStrategy());
                                m.addAxiom(o, strategy);
                            }
                            if (mitig.getDescription() != null) {
                                OWLDataPropertyAssertionAxiom decript = dataFactory.getOWLDataPropertyAssertionAxiom(Descript_Mitig, MitigItem, mitig.getDescription());
                                m.addAxiom(o, decript);
                            }
                            if (mitig.getEffectiveness() != null) {
                                OWLDataPropertyAssertionAxiom effectiv = dataFactory.getOWLDataPropertyAssertionAxiom(Effectiv_Mitig, MitigItem, mitig.getEffectiveness());
                                m.addAxiom(o, effectiv);
                            }
                            if (mitig.getPhase() != null) {
                                List<Phase> phase = mitig.getPhase();
                                int i = 0;
                                for (Phase phs : phase) {
                                    if (phs.getPhase() != null) {
                                        OWLDataProperty Phase_Mit = dataFactory.getOWLDataProperty("Phase", pm);
                                        OWLDataPropertyAssertionAxiom phss = dataFactory.getOWLDataPropertyAssertionAxiom(Phase_Mit, MitigItem, phs.getPhase());
                                        m.addAxiom(o, phss);
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }
                if (item.getDemo_example() != null) {
                    int num = 0;
                    int x = 0;
                    if (item.getDemo_example() != null) {
                        for (Demo_Example_Into demo : item.getDemo_example()) {
                            OWLNamedIndividual DemoItem = dataFactory.getOWLNamedIndividual(":Demo_" + item.getID() + "_" + x, pm);
                            OWLClassAssertionAxiom DI = dataFactory.getOWLClassAssertionAxiom(Demo, DemoItem);
                            m.addAxiom(o, DI);
                            x++;
                            OWLObjectPropertyAssertionAxiom demo_id = dataFactory.getOWLObjectPropertyAssertionAxiom(Demo_is, CWEItem, DemoItem);
                            m.addAxiom(o, demo_id);
                            if (demo.getIntro_text() != null) {
                                OWLDataPropertyAssertionAxiom intro = dataFactory.getOWLDataPropertyAssertionAxiom(Intro, DemoItem, demo.getIntro_text());
                                m.addAxiom(o, intro);
                            }
                            if (demo.getBody_text() != null) {
                                List<Body> body = demo.getBody_text();
                                for (Body s : body) {
                                    OWLDataProperty Bodys = dataFactory.getOWLDataProperty("Body_Text", pm);
                                    OWLDataPropertyAssertionAxiom body_t = dataFactory.getOWLDataPropertyAssertionAxiom(Bodys, DemoItem, s.getText());
                                    m.addAxiom(o, body_t);
                                    num++;
                                }
                            }
                            if (demo.getExample_code() != null) {
                                for (Example_Code example_code : demo.getExample_code()) {
                                    if (example_code.getLanguage() != null) {
                                        OWLDataPropertyAssertionAxiom exma_l = dataFactory.getOWLDataPropertyAssertionAxiom(Example_Code_L, DemoItem, example_code.getLanguage());
                                        m.addAxiom(o, exma_l);
                                    }
                                    if (example_code.getNature() != null) {
                                        OWLDataPropertyAssertionAxiom exma_n = dataFactory.getOWLDataPropertyAssertionAxiom(Example_Code_N, DemoItem, example_code.getNature());
                                        m.addAxiom(o, exma_n);
                                    }
                                    //TODO: upravit classu
                                    if (example_code.getText() != null) {
                                        OWLDataPropertyAssertionAxiom exma_t = dataFactory.getOWLDataPropertyAssertionAxiom(Example_Code_T, DemoItem, example_code.getText());
                                        m.addAxiom(o, exma_t);
                                    }
                                }
                            }
                        }
                    }
                }
                if (item.getObserved_examples() != null) {
                    int x = 0;
                    if (item.getObserved_examples().getObserved_example() != null) {
                        for (Observed_Example exp : item.getObserved_examples().getObserved_example()) {
                            if (exp.getReference() != null) {
                                String ref = exp.getReference().replace(" ", "");
                                OWLNamedIndividual ExamItem = dataFactory.getOWLNamedIndividual(":" + ref, pm);
                                OWLObjectPropertyAssertionAxiom exam_id = dataFactory.getOWLObjectPropertyAssertionAxiom(O_Example_is, CWEItem, ExamItem);
                                m.addAxiom(o, exam_id);
                                if (exp.getDescription() != null) {
                                    OWLDataPropertyAssertionAxiom desc = dataFactory.getOWLDataPropertyAssertionAxiom(Observed_D, ExamItem, exp.getDescription());
                                    m.addAxiom(o, desc);
                                }
                                if (exp.getLink() != null) {
                                    OWLDataPropertyAssertionAxiom link = dataFactory.getOWLDataPropertyAssertionAxiom(Observed_L, ExamItem, exp.getLink());
                                    m.addAxiom(o, link);
                                }
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
