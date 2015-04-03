package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 4/1/15.
 */
public class FuncPtrType extends OutputModelObject {
    @ModelElement TypeSpec returnType;
    @ModelElement List<TypeSpec> argTypes = new ArrayList<TypeSpec>();
}
