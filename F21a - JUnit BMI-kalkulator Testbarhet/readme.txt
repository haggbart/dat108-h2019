DAT108 - F21 - 28. oktober 2019
-------------------------------

Hensikten med dette eksemplet er � vise at valgene vi tar i utformingen
av koden har betydning for testbarheten.

---

/bmi1 = BmiServlet1.java + bmi1.jsp

Her gj�r vi "nesten alt" i BmiServlet1, dvs. b�de inputvalidering, 
feilmeldinger, beregning av BMI og avrunding til en desimal. 
Beregning av vektklasser gj�res direkte i JSP-en. FY!

Det er klin umulig � teste om noen av disse tingene er korrekte!

---

/bmi2 = BmiServlet2.java + bmi2.jsp

F�rste forsiktige forbedring er � fjerne beregninger fra JSP-en.
Men fremdeles:

Det er klin umulig � teste om noen av disse tingene er korrekte!

---

/bmi3 = BmiServlet3.java + bmi3.jsp

Vi lager hjelpemetoder for alle beregninger i servleten.

N� kan vi teste om hjelpemetodene er korrekte! JIPPI!

L�sningen testes i BmiServlet3TestV1.java

Selve testklassen b�r ogs� fikses litt p�, f.eks. flytting av
felles init-kode til en @Before-metode og bruk av konstanter for
gjentagende String-litteraler (test-data).

Da har vi BmiServlet3TestV2.java

Men det er jo litt unaturlig at alle disse beregningene gj�res i
BmiServlet3-klassen.

---

/bmi4 = BmiServlet4.java + bmi4.jsp

Vi innf�rer en BmiCalculator4.java og flytter beregningene dit.

Og vi tester mot denne i stedet i BmiCalculator4Test.java

Hva kan gj�res enda bedre?

Tester kan v�re ganske skj�re om man tester mot String-verdier, spesielt
om de tenkt � vises til brukeren. Hvis man ombestemmer seg p� output kan
testene plutselig feile.

Ofte er det bedre � teste mot "harde" verdier i stedet. Enums kan v�re 
en god "erstatning" for String-verdier.

---

/bmi5 = BmiServlet5.java + bmi5.jsp

Innf�rer n� en Enum BmiVektklasse5.java som representerer de ulike
vektklassene.

Bruker denne i applikasjonen (og testene) i stedet.

Testen heter BmiCalculator5Test.java.

...

DA ER VI I M�L MED EKSEMPLET.















