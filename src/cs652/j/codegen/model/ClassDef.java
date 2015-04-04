package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class ClassDef extends OutputModelObject{

    public String className;
    public String superClass = null;
    @ModelElement public List<VarDef> fields = new ArrayList<VarDef>();
    @ModelElement public List<MethodDef> methods = new ArrayList<MethodDef>();


    public ClassDef(String className) {
        this.className = className;
    }

    public void setSuperClass(String superClass){this.superClass = superClass;}

}
