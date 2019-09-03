package autocool.sam.example.com.autocool.modele.voitures;

public class Vehicule {
    private int     numVehicule;
    private double  kilometrage;
    private int     niveauEssence;

    public Vehicule(int numVehicule, double kilometrage, int niveauEssence) {
        this.numVehicule = numVehicule;
        this.kilometrage = kilometrage;
        this.niveauEssence = niveauEssence;
    }

    public int getNumVehicule() {
        return numVehicule;
    }

    public void setNumVehicule(int numVehicule) {
        this.numVehicule = numVehicule;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getNiveauEssence() {
        return niveauEssence;
    }

    public void setNiveauEssence(int niveauEssence) {
        this.niveauEssence = niveauEssence;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "numVehicule=" + numVehicule +
                ", kilometrage=" + kilometrage +
                ", niveauEssence=" + niveauEssence +
                '}';
    }
}
