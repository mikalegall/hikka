package espoo;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "annos") // Tässä voidaan antaa tietokantataulun nimi mikäli luokan nimi on eroava (alias)
public class Ruoka {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String viikonpaiva, sapuska, raakaaine1, raakaaine2, raakaaine3;

}
