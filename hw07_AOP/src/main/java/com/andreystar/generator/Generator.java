package com.andreystar.generator;

import com.andreystar.generator.generator.*;
import com.andreystar.generator.grammar.Grammar;
import com.andreystar.generator.util.MetaGrammarParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class Generator {

    public static void main(String[] args) {
        args = new String[2];
        args[0] = "src/main/resources/arithmetic.txt";
        args[1] = "generated";
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Usage: Generator <grammar file> <output folder>");
        }
        try {
            Path grammarDef = Path.of(Objects.requireNonNull(args[0]));
            try {
                Path dest = Path.of(Objects.requireNonNull(args[1]));
                generate(grammarDef, dest);
            } catch (InvalidPathException e) {
                System.err.println("Invalid destination folder path");
            } catch (IOException e) {
                System.err.println("An IO error occurred");
                e.printStackTrace();
            }
        } catch (InvalidPathException e) {
            System.err.println("Invalid grammar file path");
        }
    }

    private static void generate(Path grammarDef, Path dest) throws IOException {
        Grammar grammar = MetaGrammarParser.parseGrammarFromFile(grammarDef);
        dest = dest.resolve(grammar.getName().toLowerCase());
        if (!Files.exists(dest)) {
            Files.createDirectories(dest);
        }
        for (com.andreystar.generator.generator.Generator g : List.of(
                new LexerGenerator(grammar),
                new ParserGenerator(grammar),
                new TokenGenerator(grammar),
                new MainGenerator(grammar),
                new GVGenerator(grammar))) {
            Files.writeString(dest.resolve(g.getFileName()), g.generate());
        }
    }

}
