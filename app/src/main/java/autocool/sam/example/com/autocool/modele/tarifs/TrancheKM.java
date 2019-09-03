package autocool.sam.example.com.autocool.modele.tarifs;

public class TrancheKM {
    private int     codeTrancheKM;
    private int     minKM;
    private int     maxKM;


    public TrancheKM(int codeTrancheKM, int minKM, int maxKM) {

        this.codeTrancheKM = codeTrancheKM;
        this.minKM = minKM;
        this.maxKM = maxKM;
    }

    public int getCodeTrancheKM() {
        return codeTrancheKM;
    }

    public void setCodeTrancheKM(int codeTrancheKM) {
        this.codeTrancheKM = codeTrancheKM;
    }

    public int getMinKM() {
        return minKM;
    }

    public void setMinKM(int minKM) {
        this.minKM = minKM;
    }

    public int getMaxKM() {
        return maxKM;
    }

    public void setMaxKM(int maxKM) {
        this.maxKM = maxKM;
    }


}
