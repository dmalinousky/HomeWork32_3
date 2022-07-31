import java.util.Arrays;

public class TaxPayer {
    private String[] name;
    private String city;
    private Penalty[] penaltyList;

    public TaxPayer(String[] name, String city, Penalty[] penaltyList) {
        this.name = name;
        this.city = city;
        this.penaltyList = penaltyList;
    }

    public TaxPayer() {}

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Penalty[] getPenaltyList() {
        return penaltyList;
    }

    public void setPenaltyList(Penalty[] penaltyList) {
        this.penaltyList = penaltyList;
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "name=" + Arrays.toString(name) +
                ", city='" + city + '\'' +
                ", penaltyList=" + Arrays.toString(penaltyList) +
                '}';
    }
}
