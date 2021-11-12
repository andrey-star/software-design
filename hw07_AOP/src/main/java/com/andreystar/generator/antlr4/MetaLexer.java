// Generated from com\andreystar\MetaLexer.g4 by ANTLR 4.5
package com.andreystar.generator.antlr4;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            GRAMMAR = 1, IMPORT = 2, MACROS = 3, LEXER = 4, PARSER = 5, START = 6, SEMICOLON = 7,
            IDENT = 8, WS = 9, RETURNS = 10, EPS = 11, LPAREN = 12, RPAREN = 13, LSQUARE = 14, RSQUARE = 15,
            LCURLY = 16, RCURLY = 17, COMMA = 18, COLON = 19, STICK = 20, ARG = 21, PARSER_WS = 22,
            OTHER = 23, PARSER_WS2 = 24, REGEX = 25, LEXER_WS = 26, START_WS = 27, IMPORTS = 28,
            IMPORT_WS = 29, MACROS_WS = 30;
    public static final int PARSER_MODE = 1;
    public static final int CODE_0 = 2;
    public static final int CODE_N = 3;
    public static final int PARSER_BLOCK = 4;
    public static final int LEXER_BLOCK = 5;
    public static final int START_BLOCK = 6;
    public static final int IMPORT_BLOCK = 7;
    public static final int MACROS_BLOCK = 8;
    public static final int CODE_1 = 9;
    public static final int CODE_N1 = 10;
    public static String[] modeNames = {
            "DEFAULT_MODE", "PARSER_MODE", "CODE_0", "CODE_N", "PARSER_BLOCK", "LEXER_BLOCK",
            "START_BLOCK", "IMPORT_BLOCK", "MACROS_BLOCK", "CODE_1", "CODE_N1"
    };

    public static final String[] ruleNames = {
            "GRAMMAR", "IMPORT", "MACROS", "LEXER", "PARSER", "START", "SEMICOLON",
            "IDENT", "WS", "RETURNS", "EPS", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE",
            "LCURLY", "RCURLY", "COMMA", "COLON", "PARSER_SEMICOLON", "STICK", "PARSER_IDENT",
            "ARG", "PARSER_WS", "CODE_0_LCURLY", "CODE_RCURLY", "CODE_0_OTHER", "CODE_N_LCURLY",
            "CODE_N_RCURLY", "OTHER", "PARSER_LCURLY", "PARSER_WS2", "LEXER_LCURLY",
            "LEXER_IDENT", "LEXER_COLON", "LEXER_SEMICOLON", "REGEX", "LEXER_RCURLY",
            "LEXER_WS", "START_IDENT", "START_COLON", "START_SEMICOLON", "START_WS",
            "IMPORTS", "IMPORT_WS", "MACROS2_LCURLY", "MACROS_RCURLY", "MACROS_WS",
            "CODE_1_LCURLY", "CODE_1_RCURLY", "CODE_1_OTHER", "CODE_N1_LCURLY", "CODE_N1_RCURLY",
            "OTHER1"
    };

    private static final String[] _LITERAL_NAMES = {
            null, "'grammar'", "'@import'", "'@macros'", "'@lexer'", "'@parser'",
            "'@start'", null, null, null, "'returns'", "'_EPS'", "'('", "')'", "'['",
            "']'", "'{'", null, "','", "':'", "'|'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "GRAMMAR", "IMPORT", "MACROS", "LEXER", "PARSER", "START", "SEMICOLON",
            "IDENT", "WS", "RETURNS", "EPS", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE",
            "LCURLY", "RCURLY", "COMMA", "COLON", "STICK", "ARG", "PARSER_WS", "OTHER",
            "PARSER_WS2", "REGEX", "LEXER_WS", "START_WS", "IMPORTS", "IMPORT_WS",
            "MACROS_WS"
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

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }


    public MetaLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "MetaLexer.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u0192\b\1\b\1\b" +
                    "\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6" +
                    "\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t" +
                    "\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t" +
                    "\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t" +
                    "\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t" +
                    "%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t" +
                    "\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t" +
                    "\67\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
                    "\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5" +
                    "\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3" +
                    "\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\7\t\u00b6\n\t\f\t\16\t\u00b9\13\t\3" +
                    "\n\6\n\u00bc\n\n\r\n\16\n\u00bd\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13" +
                    "\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3" +
                    "\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3" +
                    "\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\6\30\u00f1" +
                    "\n\30\r\30\16\30\u00f2\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3" +
                    "\33\3\33\3\33\3\33\3\33\3\34\6\34\u0104\n\34\r\34\16\34\u0105\3\34\3\34" +
                    "\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\6\37\u0115\n\37" +
                    "\r\37\16\37\u0116\3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#" +
                    "\3#\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\6&\u0134\n&\r&\16&\u0135\3&\3&\3\'\3" +
                    "\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3" +
                    ",\3,\3-\3-\7-\u0155\n-\f-\16-\u0158\13-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/" +
                    "\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62" +
                    "\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\6\64\u017c\n\64\r\64\16" +
                    "\64\u017d\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66" +
                    "\3\67\6\67\u018d\n\67\r\67\16\67\u018e\3\67\3\67\2\28\r\3\17\4\21\5\23" +
                    "\6\25\7\27\b\31\t\33\n\35\13\37\f!\r#\16%\17\'\20)\21+\22-\23/\24\61\25" +
                    "\63\2\65\26\67\29\27;\30=\2?\2A\2C\2E\2G\31I\2K\32M\2O\2Q\2S\2U\33W\2" +
                    "Y\34[\2]\2_\2a\35c\36e\37g\2i\2k m\2o\2q\2s\2u\2w\2\r\2\3\4\5\6\7\b\t" +
                    "\n\13\f\t\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2++..\4\2}}\177" +
                    "\177\3\2$$\3\2\177\177\u0190\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23" +
                    "\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2" +
                    "\2\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\3%\3\2\2\2\3\'\3\2\2\2\3)\3\2" +
                    "\2\2\3+\3\2\2\2\3-\3\2\2\2\3/\3\2\2\2\3\61\3\2\2\2\3\63\3\2\2\2\3\65\3" +
                    "\2\2\2\3\67\3\2\2\2\39\3\2\2\2\3;\3\2\2\2\4=\3\2\2\2\4?\3\2\2\2\4A\3\2" +
                    "\2\2\5C\3\2\2\2\5E\3\2\2\2\5G\3\2\2\2\6I\3\2\2\2\6K\3\2\2\2\7M\3\2\2\2" +
                    "\7O\3\2\2\2\7Q\3\2\2\2\7S\3\2\2\2\7U\3\2\2\2\7W\3\2\2\2\7Y\3\2\2\2\b[" +
                    "\3\2\2\2\b]\3\2\2\2\b_\3\2\2\2\ba\3\2\2\2\tc\3\2\2\2\te\3\2\2\2\ng\3\2" +
                    "\2\2\ni\3\2\2\2\nk\3\2\2\2\13m\3\2\2\2\13o\3\2\2\2\13q\3\2\2\2\fs\3\2" +
                    "\2\2\fu\3\2\2\2\fw\3\2\2\2\ry\3\2\2\2\17\u0081\3\2\2\2\21\u008b\3\2\2" +
                    "\2\23\u0095\3\2\2\2\25\u009e\3\2\2\2\27\u00a8\3\2\2\2\31\u00b1\3\2\2\2" +
                    "\33\u00b3\3\2\2\2\35\u00bb\3\2\2\2\37\u00c1\3\2\2\2!\u00c9\3\2\2\2#\u00ce" +
                    "\3\2\2\2%\u00d0\3\2\2\2\'\u00d2\3\2\2\2)\u00d4\3\2\2\2+\u00d6\3\2\2\2" +
                    "-\u00da\3\2\2\2/\u00df\3\2\2\2\61\u00e1\3\2\2\2\63\u00e3\3\2\2\2\65\u00e7" +
                    "\3\2\2\2\67\u00e9\3\2\2\29\u00ed\3\2\2\2;\u00f4\3\2\2\2=\u00f8\3\2\2\2" +
                    "?\u00fd\3\2\2\2A\u0103\3\2\2\2C\u0109\3\2\2\2E\u010e\3\2\2\2G\u0114\3" +
                    "\2\2\2I\u0118\3\2\2\2K\u011d\3\2\2\2M\u0121\3\2\2\2O\u0125\3\2\2\2Q\u0129" +
                    "\3\2\2\2S\u012d\3\2\2\2U\u0131\3\2\2\2W\u0139\3\2\2\2Y\u013e\3\2\2\2[" +
                    "\u0142\3\2\2\2]\u0146\3\2\2\2_\u014a\3\2\2\2a\u014e\3\2\2\2c\u0152\3\2" +
                    "\2\2e\u015d\3\2\2\2g\u0161\3\2\2\2i\u0166\3\2\2\2k\u016b\3\2\2\2m\u016f" +
                    "\3\2\2\2o\u0174\3\2\2\2q\u017b\3\2\2\2s\u0181\3\2\2\2u\u0186\3\2\2\2w" +
                    "\u018c\3\2\2\2yz\7i\2\2z{\7t\2\2{|\7c\2\2|}\7o\2\2}~\7o\2\2~\177\7c\2" +
                    "\2\177\u0080\7t\2\2\u0080\16\3\2\2\2\u0081\u0082\7B\2\2\u0082\u0083\7" +
                    "k\2\2\u0083\u0084\7o\2\2\u0084\u0085\7r\2\2\u0085\u0086\7q\2\2\u0086\u0087" +
                    "\7t\2\2\u0087\u0088\7v\2\2\u0088\u0089\3\2\2\2\u0089\u008a\b\3\2\2\u008a" +
                    "\20\3\2\2\2\u008b\u008c\7B\2\2\u008c\u008d\7o\2\2\u008d\u008e\7c\2\2\u008e" +
                    "\u008f\7e\2\2\u008f\u0090\7t\2\2\u0090\u0091\7q\2\2\u0091\u0092\7u\2\2" +
                    "\u0092\u0093\3\2\2\2\u0093\u0094\b\4\3\2\u0094\22\3\2\2\2\u0095\u0096" +
                    "\7B\2\2\u0096\u0097\7n\2\2\u0097\u0098\7g\2\2\u0098\u0099\7z\2\2\u0099" +
                    "\u009a\7g\2\2\u009a\u009b\7t\2\2\u009b\u009c\3\2\2\2\u009c\u009d\b\5\4" +
                    "\2\u009d\24\3\2\2\2\u009e\u009f\7B\2\2\u009f\u00a0\7r\2\2\u00a0\u00a1" +
                    "\7c\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7g\2\2\u00a4" +
                    "\u00a5\7t\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\b\6\5\2\u00a7\26\3\2\2\2" +
                    "\u00a8\u00a9\7B\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7v\2\2\u00ab\u00ac" +
                    "\7c\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\3\2\2\2\u00af" +
                    "\u00b0\b\7\6\2\u00b0\30\3\2\2\2\u00b1\u00b2\7=\2\2\u00b2\32\3\2\2\2\u00b3" +
                    "\u00b7\t\2\2\2\u00b4\u00b6\t\3\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2" +
                    "\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\34\3\2\2\2\u00b9\u00b7" +
                    "\3\2\2\2\u00ba\u00bc\t\4\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd" +
                    "\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\b\n" +
                    "\7\2\u00c0\36\3\2\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4" +
                    "\7v\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7p\2\2\u00c7" +
                    "\u00c8\7u\2\2\u00c8 \3\2\2\2\u00c9\u00ca\7a\2\2\u00ca\u00cb\7G\2\2\u00cb" +
                    "\u00cc\7R\2\2\u00cc\u00cd\7U\2\2\u00cd\"\3\2\2\2\u00ce\u00cf\7*\2\2\u00cf" +
                    "$\3\2\2\2\u00d0\u00d1\7+\2\2\u00d1&\3\2\2\2\u00d2\u00d3\7]\2\2\u00d3(" +
                    "\3\2\2\2\u00d4\u00d5\7_\2\2\u00d5*\3\2\2\2\u00d6\u00d7\7}\2\2\u00d7\u00d8" +
                    "\3\2\2\2\u00d8\u00d9\b\21\b\2\u00d9,\3\2\2\2\u00da\u00db\7\177\2\2\u00db" +
                    "\u00dc\3\2\2\2\u00dc\u00dd\b\22\t\2\u00dd\u00de\b\22\t\2\u00de.\3\2\2" +
                    "\2\u00df\u00e0\7.\2\2\u00e0\60\3\2\2\2\u00e1\u00e2\7<\2\2\u00e2\62\3\2" +
                    "\2\2\u00e3\u00e4\7=\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\b\25\n\2\u00e6" +
                    "\64\3\2\2\2\u00e7\u00e8\7~\2\2\u00e8\66\3\2\2\2\u00e9\u00ea\5\33\t\2\u00ea" +
                    "\u00eb\3\2\2\2\u00eb\u00ec\b\27\13\2\u00ec8\3\2\2\2\u00ed\u00ee\5\33\t" +
                    "\2\u00ee\u00f0\7\60\2\2\u00ef\u00f1\n\5\2\2\u00f0\u00ef\3\2\2\2\u00f1" +
                    "\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3:\3\2\2\2" +
                    "\u00f4\u00f5\5\35\n\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\b\31\7\2\u00f7<" +
                    "\3\2\2\2\u00f8\u00f9\7}\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\b\32\f\2\u00fb" +
                    "\u00fc\b\32\r\2\u00fc>\3\2\2\2\u00fd\u00fe\7\177\2\2\u00fe\u00ff\3\2\2" +
                    "\2\u00ff\u0100\b\33\16\2\u0100\u0101\b\33\t\2\u0101@\3\2\2\2\u0102\u0104" +
                    "\n\6\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105" +
                    "\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\b\34\f\2\u0108B\3\2\2\2" +
                    "\u0109\u010a\7}\2\2\u010a\u010b\3\2\2\2\u010b\u010c\b\35\f\2\u010c\u010d" +
                    "\b\35\r\2\u010dD\3\2\2\2\u010e\u010f\7\177\2\2\u010f\u0110\3\2\2\2\u0110" +
                    "\u0111\b\36\f\2\u0111\u0112\b\36\t\2\u0112F\3\2\2\2\u0113\u0115\n\6\2" +
                    "\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117" +
                    "\3\2\2\2\u0117H\3\2\2\2\u0118\u0119\7}\2\2\u0119\u011a\3\2\2\2\u011a\u011b" +
                    "\b \17\2\u011b\u011c\b \20\2\u011cJ\3\2\2\2\u011d\u011e\5\35\n\2\u011e" +
                    "\u011f\3\2\2\2\u011f\u0120\b!\7\2\u0120L\3\2\2\2\u0121\u0122\5+\21\2\u0122" +
                    "\u0123\3\2\2\2\u0123\u0124\b\"\17\2\u0124N\3\2\2\2\u0125\u0126\5\33\t" +
                    "\2\u0126\u0127\3\2\2\2\u0127\u0128\b#\13\2\u0128P\3\2\2\2\u0129\u012a" +
                    "\5\61\24\2\u012a\u012b\3\2\2\2\u012b\u012c\b$\21\2\u012cR\3\2\2\2\u012d" +
                    "\u012e\5\31\b\2\u012e\u012f\3\2\2\2\u012f\u0130\b%\n\2\u0130T\3\2\2\2" +
                    "\u0131\u0133\7$\2\2\u0132\u0134\n\7\2\2\u0133\u0132\3\2\2\2\u0134\u0135" +
                    "\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\3\2\2\2\u0137" +
                    "\u0138\7$\2\2\u0138V\3\2\2\2\u0139\u013a\5-\22\2\u013a\u013b\3\2\2\2\u013b" +
                    "\u013c\b\'\16\2\u013c\u013d\b\'\t\2\u013dX\3\2\2\2\u013e\u013f\5\35\n" +
                    "\2\u013f\u0140\3\2\2\2\u0140\u0141\b(\7\2\u0141Z\3\2\2\2\u0142\u0143\5" +
                    "\33\t\2\u0143\u0144\3\2\2\2\u0144\u0145\b)\13\2\u0145\\\3\2\2\2\u0146" +
                    "\u0147\5\61\24\2\u0147\u0148\3\2\2\2\u0148\u0149\b*\21\2\u0149^\3\2\2" +
                    "\2\u014a\u014b\5\31\b\2\u014b\u014c\3\2\2\2\u014c\u014d\b+\n\2\u014d`" +
                    "\3\2\2\2\u014e\u014f\5\35\n\2\u014f\u0150\3\2\2\2\u0150\u0151\b,\7\2\u0151" +
                    "b\3\2\2\2\u0152\u0156\7}\2\2\u0153\u0155\n\b\2\2\u0154\u0153\3\2\2\2\u0155" +
                    "\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2" +
                    "\2\2\u0158\u0156\3\2\2\2\u0159\u015a\7\177\2\2\u015a\u015b\3\2\2\2\u015b" +
                    "\u015c\b-\t\2\u015cd\3\2\2\2\u015d\u015e\5\35\n\2\u015e\u015f\3\2\2\2" +
                    "\u015f\u0160\b.\7\2\u0160f\3\2\2\2\u0161\u0162\7}\2\2\u0162\u0163\3\2" +
                    "\2\2\u0163\u0164\b/\17\2\u0164\u0165\b/\22\2\u0165h\3\2\2\2\u0166\u0167" +
                    "\7\177\2\2\u0167\u0168\3\2\2\2\u0168\u0169\b\60\16\2\u0169\u016a\b\60" +
                    "\t\2\u016aj\3\2\2\2\u016b\u016c\5\35\n\2\u016c\u016d\3\2\2\2\u016d\u016e" +
                    "\b\61\7\2\u016el\3\2\2\2\u016f\u0170\7}\2\2\u0170\u0171\3\2\2\2\u0171" +
                    "\u0172\b\62\f\2\u0172\u0173\b\62\23\2\u0173n\3\2\2\2\u0174\u0175\7\177" +
                    "\2\2\u0175\u0176\3\2\2\2\u0176\u0177\b\63\16\2\u0177\u0178\b\63\t\2\u0178" +
                    "\u0179\b\63\t\2\u0179p\3\2\2\2\u017a\u017c\n\6\2\2\u017b\u017a\3\2\2\2" +
                    "\u017c\u017d\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f" +
                    "\3\2\2\2\u017f\u0180\b\64\f\2\u0180r\3\2\2\2\u0181\u0182\7}\2\2\u0182" +
                    "\u0183\3\2\2\2\u0183\u0184\b\65\f\2\u0184\u0185\b\65\23\2\u0185t\3\2\2" +
                    "\2\u0186\u0187\7\177\2\2\u0187\u0188\3\2\2\2\u0188\u0189\b\66\f\2\u0189" +
                    "\u018a\b\66\t\2\u018av\3\2\2\2\u018b\u018d\n\6\2\2\u018c\u018b\3\2\2\2" +
                    "\u018d\u018e\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0190" +
                    "\3\2\2\2\u0190\u0191\b\67\f\2\u0191x\3\2\2\2\26\2\3\4\5\6\7\b\t\n\13\f" +
                    "\u00b7\u00bd\u00f2\u0105\u0116\u0135\u0156\u017d\u018e\24\7\t\2\7\n\2" +
                    "\7\7\2\7\6\2\7\b\2\b\2\2\7\4\2\6\2\2\t\t\2\t\n\2\t\31\2\7\5\2\t\23\2\t" +
                    "\22\2\7\3\2\t\25\2\7\13\2\7\f\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}
