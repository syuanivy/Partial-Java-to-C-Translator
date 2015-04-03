package cs652.j.codegen.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class MainMethod extends OutputModelObject{
    public String retType = "void";
    public String methodName = "main";
    @ModelElement public List<OutputModelObject> statements = new ArrayList<OutputModelObject>();

}
