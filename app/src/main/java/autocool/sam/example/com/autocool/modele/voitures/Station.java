package autocool.sam.example.com.autocool.modele.voitures;

public class Station {
    private int     numStation;
    private String  lieuStation;
    private String  villeStation;
    private String  cpStation;

    public Station(int numStation, String lieuStation, String villeStation, String cpStation) {
        this.numStation = numStation;
        this.lieuStation = lieuStation;
        this.villeStation = villeStation;
        this.cpStation = cpStation;
    }

    public int getNumStation() {
        return numStation;
    }

    public void setNumStation(int numStation) {
        this.numStation = numStation;
    }

    public String getLieuStation() {
        return lieuStation;
    }

    public void setLieuStation(String lieuStation) {
        this.lieuStation = lieuStation;
    }

    public String getVilleStation() {
        return villeStation;
    }

    public void setVilleStation(String villeStation) {
        this.villeStation = villeStation;
    }

    public String getCpStation() {
        return cpStation;
    }

    public void setCpStation(String cpStation) {
        this.cpStation = cpStation;
    }

    @Override
    public String toString() {
        return "Station{" +
                "numStation=" + numStation +
                ", lieuStation='" + lieuStation + '\'' +
                ", villeStation='" + villeStation + '\'' +
                ", cpStation='" + cpStation + '\'' +
                '}';
    }
}
