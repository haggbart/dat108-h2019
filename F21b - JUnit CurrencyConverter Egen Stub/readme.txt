DAT108 - F21 - 28. oktober 2019
-------------------------------

Hensikten med dette eksemplet er � vise hvordan vi kan isolere
testobjektet (currencyConverter) ved � bruke en stub for et objekt 
det samarbeider med (exchangeRateService).

For � f� dette til:

- IKKE bruk static metoder. static hindrer polymorfisme og dermed
    muligheten til � bruke stand-ins for objekter n�r man tester.
    M� alts� endre ExchangeRateService slik at metoden(e) ikke er
    static. M� derfor opprette et ExchangeRateService-objekt i 
    CurrencyConverter.
    
- M� tilrettelegge for mulig utbytting av objekter vi samhandler med.
    Utbyttingen kan skje i f.eks. konstrukt�r, set-metode eller
    ved � gi objektet som parameter i aktuell metode. Vi gj�r det
    via set-metode, og bruker den opprinnelige ExchangeRateService
    som default.
    
- Objektet som skal erstatte ExchangeRateService m� v�re av 
    "samme type", dvs. arve fra ExchangeRateService. Vi liker ikke
    � bruke arv som et triks! :) Foretrekker � innf�re et interface
    i stedet som vi bruker som type i applikasjonen.
    
- Da lager vi oss en stub som vi kan bruke i testingen. S� injecter
    vi denne i den aktuelle testen.
    Teste: GREEN BAR :)
    
    
    
