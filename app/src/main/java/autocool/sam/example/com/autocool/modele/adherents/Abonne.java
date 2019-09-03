package autocool.sam.example.com.autocool.modele.adherents;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by sbelondrade on 3/23/18.
 */

class Abonnes{
    ArrayList<Abonne> abonnes;


    public ArrayList<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(ArrayList<Abonne> abonnes) {
        this.abonnes = abonnes;
    }


    public Abonne rechercheAbonne(String nomPreAbonne){
        for (Abonne unAbonne:abonnes){
            String valeur = unAbonne.getNom() + " " + unAbonne.getPrenom();
            if (valeur.equals(nomPreAbonne)) return unAbonne;
        }
        return null;
    }
}

public class Abonne implements Parcelable{
    private Integer numAbonne;
    private String  nom;
    private String  prenom;
    private String  dateNaissance;
    private String  rue;
    private String  ville;
    private String  codePostal;
    private String  tel;
    private String  telMobile;
    private String  email;
    private String  numPermis;
    private String  lieuPermis;
    private String  datePermis;
    private int     paiementAdhesion;
    private int     paiementCaution;
    private String  ribFourni;

    public Abonne(Integer numAbonne, String nom, String prenom, String dateNaissance, String rue,
                  String ville, String codePostal, String tel, String telMobile, String email,
                  String numPermis, String lieuPermis, String datePermis, int paiementAdhesion,
                  int paiementCaution, String ribFourni) {
        super();
        this.numAbonne = numAbonne;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.tel = tel;
        this.telMobile = telMobile;
        this.email = email;
        this.numPermis = numPermis;
        this.lieuPermis = lieuPermis;
        this.datePermis = datePermis;
        this.paiementAdhesion = paiementAdhesion;
        this.paiementCaution = paiementCaution;
        this.ribFourni = ribFourni;
    }

    //      parcelable

    public Abonne(Parcel source) {
        this.numAbonne = source.readInt();
        this.nom = source.readString();
        this.prenom = source.readString();
        this.dateNaissance = source.readString();
        this.rue = source.readString();
        this.ville = source.readString();
        this.codePostal = source.readString();
        this.tel = source.readString();
        this.telMobile = source.readString();
        this.email = source.readString();
        this.numPermis = source.readString();
        this.lieuPermis = source.readString();
        this.datePermis = source.readString();
        this.paiementAdhesion = source.readInt();
        this.paiementCaution = source.readInt();
        this.ribFourni = source.readString();
    }

    //      fin parcelable suite a la fin

    public Integer getNumAbonne() {
        return numAbonne;
    }

    public void setNumAbonne(Integer numAbonne) {
        this.numAbonne = numAbonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(String numPermis) {
        this.numPermis = numPermis;
    }

    public String getLieuPermis() {
        return lieuPermis;
    }

    public void setLieuPermis(String lieuPermis) {
        this.lieuPermis = lieuPermis;
    }

    public String getDatePermis() {
        return datePermis;
    }

    public void setDatePermis(String datePermis) {
        this.datePermis = datePermis;
    }

    public int getPaiementAdhesion() {
        return paiementAdhesion;
    }

    public void setPaiementAdhesion(int paiementAdhesion) {
        this.paiementAdhesion = paiementAdhesion;
    }

    public int getPaiementCaution() {
        return paiementCaution;
    }

    public void setPaiementCaution(int paiementCaution) {
        this.paiementCaution = paiementCaution;
    }

    public String getRibFourni() {
        return ribFourni;
    }

    public void setRibFourni(String ribFourni) {
        this.ribFourni = ribFourni;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }




    // parcelable
    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(this.numAbonne);
        dest.writeString(this.nom);
        dest.writeString(this.prenom);
        dest.writeString(this.dateNaissance);
        dest.writeString(this.rue);
        dest.writeString(this.ville);
        dest.writeString(this.codePostal);
        dest.writeString(this.tel);
        dest.writeString(this.telMobile);
        dest.writeString(this.email);
        dest.writeString(this.numPermis);
        dest.writeString(this.lieuPermis);
        dest.writeString(this.datePermis);
        dest.writeInt(this.paiementAdhesion);
        dest.writeInt(this.paiementCaution);
        dest.writeString(this.ribFourni);
    }

    public static final Parcelable.Creator<Abonne> CREATOR = new Parcelable.Creator<Abonne>() {
        @Override
        public Abonne createFromParcel(Parcel parcel) {
            return new Abonne(parcel);
        }

        @Override
        public Abonne[] newArray(int i) {
            return new Abonne[i];
        }
    };

}
