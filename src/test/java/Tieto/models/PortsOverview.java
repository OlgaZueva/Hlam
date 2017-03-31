package Tieto.models;

import java.util.Date;

/**
 * Created by zuevaolg on 27.03.2017.
 */
public class PortsOverview {
    private String LocationCode;
    private String Liner;
    private String LinerAssistant;
    private String DestinationRegion;
    private String TradeNameGVAStyleForEMEDstatistic;
    private String LANDLOCKEDCountry;
    private String AgencyRegion;
    private String AgencyCode;
    private String CTSTier5;
    private String CTSTier4;
    private String USPiersUSPORT;
    private String USPiersULTCODE;
    private String DKEXPTEAM;
    private String DeepseaFlag;
    private String VALID_FROM;

    public PortsOverview(String LocationCode, String Liner, String LinerAssistant, String DestinationRegion,
                         String TradeNameGVAStyleForEMEDstatistic, String LANDLOCKEDCountry, String AgencyRegion,
                         String AgencyCode, String CTSTier5, String CTSTier4, String USPiersUSPORT,
                         String USPiersULTCODE, String DKEXPTEAM, String DeepseaFlagForFeederDailyBookingPurpose,
                         String VALID_FROM) {
        this.LocationCode = LocationCode;
        this.Liner = Liner;
        this.LinerAssistant = LinerAssistant;
        this.DestinationRegion = DestinationRegion;
        this.TradeNameGVAStyleForEMEDstatistic = TradeNameGVAStyleForEMEDstatistic;
        this.LANDLOCKEDCountry = LANDLOCKEDCountry;
        this.AgencyRegion = AgencyRegion;
        this.AgencyCode = AgencyCode;
        this.CTSTier5 = CTSTier5;
        this.CTSTier4 = CTSTier4;
        this.USPiersUSPORT = USPiersUSPORT;
        this.USPiersULTCODE = USPiersULTCODE;
        this.DKEXPTEAM = DKEXPTEAM;
        this.DeepseaFlag = DeepseaFlagForFeederDailyBookingPurpose;
        this.VALID_FROM = VALID_FROM;

    }


    public String getLocationCode() {
        return LocationCode;
    }

    public void setLocationCode(String locationCode) {
        LocationCode = locationCode;
    }

    public String getLiner() {
        return Liner;
    }

    public void setLiner(String liner) {
        Liner = liner;
    }

    public String getLinerAssistant() {
        return LinerAssistant;
    }

    public void setLinerAssistant(String linerAssistant) {
        LinerAssistant = linerAssistant;
    }

    public String getDestinationRegion() {
        return DestinationRegion;
    }

    public void setDestinationRegion(String destinationRegion) {
        DestinationRegion = destinationRegion;
    }

    public String getTradeNameGVAStyleForEMEDstatistic() {
        return TradeNameGVAStyleForEMEDstatistic;
    }

    public void setTradeNameGVAStyleForEMEDstatistic(String tradeNameGVAStyleForEMEDstatistic) {
        TradeNameGVAStyleForEMEDstatistic = tradeNameGVAStyleForEMEDstatistic;
    }

    public String getLANDLOCKEDCountry() {
        return LANDLOCKEDCountry;
    }

    public void setLANDLOCKEDCountry(String LANDLOCKEDCountry) {
        this.LANDLOCKEDCountry = LANDLOCKEDCountry;
    }

    public String getAgencyRegion() {
        return AgencyRegion;
    }

    public void setAgencyRegion(String agencyRegion) {
        AgencyRegion = agencyRegion;
    }

    public String getAgencyCode() {
        return AgencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        AgencyCode = agencyCode;
    }

    public String getCTSTier5() {
        return CTSTier5;
    }

    public void setCTSTier5(String CTSTier5) {
        this.CTSTier5 = CTSTier5;
    }

    public String getCTSTier4() {
        return CTSTier4;
    }

    public void setCTSTier4(String CTSTier4) {
        this.CTSTier4 = CTSTier4;
    }

    public String getUSPiersUSPORT() {
        return USPiersUSPORT;
    }

    public void setUSPiersUSPORT(String USPiersUSPORT) {
        this.USPiersUSPORT = USPiersUSPORT;
    }

    public String getUSPiersULTCODE() {
        return USPiersULTCODE;
    }

    public void setUSPiersULTCODE(String USPiersULTCODE) {
        this.USPiersULTCODE = USPiersULTCODE;
    }

    public String getDKEXPTEAM() {
        return DKEXPTEAM;
    }

    public void setDKEXPTEAM(String DKEXPTEAM) {
        this.DKEXPTEAM = DKEXPTEAM;
    }

    public String getDeepseaFlag() {
        return DeepseaFlag;
    }

    public void setDeepseaFlag(String deepseaFlag) {
        DeepseaFlag = deepseaFlag;
    }

    public String getVALID_FROM() {
        return VALID_FROM;
    }

    public void setVALID_FROM(String VALID_FROM) {
        this.VALID_FROM = VALID_FROM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortsOverview that = (PortsOverview) o;

        if (LocationCode != null ? !LocationCode.equals(that.LocationCode) : that.LocationCode != null) return false;
        if (Liner != null ? !Liner.equals(that.Liner) : that.Liner != null) return false;
        if (LinerAssistant != null ? !LinerAssistant.equals(that.LinerAssistant) : that.LinerAssistant != null)
            return false;
        if (DestinationRegion != null ? !DestinationRegion.equals(that.DestinationRegion) : that.DestinationRegion != null)
            return false;
        if (TradeNameGVAStyleForEMEDstatistic != null ? !TradeNameGVAStyleForEMEDstatistic.equals(that.TradeNameGVAStyleForEMEDstatistic) : that.TradeNameGVAStyleForEMEDstatistic != null)
            return false;
        if (LANDLOCKEDCountry != null ? !LANDLOCKEDCountry.equals(that.LANDLOCKEDCountry) : that.LANDLOCKEDCountry != null)
            return false;
        if (AgencyRegion != null ? !AgencyRegion.equals(that.AgencyRegion) : that.AgencyRegion != null) return false;
        if (AgencyCode != null ? !AgencyCode.equals(that.AgencyCode) : that.AgencyCode != null) return false;
        if (CTSTier5 != null ? !CTSTier5.equals(that.CTSTier5) : that.CTSTier5 != null) return false;
        if (CTSTier4 != null ? !CTSTier4.equals(that.CTSTier4) : that.CTSTier4 != null) return false;
        if (USPiersUSPORT != null ? !USPiersUSPORT.equals(that.USPiersUSPORT) : that.USPiersUSPORT != null)
            return false;
        if (USPiersULTCODE != null ? !USPiersULTCODE.equals(that.USPiersULTCODE) : that.USPiersULTCODE != null)
            return false;
        if (DKEXPTEAM != null ? !DKEXPTEAM.equals(that.DKEXPTEAM) : that.DKEXPTEAM != null) return false;
        if (DeepseaFlag != null ? !DeepseaFlag.equals(that.DeepseaFlag) : that.DeepseaFlag != null) return false;
        return VALID_FROM != null ? VALID_FROM.equals(that.VALID_FROM) : that.VALID_FROM == null;
    }

    @Override
    public int hashCode() {
        int result = LocationCode != null ? LocationCode.hashCode() : 0;
        result = 31 * result + (Liner != null ? Liner.hashCode() : 0);
        result = 31 * result + (LinerAssistant != null ? LinerAssistant.hashCode() : 0);
        result = 31 * result + (DestinationRegion != null ? DestinationRegion.hashCode() : 0);
        result = 31 * result + (TradeNameGVAStyleForEMEDstatistic != null ? TradeNameGVAStyleForEMEDstatistic.hashCode() : 0);
        result = 31 * result + (LANDLOCKEDCountry != null ? LANDLOCKEDCountry.hashCode() : 0);
        result = 31 * result + (AgencyRegion != null ? AgencyRegion.hashCode() : 0);
        result = 31 * result + (AgencyCode != null ? AgencyCode.hashCode() : 0);
        result = 31 * result + (CTSTier5 != null ? CTSTier5.hashCode() : 0);
        result = 31 * result + (CTSTier4 != null ? CTSTier4.hashCode() : 0);
        result = 31 * result + (USPiersUSPORT != null ? USPiersUSPORT.hashCode() : 0);
        result = 31 * result + (USPiersULTCODE != null ? USPiersULTCODE.hashCode() : 0);
        result = 31 * result + (DKEXPTEAM != null ? DKEXPTEAM.hashCode() : 0);
        result = 31 * result + (DeepseaFlag != null ? DeepseaFlag.hashCode() : 0);
        result = 31 * result + (VALID_FROM != null ? VALID_FROM.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PortsOverview{" +
                "LocationCode='" + LocationCode + '\'' +
                ", Liner='" + Liner + '\'' +
                ", LinerAssistant='" + LinerAssistant + '\'' +
                ", DestinationRegion='" + DestinationRegion + '\'' +
                ", TradeNameGVAStyleForEMEDstatistic='" + TradeNameGVAStyleForEMEDstatistic + '\'' +
                ", LANDLOCKEDCountry='" + LANDLOCKEDCountry + '\'' +
                ", AgencyRegion='" + AgencyRegion + '\'' +
                ", AgencyCode='" + AgencyCode + '\'' +
                ", CTSTier5='" + CTSTier5 + '\'' +
                ", CTSTier4='" + CTSTier4 + '\'' +
                ", USPiersUSPORT='" + USPiersUSPORT + '\'' +
                ", USPiersULTCODE='" + USPiersULTCODE + '\'' +
                ", DKEXPTEAM='" + DKEXPTEAM + '\'' +
                ", DeepseaFlag='" + DeepseaFlag + '\'' +
                ", VALID_FROM=" + VALID_FROM +
                '}';
    }
}
