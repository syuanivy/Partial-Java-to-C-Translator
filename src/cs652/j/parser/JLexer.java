// Generated from /Users/Shuai/Dropbox/cs652/syuanivy-vtable/src/cs652/j/parser/J.g4 by ANTLR 4.5

package cs652.j.parser;
import org.antlr.symbols.*;
import cs652.j.semantics.*; // You will need these for stuff in "returns" clauses

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, StringLiteral=21, IntegerLiteral=22, DecimalIntegerLiteral=23, 
		FloatingPointLiteral=24, Identifier=25, COMMENT=26, LINE_COMMENT=27, WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "StringLiteral", "IntegerLiteral", "DecimalIntegerLiteral", 
		"FloatingPointLiteral", "StringCharacters", "StringCharacter", "DecimalFloatingPointLiteral", 
		"DecimalNumeral", "NonZeroDigit", "Digits", "Digit", "Identifier", "JavaLetter", 
		"JavaLetterOrDigit", "COMMENT", "LINE_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'extends'", "'{'", "'}'", "';'", "'void'", "'('", "')'", 
		"','", "'if'", "'else'", "'while'", "'return'", "'.'", "'new'", "'='", 
		"'this'", "'null'", "'int'", "'float'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "StringLiteral", 
		"IntegerLiteral", "DecimalIntegerLiteral", "FloatingPointLiteral", "Identifier", 
		"COMMENT", "LINE_COMMENT", "WS"
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

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 33: 
			return JavaLetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean JavaLetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return Character.isJavaIdentifierPart(_input.LA(-1));
		case 1: 
			return Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00fa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\5\26\u00a0"+
		"\n\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\6\32\u00ab\n\32\r\32"+
		"\16\32\u00ac\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\5\35\u00b8\n"+
		"\35\5\35\u00ba\n\35\3\36\3\36\3\37\7\37\u00bf\n\37\f\37\16\37\u00c2\13"+
		"\37\3 \3 \5 \u00c6\n \3!\3!\7!\u00ca\n!\f!\16!\u00cd\13!\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3#\5#\u00d7\n#\3$\3$\3$\3$\7$\u00dd\n$\f$\16$\u00e0\13$\3$"+
		"\3$\3$\3$\3$\3%\3%\3%\3%\7%\u00eb\n%\f%\16%\u00ee\13%\3%\3%\3%\3%\3&\6"+
		"&\u00f5\n&\r&\16&\u00f6\3&\3&\3\u00de\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\2\65\2\67\29\2;\2=\2?\2A\33C\2E\2G\34I\35K\36\3\2"+
		"\13\3\2$$\3\2\63;\6\2&&C\\aac|\7\2&&\62;C\\aac|\4\2\2\u0101\ud802\udc01"+
		"\3\2\ud802\udc01\3\2\udc02\ue001\3\2\f\f\5\2\13\f\17\17\"\"\u00fc\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2A\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5S"+
		"\3\2\2\2\7[\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\ra\3\2\2\2\17f\3\2\2\2\21h"+
		"\3\2\2\2\23j\3\2\2\2\25l\3\2\2\2\27o\3\2\2\2\31t\3\2\2\2\33z\3\2\2\2\35"+
		"\u0081\3\2\2\2\37\u0083\3\2\2\2!\u0087\3\2\2\2#\u0089\3\2\2\2%\u008e\3"+
		"\2\2\2\'\u0093\3\2\2\2)\u0097\3\2\2\2+\u009d\3\2\2\2-\u00a3\3\2\2\2/\u00a5"+
		"\3\2\2\2\61\u00a7\3\2\2\2\63\u00aa\3\2\2\2\65\u00ae\3\2\2\2\67\u00b0\3"+
		"\2\2\29\u00b9\3\2\2\2;\u00bb\3\2\2\2=\u00c0\3\2\2\2?\u00c5\3\2\2\2A\u00c7"+
		"\3\2\2\2C\u00ce\3\2\2\2E\u00d6\3\2\2\2G\u00d8\3\2\2\2I\u00e6\3\2\2\2K"+
		"\u00f4\3\2\2\2MN\7e\2\2NO\7n\2\2OP\7c\2\2PQ\7u\2\2QR\7u\2\2R\4\3\2\2\2"+
		"ST\7g\2\2TU\7z\2\2UV\7v\2\2VW\7g\2\2WX\7p\2\2XY\7f\2\2YZ\7u\2\2Z\6\3\2"+
		"\2\2[\\\7}\2\2\\\b\3\2\2\2]^\7\177\2\2^\n\3\2\2\2_`\7=\2\2`\f\3\2\2\2"+
		"ab\7x\2\2bc\7q\2\2cd\7k\2\2de\7f\2\2e\16\3\2\2\2fg\7*\2\2g\20\3\2\2\2"+
		"hi\7+\2\2i\22\3\2\2\2jk\7.\2\2k\24\3\2\2\2lm\7k\2\2mn\7h\2\2n\26\3\2\2"+
		"\2op\7g\2\2pq\7n\2\2qr\7u\2\2rs\7g\2\2s\30\3\2\2\2tu\7y\2\2uv\7j\2\2v"+
		"w\7k\2\2wx\7n\2\2xy\7g\2\2y\32\3\2\2\2z{\7t\2\2{|\7g\2\2|}\7v\2\2}~\7"+
		"w\2\2~\177\7t\2\2\177\u0080\7p\2\2\u0080\34\3\2\2\2\u0081\u0082\7\60\2"+
		"\2\u0082\36\3\2\2\2\u0083\u0084\7p\2\2\u0084\u0085\7g\2\2\u0085\u0086"+
		"\7y\2\2\u0086 \3\2\2\2\u0087\u0088\7?\2\2\u0088\"\3\2\2\2\u0089\u008a"+
		"\7v\2\2\u008a\u008b\7j\2\2\u008b\u008c\7k\2\2\u008c\u008d\7u\2\2\u008d"+
		"$\3\2\2\2\u008e\u008f\7p\2\2\u008f\u0090\7w\2\2\u0090\u0091\7n\2\2\u0091"+
		"\u0092\7n\2\2\u0092&\3\2\2\2\u0093\u0094\7k\2\2\u0094\u0095\7p\2\2\u0095"+
		"\u0096\7v\2\2\u0096(\3\2\2\2\u0097\u0098\7h\2\2\u0098\u0099\7n\2\2\u0099"+
		"\u009a\7q\2\2\u009a\u009b\7c\2\2\u009b\u009c\7v\2\2\u009c*\3\2\2\2\u009d"+
		"\u009f\7$\2\2\u009e\u00a0\5\63\32\2\u009f\u009e\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7$\2\2\u00a2,\3\2\2\2\u00a3\u00a4"+
		"\5/\30\2\u00a4.\3\2\2\2\u00a5\u00a6\59\35\2\u00a6\60\3\2\2\2\u00a7\u00a8"+
		"\5\67\34\2\u00a8\62\3\2\2\2\u00a9\u00ab\5\65\33\2\u00aa\u00a9\3\2\2\2"+
		"\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\64"+
		"\3\2\2\2\u00ae\u00af\n\2\2\2\u00af\66\3\2\2\2\u00b0\u00b1\59\35\2\u00b1"+
		"\u00b2\7\60\2\2\u00b2\u00b3\5=\37\2\u00b38\3\2\2\2\u00b4\u00ba\7\62\2"+
		"\2\u00b5\u00b7\5;\36\2\u00b6\u00b8\5=\37\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b4\3\2\2\2\u00b9\u00b5\3\2\2\2\u00ba"+
		":\3\2\2\2\u00bb\u00bc\t\3\2\2\u00bc<\3\2\2\2\u00bd\u00bf\5? \2\u00be\u00bd"+
		"\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		">\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6\7\62\2\2\u00c4\u00c6\5;\36\2"+
		"\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6@\3\2\2\2\u00c7\u00cb\5"+
		"C\"\2\u00c8\u00ca\5E#\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00ccB\3\2\2\2\u00cd\u00cb\3\2\2\2"+
		"\u00ce\u00cf\t\4\2\2\u00cfD\3\2\2\2\u00d0\u00d7\t\5\2\2\u00d1\u00d2\n"+
		"\6\2\2\u00d2\u00d7\6#\2\2\u00d3\u00d4\t\7\2\2\u00d4\u00d5\t\b\2\2\u00d5"+
		"\u00d7\6#\3\2\u00d6\u00d0\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d3\3\2"+
		"\2\2\u00d7F\3\2\2\2\u00d8\u00d9\7\61\2\2\u00d9\u00da\7,\2\2\u00da\u00de"+
		"\3\2\2\2\u00db\u00dd\13\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2"+
		"\u00de\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e1\u00e2\7,\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e5\b$\2\2\u00e5H\3\2\2\2\u00e6\u00e7\7\61\2\2\u00e7\u00e8\7\61\2\2"+
		"\u00e8\u00ec\3\2\2\2\u00e9\u00eb\n\t\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee"+
		"\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00f0\7\f\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b%"+
		"\2\2\u00f2J\3\2\2\2\u00f3\u00f5\t\n\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00f9\b&\2\2\u00f9L\3\2\2\2\16\2\u009f\u00ac\u00b7\u00b9\u00c0\u00c5"+
		"\u00cb\u00d6\u00de\u00ec\u00f6\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}