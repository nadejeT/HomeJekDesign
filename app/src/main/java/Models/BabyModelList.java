package Models;

public class BabyModelList {

    private String nb_enfant;
    private String tranche_age;

    public BabyModelList(String nb_enfant, String tranche_age) {
        this.nb_enfant = nb_enfant;
        this.tranche_age = tranche_age;
    }

    public String getNb_enfant() {
        return nb_enfant;
    }

    public void setNb_enfant(String nb_enfant) {
        this.nb_enfant = nb_enfant;
    }

    public String getTranche_age() {
        return tranche_age;
    }

    public void setTranche_age(String tranche_age) {
        this.tranche_age = tranche_age;
    }
}
