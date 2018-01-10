package espoo;

import lombok.Data;
import javax.persistence.*;

@Entity // Tämä ilmoittaa Hibernatelle, että tee tästä Java-luokasta tietokantataulu. Tässä Java-luokassa on oltava julkinen tai protected-näkyvyydelle
        // määritelty parametriton konstruktori (oletuskonstruktori riittää), tämä luokka ei voi olla final tai enum (etukäteen määritellyt tyypit omaava),
        // tälle luokalle täytyy luoda getterit ja setterit
@Table(name = "annos") // Tässä voidaan antaa tietokantataulun nimi mikäli luokan nimi on eroava eli halutaan käyttää aliasta
// Hibernate natiivilla ilman nimeämistä oletusarvoinen taulu luotaisiin nimellä EVENT
@Data // Tekee @Entitylle vaadittavat getterit ja setterit, jotta Spring Data / Hibernate / JPA toimii autogeneroitavan DAO-kerroksen (interface --> repository) kautta
/*
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
</dependency>
*/
public class Ruoka {

    @Id // Tämä määrittää entiteetin identiteetin yhdeksi kentäksi
    @GeneratedValue(strategy= GenerationType.AUTO)
    // @GeneratedValue(generator = "increment")    // Hibernate natiivilla + alla oleva annotaatio
    // @GenericGenerator(name = "increment", strategy = "increment")  // Hibernate natiivilla

    private int id;

    private String viikonpaiva, raakaaine1, raakaaine2, raakaaine3;
    @Lob // String on oletusarvoisesti VARCHAR(255), lisäämällä annotaation @Lob tulee tyypiksi TEXT (voi tosin riippua kannasta!)
    private String sapuska;

}
