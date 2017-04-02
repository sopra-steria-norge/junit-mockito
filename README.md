# Introduksjon til JUnit og Mockito

Denne introduksjonen forutsetter at Maven 3 er installert (https://maven.apache.org/download.cgi)

## Del 1: Oppsett
1. Kjør `mvn test` i rotmappa til prosjektet
2. Legg til JUnit som avhengighet i `pom.xml`:

```
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.12</version>
  <scope>test</scope>
</dependency>
```

3. Opprett en testpakke `com.soprasteria.kalkulator` i src/test/java/
4. Opprett en testklasse `KalkulatorTest.java` i testpakken
5. Kjør `mvn test` igjen, og sammenlign utskriften med første kjøring

## Del 2: Første test
1. Lag en metode i `KalkulatorTest.java` med følgende signatur
```
public void skal_få_4_når_1_og_3_adderes()
```
2. Kjør `mvn test` og se på resultatet
3. Legg til annotasjonen `@Test` over metoden for å markere at det er en test
4. Kjør `mvn test` og se på resultatet
5. Gjør et kall til `Kalkulator#adder` i testmetoden, og bruk `Assert.assertEquals` til å sjekke at resultatet blir som forventet.
6. Kjør `mvn test` og se på resultatet
7. Fiks koden i `Kalkulator#add`!
8. Kjør `mvn test` og se på resultatet

### Oppgave:
9. Test `Kalkulator#subtraher` og `Kalkulator#multipliser`
    1. Skriv nye testmetoder i `KalkulatorTest.java`. Husk `@Test`-annotasjonen
    2. Kjør `mvn test` og verifiser at testene feiler
    3. Fiks koden i `Kalkulator`
    4. Kjør `mvn test` og verifiser at testene kjører grønt!

## Del 3: Bedre assertions
1. Legg til AssertJ som avhengighet i `pom.xml`, like under `junit`:
```
<dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <version>3.6.2</version>
    <scope>test</scope>
</dependency>
```
2. Skriv om testmetoden `KalkulatorTest#skal_få_4_når_1_og_3_adderes` til å bruke AssertJ i stedet for junit.core.Assert
    1. Fjern `Assert.assertEquals...`
    2. Kall `Assertions.assertThat(...).isEqualTo(...)` i stedet
    3. Legg til en statisk import av `Assertions.assertThat` for bedre lesbarhet
    4. Kjør testen og se at den fremdeles er grønn

### Oppgave:
4. Skriv om resten av testen til å bruke AssertJ
    1. Skriv om testmetodene for `Kalkulator#subtraher` og `Kalkulator#multipliser`
    2. Kjør testene og se at de fremdeles er grønne

## Del 4: Testing med exceptions
1. Opprett en metode i `Kalkulator` med følgende signatur som returnerer 0:
```
public int divider(int dividend, int divisor) {}
```
2. Opprett en testmetode i `KalkulatorTest` med følgende signatur:
```
public void skal_få_2_når_8_divideres_med_4()
```
3. Implementer testen, kjør `mvn test` og se at den feiler
4. Implementer metoden `Kalkulator#divider`, kjør `mvn test` og se at testen går grønt
5. Opprett en testmetode i `KalkulatorTest`med følgende signatur:
```
public void skal_få_IllegalArgumentException_når_divisor_er_0()
```
6. Bruk parameteret `exåected` til `@Test`-annotasjonen til å si at vi forventer enn IllegalArgumentException
7. Implementer testmetoden og gjør et kall til `Kalkulator#divider` med 0 som divisor
8. Kjør testen og se at den feiler
9. Implementer en sjekk på divisorens verdi i `Kalkulator#divider` der en exception kastes dersom den er 0
10. Kjør testen og se at den går grønt

## Del 5: Forberedelser og etterarbeid
1. Opprett testpakken `com.soprasteria.filleser` i src/test/java, og opprett testklassen `FilLeserTest` i pakken
2. Lag en testmetode med følgende signatur:
```
public void skal_lese_første_linje_fra_fil()
```
3. Implementer metoden:
    1. Opprett en fil `tempfile.txt` med en linje tekst (f. eks. "Lisa gikk til skolen"). Tips: Du kan opprette en fil ved å skrive `new File("filnavn")`.
    2. Gjør et kall til `FilLeser#lesLinjeFraFil` for å hente første linje
    3. Bruk assertions til å sjekke om returverdien er som forventet
4. Kjør testen og se at den går grønt
5. Lag en til testmetode til med følgende signatur:
```
public void skal_lese_andre_linje_fra_fil() {}
```
8. Implementer testen på tilsvarende måte som sist. Husk å legge til to linjer med tekst i filen, og bruk `FilLeser#lesLinjeFraFil` for å lese den andre linjen.
9. Kjør begge testene og se at de går grønt
10. Opprett en metode med følgende signatur i `FilLeserTest`:
```
public void setUp()
```
11. Legg til annotasjonen `@Before` over metoden. Dette gjør at metoden kalles før hver eneste testmetode blir kjørt.
12. Flytt koden som oppretter `tempFile.txt` inn i den nye `setUp`-metoden, og fjern koden fra begge testmetodene
13. Kjør begge testene!
14. Se i rotmappen til prosjektet. Ser du noe som ikke burde vært der?

### Oppgave
15. Lag en metode som rydder opp de midlertidige filene etter at testene er kjørt
    1. Opprett en metode som heter `tearDown` i `FilLeserTest`
    2. Implementer metoden slik at den sletter den midlertidige filen som `setUp`-metoden oppretter
    3. Kjør testene og se at fortsatt er grønne. Hvordan ser rotmappa til prosjektet ut nå?

## Del 6: Ignorering av tester
1. Legg til annotasjonen `@Ignore` på metoden `FilLeserTest#skal_lese_første_linje_fra_fil`
2. Kjør testene, og se på rapporten
3. Legg til en kommentar som parameter til `@Ignore`-annotasjonen
4. Kjør testene

## Del 7: @Rule
1. Finn frem igjen `KalkulatorTest` og legg til følgende felt i klassen:
```
public ExpectedException expectedException = ExpectedException.none();
```
2. Annotér feltet med `@Rule`
3. Fjern `expected`-parameteret fra `@Test`-annotasjonen på `KalkulatorTest#skal_få_IllegalArgumentException_når_divisor_er_0`
4. Kjør testene
5. Øverst i `KalkulatorTest#skal_få_IllegalArgumentException_når_divisor_er_0`, legg til følgende:
```
expectedException.expect(IllegalArgumentException.class);
```
6. Kjør testene igjen

### Oppgave
7. Utvid testen og bruk `ExpectedException#expectMessage(...)` til å verifisere at feilmeldingen er `Divisor kan ikke være 0!`

### Ekstraoppgave
8. Skriv om `FilLeserTest` til å benytte `TemporaryFolder` (en annen `@Rule`) i stedet for metodene `setUp` og `tearDown`

## Del 8: Parameterisert testing vha. en annen TestRunner
1. Opprett en ny testklasse `KalkulatorMultipliserTest` i samme pakke som `KalkulatorTest`
2. Annotér klassen med `@RunWith(Parameterized.class)`, og legg til følgende i klassen:
```
@Parameters
public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
             {0, 0, 0}, {1, 0, 1}, {2, 1, 2}, {3, 2, 6}, {4, 3, 12}, {5, 5, 25}, {6, 8, 47}
       });
}

@Parameter(0)
public int multiplikand;

@Parameter(1)
public int multiplikator;

@Parameter(2)
public int produkt;
```
3. Opprett en testmetode med følgende signatur:
```
public void skal_få_produkt_når_multiplikand_multipliseres_med_multiplikator()
```
4. Oppsettet ligger nå i feltene i klassen. Alt vi trenger gjøre er å kalle `Kalkulator#multipliser` med feltene `multiplikand` og `multiplikator` som argumenter, og verifisere at resultatet blir som forventet (verdien som ligger i `produkt`-feltet). Implementer testmetoden!
5. Kjør testen, og se på resultatet
6. Korriger inputdata og kjør testen igjen!
