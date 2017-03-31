package Tieto.models;

/**
 * Created by zuevaolg on 28.03.2017.
 */
public class CleanUp {

    private String blNumber;
    private String customer;
    private String validFrom;
    private String nvoBcoFrw;

    public CleanUp(String blNumber, String customer, String validFrom, String nvoBcoFrw) {
        this.blNumber = blNumber;
        this.customer = customer;
        this.validFrom = validFrom;
        this.nvoBcoFrw = nvoBcoFrw;
    }

    public String getBlNumber() {
        return blNumber;
    }

    public void setBlNumber(String blNumber) {
        this.blNumber = blNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getNvoBcoFrw() {
        return nvoBcoFrw;
    }

    public void setNvoBcoFrw(String nvoBcoFrw) {
        this.nvoBcoFrw = nvoBcoFrw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CleanUp cleanUp = (CleanUp) o;

        if (blNumber != null ? !blNumber.equals(cleanUp.blNumber) : cleanUp.blNumber != null) return false;
        if (customer != null ? !customer.equals(cleanUp.customer) : cleanUp.customer != null) return false;
        if (validFrom != null ? !validFrom.equals(cleanUp.validFrom) : cleanUp.validFrom != null) return false;
        return nvoBcoFrw != null ? nvoBcoFrw.equals(cleanUp.nvoBcoFrw) : cleanUp.nvoBcoFrw == null;
    }

    @Override
    public int hashCode() {
        int result = blNumber != null ? blNumber.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (validFrom != null ? validFrom.hashCode() : 0);
        result = 31 * result + (nvoBcoFrw != null ? nvoBcoFrw.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CleanUp{" +
                "blNumber='" + blNumber + '\'' +
                ", customer='" + customer + '\'' +
                ", validFrom='" + validFrom + '\'' +
                ", nvoBcoFrw='" + nvoBcoFrw + '\'' +
                '}';
    }
}
