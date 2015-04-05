package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class Block extends Stat {

    @ModelElement public List<VarDef> declarations = null;
    @ModelElement public List<Stat> statements = new ArrayList<>();

}
