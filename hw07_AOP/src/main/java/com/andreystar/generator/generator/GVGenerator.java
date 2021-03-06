package com.andreystar.generator.generator;

import com.andreystar.generator.grammar.Grammar;
import com.andreystar.generator.util.StringUtils;

public class GVGenerator extends Generator {

    public GVGenerator(Grammar grammar) {
        super(grammar);
    }

    @Override
    public String getGeneratorName() {
        return "GV";
    }

    @Override
    public String generate() {
        StringBuilder res = new StringBuilder();
        res.append(generatePackage()).append("\n");
        res.append(generateImports()).append("\n");
        res.append(generateClassHeader()).append(" {\n\n");
        res.append(generateClassBody()).append("\n");
        res.append("}\n");
        return StringUtils.formatCode(res.toString());
    }

    private String generateImports() {
        return """
                import java.io.BufferedWriter;
                import java.io.IOException;
                import java.nio.file.Files;
                import java.nio.file.Path;
                """;
    }

    private String generateClassHeader() {
        return "public class %s%s"
                .formatted(grammar.getName(), getGeneratorName());
    }

    private String generateClassBody() {
        return """
                private int index;
                				
                public %1$sGV() {
                	this.index = -1;
                }
                				
                public String getGraph(%1$sParser.Node root) throws IOException {
                	StringBuilder sb = new StringBuilder("digraph G {\\n");
                	traverse(root, -1, sb);
                	sb.append("}\\n");
                	return sb.toString();
                }
                				
                public void generateImage(String graph, Path dest, String fileName) throws IOException {
                	try (BufferedWriter out = Files.newBufferedWriter(dest.resolve(fileName + ".dot"))) {
                		out.write(graph);
                		Runtime.getRuntime().exec("dot -Tpdf %%1$s/%%2$s.dot -o %%1$s/%%2$s.pdf".formatted(dest.toString(), fileName));
                	}
                }
                				
                private void traverse(%1$sParser.Node t, int pIndex, StringBuilder sb) {
                	index++;
                	sb.append(String.format("\\t%%d [label = \\"%%s\\"]\\n", index, t.value));
                	if (pIndex != -1) {
                		sb.append(String.format("\\t%%d -> %%d\\n", pIndex, index));
                	}
                	int p = index;
                	for (var ch : t.children) {
                		traverse(ch, p, sb);
                	}
                }
                """.formatted(grammar.getName());
    }

}
