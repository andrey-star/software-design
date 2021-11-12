// Generated from com\andreystar\MetaParser.g4 by ANTLR 4.5
package com.andreystar.generator.antlr4;

import com.andreystar.generator.grammar.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaParser extends Parser {
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
    public static final int
            RULE_grammarDef = 0, RULE_grammarName = 1, RULE_imports = 2, RULE_macros = 3,
            RULE_lexerRules = 4, RULE_myLexerRule = 5, RULE_parserRules = 6, RULE_myParserRule = 7,
            RULE_typedNames = 8, RULE_typedName = 9, RULE_ruleRhss = 10, RULE_ruleRhs = 11,
            RULE_rhsAtom = 12, RULE_rhsEps = 13, RULE_rhsTerminal = 14, RULE_rhsNonTerminal = 15,
            RULE_args = 16, RULE_startRule = 17, RULE_code = 18;
    public static final String[] ruleNames = {
            "grammarDef", "grammarName", "imports", "macros", "lexerRules", "myLexerRule",
            "parserRules", "myParserRule", "typedNames", "typedName", "ruleRhss",
            "ruleRhs", "rhsAtom", "rhsEps", "rhsTerminal", "rhsNonTerminal", "args",
            "startRule", "code"
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

    @Override
    public String getGrammarFileName() {
        return "MetaParser.g4";
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
    public ATN getATN() {
        return _ATN;
    }

    public MetaParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class GrammarDefContext extends ParserRuleContext {
        public Grammar grammar;
        public String importsVal;
        public String macrosVal;
        public GrammarNameContext grammarName;
        public ImportsContext imports;
        public MacrosContext macros;
        public LexerRulesContext lexerRules;
        public ParserRulesContext parserRules;
        public StartRuleContext startRule;

        public GrammarNameContext grammarName() {
            return getRuleContext(GrammarNameContext.class, 0);
        }

        public LexerRulesContext lexerRules() {
            return getRuleContext(LexerRulesContext.class, 0);
        }

        public ParserRulesContext parserRules() {
            return getRuleContext(ParserRulesContext.class, 0);
        }

        public StartRuleContext startRule() {
            return getRuleContext(StartRuleContext.class, 0);
        }

        public ImportsContext imports() {
            return getRuleContext(ImportsContext.class, 0);
        }

        public MacrosContext macros() {
            return getRuleContext(MacrosContext.class, 0);
        }

        public GrammarDefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_grammarDef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterGrammarDef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitGrammarDef(this);
        }
    }

    public final GrammarDefContext grammarDef() throws RecognitionException {
        GrammarDefContext _localctx = new GrammarDefContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_grammarDef);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(38);
                ((GrammarDefContext) _localctx).grammarName = grammarName();
                setState(42);
                _la = _input.LA(1);
                if (_la == IMPORT) {
                    {
                        setState(39);
                        ((GrammarDefContext) _localctx).imports = imports();
                        ((GrammarDefContext) _localctx).importsVal = ((GrammarDefContext) _localctx).imports.value;
                    }
                }

                setState(47);
                _la = _input.LA(1);
                if (_la == MACROS) {
                    {
                        setState(44);
                        ((GrammarDefContext) _localctx).macros = macros();
                        ((GrammarDefContext) _localctx).macrosVal = ((GrammarDefContext) _localctx).macros.value;
                    }
                }

                setState(49);
                ((GrammarDefContext) _localctx).lexerRules = lexerRules();
                setState(50);
                ((GrammarDefContext) _localctx).parserRules = parserRules();
                setState(51);
                ((GrammarDefContext) _localctx).startRule = startRule();
                ((GrammarDefContext) _localctx).grammar = new Grammar(((GrammarDefContext) _localctx).grammarName.value, _localctx.importsVal, _localctx.macrosVal, ((GrammarDefContext) _localctx).lexerRules.value, ((GrammarDefContext) _localctx).parserRules.value, ((GrammarDefContext) _localctx).startRule.start, ((GrammarDefContext) _localctx).startRule.retAttr);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class GrammarNameContext extends ParserRuleContext {
        public String value;
        public Token IDENT;

        public TerminalNode GRAMMAR() {
            return getToken(MetaParser.GRAMMAR, 0);
        }

        public TerminalNode IDENT() {
            return getToken(MetaParser.IDENT, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(MetaParser.SEMICOLON, 0);
        }

        public GrammarNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_grammarName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterGrammarName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitGrammarName(this);
        }
    }

    public final GrammarNameContext grammarName() throws RecognitionException {
        GrammarNameContext _localctx = new GrammarNameContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_grammarName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(54);
                match(GRAMMAR);
                setState(55);
                ((GrammarNameContext) _localctx).IDENT = match(IDENT);
                setState(56);
                match(SEMICOLON);
                ((GrammarNameContext) _localctx).value = (((GrammarNameContext) _localctx).IDENT != null ? ((GrammarNameContext) _localctx).IDENT.getText() : null);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ImportsContext extends ParserRuleContext {
        public String value;
        public Token IMPORTS;

        public TerminalNode IMPORT() {
            return getToken(MetaParser.IMPORT, 0);
        }

        public TerminalNode IMPORTS() {
            return getToken(MetaParser.IMPORTS, 0);
        }

        public ImportsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_imports;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterImports(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitImports(this);
        }
    }

    public final ImportsContext imports() throws RecognitionException {
        ImportsContext _localctx = new ImportsContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_imports);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(59);
                match(IMPORT);
                setState(60);
                ((ImportsContext) _localctx).IMPORTS = match(IMPORTS);
                ((ImportsContext) _localctx).value = (((ImportsContext) _localctx).IMPORTS != null ? ((ImportsContext) _localctx).IMPORTS.getText() : null);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class MacrosContext extends ParserRuleContext {
        public String value;
        public CodeContext code;

        public TerminalNode MACROS() {
            return getToken(MetaParser.MACROS, 0);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }

        public MacrosContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_macros;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterMacros(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitMacros(this);
        }
    }

    public final MacrosContext macros() throws RecognitionException {
        MacrosContext _localctx = new MacrosContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_macros);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(63);
                match(MACROS);
                setState(64);
                ((MacrosContext) _localctx).code = code();
                ((MacrosContext) _localctx).value = ((MacrosContext) _localctx).code.value;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LexerRulesContext extends ParserRuleContext {
        public List<LexerRule> value;
        public MyLexerRuleContext myLexerRule;

        public TerminalNode LEXER() {
            return getToken(MetaParser.LEXER, 0);
        }

        public TerminalNode LCURLY() {
            return getToken(MetaParser.LCURLY, 0);
        }

        public TerminalNode RCURLY() {
            return getToken(MetaParser.RCURLY, 0);
        }

        public List<MyLexerRuleContext> myLexerRule() {
            return getRuleContexts(MyLexerRuleContext.class);
        }

        public MyLexerRuleContext myLexerRule(int i) {
            return getRuleContext(MyLexerRuleContext.class, i);
        }

        public LexerRulesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lexerRules;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterLexerRules(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitLexerRules(this);
        }
    }

    public final LexerRulesContext lexerRules() throws RecognitionException {
        LexerRulesContext _localctx = new LexerRulesContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_lexerRules);
        ((LexerRulesContext) _localctx).value = new ArrayList<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(67);
                match(LEXER);
                setState(68);
                match(LCURLY);
                setState(72);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(69);
                            ((LexerRulesContext) _localctx).myLexerRule = myLexerRule();
                            _localctx.value.add(((LexerRulesContext) _localctx).myLexerRule.value);
                        }
                    }
                    setState(74);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == IDENT);
                setState(76);
                match(RCURLY);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class MyLexerRuleContext extends ParserRuleContext {
        public LexerRule value;
        public Token name;
        public Token regex;

        public TerminalNode COLON() {
            return getToken(MetaParser.COLON, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(MetaParser.SEMICOLON, 0);
        }

        public TerminalNode IDENT() {
            return getToken(MetaParser.IDENT, 0);
        }

        public TerminalNode REGEX() {
            return getToken(MetaParser.REGEX, 0);
        }

        public MyLexerRuleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_myLexerRule;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterMyLexerRule(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitMyLexerRule(this);
        }
    }

    public final MyLexerRuleContext myLexerRule() throws RecognitionException {
        MyLexerRuleContext _localctx = new MyLexerRuleContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_myLexerRule);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(78);
                ((MyLexerRuleContext) _localctx).name = match(IDENT);
                setState(79);
                match(COLON);
                setState(80);
                ((MyLexerRuleContext) _localctx).regex = match(REGEX);
                setState(81);
                match(SEMICOLON);
                ((MyLexerRuleContext) _localctx).value = new LexerRule((((MyLexerRuleContext) _localctx).name != null ? ((MyLexerRuleContext) _localctx).name.getText() : null), (((MyLexerRuleContext) _localctx).regex != null ? ((MyLexerRuleContext) _localctx).regex.getText() : null));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParserRulesContext extends ParserRuleContext {
        public List<ParserRule> value;
        public MyParserRuleContext myParserRule;

        public TerminalNode PARSER() {
            return getToken(MetaParser.PARSER, 0);
        }

        public TerminalNode LCURLY() {
            return getToken(MetaParser.LCURLY, 0);
        }

        public TerminalNode RCURLY() {
            return getToken(MetaParser.RCURLY, 0);
        }

        public List<MyParserRuleContext> myParserRule() {
            return getRuleContexts(MyParserRuleContext.class);
        }

        public MyParserRuleContext myParserRule(int i) {
            return getRuleContext(MyParserRuleContext.class, i);
        }

        public ParserRulesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parserRules;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterParserRules(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitParserRules(this);
        }
    }

    public final ParserRulesContext parserRules() throws RecognitionException {
        ParserRulesContext _localctx = new ParserRulesContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_parserRules);
        ((ParserRulesContext) _localctx).value = new ArrayList<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(84);
                match(PARSER);
                setState(85);
                match(LCURLY);
                setState(89);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(86);
                            ((ParserRulesContext) _localctx).myParserRule = myParserRule();
                            _localctx.value.add(((ParserRulesContext) _localctx).myParserRule.value);
                        }
                    }
                    setState(91);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == IDENT);
                setState(93);
                match(RCURLY);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class MyParserRuleContext extends ParserRuleContext {
        public ParserRule value;
        public Token name;
        public TypedNamesContext params;
        public TypedNamesContext returnsVal;
        public RuleRhssContext rhss;

        public TerminalNode LPAREN() {
            return getToken(MetaParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(MetaParser.RPAREN, 0);
        }

        public TerminalNode RETURNS() {
            return getToken(MetaParser.RETURNS, 0);
        }

        public TerminalNode LSQUARE() {
            return getToken(MetaParser.LSQUARE, 0);
        }

        public TerminalNode RSQUARE() {
            return getToken(MetaParser.RSQUARE, 0);
        }

        public TerminalNode COLON() {
            return getToken(MetaParser.COLON, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(MetaParser.SEMICOLON, 0);
        }

        public TerminalNode IDENT() {
            return getToken(MetaParser.IDENT, 0);
        }

        public List<TypedNamesContext> typedNames() {
            return getRuleContexts(TypedNamesContext.class);
        }

        public TypedNamesContext typedNames(int i) {
            return getRuleContext(TypedNamesContext.class, i);
        }

        public RuleRhssContext ruleRhss() {
            return getRuleContext(RuleRhssContext.class, 0);
        }

        public MyParserRuleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_myParserRule;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterMyParserRule(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitMyParserRule(this);
        }
    }

    public final MyParserRuleContext myParserRule() throws RecognitionException {
        MyParserRuleContext _localctx = new MyParserRuleContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_myParserRule);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(95);
                ((MyParserRuleContext) _localctx).name = match(IDENT);
                setState(96);
                match(LPAREN);
                setState(97);
                ((MyParserRuleContext) _localctx).params = typedNames();
                setState(98);
                match(RPAREN);
                setState(99);
                match(RETURNS);
                setState(100);
                match(LSQUARE);
                setState(101);
                ((MyParserRuleContext) _localctx).returnsVal = typedNames();
                setState(102);
                match(RSQUARE);
                setState(103);
                match(COLON);
                setState(104);
                ((MyParserRuleContext) _localctx).rhss = ruleRhss();
                setState(105);
                match(SEMICOLON);
                ((MyParserRuleContext) _localctx).value = new ParserRule((((MyParserRuleContext) _localctx).name != null ? ((MyParserRuleContext) _localctx).name.getText() : null), ((MyParserRuleContext) _localctx).params.value, ((MyParserRuleContext) _localctx).returnsVal.value, ((MyParserRuleContext) _localctx).rhss.value);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TypedNamesContext extends ParserRuleContext {
        public List<TypedName> value;
        public TypedNameContext typedName;

        public List<TypedNameContext> typedName() {
            return getRuleContexts(TypedNameContext.class);
        }

        public TypedNameContext typedName(int i) {
            return getRuleContext(TypedNameContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(MetaParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(MetaParser.COMMA, i);
        }

        public TypedNamesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typedNames;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterTypedNames(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitTypedNames(this);
        }
    }

    public final TypedNamesContext typedNames() throws RecognitionException {
        TypedNamesContext _localctx = new TypedNamesContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_typedNames);
        ((TypedNamesContext) _localctx).value = new ArrayList<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(119);
                _la = _input.LA(1);
                if (_la == IDENT) {
                    {
                        setState(108);
                        ((TypedNamesContext) _localctx).typedName = typedName();
                        _localctx.value.add(((TypedNamesContext) _localctx).typedName.value);
                        setState(116);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(110);
                                    match(COMMA);
                                    setState(111);
                                    ((TypedNamesContext) _localctx).typedName = typedName();
                                    _localctx.value.add(((TypedNamesContext) _localctx).typedName.value);
                                }
                            }
                            setState(118);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TypedNameContext extends ParserRuleContext {
        public TypedName value;
        public Token type;
        public Token nameVal;

        public List<TerminalNode> IDENT() {
            return getTokens(MetaParser.IDENT);
        }

        public TerminalNode IDENT(int i) {
            return getToken(MetaParser.IDENT, i);
        }

        public TypedNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typedName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterTypedName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitTypedName(this);
        }
    }

    public final TypedNameContext typedName() throws RecognitionException {
        TypedNameContext _localctx = new TypedNameContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_typedName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(121);
                ((TypedNameContext) _localctx).type = match(IDENT);
                setState(122);
                ((TypedNameContext) _localctx).nameVal = match(IDENT);
                ((TypedNameContext) _localctx).value = new TypedName((((TypedNameContext) _localctx).type != null ? ((TypedNameContext) _localctx).type.getText() : null), (((TypedNameContext) _localctx).nameVal != null ? ((TypedNameContext) _localctx).nameVal.getText() : null));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RuleRhssContext extends ParserRuleContext {
        public List<RuleRhs> value;
        public RuleRhsContext ruleRhs;

        public List<RuleRhsContext> ruleRhs() {
            return getRuleContexts(RuleRhsContext.class);
        }

        public RuleRhsContext ruleRhs(int i) {
            return getRuleContext(RuleRhsContext.class, i);
        }

        public List<TerminalNode> STICK() {
            return getTokens(MetaParser.STICK);
        }

        public TerminalNode STICK(int i) {
            return getToken(MetaParser.STICK, i);
        }

        public RuleRhssContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ruleRhss;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterRuleRhss(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitRuleRhss(this);
        }
    }

    public final RuleRhssContext ruleRhss() throws RecognitionException {
        RuleRhssContext _localctx = new RuleRhssContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_ruleRhss);
        ((RuleRhssContext) _localctx).value = new ArrayList<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(125);
                ((RuleRhssContext) _localctx).ruleRhs = ruleRhs();
                _localctx.value.add(((RuleRhssContext) _localctx).ruleRhs.value);
                setState(133);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == STICK) {
                    {
                        {
                            setState(127);
                            match(STICK);
                            setState(128);
                            ((RuleRhssContext) _localctx).ruleRhs = ruleRhs();
                            _localctx.value.add(((RuleRhssContext) _localctx).ruleRhs.value);
                        }
                    }
                    setState(135);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RuleRhsContext extends ParserRuleContext {
        public RuleRhs value;
        public List<RhsAtom> atoms;
        public RhsAtomContext rhsAtom;

        public List<RhsAtomContext> rhsAtom() {
            return getRuleContexts(RhsAtomContext.class);
        }

        public RhsAtomContext rhsAtom(int i) {
            return getRuleContext(RhsAtomContext.class, i);
        }

        public RuleRhsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ruleRhs;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterRuleRhs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitRuleRhs(this);
        }
    }

    public final RuleRhsContext ruleRhs() throws RecognitionException {
        RuleRhsContext _localctx = new RuleRhsContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_ruleRhs);
        ((RuleRhsContext) _localctx).atoms = new ArrayList<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(139);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(136);
                            ((RuleRhsContext) _localctx).rhsAtom = rhsAtom();
                            _localctx.atoms.add(((RuleRhsContext) _localctx).rhsAtom.value);
                        }
                    }
                    setState(141);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == IDENT || _la == EPS);
            }
            ((RuleRhsContext) _localctx).value = new RuleRhs(_localctx.atoms);
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RhsAtomContext extends ParserRuleContext {
        public RhsAtom value;
        public RhsNonTerminalContext rhsNonTerminal;
        public RhsTerminalContext rhsTerminal;
        public RhsEpsContext rhsEps;

        public RhsNonTerminalContext rhsNonTerminal() {
            return getRuleContext(RhsNonTerminalContext.class, 0);
        }

        public RhsTerminalContext rhsTerminal() {
            return getRuleContext(RhsTerminalContext.class, 0);
        }

        public RhsEpsContext rhsEps() {
            return getRuleContext(RhsEpsContext.class, 0);
        }

        public RhsAtomContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rhsAtom;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterRhsAtom(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitRhsAtom(this);
        }
    }

    public final RhsAtomContext rhsAtom() throws RecognitionException {
        RhsAtomContext _localctx = new RhsAtomContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_rhsAtom);
        try {
            setState(152);
            switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(143);
                    ((RhsAtomContext) _localctx).rhsNonTerminal = rhsNonTerminal();
                    ((RhsAtomContext) _localctx).value = ((RhsAtomContext) _localctx).rhsNonTerminal.value;
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(146);
                    ((RhsAtomContext) _localctx).rhsTerminal = rhsTerminal();
                    ((RhsAtomContext) _localctx).value = ((RhsAtomContext) _localctx).rhsTerminal.value;
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(149);
                    ((RhsAtomContext) _localctx).rhsEps = rhsEps();
                    ((RhsAtomContext) _localctx).value = ((RhsAtomContext) _localctx).rhsEps.value;
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RhsEpsContext extends ParserRuleContext {
        public RhsEpsilon value;
        public CodeContext code;

        public TerminalNode EPS() {
            return getToken(MetaParser.EPS, 0);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }

        public RhsEpsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rhsEps;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterRhsEps(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitRhsEps(this);
        }
    }

    public final RhsEpsContext rhsEps() throws RecognitionException {
        RhsEpsContext _localctx = new RhsEpsContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_rhsEps);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(154);
                match(EPS);
                setState(156);
                _la = _input.LA(1);
                if (_la == LCURLY) {
                    {
                        setState(155);
                        ((RhsEpsContext) _localctx).code = code();
                    }
                }

                ((RhsEpsContext) _localctx).value = new RhsEpsilon((((RhsEpsContext) _localctx).code != null ? _input.getText(((RhsEpsContext) _localctx).code.start, ((RhsEpsContext) _localctx).code.stop) : null));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RhsTerminalContext extends ParserRuleContext {
        public RhsTerminal value;
        public Token name;
        public CodeContext code;

        public TerminalNode IDENT() {
            return getToken(MetaParser.IDENT, 0);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }

        public RhsTerminalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rhsTerminal;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterRhsTerminal(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitRhsTerminal(this);
        }
    }

    public final RhsTerminalContext rhsTerminal() throws RecognitionException {
        RhsTerminalContext _localctx = new RhsTerminalContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_rhsTerminal);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(160);
                ((RhsTerminalContext) _localctx).name = match(IDENT);
                setState(162);
                _la = _input.LA(1);
                if (_la == LCURLY) {
                    {
                        setState(161);
                        ((RhsTerminalContext) _localctx).code = code();
                    }
                }

                ((RhsTerminalContext) _localctx).value = new RhsTerminal((((RhsTerminalContext) _localctx).name != null ? ((RhsTerminalContext) _localctx).name.getText() : null), (((RhsTerminalContext) _localctx).code != null ? _input.getText(((RhsTerminalContext) _localctx).code.start, ((RhsTerminalContext) _localctx).code.stop) : null));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RhsNonTerminalContext extends ParserRuleContext {
        public RhsNonTerminal value;
        public Token name;
        public ArgsContext argsVal;
        public CodeContext code;

        public TerminalNode LPAREN() {
            return getToken(MetaParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(MetaParser.RPAREN, 0);
        }

        public TerminalNode IDENT() {
            return getToken(MetaParser.IDENT, 0);
        }

        public ArgsContext args() {
            return getRuleContext(ArgsContext.class, 0);
        }

        public CodeContext code() {
            return getRuleContext(CodeContext.class, 0);
        }

        public RhsNonTerminalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rhsNonTerminal;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterRhsNonTerminal(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitRhsNonTerminal(this);
        }
    }

    public final RhsNonTerminalContext rhsNonTerminal() throws RecognitionException {
        RhsNonTerminalContext _localctx = new RhsNonTerminalContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_rhsNonTerminal);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(166);
                ((RhsNonTerminalContext) _localctx).name = match(IDENT);
                setState(167);
                match(LPAREN);
                setState(168);
                ((RhsNonTerminalContext) _localctx).argsVal = args();
                setState(169);
                match(RPAREN);
                setState(171);
                _la = _input.LA(1);
                if (_la == LCURLY) {
                    {
                        setState(170);
                        ((RhsNonTerminalContext) _localctx).code = code();
                    }
                }

                ((RhsNonTerminalContext) _localctx).value = new RhsNonTerminal((((RhsNonTerminalContext) _localctx).name != null ? ((RhsNonTerminalContext) _localctx).name.getText() : null), ((RhsNonTerminalContext) _localctx).argsVal.value, (((RhsNonTerminalContext) _localctx).code != null ? _input.getText(((RhsNonTerminalContext) _localctx).code.start, ((RhsNonTerminalContext) _localctx).code.stop) : null));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArgsContext extends ParserRuleContext {
        public List<String> value;
        public Token ARG;

        public List<TerminalNode> ARG() {
            return getTokens(MetaParser.ARG);
        }

        public TerminalNode ARG(int i) {
            return getToken(MetaParser.ARG, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(MetaParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(MetaParser.COMMA, i);
        }

        public ArgsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_args;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterArgs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitArgs(this);
        }
    }

    public final ArgsContext args() throws RecognitionException {
        ArgsContext _localctx = new ArgsContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_args);
        ((ArgsContext) _localctx).value = new ArrayList<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(185);
                _la = _input.LA(1);
                if (_la == ARG) {
                    {
                        setState(175);
                        ((ArgsContext) _localctx).ARG = match(ARG);
                        _localctx.value.add((((ArgsContext) _localctx).ARG != null ? ((ArgsContext) _localctx).ARG.getText() : null));
                        setState(182);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(177);
                                    match(COMMA);
                                    setState(178);
                                    ((ArgsContext) _localctx).ARG = match(ARG);
                                    _localctx.value.add((((ArgsContext) _localctx).ARG != null ? ((ArgsContext) _localctx).ARG.getText() : null));
                                }
                            }
                            setState(184);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StartRuleContext extends ParserRuleContext {
        public String start;
        public String retAttr;
        public Token startVal;
        public Token retAttrVal;

        public TerminalNode START() {
            return getToken(MetaParser.START, 0);
        }

        public TerminalNode COLON() {
            return getToken(MetaParser.COLON, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(MetaParser.SEMICOLON, 0);
        }

        public List<TerminalNode> IDENT() {
            return getTokens(MetaParser.IDENT);
        }

        public TerminalNode IDENT(int i) {
            return getToken(MetaParser.IDENT, i);
        }

        public StartRuleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_startRule;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterStartRule(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitStartRule(this);
        }
    }

    public final StartRuleContext startRule() throws RecognitionException {
        StartRuleContext _localctx = new StartRuleContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_startRule);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(187);
                match(START);
                setState(188);
                match(COLON);
                setState(189);
                ((StartRuleContext) _localctx).startVal = match(IDENT);
                setState(190);
                ((StartRuleContext) _localctx).retAttrVal = match(IDENT);
                setState(191);
                match(SEMICOLON);
                ((StartRuleContext) _localctx).start = (((StartRuleContext) _localctx).startVal != null ? ((StartRuleContext) _localctx).startVal.getText() : null);
                ((StartRuleContext) _localctx).retAttr = (((StartRuleContext) _localctx).retAttrVal != null ? ((StartRuleContext) _localctx).retAttrVal.getText() : null);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CodeContext extends ParserRuleContext {
        public String value;
        public Token OTHER;

        public TerminalNode LCURLY() {
            return getToken(MetaParser.LCURLY, 0);
        }

        public TerminalNode RCURLY() {
            return getToken(MetaParser.RCURLY, 0);
        }

        public List<TerminalNode> OTHER() {
            return getTokens(MetaParser.OTHER);
        }

        public TerminalNode OTHER(int i) {
            return getToken(MetaParser.OTHER, i);
        }

        public CodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_code;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterCode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitCode(this);
        }
    }

    public final CodeContext code() throws RecognitionException {
        CodeContext _localctx = new CodeContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_code);
        ((CodeContext) _localctx).value = "";
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(194);
                match(LCURLY);
                setState(199);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OTHER) {
                    {
                        {
                            setState(195);
                            ((CodeContext) _localctx).OTHER = match(OTHER);
                            _localctx.value += (((CodeContext) _localctx).OTHER != null ? ((CodeContext) _localctx).OTHER.getText() : null);
                        }
                    }
                    setState(201);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(202);
                match(RCURLY);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 \u00cf\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\5\2-\n\2\3\2\3\2\3\2\5\2\62\n\2\3" +
                    "\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5" +
                    "\3\6\3\6\3\6\3\6\3\6\6\6K\n\6\r\6\16\6L\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3" +
                    "\7\3\b\3\b\3\b\3\b\3\b\6\b\\\n\b\r\b\16\b]\3\b\3\b\3\t\3\t\3\t\3\t\3\t" +
                    "\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nu\n\n\f\n" +
                    "\16\nx\13\n\5\nz\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0086" +
                    "\n\f\f\f\16\f\u0089\13\f\3\r\3\r\3\r\6\r\u008e\n\r\r\r\16\r\u008f\3\16" +
                    "\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009b\n\16\3\17\3\17\5\17" +
                    "\u009f\n\17\3\17\3\17\3\20\3\20\5\20\u00a5\n\20\3\20\3\20\3\21\3\21\3" +
                    "\21\3\21\3\21\5\21\u00ae\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\7\22" +
                    "\u00b7\n\22\f\22\16\22\u00ba\13\22\5\22\u00bc\n\22\3\23\3\23\3\23\3\23" +
                    "\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u00c8\n\24\f\24\16\24\u00cb\13\24" +
                    "\3\24\3\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\2" +
                    "\u00cb\2(\3\2\2\2\48\3\2\2\2\6=\3\2\2\2\bA\3\2\2\2\nE\3\2\2\2\fP\3\2\2" +
                    "\2\16V\3\2\2\2\20a\3\2\2\2\22y\3\2\2\2\24{\3\2\2\2\26\177\3\2\2\2\30\u008d" +
                    "\3\2\2\2\32\u009a\3\2\2\2\34\u009c\3\2\2\2\36\u00a2\3\2\2\2 \u00a8\3\2" +
                    "\2\2\"\u00bb\3\2\2\2$\u00bd\3\2\2\2&\u00c4\3\2\2\2(,\5\4\3\2)*\5\6\4\2" +
                    "*+\b\2\1\2+-\3\2\2\2,)\3\2\2\2,-\3\2\2\2-\61\3\2\2\2./\5\b\5\2/\60\b\2" +
                    "\1\2\60\62\3\2\2\2\61.\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\5\n\6" +
                    "\2\64\65\5\16\b\2\65\66\5$\23\2\66\67\b\2\1\2\67\3\3\2\2\289\7\3\2\29" +
                    ":\7\n\2\2:;\7\t\2\2;<\b\3\1\2<\5\3\2\2\2=>\7\4\2\2>?\7\36\2\2?@\b\4\1" +
                    "\2@\7\3\2\2\2AB\7\5\2\2BC\5&\24\2CD\b\5\1\2D\t\3\2\2\2EF\7\6\2\2FJ\7\22" +
                    "\2\2GH\5\f\7\2HI\b\6\1\2IK\3\2\2\2JG\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2" +
                    "\2\2MN\3\2\2\2NO\7\23\2\2O\13\3\2\2\2PQ\7\n\2\2QR\7\25\2\2RS\7\33\2\2" +
                    "ST\7\t\2\2TU\b\7\1\2U\r\3\2\2\2VW\7\7\2\2W[\7\22\2\2XY\5\20\t\2YZ\b\b" +
                    "\1\2Z\\\3\2\2\2[X\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7" +
                    "\23\2\2`\17\3\2\2\2ab\7\n\2\2bc\7\16\2\2cd\5\22\n\2de\7\17\2\2ef\7\f\2" +
                    "\2fg\7\20\2\2gh\5\22\n\2hi\7\21\2\2ij\7\25\2\2jk\5\26\f\2kl\7\t\2\2lm" +
                    "\b\t\1\2m\21\3\2\2\2no\5\24\13\2ov\b\n\1\2pq\7\24\2\2qr\5\24\13\2rs\b" +
                    "\n\1\2su\3\2\2\2tp\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3" +
                    "\2\2\2yn\3\2\2\2yz\3\2\2\2z\23\3\2\2\2{|\7\n\2\2|}\7\n\2\2}~\b\13\1\2" +
                    "~\25\3\2\2\2\177\u0080\5\30\r\2\u0080\u0087\b\f\1\2\u0081\u0082\7\26\2" +
                    "\2\u0082\u0083\5\30\r\2\u0083\u0084\b\f\1\2\u0084\u0086\3\2\2\2\u0085" +
                    "\u0081\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2" +
                    "\2\2\u0088\27\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\5\32\16\2\u008b" +
                    "\u008c\b\r\1\2\u008c\u008e\3\2\2\2\u008d\u008a\3\2\2\2\u008e\u008f\3\2" +
                    "\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\31\3\2\2\2\u0091\u0092" +
                    "\5 \21\2\u0092\u0093\b\16\1\2\u0093\u009b\3\2\2\2\u0094\u0095\5\36\20" +
                    "\2\u0095\u0096\b\16\1\2\u0096\u009b\3\2\2\2\u0097\u0098\5\34\17\2\u0098" +
                    "\u0099\b\16\1\2\u0099\u009b\3\2\2\2\u009a\u0091\3\2\2\2\u009a\u0094\3" +
                    "\2\2\2\u009a\u0097\3\2\2\2\u009b\33\3\2\2\2\u009c\u009e\7\r\2\2\u009d" +
                    "\u009f\5&\24\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2" +
                    "\2\2\u00a0\u00a1\b\17\1\2\u00a1\35\3\2\2\2\u00a2\u00a4\7\n\2\2\u00a3\u00a5" +
                    "\5&\24\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6" +
                    "\u00a7\b\20\1\2\u00a7\37\3\2\2\2\u00a8\u00a9\7\n\2\2\u00a9\u00aa\7\16" +
                    "\2\2\u00aa\u00ab\5\"\22\2\u00ab\u00ad\7\17\2\2\u00ac\u00ae\5&\24\2\u00ad" +
                    "\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\21" +
                    "\1\2\u00b0!\3\2\2\2\u00b1\u00b2\7\27\2\2\u00b2\u00b8\b\22\1\2\u00b3\u00b4" +
                    "\7\24\2\2\u00b4\u00b5\7\27\2\2\u00b5\u00b7\b\22\1\2\u00b6\u00b3\3\2\2" +
                    "\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bc" +
                    "\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00b1\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc" +
                    "#\3\2\2\2\u00bd\u00be\7\b\2\2\u00be\u00bf\7\25\2\2\u00bf\u00c0\7\n\2\2" +
                    "\u00c0\u00c1\7\n\2\2\u00c1\u00c2\7\t\2\2\u00c2\u00c3\b\23\1\2\u00c3%\3" +
                    "\2\2\2\u00c4\u00c9\7\22\2\2\u00c5\u00c6\7\31\2\2\u00c6\u00c8\b\24\1\2" +
                    "\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca" +
                    "\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\23\2\2" +
                    "\u00cd\'\3\2\2\2\21,\61L]vy\u0087\u008f\u009a\u009e\u00a4\u00ad\u00b8" +
                    "\u00bb\u00c9";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}
