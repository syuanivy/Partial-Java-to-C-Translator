package cs652.j.codegen;

import cs652.j.codegen.model.AssignStat;
import cs652.j.codegen.model.Block;
import cs652.j.codegen.model.CFile;
import cs652.j.codegen.model.CallStat;
import cs652.j.codegen.model.ClassDef;
import cs652.j.codegen.model.CtorCall;
import cs652.j.codegen.model.Expr;
import cs652.j.codegen.model.FieldRef;
import cs652.j.codegen.model.FuncName;
import cs652.j.codegen.model.IfElseStat;
import cs652.j.codegen.model.IfStat;
import cs652.j.codegen.model.LiteralRef;
import cs652.j.codegen.model.MainMethod;
import cs652.j.codegen.model.MethodCall;
import cs652.j.codegen.model.MethodDef;
import cs652.j.codegen.model.NullRef;
import cs652.j.codegen.model.ObjectTypeSpec;
import cs652.j.codegen.model.OutputModelObject;
import cs652.j.codegen.model.PrimitiveTypeSpec;
import cs652.j.codegen.model.PrintStat;
import cs652.j.codegen.model.PrintStringStat;
import cs652.j.codegen.model.ReturnStat;
import cs652.j.codegen.model.Stat;
import cs652.j.codegen.model.ThisRef;
import cs652.j.codegen.model.TypeCast;
import cs652.j.codegen.model.TypeSpec;
import cs652.j.codegen.model.VarDef;
import cs652.j.codegen.model.VarRef;
import cs652.j.codegen.model.WhileStat;
import cs652.j.parser.JBaseVisitor;
import cs652.j.parser.JParser;
import cs652.j.semantics.JClass;
import cs652.j.semantics.JField;
import cs652.j.semantics.JMethod;
import org.antlr.symbols.MethodSymbol;
import org.antlr.symbols.Scope;
import org.antlr.symbols.Symbol;
import org.antlr.symbols.Type;
import org.antlr.symbols.Utils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator extends JBaseVisitor<OutputModelObject> {
	public STGroup templates;
	public String fileName;

	public Scope currentScope;
	public JClass currentClass;

	public CodeGenerator(String fileName) {
		this.fileName = fileName;
		templates = new STGroupFile("cs652/j/templates/C.stg");
	}

	public CFile generate(ParserRuleContext tree) {
		CFile file = (CFile)visit(tree);
		return file;
	}
}
