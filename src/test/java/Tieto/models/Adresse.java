package Tieto.models;

/**
 * Created by zuevaolg on 22.03.2017.
 */
public class Adresse {
    private int NR;
    private int REF_NR;
    private String REF_TYPE;
    private int SELSKAB;
    private String ADRESSE1;
    private String ADRESSE2;
    private String ADRESSE3;
    private String AMS_FLAG;
    private String BYNAVN;
    private String CITY_CODE;
    private String CUSTOMER_NUMBER;
    private String DEB_LAND;
    private String EMAILADR;
    private String ENF_FLAG;
    private String GLOBAL_AC;
    private String INTTRA_CODE;
    private String NAVN;
    private String POSTNR;
    private String SCAC_CODE;
    private String TELEFAX;
    private String TELEFON;
    private String VIRKNR1;
    private String VIRKNR2;


    public int getNR() {

        return NR;
    }

    public Adresse setNR(int NR) {
        this.NR = NR;
        return this;
    }

    public int getREF_NR() {
        return REF_NR;
    }

    public Adresse setREF_NR(int REF_NR) {
        this.REF_NR = REF_NR;
        return this;
    }

    public String getREF_TYPE() {
        return REF_TYPE;
    }

    public Adresse setREF_TYPE(String REF_TYPE) {
        this.REF_TYPE = REF_TYPE;
        return this;
    }

    public int getSELSKAB() {
        return SELSKAB;
    }

    public Adresse setSELSKAB(int SELSKAB) {
        this.SELSKAB = SELSKAB;
        return this;
    }

    public String getADRESSE1() {
        return ADRESSE1;
    }

    public Adresse setADRESSE1(String ADRESSE1) {
        this.ADRESSE1 = ADRESSE1;
        return this;
    }

    public String getADRESSE2() {
        return ADRESSE2;
    }

    public Adresse setADRESSE2(String ADRESSE2) {
        this.ADRESSE2 = ADRESSE2;
        return this;
    }

    public String getADRESSE3() {
        return ADRESSE3;
    }

    public Adresse setADRESSE3(String ADRESSE3) {
        this.ADRESSE3 = ADRESSE3;
        return this;
    }

    public String getAMS_FLAG() {
        return AMS_FLAG;
    }

    public Adresse setAMS_FLAG(String AMS_FLAG) {
        this.AMS_FLAG = AMS_FLAG;
        return this;
    }

    public String getBYNAVN() {
        return BYNAVN;
    }

    public Adresse setBYNAVN(String BYNAVN) {
        this.BYNAVN = BYNAVN;
        return this;
    }

    public String getCITY_CODE() {
        return CITY_CODE;
    }

    public Adresse setCITY_CODE(String CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
        return this;
    }

    public String getCUSTOMER_NUMBER() {
        return CUSTOMER_NUMBER;
    }

    public Adresse setCUSTOMER_NUMBER(String CUSTOMER_NUMBER) {
        this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
        return this;
    }

    public String getDEB_LAND() {
        return DEB_LAND;
    }

    public Adresse setDEB_LAND(String DEB_LAND) {
        this.DEB_LAND = DEB_LAND;
        return this;
    }

    public String getEMAILADR() {
        return EMAILADR;
    }

    public Adresse setEMAILADR(String EMAILADR) {
        this.EMAILADR = EMAILADR;
        return this;
    }

    public String getENF_FLAG() {
        return ENF_FLAG;
    }

    public Adresse setENF_FLAG(String ENF_FLAG) {
        this.ENF_FLAG = ENF_FLAG;
        return this;
    }

    public String getGLOBAL_AC() {
        return GLOBAL_AC;
    }

    public Adresse setGLOBAL_AC(String GLOBAL_AC) {
        this.GLOBAL_AC = GLOBAL_AC;
        return this;
    }

    public String getINTTRA_CODE() {
        return INTTRA_CODE;
    }

    public Adresse setINTTRA_CODE(String INTTRA_CODE) {
        this.INTTRA_CODE = INTTRA_CODE;
        return this;
    }

    public String getNAVN() {
        return NAVN;
    }

    public Adresse setNAVN(String NAVN) {
        this.NAVN = NAVN;
        return this;
    }

    public String getPOSTNR() {
        return POSTNR;
    }

    public Adresse setPOSTNR(String POSTNR) {
        this.POSTNR = POSTNR;
        return this;
    }

    public String getSCAC_CODE() {
        return SCAC_CODE;
    }

    public Adresse setSCAC_CODE(String SCAC_CODE) {
        this.SCAC_CODE = SCAC_CODE;
        return this;
    }

    public String getTELEFAX() {
        return TELEFAX;
    }

    public Adresse setTELEFAX(String TELEFAX) {
        this.TELEFAX = TELEFAX;
        return this;
    }

    public String getTELEFON() {
        return TELEFON;
    }

    public Adresse setTELEFON(String TELEFON) {
        this.TELEFON = TELEFON;
        return this;
    }

    public String getVIRKNR1() {
        return VIRKNR1;
    }

    public Adresse setVIRKNR1(String VIRKNR1) {
        this.VIRKNR1 = VIRKNR1;
        return this;
    }

    public String getVIRKNR2() {
        return VIRKNR2;
    }

    public Adresse setVIRKNR2(String VIRKNR2) {
        this.VIRKNR2 = VIRKNR2;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        if (NR != adresse.NR) return false;
        if (REF_NR != adresse.REF_NR) return false;
        if (SELSKAB != adresse.SELSKAB) return false;
        if (REF_TYPE != null ? !REF_TYPE.equals(adresse.REF_TYPE) : adresse.REF_TYPE != null) return false;
        if (ADRESSE1 != null ? !ADRESSE1.equals(adresse.ADRESSE1) : adresse.ADRESSE1 != null) return false;
        if (ADRESSE2 != null ? !ADRESSE2.equals(adresse.ADRESSE2) : adresse.ADRESSE2 != null) return false;
        if (ADRESSE3 != null ? !ADRESSE3.equals(adresse.ADRESSE3) : adresse.ADRESSE3 != null) return false;
        if (AMS_FLAG != null ? !AMS_FLAG.equals(adresse.AMS_FLAG) : adresse.AMS_FLAG != null) return false;
        if (BYNAVN != null ? !BYNAVN.equals(adresse.BYNAVN) : adresse.BYNAVN != null) return false;
        if (CITY_CODE != null ? !CITY_CODE.equals(adresse.CITY_CODE) : adresse.CITY_CODE != null) return false;
        if (CUSTOMER_NUMBER != null ? !CUSTOMER_NUMBER.equals(adresse.CUSTOMER_NUMBER) : adresse.CUSTOMER_NUMBER != null)
            return false;
        if (DEB_LAND != null ? !DEB_LAND.equals(adresse.DEB_LAND) : adresse.DEB_LAND != null) return false;
        if (EMAILADR != null ? !EMAILADR.equals(adresse.EMAILADR) : adresse.EMAILADR != null) return false;
        if (ENF_FLAG != null ? !ENF_FLAG.equals(adresse.ENF_FLAG) : adresse.ENF_FLAG != null) return false;
        if (GLOBAL_AC != null ? !GLOBAL_AC.equals(adresse.GLOBAL_AC) : adresse.GLOBAL_AC != null) return false;
        if (INTTRA_CODE != null ? !INTTRA_CODE.equals(adresse.INTTRA_CODE) : adresse.INTTRA_CODE != null) return false;
        if (NAVN != null ? !NAVN.equals(adresse.NAVN) : adresse.NAVN != null) return false;
        if (POSTNR != null ? !POSTNR.equals(adresse.POSTNR) : adresse.POSTNR != null) return false;
        if (SCAC_CODE != null ? !SCAC_CODE.equals(adresse.SCAC_CODE) : adresse.SCAC_CODE != null) return false;
        if (TELEFAX != null ? !TELEFAX.equals(adresse.TELEFAX) : adresse.TELEFAX != null) return false;
        if (TELEFON != null ? !TELEFON.equals(adresse.TELEFON) : adresse.TELEFON != null) return false;
        if (VIRKNR1 != null ? !VIRKNR1.equals(adresse.VIRKNR1) : adresse.VIRKNR1 != null) return false;
        return VIRKNR2 != null ? VIRKNR2.equals(adresse.VIRKNR2) : adresse.VIRKNR2 == null;
    }

    @Override
    public int hashCode() {
        int result = NR;
        result = 31 * result + REF_NR;
        result = 31 * result + (REF_TYPE != null ? REF_TYPE.hashCode() : 0);
        result = 31 * result + SELSKAB;
        result = 31 * result + (ADRESSE1 != null ? ADRESSE1.hashCode() : 0);
        result = 31 * result + (ADRESSE2 != null ? ADRESSE2.hashCode() : 0);
        result = 31 * result + (ADRESSE3 != null ? ADRESSE3.hashCode() : 0);
        result = 31 * result + (AMS_FLAG != null ? AMS_FLAG.hashCode() : 0);
        result = 31 * result + (BYNAVN != null ? BYNAVN.hashCode() : 0);
        result = 31 * result + (CITY_CODE != null ? CITY_CODE.hashCode() : 0);
        result = 31 * result + (CUSTOMER_NUMBER != null ? CUSTOMER_NUMBER.hashCode() : 0);
        result = 31 * result + (DEB_LAND != null ? DEB_LAND.hashCode() : 0);
        result = 31 * result + (EMAILADR != null ? EMAILADR.hashCode() : 0);
        result = 31 * result + (ENF_FLAG != null ? ENF_FLAG.hashCode() : 0);
        result = 31 * result + (GLOBAL_AC != null ? GLOBAL_AC.hashCode() : 0);
        result = 31 * result + (INTTRA_CODE != null ? INTTRA_CODE.hashCode() : 0);
        result = 31 * result + (NAVN != null ? NAVN.hashCode() : 0);
        result = 31 * result + (POSTNR != null ? POSTNR.hashCode() : 0);
        result = 31 * result + (SCAC_CODE != null ? SCAC_CODE.hashCode() : 0);
        result = 31 * result + (TELEFAX != null ? TELEFAX.hashCode() : 0);
        result = 31 * result + (TELEFON != null ? TELEFON.hashCode() : 0);
        result = 31 * result + (VIRKNR1 != null ? VIRKNR1.hashCode() : 0);
        result = 31 * result + (VIRKNR2 != null ? VIRKNR2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "NR=" + NR +
                ", REF_NR=" + REF_NR +
                ", REF_TYPE='" + REF_TYPE + '\'' +
                ", SELSKAB=" + SELSKAB +
                ", ADRESSE1='" + ADRESSE1 + '\'' +
                ", ADRESSE2='" + ADRESSE2 + '\'' +
                ", ADRESSE3='" + ADRESSE3 + '\'' +
                ", AMS_FLAG='" + AMS_FLAG + '\'' +
                ", BYNAVN='" + BYNAVN + '\'' +
                ", CITY_CODE='" + CITY_CODE + '\'' +
                ", CUSTOMER_NUMBER='" + CUSTOMER_NUMBER + '\'' +
                ", DEB_LAND='" + DEB_LAND + '\'' +
                ", EMAILADR='" + EMAILADR + '\'' +
                ", ENF_FLAG='" + ENF_FLAG + '\'' +
                ", GLOBAL_AC='" + GLOBAL_AC + '\'' +
                ", INTTRA_CODE='" + INTTRA_CODE + '\'' +
                ", NAVN='" + NAVN + '\'' +
                ", POSTNR='" + POSTNR + '\'' +
                ", SCAC_CODE='" + SCAC_CODE + '\'' +
                ", TELEFAX='" + TELEFAX + '\'' +
                ", TELEFON='" + TELEFON + '\'' +
                ", VIRKNR1='" + VIRKNR1 + '\'' +
                ", VIRKNR2='" + VIRKNR2 + '\'' +
                '}';
    }
}
