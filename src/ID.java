import java.util.Arrays;
import java.util.Locale;

public class ID {
    private String IDnumber;
    private static long additionalNumber = 0;

    public ID(String IDnumber, long number) {
        this.IDnumber = IDnumber;
        this.additionalNumber = number;
    }

    public ID() {}

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public long getAdditionalNumber() {
        return additionalNumber;
    }

    public void setAdditionalNumber(long number) {
        this.additionalNumber = number;
    }

    public static ID IDgenerator(TaxPayer taxPayer) {
        ID id = new ID();
        String tempName = Arrays.deepToString(taxPayer.getName()).replace("[", "").replace("]", "").replace(", ", "").toLowerCase();
        id.setIDnumber(tempName + id.getAdditionalNumber());
        additionalNumber++;
        return id;
    }

    @Override
    public String toString() {
        return "\nID{" +
                "IDnumber='" + IDnumber + '\'' +
                '}';
    }
}
