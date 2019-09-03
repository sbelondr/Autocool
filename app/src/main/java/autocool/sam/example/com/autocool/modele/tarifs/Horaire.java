package autocool.sam.example.com.autocool.modele.tarifs;

public class Horaire {
    private String  codeTranche;
    private int     duree;


    public Horaire(String codeTranche, int duree) {
        this.codeTranche = codeTranche;
        this.duree = duree;
    }

    public String getCodeTranche() {
        return codeTranche;
    }

    public void setCodeTranche(String codeTranche) {
        this.codeTranche = codeTranche;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }


}
