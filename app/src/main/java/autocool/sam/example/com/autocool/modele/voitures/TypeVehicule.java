package autocool.sam.example.com.autocool.modele.voitures;

public class TypeVehicule {
    private int     codeTypeV;
    private String  libelleTypeV;
    private int     nbPlaces;
    private boolean automatique;

    public TypeVehicule(int codeTypeV, String libelleTypeV, int nbPlaces, boolean automatique) {
        this.codeTypeV = codeTypeV;
        this.libelleTypeV = libelleTypeV;
        this.nbPlaces = nbPlaces;
        this.automatique = automatique;
    }

    public int getCodeTypeV() {
        return codeTypeV;
    }

    public void setCodeTypeV(int codeTypeV) {
        this.codeTypeV = codeTypeV;
    }

    public String getLibelleTypeV() {
        return libelleTypeV;
    }

    public void setLibelleTypeV(String libelleTypeV) {
        this.libelleTypeV = libelleTypeV;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public boolean isAutomatique() {
        return automatique;
    }

    public void setAutomatique(boolean automatique) {
        this.automatique = automatique;
    }


    @Override
    public String toString() {
        return "TypeVehicule{" +
                "codeTypeV=" + codeTypeV +
                ", libelleTypeV='" + libelleTypeV + '\'' +
                ", nbPlaces=" + nbPlaces +
                ", automatique=" + automatique +
                '}';
    }
}
