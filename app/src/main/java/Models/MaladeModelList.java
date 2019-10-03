package Models;

public class MaladeModelList {

    private String nb_malade;
    private String tranche_age;

    public MaladeModelList(String nb_malade, String tranche_age) {
        this.nb_malade = nb_malade;
        this.tranche_age = tranche_age;
    }

    public String getNb_malade() {
        return nb_malade;
    }

    public void setNb_malade(String nb_malade) {
        this.nb_malade = nb_malade;
    }

    public String getTranche_age() {
        return tranche_age;
    }

    public void setTranche_age(String tranche_age) {
        this.tranche_age = tranche_age;
    }
}
