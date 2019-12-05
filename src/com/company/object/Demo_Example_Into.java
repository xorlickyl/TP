package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="Demonstrative_Example",strict = false)
public class Demo_Example_Into {
    @Element(name="Intro_Text",required = false)
    public String intro_text;
    @ElementList(name="Body_Text",inline = true,required = false)
    public List<String> body_text;
    @ElementList(name="Example_Code", inline = true, required = false)
    public List<Example_Code> example_code;

    public String getIntro_text() {
        return intro_text;
    }

    public void setIntro_text(String intro_text) {
        this.intro_text = intro_text;
    }

    public List<String> getBody_text() {
        return body_text;
    }

    public void setBody_text(List<String> body_text) {
        this.body_text = body_text;
    }

    public List<Example_Code> getExample_code() {
        return example_code;
    }

    public void setExample_code(List<Example_Code> example_code) {
        this.example_code = example_code;
    }
}
