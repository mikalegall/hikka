package espoo;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "annos") // Tässä voidaan antaa tietokantataulun nimi mikäli luokan nimi on eroava (alias)
public class Ruoka {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String viikonpaiva, sapuska, raakaaine1, raakaaine2, raakaaine3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getViikonpaiva() {
        return viikonpaiva;
    }

    public void setViikonpaiva(String viikonpaiva) {
        this.viikonpaiva = viikonpaiva;
    }

    public String getSapuska() {
        return sapuska;
    }

    public void setSapuska(String sapuska) {
        this.sapuska = sapuska;
    }

    public String getRaakaaine1() {
        return raakaaine1;
    }

    public void setRaakaaine1(String raakaaine1) {
        this.raakaaine1 = raakaaine1;
    }

    public String getRaakaaine2() {
        return raakaaine2;
    }

    public void setRaakaaine2(String raakaaine2) {
        this.raakaaine2 = raakaaine2;
    }

    public String getRaakaaine3() {
        return raakaaine3;
    }

    public void setRaakaaine3(String raakaaine3) {
        this.raakaaine3 = raakaaine3;
    }
}
