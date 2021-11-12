package com.andreystar.generator.util;

import com.andreystar.generator.antlr4.MetaLexer;
import com.andreystar.generator.antlr4.MetaParser;
import com.andreystar.generator.grammar.Grammar;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class MetaGrammarParser {

    public static Grammar parseGrammarFromString(String inputString) throws IOException {
        return parseGrammarFromStream(new ByteArrayInputStream(inputString.getBytes()));
    }

    public static Grammar parseGrammarFromFile(Path grammarDef) throws IOException {
        return getParser(Files.newInputStream(grammarDef)).grammarDef().grammar;
    }

    private static Grammar parseGrammarFromStream(InputStream is) throws IOException {
        return getParser(is).grammarDef().grammar;
    }

    private static MetaParser getParser(InputStream is) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(is);
        MetaLexer lexer = new MetaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new MetaParser(tokens);
    }

}
