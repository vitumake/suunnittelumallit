# Vastaukset

## a. Kaksi säiettä käyttää omia iteraattoreitaan

Kun kaksi säiettä käyttää omia iteraattoreitaan, kumpikaan säie ei voi muuttaa toisen säikeen iteraattorin tilaa. Tämä tarkoittaa sitä, että kumpikin säie voi käydä iteraattorin läpi omassa tahdissaan ilman, että toisen säikeen toiminta vaikuttaa siihen millään tavalla.

## b. Kahdella säikeellä on yhteinen iteraattori

Kun kahdella säikeellä on yhteinen iteraattori, säikeet voivat muuttaa toistensa iteraattorin tilaa. Tämä tarkoittaa sitä, että jos toinen säie muuttaa iteraattorin tilaa, se vaikuttaa myös toisen säikeen toimintaan. Tämä voi aiheuttaa ongelmia, jos iteraattoria käytetään samanaikaisesti useassa säikeessä.

## c. Kokoelman muuttaminen iteraattorin läpikäynnin aikana

Kokoelman muuttaminen iteraattorin läpikäynnin aikana voi aiheuttaa ConcurrentModificationException-poikkeuksen. Tämä johtuu siitä, että iteraattori tarkistaa automaattisesti, onko kokoelmaa muutettu sen läpikäynnin aikana. Jos iteraattori havaitsee muutoksia, se heittää poikkeuksen estääkseen mahdolliset virhetilanteet.

## d. Iteraattorin remove()-metodi poistaa alkion kokoelmasta

Iteraattorin remove()-metodi poistaa alkion kokoelmasta ja päivittää iteraattorin tilan sen mukaisesti. Tämä tarkoittaa sitä, että iteraattori ei enää viittaa poistettuun alkioon, vaan jatkaa seuraavan alkion käsittelyä. Tämä mahdollistaa kokoelman turvallisen muokkaamisen iteraattorin läpikäynnin aikana.
