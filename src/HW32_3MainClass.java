import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class HW32_3MainClass {
    public static void main(String[] args) {

        // PLEASE DO NOT ESTIMATE THIS TASK UNTIL 07.07.2022

        HashMap<ID, TaxPayer> dataBase = new HashMap<>();

        TaxPayer taxPayer1 = new TaxPayer();
        taxPayer1.setName(new String[]{"Ivanov", "Ivan", "Ivanovich"});
        taxPayer1.setCity("Minsk");
        Penalty taxPayer1Penalty = new Penalty();
        taxPayer1Penalty.setType(PenaltyType.LATE_PAYMENT);
        taxPayer1Penalty.setSize(1000d);
        taxPayer1Penalty.setDate(new Date(2000, Calendar.MARCH, 12));
        taxPayer1.setPenaltyList(new Penalty[]{taxPayer1Penalty});

        TaxPayer taxPayer2 = new TaxPayer();
        taxPayer2.setName(new String[]{"Petrov", "Petr", "Petrovich"});
        taxPayer2.setCity("Grodno");
        Penalty taxPayer2Penalty = new Penalty();
        taxPayer2Penalty.setType(PenaltyType.JUST_BECAUSE);
        taxPayer2Penalty.setSize(2000d);
        taxPayer2Penalty.setDate(new Date(2001, Calendar.FEBRUARY, 28));
        taxPayer2.setPenaltyList(new Penalty[]{taxPayer2Penalty});

        dataBase.put(ID.IDgenerator(taxPayer1), taxPayer1);
        dataBase.put(ID.IDgenerator(taxPayer2), taxPayer2);

        System.out.println(Arrays.toString(dataBase.entrySet().toArray()));
    }
}
