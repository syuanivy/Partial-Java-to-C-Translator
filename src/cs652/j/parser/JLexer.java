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
		T__0=1, CLASS=2, ELSE=3, EXTENDS=4, FLOAT=5, IF=6, INT=7, NEW=8, RETURN=9, 
		THIS=10, VOID=11, WHILE=12, IntegerLiteral=13, FloatPointLiteral=14, StringLiteral=15, 
		NullLiteral=16, LPAREN=17, RPAREN=18, LBRACE=19, RBRACE=20, SEMI=21, COMMA=22, 
		DOT=23, ASSIGN=24, Identifier=25, COMMENT=26, LINE_COMMENT=27, WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "CLASS", "ELSE", "EXTENDS", "FLOAT", "IF", "INT", "NEW", "RETURN", 
		"THIS", "VOID", "WHILE", "IntegerLiteral", "DecimalIntegerLiteral", "DecimalNumeral", 
		"Digits", "Digit", "NonZeroDigit", "FloatPointLiteral", "StringLiteral", 
		"StringCharacters", "StringCharacter", "NullLiteral", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "SEMI", "COMMA", "DOT", "ASSIGN", "Identifier", "JavaLetter", 
		"JavaLetterOrDigit", "COMMENT", "LINE_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'printf('", "'class'", "'else'", "'extends'", "'float'", "'if'", 
		"'int'", "'new'", "'return'", "'this'", "'void'", "'while'", null, null, 
		null, "'null'", "'('", "')'", "'{'", "'}'", "';'", "','", "'.'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "CLASS", "ELSE", "EXTENDS", "FLOAT", "IF", "INT", "NEW", "RETURN", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00fc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\5\20\u0098\n\20\5\20\u009a\n\20\3\21\7\21\u009d\n\21\f\21\16\21\u00a0"+
		"\13\21\3\22\3\22\5\22\u00a4\n\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\5\25\u00ae\n\25\3\25\3\25\3\26\6\26\u00b3\n\26\r\26\16\26\u00b4\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\7!\u00d0\n!\f!\16!\u00d3"+
		"\13!\3\"\5\"\u00d6\n\"\3#\5#\u00d9\n#\3$\3$\3$\3$\7$\u00df\n$\f$\16$\u00e2"+
		"\13$\3$\3$\3$\3$\3$\3%\3%\3%\3%\7%\u00ed\n%\f%\16%\u00f0\13%\3%\3%\3%"+
		"\3%\3&\6&\u00f7\n&\r&\16&\u00f8\3&\3&\3\u00e0\2\'\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\2!\2#\2%\2\'\20)\21"+
		"+\2-\2/\22\61\23\63\24\65\25\67\269\27;\30=\31?\32A\33C\2E\2G\34I\35K"+
		"\36\3\2\b\3\2\63;\3\2$$\6\2&&C\\aac|\7\2&&\62;C\\aac|\3\2\f\f\5\2\13\f"+
		"\17\17\"\"\u00fc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2/\3"+
		"\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\3M\3\2\2\2\5U\3\2\2\2\7[\3\2\2\2\t`\3\2\2\2\13h\3\2\2\2\rn\3"+
		"\2\2\2\17q\3\2\2\2\21u\3\2\2\2\23y\3\2\2\2\25\u0080\3\2\2\2\27\u0085\3"+
		"\2\2\2\31\u008a\3\2\2\2\33\u0090\3\2\2\2\35\u0092\3\2\2\2\37\u0099\3\2"+
		"\2\2!\u009e\3\2\2\2#\u00a3\3\2\2\2%\u00a5\3\2\2\2\'\u00a7\3\2\2\2)\u00ab"+
		"\3\2\2\2+\u00b2\3\2\2\2-\u00b6\3\2\2\2/\u00b8\3\2\2\2\61\u00bd\3\2\2\2"+
		"\63\u00bf\3\2\2\2\65\u00c1\3\2\2\2\67\u00c3\3\2\2\29\u00c5\3\2\2\2;\u00c7"+
		"\3\2\2\2=\u00c9\3\2\2\2?\u00cb\3\2\2\2A\u00cd\3\2\2\2C\u00d5\3\2\2\2E"+
		"\u00d8\3\2\2\2G\u00da\3\2\2\2I\u00e8\3\2\2\2K\u00f6\3\2\2\2MN\7r\2\2N"+
		"O\7t\2\2OP\7k\2\2PQ\7p\2\2QR\7v\2\2RS\7h\2\2ST\7*\2\2T\4\3\2\2\2UV\7e"+
		"\2\2VW\7n\2\2WX\7c\2\2XY\7u\2\2YZ\7u\2\2Z\6\3\2\2\2[\\\7g\2\2\\]\7n\2"+
		"\2]^\7u\2\2^_\7g\2\2_\b\3\2\2\2`a\7g\2\2ab\7z\2\2bc\7v\2\2cd\7g\2\2de"+
		"\7p\2\2ef\7f\2\2fg\7u\2\2g\n\3\2\2\2hi\7h\2\2ij\7n\2\2jk\7q\2\2kl\7c\2"+
		"\2lm\7v\2\2m\f\3\2\2\2no\7k\2\2op\7h\2\2p\16\3\2\2\2qr\7k\2\2rs\7p\2\2"+
		"st\7v\2\2t\20\3\2\2\2uv\7p\2\2vw\7g\2\2wx\7y\2\2x\22\3\2\2\2yz\7t\2\2"+
		"z{\7g\2\2{|\7v\2\2|}\7w\2\2}~\7t\2\2~\177\7p\2\2\177\24\3\2\2\2\u0080"+
		"\u0081\7v\2\2\u0081\u0082\7j\2\2\u0082\u0083\7k\2\2\u0083\u0084\7u\2\2"+
		"\u0084\26\3\2\2\2\u0085\u0086\7x\2\2\u0086\u0087\7q\2\2\u0087\u0088\7"+
		"k\2\2\u0088\u0089\7f\2\2\u0089\30\3\2\2\2\u008a\u008b\7y\2\2\u008b\u008c"+
		"\7j\2\2\u008c\u008d\7k\2\2\u008d\u008e\7n\2\2\u008e\u008f\7g\2\2\u008f"+
		"\32\3\2\2\2\u0090\u0091\5\35\17\2\u0091\34\3\2\2\2\u0092\u0093\5\37\20"+
		"\2\u0093\36\3\2\2\2\u0094\u009a\7\62\2\2\u0095\u0097\5%\23\2\u0096\u0098"+
		"\5!\21\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0094\3\2\2\2\u0099\u0095\3\2\2\2\u009a \3\2\2\2\u009b\u009d\5#\22\2"+
		"\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\7\62\2\2\u00a2"+
		"\u00a4\5%\23\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4$\3\2\2\2"+
		"\u00a5\u00a6\t\2\2\2\u00a6&\3\2\2\2\u00a7\u00a8\5\33\16\2\u00a8\u00a9"+
		"\7\60\2\2\u00a9\u00aa\5!\21\2\u00aa(\3\2\2\2\u00ab\u00ad\7$\2\2\u00ac"+
		"\u00ae\5+\26\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b0\7$\2\2\u00b0*\3\2\2\2\u00b1\u00b3\5-\27\2\u00b2\u00b1"+
		"\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		",\3\2\2\2\u00b6\u00b7\n\3\2\2\u00b7.\3\2\2\2\u00b8\u00b9\7p\2\2\u00b9"+
		"\u00ba\7w\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7n\2\2\u00bc\60\3\2\2\2\u00bd"+
		"\u00be\7*\2\2\u00be\62\3\2\2\2\u00bf\u00c0\7+\2\2\u00c0\64\3\2\2\2\u00c1"+
		"\u00c2\7}\2\2\u00c2\66\3\2\2\2\u00c3\u00c4\7\177\2\2\u00c48\3\2\2\2\u00c5"+
		"\u00c6\7=\2\2\u00c6:\3\2\2\2\u00c7\u00c8\7.\2\2\u00c8<\3\2\2\2\u00c9\u00ca"+
		"\7\60\2\2\u00ca>\3\2\2\2\u00cb\u00cc\7?\2\2\u00cc@\3\2\2\2\u00cd\u00d1"+
		"\5C\"\2\u00ce\u00d0\5E#\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2B\3\2\2\2\u00d3\u00d1\3\2\2\2"+
		"\u00d4\u00d6\t\4\2\2\u00d5\u00d4\3\2\2\2\u00d6D\3\2\2\2\u00d7\u00d9\t"+
		"\5\2\2\u00d8\u00d7\3\2\2\2\u00d9F\3\2\2\2\u00da\u00db\7\61\2\2\u00db\u00dc"+
		"\7,\2\2\u00dc\u00e0\3\2\2\2\u00dd\u00df\13\2\2\2\u00de\u00dd\3\2\2\2\u00df"+
		"\u00e2\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e5\7\61\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e7\b$\2\2\u00e7H\3\2\2\2\u00e8\u00e9\7\61\2\2"+
		"\u00e9\u00ea\7\61\2\2\u00ea\u00ee\3\2\2\2\u00eb\u00ed\n\6\2\2\u00ec\u00eb"+
		"\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7\f\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\u00f4\b%\2\2\u00f4J\3\2\2\2\u00f5\u00f7\t\7\2\2\u00f6\u00f5"+
		"\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fb\b&\2\2\u00fbL\3\2\2\2\17\2\u0097\u0099\u009e"+
		"\u00a3\u00ad\u00b4\u00d1\u00d5\u00d8\u00e0\u00ee\u00f8\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}