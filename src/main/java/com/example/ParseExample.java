package com.example;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.util.Optional;

import com.github.javaparser.StaticJavaParser;

public class ParseExample {
    public static void main(String[] args) {
        // Create a Java object representation of your code
        // (Google翻訳)コードの Java オブジェクト表現を作成します

        CompilationUnit compilationUnit = StaticJavaParser.parse("class A { }");
        Optional<ClassOrInterfaceDeclaration> classA = compilationUnit.getClassByName("A");

        System.out.println(classA.toString());
    }
}
