# java_javaparser_example1

JavaParser - GitHub  
https://github.com/javaparser/javaparser

JavaParser  
http://javaparser.org/

JavaParser and Maven sample  
https://github.com/javaparser/javasymbolsolver-maven-sample


### 依存関係の追加
pom.xml
```xml
    <dependency>
      <groupId>com.github.javaparser</groupId>
      <artifactId>javaparser-symbol-solver-core</artifactId>
      <version>3.25.3</version>
    </dependency>
    <dependency>
      <groupId>com.github.javaparser</groupId>
      <artifactId>javaparser-core-serialization</artifactId>
      <version>3.25.3</version>
    </dependency>
```

### Parse 解析する
```java
// Create a Java object representation of your code
// (Google翻訳)コードの Java オブジェクト表現を作成します

CompilationUnit compilationUnit
		= StaticJavaParser.parse("class A { }");
Optiona<ClassOrInterfaceDeclaration> classA
		= compilationUnit.getClassByName("A");
```

### Analyse 分析する
```java
// Look for fields which are public and not static
// (Google翻訳)静的ではなくパブリックなフィールドを探します

compilationUnit.findAll(FieldDeclaration.class).stream()
        .filter(f -> f.isPublic() && !f.isStatic())
        .forEach(f -> System.out.println("Check field at line " +
            f.getRange().map(r -> r.begin.line).orElse(-1)));
```

### Transform 変身
```java
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
```

### Generate 生成
```java
// Create source code on the fly
// (Google翻訳)オンザフライでソースコードを作成

CompilationUnit compilationUnit = new CompilationUnit();
ClassOrInterfaceDeclaration myClass = compilationUnit
        .addClass("MyClass")
        .setPublic(true);
myClass.addField(int.class, "A_CONSTANT", PUBLIC, STATIC);
myClass.addField(String.class, "name", PRIVATE);
String code = myClass.toString();
```