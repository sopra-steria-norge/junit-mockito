# Introduksjon til JUnit og Mockito

## Oppgave 1: Oppsett
1. Kjør `mvn test` i rotmappa til prosjektet
2. Legg til junit som avhengighet i pom.xml

```
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.12</version>
  <scope>test</scope>
</dependency>
```

3. Opprett en mappe src/test/java
4. Opprett en testklasse CalculatorTest.java i src/test/java
5. Kjør mvn test igjen, sammenlign utskriften med første kjøring