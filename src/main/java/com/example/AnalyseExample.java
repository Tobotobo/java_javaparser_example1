package com.example;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.StaticJavaParser;

public class AnalyseExample {
    public static void main(String[] args) {
        CompilationUnit compilationUnit = StaticJavaParser.parse("""
                class A {                  // 1
                    int a;                 // 2
                    private int b;         // 3
                    public int c;          // 4
                    static int d;          // 5
                    private static int e;  // 6
                    public static int f;   // 7
                }                          // 8
                """);

        // Look for fields which are public and not static
        // (Google翻訳)静的ではなくパブリックなフィールドを探します

        compilationUnit.findAll(FieldDeclaration.class).stream()
                .filter(f -> f.isPublic() && !f.isStatic())
                .forEach(f -> System.out.println("Check field at line " +
                        f.getRange().map(r -> r.begin.line).orElse(-1)));
    }
}
