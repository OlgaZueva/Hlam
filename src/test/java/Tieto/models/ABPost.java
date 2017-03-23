package Tieto.models;


import java.util.Date;

public class ABPost {
    private String F_TYPE;
    private String FAKTURANR;
    private String K_TYPE;
    private int KUNDE;
    private int LOBE_NR;
    private int SELSKAB;
    private String BEH_KODE;
    private int BELOBDKK;
    private int BELOBVAL;
    private String BET_MD;
    private int BILAGSNR;
    private int DAGBOG;
    private Date DATO;
    private String INIT;
    private int KURS;
    private String MONT_ENHED;
    private String TEKST;
    private String UUCP;
    private String VALUTA;

    public String getF_TYPE() {
        return F_TYPE;
    }

    public void setF_TYPE(String f_TYPE) {
        F_TYPE = f_TYPE;
    }

    public String getFAKTURANR() {
        return FAKTURANR;
    }

    public void setFAKTURANR(String FAKTURANR) {
        this.FAKTURANR = FAKTURANR;
    }

    public String getK_TYPE() {
        return K_TYPE;
    }

    public void setK_TYPE(String k_TYPE) {
        K_TYPE = k_TYPE;
    }

    public int getKUNDE() {
        return KUNDE;
    }

    public void setKUNDE(int KUNDE) {
        this.KUNDE = KUNDE;
    }

    public int getLOBE_NR() {
        return LOBE_NR;
    }

    public void setLOBE_NR(int LOBE_NR) {
        this.LOBE_NR = LOBE_NR;
    }

    public int getSELSKAB() {
        return SELSKAB;
    }

    public void setSELSKAB(int SELSKAB) {
        this.SELSKAB = SELSKAB;
    }

    public String getBEH_KODE() {
        return BEH_KODE;
    }

    public void setBEH_KODE(String BEH_KODE) {
        this.BEH_KODE = BEH_KODE;
    }

    public int getBELOBDKK() {
        return BELOBDKK;
    }

    public void setBELOBDKK(int BELOBDKK) {
        this.BELOBDKK = BELOBDKK;
    }

    public int getBELOBVAL() {
        return BELOBVAL;
    }

    public void setBELOBVAL(int BELOBVAL) {
        this.BELOBVAL = BELOBVAL;
    }

    public String getBET_MD() {
        return BET_MD;
    }

    public void setBET_MD(String BET_MD) {
        this.BET_MD = BET_MD;
    }

    public int getBILAGSNR() {
        return BILAGSNR;
    }

    public void setBILAGSNR(int BILAGSNR) {
        this.BILAGSNR = BILAGSNR;
    }

    public int getDAGBOG() {
        return DAGBOG;
    }

    public void setDAGBOG(int DAGBOG) {
        this.DAGBOG = DAGBOG;
    }

    public Date getDATO() {
        return DATO;
    }

    public void setDATO(Date DATO) {
        this.DATO = DATO;
    }

    public String getINIT() {
        return INIT;
    }

    public void setINIT(String INIT) {
        this.INIT = INIT;
    }

    public int getKURS() {
        return KURS;
    }

    public void setKURS(int KURS) {
        this.KURS = KURS;
    }

    public String getMONT_ENHED() {
        return MONT_ENHED;
    }

    public void setMONT_ENHED(String MONT_ENHED) {
        this.MONT_ENHED = MONT_ENHED;
    }

    public String getTEKST() {
        return TEKST;
    }

    public void setTEKST(String TEKST) {
        this.TEKST = TEKST;
    }

    public String getUUCP() {
        return UUCP;
    }

    public void setUUCP(String UUCP) {
        this.UUCP = UUCP;
    }

    public String getVALUTA() {
        return VALUTA;
    }

    public void setVALUTA(String VALUTA) {
        this.VALUTA = VALUTA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ABPost abPost = (ABPost) o;

        if (KUNDE != abPost.KUNDE) return false;
        if (LOBE_NR != abPost.LOBE_NR) return false;
        if (SELSKAB != abPost.SELSKAB) return false;
        if (BELOBDKK != abPost.BELOBDKK) return false;
        if (BELOBVAL != abPost.BELOBVAL) return false;
        if (BILAGSNR != abPost.BILAGSNR) return false;
        if (DAGBOG != abPost.DAGBOG) return false;
        if (KURS != abPost.KURS) return false;
        if (!F_TYPE.equals(abPost.F_TYPE)) return false;
        if (!FAKTURANR.equals(abPost.FAKTURANR)) return false;
        if (!K_TYPE.equals(abPost.K_TYPE)) return false;
        if (BEH_KODE != null ? !BEH_KODE.equals(abPost.BEH_KODE) : abPost.BEH_KODE != null) return false;
        if (BET_MD != null ? !BET_MD.equals(abPost.BET_MD) : abPost.BET_MD != null) return false;
        if (DATO != null ? !DATO.equals(abPost.DATO) : abPost.DATO != null) return false;
        if (INIT != null ? !INIT.equals(abPost.INIT) : abPost.INIT != null) return false;
        if (MONT_ENHED != null ? !MONT_ENHED.equals(abPost.MONT_ENHED) : abPost.MONT_ENHED != null) return false;
        if (TEKST != null ? !TEKST.equals(abPost.TEKST) : abPost.TEKST != null) return false;
        if (UUCP != null ? !UUCP.equals(abPost.UUCP) : abPost.UUCP != null) return false;
        return VALUTA != null ? VALUTA.equals(abPost.VALUTA) : abPost.VALUTA == null;
    }

    @Override
    public int hashCode() {
        int result = F_TYPE.hashCode();
        result = 31 * result + FAKTURANR.hashCode();
        result = 31 * result + K_TYPE.hashCode();
        result = 31 * result + KUNDE;
        result = 31 * result + LOBE_NR;
        result = 31 * result + SELSKAB;
        result = 31 * result + (BEH_KODE != null ? BEH_KODE.hashCode() : 0);
        result = 31 * result + BELOBDKK;
        result = 31 * result + BELOBVAL;
        result = 31 * result + (BET_MD != null ? BET_MD.hashCode() : 0);
        result = 31 * result + BILAGSNR;
        result = 31 * result + DAGBOG;
        result = 31 * result + (DATO != null ? DATO.hashCode() : 0);
        result = 31 * result + (INIT != null ? INIT.hashCode() : 0);
        result = 31 * result + KURS;
        result = 31 * result + (MONT_ENHED != null ? MONT_ENHED.hashCode() : 0);
        result = 31 * result + (TEKST != null ? TEKST.hashCode() : 0);
        result = 31 * result + (UUCP != null ? UUCP.hashCode() : 0);
        result = 31 * result + (VALUTA != null ? VALUTA.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ABPost{" +
                "F_TYPE='" + F_TYPE + '\'' +
                ", FAKTURANR='" + FAKTURANR + '\'' +
                ", K_TYPE='" + K_TYPE + '\'' +
                ", KUNDE=" + KUNDE +
                ", LOBE_NR=" + LOBE_NR +
                ", SELSKAB=" + SELSKAB +
                ", BEH_KODE='" + BEH_KODE + '\'' +
                ", BELOBDKK=" + BELOBDKK +
                ", BELOBVAL=" + BELOBVAL +
                ", BET_MD='" + BET_MD + '\'' +
                ", BILAGSNR=" + BILAGSNR +
                ", DAGBOG=" + DAGBOG +
                ", DATO=" + DATO +
                ", INIT='" + INIT + '\'' +
                ", KURS=" + KURS +
                ", MONT_ENHED='" + MONT_ENHED + '\'' +
                ", TEKST='" + TEKST + '\'' +
                ", UUCP='" + UUCP + '\'' +
                ", VALUTA='" + VALUTA + '\'' +
                '}';
    }
}
