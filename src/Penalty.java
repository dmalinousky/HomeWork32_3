import java.util.ArrayList;
import java.util.Date;

public class Penalty extends ArrayList {
    private PenaltyType type;
    private double size;
    private Date date;

    public Penalty(PenaltyType type, Double size, Date date) {
        this.type = type;
        this.size = size;
        this.date = date;
    }

    public Penalty() {}

    public PenaltyType getType() {
        return type;
    }

    public void setType(PenaltyType type) {
        this.type = type;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Penalty{" +
                "type=" + type +
                ", size=" + size +
                ", date=" + date +
                '}';
    }
}
