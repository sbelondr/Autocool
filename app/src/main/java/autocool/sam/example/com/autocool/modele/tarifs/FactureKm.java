package autocool.sam.example.com.autocool.modele.tarifs;

public class FactureKm {
    private int     codeTrancheKm;
    private int     codeFormule;
    private String  codeCateg;
    private double  tarifKm;


    public FactureKm(int codeTrancheKm, int codeFormule, String codeCateg, double tarifKm) {
        this.codeTrancheKm = codeTrancheKm;
        this.codeFormule = codeFormule;
        this.codeCateg = codeCateg;
        this.tarifKm = tarifKm;
    }

    public int getCodeTrancheKm() {
        return codeTrancheKm;
    }

    public void setCodeTrancheKm(int codeTrancheKm) {
        this.codeTrancheKm = codeTrancheKm;
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

    public double getTarifKm() {
        return tarifKm;
    }

    public void setTarifKm(double tarifKm) {
        this.tarifKm = tarifKm;
    }

    @Override
    public String toString() {
        return "FactureKm{" +
                "codeTrancheKm=" + codeTrancheKm +
                ", codeFormule=" + codeFormule +
                ", codeCateg='" + codeCateg + '\'' +
                ", tarifH=" + tarifKm +
                '}';
    }
}
