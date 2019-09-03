package autocool.sam.example.com.autocool.modele.adherents;

/**
 * Created by samuel on 3/23/18.
 */

public class Adherer {
    private Integer     numAbonne;
    private Integer     codeFormule;


    public Adherer(Integer numAbonne, Integer codeFormule) {
        this.numAbonne = numAbonne;
        this.codeFormule = codeFormule;
    }

    public Integer getNumAbonne() {
        return numAbonne;
    }

    public void setNumAbonne(Integer numAbonne) {
        this.numAbonne = numAbonne;
    }

    public Integer getCodeFormule() {
        return codeFormule;
    }

    public void setCodeFormule(Integer codeFormule) {
        this.codeFormule = codeFormule;
    }

    @Override
    public String toString() {
        return "Adherer{" +
                "numAbonne=" + numAbonne +
                ", numFormule=" + codeFormule +
                '}';
    }
}
