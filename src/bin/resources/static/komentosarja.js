
// Pakotetaan muuttujan (variable) esittely tapahtuvaksi (var x = arvo;)
"use strict";

// Haetaan HTML-dokumentista haluttu elementti käsiteltäväksi
var htmlElementti = document.getElementById("lista");

// Luodaan XMLHttpRequest olio
var kyselija = new XMLHttpRequest();

// Alustetaan yhteys "true" -arvolla asynkroniseksi
kyselija.open("GET", "http://localhost:8080/safka", true);

// Avataan yhteys
kyselija.send();

// Luodaan avoimelle yhteydelle (oliolle) tapahtumankäsittelijä,
// joka (tilanmuutosten yhteydessä) toteuttaa kommunikointia metodilla

kyselija.onreadystatechange = function () {
    if (kyselija.readyState === 4) {

        if (kyselija.status === 200 || kyselija.status === 204) {

            // Mikäli tähän Jos-lauseeseen on astuttu, niin pyyntö on valmis
            // console.log(kyselija.responseText);

            // Tallennetaan saatu vastausteksti erilliseen muuttujaan
            // ihan vaan selkeyden vuoksi ja siis esimerkin omaisesti
            var sisalto = kyselija.responseText;

            // Muunnetaan saatu merkkijono (String) taulukoksi, jäsentelemällä (parse)
            // sen aaltosulkeissa olevat osuudet dynaamisesti kasvatettavan taulukon eri alkioiksi
            var taulu = JSON.parse(sisalto);

            //console.log(taulu[0].viikonpaiva);
            // Selaimen kehittäjätyökalun konsolilla huomataan hakemistosta (dir)
            // kyseessä olevan Javan kaltainen HashMap-taulukko (JavaScriptin assosiatiivinen
            // avain-arvo -pari taulukko). Konsolilta nähdään mitä avaimia eri arvoille on tarjolla
            console.dir(taulu);

            for (var i = 0; i < taulu.length; i++) {
                var annos = taulu[i];
                var viikonpaiva = annos.viikonpaiva;
                var sapuska = annos.sapuska;
                var raakaaine1 = annos.raakaaine1;
                var raakaaine2 = annos.raakaaine2;
                var raakaaine3 = annos.raakaaine3;

                // Luodaan elementtipuun rakenteeseen uusi tekstisolmu ja haetaan
                // siihen sisältökirjoitusta
                var solmu = document.createTextNode(viikonpaiva + "na tarjolla: " + sapuska + " (koostuu aineksista: " +
                    raakaaine1 + ", " + raakaaine2 + " ja " + raakaaine3 + ").");

                // console.log(solmu);

                // Jokaisella silmukoinnilla tehdään uusi kohta järjestämättömään listaan
                var uusielementti = document.createElement("li");
                // Jokaiseen listaelementin uuteen kohtaan sijoitetaan tekstisolmu,
                // jossa on kirjoitusta taulukon sisällöstä
                uusielementti.appendChild(solmu);

                // Käsiteltävään HTML-elementtiin lisätään uusi
                // osio listaelementin kohta, jossa on taulukosta
                // haettu sisältö kapseloituna sisälleen tekstiNodeen,
                // ikään kuin maatuskanuken tavoin...
                htmlElementti.appendChild(uusielementti);

                // HTML-sivun muokkaus olisi voitu tehdä myös suoraan, maatuskanuken tavoin, asettamalla lauseet sisäkkäin:
                // htmlElementti.appendChild(document.createElement("li").appendChild(document.createTextNode(viikonpaiva + ", tarjolla: " + sapuska + " (koostuu aineksista: " + raakaaine1 + ", " + raakaaine2 + " ja " + raakaaine3 + ")."))));
            }
        } else {
            alert("Pyyntö REST-APIin häiriintyi");
        }
    }
}