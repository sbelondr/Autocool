package autocool.sam.example.com.autocool.modele.tarifs;

public class CategorieVehicule {
    private String  codeCateg;
    private String  libelleCateg;

    public CategorieVehicule(String codeCateg, String libelleCateg) {
        this.codeCateg = codeCateg;
        this.libelleCateg = libelleCateg;
    }

    public String getCodeCateg() {
        return codeCateg;
    }

    public void setCodeCateg(String codeCateg) {
        this.codeCateg = codeCateg;
    }

    public String getLibelleCateg() {
        return libelleCateg;
    }

    public void setLibelleCateg(String libelleCateg) {
        this.libelleCateg = libelleCateg;
    }
}
