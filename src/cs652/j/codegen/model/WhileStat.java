package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class WhileStat extends Stat{
    @ModelElement public Expr condition;
    @ModelElement public Block block;
}
