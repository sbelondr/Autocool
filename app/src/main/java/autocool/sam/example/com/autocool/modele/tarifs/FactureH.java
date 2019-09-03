package autocool.sam.example.com.autocool.modele.tarifs;

public class FactureH {
    private String  codeTrancheH;
    private int     codeFormule;
    private String  codeCateg;
    private double  tarifH;


    public FactureH(String codeTrancheH, int codeFormule, String codeCateg, double tarifH) {
        this.codeTrancheH = codeTrancheH;
        this.codeFormule = codeFormule;
        this.codeCateg = codeCateg;
        this.tarifH = tarifH;
    }

    public String getCodeTrancheH() {
        return codeTrancheH;
    }

    public void setCodeTrancheH(String codeTrancheH) {
        this.codeTrancheH = codeTrancheH;
    }

    public int getCodeFormule() {
        return codeFormule;
    }

    public void setCodeFormule(int codeFormule) {
        this.codeFormule = codeFormule;
    }

    public String getCodeCateg() {
        return codeCateg;
    }

    public void setCodeCateg(String codeCateg) {
        this.codeCateg = codeCateg;
    }

    public double getTarifH() {
        return tarifH;
    }

    public void setTarifH(double tarifH) {
        this.tarifH = tarifH;
    }

    @Override
    public String toString() {
        return "FactureH{" +
                "codeTrancheH='" + codeTrancheH + '\'' +
                ", codeFormule=" + codeFormule +
                ", codeCateg='" + codeCateg + '\'' +
                ", tarifH=" + tarifH +
                '}';
    }
}
