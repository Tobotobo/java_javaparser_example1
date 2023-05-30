package com.example;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import static com.github.javaparser.ast.Modifier.Keyword.*;

public class GenerateExample {
    public static void main(String[] args) {
        // Create source code on the fly
        // (Google翻訳)オンザフライでソースコードを作成

        CompilationUnit compilationUnit = new CompilationUnit();
        ClassOrInterfaceDeclaration myClass = compilationUnit
                .addClass("MyClass")
                .setPublic(true);
        myClass.addField(int.class, "A_CONSTANT", PUBLIC, STATIC);
        myClass.addField(String.class, "name", PRIVATE);
        String code = myClass.toString();

        System.out.println(code);
    }
}
