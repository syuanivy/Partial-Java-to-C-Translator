package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class PrintStat extends PrintStringStat{
    public List<Expr> args = new ArrayList<>();

    public PrintStat(String str) {
        super(str);
    }
}
