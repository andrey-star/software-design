// Generated from com\andreystar\MetaParser.g4 by ANTLR 4.5
package com.andreystar.generator.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MetaParser}.
 */
public interface MetaParserListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link MetaParser#grammarDef}.
     *
     * @param ctx the parse tree
     */
    void enterGrammarDef(MetaParser.GrammarDefContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#grammarDef}.
     *
     * @param ctx the parse tree
     */
    void exitGrammarDef(MetaParser.GrammarDefContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#grammarName}.
     *
     * @param ctx the parse tree
     */
    void enterGrammarName(MetaParser.GrammarNameContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#grammarName}.
     *
     * @param ctx the parse tree
     */
    void exitGrammarName(MetaParser.GrammarNameContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#imports}.
     *
     * @param ctx the parse tree
     */
    void enterImports(MetaParser.ImportsContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#imports}.
     *
     * @param ctx the parse tree
     */
    void exitImports(MetaParser.ImportsContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#macros}.
     *
     * @param ctx the parse tree
     */
    void enterMacros(MetaParser.MacrosContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#macros}.
     *
     * @param ctx the parse tree
     */
    void exitMacros(MetaParser.MacrosContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#lexerRules}.
     *
     * @param ctx the parse tree
     */
    void enterLexerRules(MetaParser.LexerRulesContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#lexerRules}.
     *
     * @param ctx the parse tree
     */
    void exitLexerRules(MetaParser.LexerRulesContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#myLexerRule}.
     *
     * @param ctx the parse tree
     */
    void enterMyLexerRule(MetaParser.MyLexerRuleContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#myLexerRule}.
     *
     * @param ctx the parse tree
     */
    void exitMyLexerRule(MetaParser.MyLexerRuleContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#parserRules}.
     *
     * @param ctx the parse tree
     */
    void enterParserRules(MetaParser.ParserRulesContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#parserRules}.
     *
     * @param ctx the parse tree
     */
    void exitParserRules(MetaParser.ParserRulesContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#myParserRule}.
     *
     * @param ctx the parse tree
     */
    void enterMyParserRule(MetaParser.MyParserRuleContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#myParserRule}.
     *
     * @param ctx the parse tree
     */
    void exitMyParserRule(MetaParser.MyParserRuleContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#typedNames}.
     *
     * @param ctx the parse tree
     */
    void enterTypedNames(MetaParser.TypedNamesContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#typedNames}.
     *
     * @param ctx the parse tree
     */
    void exitTypedNames(MetaParser.TypedNamesContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#typedName}.
     *
     * @param ctx the parse tree
     */
    void enterTypedName(MetaParser.TypedNameContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#typedName}.
     *
     * @param ctx the parse tree
     */
    void exitTypedName(MetaParser.TypedNameContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#ruleRhss}.
     *
     * @param ctx the parse tree
     */
    void enterRuleRhss(MetaParser.RuleRhssContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#ruleRhss}.
     *
     * @param ctx the parse tree
     */
    void exitRuleRhss(MetaParser.RuleRhssContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#ruleRhs}.
     *
     * @param ctx the parse tree
     */
    void enterRuleRhs(MetaParser.RuleRhsContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#ruleRhs}.
     *
     * @param ctx the parse tree
     */
    void exitRuleRhs(MetaParser.RuleRhsContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#rhsAtom}.
     *
     * @param ctx the parse tree
     */
    void enterRhsAtom(MetaParser.RhsAtomContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#rhsAtom}.
     *
     * @param ctx the parse tree
     */
    void exitRhsAtom(MetaParser.RhsAtomContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#rhsEps}.
     *
     * @param ctx the parse tree
     */
    void enterRhsEps(MetaParser.RhsEpsContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#rhsEps}.
     *
     * @param ctx the parse tree
     */
    void exitRhsEps(MetaParser.RhsEpsContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#rhsTerminal}.
     *
     * @param ctx the parse tree
     */
    void enterRhsTerminal(MetaParser.RhsTerminalContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#rhsTerminal}.
     *
     * @param ctx the parse tree
     */
    void exitRhsTerminal(MetaParser.RhsTerminalContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#rhsNonTerminal}.
     *
     * @param ctx the parse tree
     */
    void enterRhsNonTerminal(MetaParser.RhsNonTerminalContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#rhsNonTerminal}.
     *
     * @param ctx the parse tree
     */
    void exitRhsNonTerminal(MetaParser.RhsNonTerminalContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#args}.
     *
     * @param ctx the parse tree
     */
    void enterArgs(MetaParser.ArgsContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#args}.
     *
     * @param ctx the parse tree
     */
    void exitArgs(MetaParser.ArgsContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#startRule}.
     *
     * @param ctx the parse tree
     */
    void enterStartRule(MetaParser.StartRuleContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#startRule}.
     *
     * @param ctx the parse tree
     */
    void exitStartRule(MetaParser.StartRuleContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#code}.
     *
     * @param ctx the parse tree
     */
    void enterCode(MetaParser.CodeContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#code}.
     *
     * @param ctx the parse tree
     */
    void exitCode(MetaParser.CodeContext ctx);
}
