package com.example;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import com.github.javaparser.StaticJavaParser;

public class TransformExample {
    public static void main(String[] args) {
        CompilationUnit compilationUnit = StaticJavaParser.parse("""
                class A { }
                abstract class B { }
                abstract class AbstractC { }
                """);

        // Ensure all abstract classes have a name starting with Abstract
        // (Google翻訳)すべての抽象クラスが Abstract で始まることを確認します。

        compilationUnit.findAll(ClassOrInterfaceDeclaration.class).stream()
                .filter(c -> !c.isInterface()
                        && c.isAbstract()
                        && !c.getNameAsString().startsWith("Abstract"))
                .forEach(c -> {
                    String from = c.getNameAsString();
                    String to = "Abstract" + from;
                    System.out.println("Renaming class " + from + " into " + to);
                    c.setName(to);
                });
    }
}
