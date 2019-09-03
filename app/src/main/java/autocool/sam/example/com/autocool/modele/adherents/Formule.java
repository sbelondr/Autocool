package autocool.sam.example.com.autocool.modele.adherents;

public class Formule {
    private int     codeFormule;
    private String  libelleFormule;
    private double  fraisAdhesion;
    private double  tarifMensuel;
    private double  partSociale;
    private double  depotGarantie;
    private double  caution;

    public Formule(int codeFormule, String libelleFormule, double fraisAdhesion, double tarifMensuel,
                   double partSociale, double depotGarantie, double caution) {
        this.codeFormule = codeFormule;
        this.libelleFormule = libelleFormule;
        this.fraisAdhesion = fraisAdhesion;
        this.tarifMensuel = tarifMensuel;
        this.partSociale = partSociale;
        this.depotGarantie = depotGarantie;
        this.caution = caution;
    }

    public int getCodeFormule() {
        return codeFormule;
    }

    public void setCodeFormule(int codeFormule) {
        this.codeFormule = codeFormule;
    }

    public String getLibelleFormule() {
        return libelleFormule;
    }

    public void setLibelleFormule(String libelleFormule) {
        this.libelleFormule = libelleFormule;
    }

    public double getFraisAdhesion() {
        return fraisAdhesion;
    }

    public void setFraisAdhesion(double fraisAdhesion) {
        this.fraisAdhesion = fraisAdhesion;
    }

    public double getTarifMensuel() {
        return tarifMensuel;
    }

    public void setTarifMensuel(double tarifMensuel) {
        this.tarifMensuel = tarifMensuel;
    }

    public double getPartSociale() {
        return partSociale;
    }

    public void setPartSociale(double partSociale) {
        this.partSociale = partSociale;
    }

    public double getDepotGarantie() {
        return depotGarantie;
    }

    public void setDepotGarantie(double depotGarantie) {
        this.depotGarantie = depotGarantie;
    }

    public double getCaution() {
        return caution;
    }

    public void setCaution(double caution) {
        this.caution = caution;
    }
}

