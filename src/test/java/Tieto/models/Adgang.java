package Tieto.models;

public class Adgang {
    private String VOR_REF;
    private String ACCOUNTANT;
    private String AD_LOGIN;
    private String AD_USER_ONLY;
    private String FGAC;
    private int START_SEL;
    private String UTS_ADMIN;
    private String UTS_GROUP;
    private int UTS_LEVEL;

    public String getVOR_REF() {
        return VOR_REF;    }


    public Adgang setVOR_REF(String VOR_REF) {
        this.VOR_REF = VOR_REF;
        return this;
    }

    public String getACCOUNTANT() {
        return ACCOUNTANT;
    }

    public Adgang setACCOUNTANT(String ACCOUNTANT) {
        this.ACCOUNTANT = ACCOUNTANT;
        return this;
    }

    public String getAD_LOGIN() {
        return AD_LOGIN;
    }

    public Adgang setAD_LOGIN(String AD_LOGIN) {
        this.AD_LOGIN = AD_LOGIN;
        return this;
    }

    public String getAD_USER_ONLY() {
        return AD_USER_ONLY;
    }

    public Adgang setAD_USER_ONLY(String AD_USER_ONLY) {
        this.AD_USER_ONLY = AD_USER_ONLY;
        return this;
    }

    public String getFGAC() {
        return FGAC;
    }

    public Adgang setFGAC(String FGAC) {
        this.FGAC = FGAC;
        return this;
    }

    public int getSTART_SEL() {
        return START_SEL;
    }

    public Adgang setSTART_SEL(int START_SEL) {
        this.START_SEL = START_SEL;
        return this;
    }

    public String getUTS_ADMIN() {
        return UTS_ADMIN;
    }

    public Adgang setUTS_ADMIN(String UTS_ADMIN) {
        this.UTS_ADMIN = UTS_ADMIN;
        return this;
    }

    public String getUTS_GROUP() {
        return UTS_GROUP;
    }

    public Adgang setUTS_GROUP(String UTS_GROUP) {
        this.UTS_GROUP = UTS_GROUP;
        return this;
    }

    public int getUTS_LEVEL() {
        return UTS_LEVEL;
    }

    public Adgang setUTS_LEVEL(int UTS_LEVEL) {
        this.UTS_LEVEL = UTS_LEVEL;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adgang adgang = (Adgang) o;

        if (START_SEL != adgang.START_SEL) return false;
        if (UTS_LEVEL != adgang.UTS_LEVEL) return false;
        if (!VOR_REF.equals(adgang.VOR_REF)) return false;
        if (!ACCOUNTANT.equals(adgang.ACCOUNTANT)) return false;
        if (AD_LOGIN != null ? !AD_LOGIN.equals(adgang.AD_LOGIN) : adgang.AD_LOGIN != null) return false;
        if (AD_USER_ONLY != null ? !AD_USER_ONLY.equals(adgang.AD_USER_ONLY) : adgang.AD_USER_ONLY != null)
            return false;
        if (!FGAC.equals(adgang.FGAC)) return false;
        if (UTS_ADMIN != null ? !UTS_ADMIN.equals(adgang.UTS_ADMIN) : adgang.UTS_ADMIN != null) return false;
        return UTS_GROUP != null ? UTS_GROUP.equals(adgang.UTS_GROUP) : adgang.UTS_GROUP == null;
    }

    @Override
    public int hashCode() {
        int result = VOR_REF.hashCode();
        result = 31 * result + ACCOUNTANT.hashCode();
        result = 31 * result + (AD_LOGIN != null ? AD_LOGIN.hashCode() : 0);
        result = 31 * result + (AD_USER_ONLY != null ? AD_USER_ONLY.hashCode() : 0);
        result = 31 * result + FGAC.hashCode();
        result = 31 * result + START_SEL;
        result = 31 * result + (UTS_ADMIN != null ? UTS_ADMIN.hashCode() : 0);
        result = 31 * result + (UTS_GROUP != null ? UTS_GROUP.hashCode() : 0);
        result = 31 * result + UTS_LEVEL;
        return result;
    }

    @Override
    public String toString() {
        return "Adgang{" +
                "VOR_REF='" + VOR_REF + '\'' +
                ", ACCOUNTANT='" + ACCOUNTANT + '\'' +
                ", AD_LOGIN='" + AD_LOGIN + '\'' +
                ", AD_USER_ONLY='" + AD_USER_ONLY + '\'' +
                ", FGAC='" + FGAC + '\'' +
                ", START_SEL=" + START_SEL +
                ", UTS_ADMIN='" + UTS_ADMIN + '\'' +
                ", UTS_GROUP='" + UTS_GROUP + '\'' +
                ", UTS_LEVEL=" + UTS_LEVEL +
                '}';
    }
}
