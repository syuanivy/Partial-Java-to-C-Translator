// Generated from /Users/Shuai/Dropbox/cs652/syuanivy-vtable/src/cs652/j/parser/J.g4 by ANTLR 4.5

package cs652.j.parser;
import cs652.j.semantics.*; // You will need these for stuff in "returns" clauses
import org.antlr.symbols.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, ELSE=2, EXTENDS=3, FLOAT=4, IF=5, INT=6, NEW=7, RETURN=8, THIS=9, 
		VOID=10, WHILE=11, IntegerLiteral=12, FloatPointLiteral=13, StringLiteral=14, 
		NullLiteral=15, LPAREN=16, RPAREN=17, LBRACE=18, RBRACE=19, SEMI=20, COMMA=21, 
		DOT=22, ASSIGN=23, Identifier=24, COMMENT=25, LINE_COMMENT=26, WS=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CLASS", "ELSE", "EXTENDS", "FLOAT", "IF", "INT", "NEW", "RETURN", "THIS", 
		"VOID", "WHILE", "IntegerLiteral", "DecimalIntegerLiteral", "DecimalNumeral", 
		"Digits", "Digit", "NonZeroDigit", "FloatPointLiteral", "StringLiteral", 
		"StringCharacters", "StringCharacter", "NullLiteral", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "SEMI", "COMMA", "DOT", "ASSIGN", "Identifier", "JavaLetter", 
		"JavaLetterOrDigit", "COMMENT", "LINE_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'else'", "'extends'", "'float'", "'if'", "'int'", "'new'", 
		"'return'", "'this'", "'void'", "'while'", null, null, null, "'null'", 
		"'('", "')'", "'{'", "'}'", "';'", "','", "'.'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CLASS", "ELSE", "EXTENDS", "FLOAT", "IF", "INT", "NEW", "RETURN", 
		"THIS", "VOID", "WHILE", "IntegerLiteral", "FloatPointLiteral", "StringLiteral", 
		"NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMI", "COMMA", 
		"DOT", "ASSIGN", "Identifier", "COMMENT", "LINE_COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public JLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "J.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00f2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\17\5\17\u008e\n\17\5\17\u0090\n\17\3\20\7\20"+
		"\u0093\n\20\f\20\16\20\u0096\13\20\3\21\3\21\5\21\u009a\n\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\5\24\u00a4\n\24\3\24\3\24\3\25\6\25\u00a9"+
		"\n\25\r\25\16\25\u00aa\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		" \3 \7 \u00c6\n \f \16 \u00c9\13 \3!\5!\u00cc\n!\3\"\5\"\u00cf\n\"\3#"+
		"\3#\3#\3#\7#\u00d5\n#\f#\16#\u00d8\13#\3#\3#\3#\3#\3#\3$\3$\3$\3$\7$\u00e3"+
		"\n$\f$\16$\u00e6\13$\3$\3$\3$\3$\3%\6%\u00ed\n%\r%\16%\u00ee\3%\3%\3\u00d6"+
		"\2&\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\2\35\2"+
		"\37\2!\2#\2%\17\'\20)\2+\2-\21/\22\61\23\63\24\65\25\67\269\27;\30=\31"+
		"?\32A\2C\2E\33G\34I\35\3\2\b\3\2\63;\3\2$$\6\2&&C\\aac|\7\2&&\62;C\\a"+
		"ac|\3\2\f\f\5\2\13\f\17\17\"\"\u00f2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\3K\3\2\2\2\5Q\3\2\2\2\7V\3\2\2\2\t^\3\2\2\2\13d\3\2\2\2\r"+
		"g\3\2\2\2\17k\3\2\2\2\21o\3\2\2\2\23v\3\2\2\2\25{\3\2\2\2\27\u0080\3\2"+
		"\2\2\31\u0086\3\2\2\2\33\u0088\3\2\2\2\35\u008f\3\2\2\2\37\u0094\3\2\2"+
		"\2!\u0099\3\2\2\2#\u009b\3\2\2\2%\u009d\3\2\2\2\'\u00a1\3\2\2\2)\u00a8"+
		"\3\2\2\2+\u00ac\3\2\2\2-\u00ae\3\2\2\2/\u00b3\3\2\2\2\61\u00b5\3\2\2\2"+
		"\63\u00b7\3\2\2\2\65\u00b9\3\2\2\2\67\u00bb\3\2\2\29\u00bd\3\2\2\2;\u00bf"+
		"\3\2\2\2=\u00c1\3\2\2\2?\u00c3\3\2\2\2A\u00cb\3\2\2\2C\u00ce\3\2\2\2E"+
		"\u00d0\3\2\2\2G\u00de\3\2\2\2I\u00ec\3\2\2\2KL\7e\2\2LM\7n\2\2MN\7c\2"+
		"\2NO\7u\2\2OP\7u\2\2P\4\3\2\2\2QR\7g\2\2RS\7n\2\2ST\7u\2\2TU\7g\2\2U\6"+
		"\3\2\2\2VW\7g\2\2WX\7z\2\2XY\7v\2\2YZ\7g\2\2Z[\7p\2\2[\\\7f\2\2\\]\7u"+
		"\2\2]\b\3\2\2\2^_\7h\2\2_`\7n\2\2`a\7q\2\2ab\7c\2\2bc\7v\2\2c\n\3\2\2"+
		"\2de\7k\2\2ef\7h\2\2f\f\3\2\2\2gh\7k\2\2hi\7p\2\2ij\7v\2\2j\16\3\2\2\2"+
		"kl\7p\2\2lm\7g\2\2mn\7y\2\2n\20\3\2\2\2op\7t\2\2pq\7g\2\2qr\7v\2\2rs\7"+
		"w\2\2st\7t\2\2tu\7p\2\2u\22\3\2\2\2vw\7v\2\2wx\7j\2\2xy\7k\2\2yz\7u\2"+
		"\2z\24\3\2\2\2{|\7x\2\2|}\7q\2\2}~\7k\2\2~\177\7f\2\2\177\26\3\2\2\2\u0080"+
		"\u0081\7y\2\2\u0081\u0082\7j\2\2\u0082\u0083\7k\2\2\u0083\u0084\7n\2\2"+
		"\u0084\u0085\7g\2\2\u0085\30\3\2\2\2\u0086\u0087\5\33\16\2\u0087\32\3"+
		"\2\2\2\u0088\u0089\5\35\17\2\u0089\34\3\2\2\2\u008a\u0090\7\62\2\2\u008b"+
		"\u008d\5#\22\2\u008c\u008e\5\37\20\2\u008d\u008c\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u0090\3\2\2\2\u008f\u008a\3\2\2\2\u008f\u008b\3\2\2\2\u0090"+
		"\36\3\2\2\2\u0091\u0093\5!\21\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095 \3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0097\u009a\7\62\2\2\u0098\u009a\5#\22\2\u0099\u0097\3\2\2\2"+
		"\u0099\u0098\3\2\2\2\u009a\"\3\2\2\2\u009b\u009c\t\2\2\2\u009c$\3\2\2"+
		"\2\u009d\u009e\5\31\r\2\u009e\u009f\7\60\2\2\u009f\u00a0\5\37\20\2\u00a0"+
		"&\3\2\2\2\u00a1\u00a3\7$\2\2\u00a2\u00a4\5)\25\2\u00a3\u00a2\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7$\2\2\u00a6(\3\2\2\2\u00a7"+
		"\u00a9\5+\26\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00aa\u00ab\3\2\2\2\u00ab*\3\2\2\2\u00ac\u00ad\n\3\2\2\u00ad,\3\2"+
		"\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7w\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2"+
		"\7n\2\2\u00b2.\3\2\2\2\u00b3\u00b4\7*\2\2\u00b4\60\3\2\2\2\u00b5\u00b6"+
		"\7+\2\2\u00b6\62\3\2\2\2\u00b7\u00b8\7}\2\2\u00b8\64\3\2\2\2\u00b9\u00ba"+
		"\7\177\2\2\u00ba\66\3\2\2\2\u00bb\u00bc\7=\2\2\u00bc8\3\2\2\2\u00bd\u00be"+
		"\7.\2\2\u00be:\3\2\2\2\u00bf\u00c0\7\60\2\2\u00c0<\3\2\2\2\u00c1\u00c2"+
		"\7?\2\2\u00c2>\3\2\2\2\u00c3\u00c7\5A!\2\u00c4\u00c6\5C\"\2\u00c5\u00c4"+
		"\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"@\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cc\t\4\2\2\u00cb\u00ca\3\2\2\2"+
		"\u00ccB\3\2\2\2\u00cd\u00cf\t\5\2\2\u00ce\u00cd\3\2\2\2\u00cfD\3\2\2\2"+
		"\u00d0\u00d1\7\61\2\2\u00d1\u00d2\7,\2\2\u00d2\u00d6\3\2\2\2\u00d3\u00d5"+
		"\13\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d7\3\2\2\2"+
		"\u00d6\u00d4\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da"+
		"\7,\2\2\u00da\u00db\7\61\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b#\2\2\u00dd"+
		"F\3\2\2\2\u00de\u00df\7\61\2\2\u00df\u00e0\7\61\2\2\u00e0\u00e4\3\2\2"+
		"\2\u00e1\u00e3\n\6\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00e8\7\f\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b$\2\2\u00eaH\3\2\2\2\u00eb"+
		"\u00ed\t\7\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\b%\2\2\u00f1"+
		"J\3\2\2\2\17\2\u008d\u008f\u0094\u0099\u00a3\u00aa\u00c7\u00cb\u00ce\u00d6"+
		"\u00e4\u00ee\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}