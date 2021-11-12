package com.andreystar.generator.grammar;

public class RhsTerminal extends RhsAtom {

    public RhsTerminal(String name) {
        this(name, "");
    }

    public RhsTerminal(String name, String code) {
        super(name, code);
    }

}
