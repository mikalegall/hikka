package espoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// Tarjotaan REST-rajapinta esim. React:ille
// https://spring.io/guides/tutorials/react-and-spring-data-rest/
@RestController
public class Controller1 {

    @Autowired
    private RaakaaineRepository sapuskarepo;

    // R(ead) GET: Haku
/*
    @RequestMapping(value = "rajapinta/mietelause", method = RequestMethod.GET)  <-- Jäljempänä oleva @GetMapping (uudempi tapa) korvaa tämän
    @ResponseBody <-- tuota ei tarvita, koska aiemmin on ilmeoitettu @RestController, joka sisältää sekä @Controller että @ResponseBody
*/
    @GetMapping("safka")
    public Iterable<Ruoka> haeKaikkiRuokaAnnokset() {

        return sapuskarepo.findAll();
    }

    @GetMapping("safka/{id}")
    public Ruoka haeTiettyPaiva(@PathVariable Integer id) {

        return sapuskarepo.findOne(id);
    }


    // C(reate) POST: Uuden tiedon syöttö
/*
    @RequestMapping(value = "rajapinta/mietelause", method = RequestMethod.POST)  <-- Jäljempänä oleva @PostMapping (uudempi tapa) korvaa tämän
*/
    @PostMapping("safka")
    public void lisaaYksiLounas(@RequestBody Ruoka lounas) {

        sapuskarepo.save(lounas);
    }


    // U(pdate) PUT: Päivitys
    @PutMapping("safka/{id}")
    public void paivitaYhtaLounasta(@PathVariable("sanontaId") int id, @RequestBody Ruoka lounas) {
//
//        sanonta.id = id;
//Tai poista se rivi (olio) mikä saatiin id:llä ja tuuppaa usi sisään samalla id:llä

 /*       Sanonta olemassaoleva = sapuskarepo.findOne(id);
        olemassaoleva = sapuska;
        sapuskarepo.(olemassaoleva);
 */   }





/*
    // D(elete) DELETE: Poisto
    @DeleteMapping("/mietelause")
    public ResponseEntity poistaSanonta(@PathVariable("sanontaId") int id) {

        return x;
    }

*/


}
