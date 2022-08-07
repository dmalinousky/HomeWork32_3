import java.util.Arrays;
import java.util.Objects;

public class ID {
    private long IDnumber;

    public ID(long IDnumber) {
        this.IDnumber = IDnumber;
    }

    public ID() {
    }

    public long getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(long IDnumber) {
        this.IDnumber = IDnumber;
    }

    public static ID IDgenerator(TaxPayer taxPayer) {
        ID id = new ID();
        id.setIDnumber(taxPayer.hashCode());
        return id;
    }

    @Override
    public String toString() {
        return "\nID{" +
                "IDnumber='" + IDnumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ID)) return false;
        ID id = (ID) o;
        return IDnumber == id.IDnumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDnumber);
    }
}
