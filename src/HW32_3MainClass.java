import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HW32_3MainClass {
    public static void main(String[] args) throws Exception {

        // PLEASE DO NOT ESTIMATE THIS TASK UNTIL 07.07.2022

        HashMap<ID, TaxPayer> dataBase = new HashMap<>();

        TaxPayer taxPayer1 = new TaxPayer();
        ArrayList<String> taxPayer1Name = new ArrayList<>();
        taxPayer1Name.add("Ivanov");
        taxPayer1Name.add("Ivan");
        taxPayer1Name.add("Ivanovich");
        taxPayer1.setName(taxPayer1Name);
        taxPayer1.setCity("Minsk");
        Penalty taxPayer1Penalty = new Penalty();
        taxPayer1Penalty.setType(PenaltyType.LATE_PAYMENT);
        taxPayer1Penalty.setSize(1000d);
        taxPayer1Penalty.setDate(new Date(2000, Calendar.MARCH, 12));
        ArrayList<Penalty> taxPayer1PenaltyList = new ArrayList<>();
        taxPayer1PenaltyList.add(taxPayer1Penalty);
        taxPayer1.setPenaltyList(taxPayer1PenaltyList);

        TaxPayer taxPayer2 = new TaxPayer();
        ArrayList<String> taxPayer2Name = new ArrayList<>();
        taxPayer2Name.add("Petrov");
        taxPayer2Name.add("Petr");
        taxPayer2Name.add("Petrovich");
        taxPayer2.setName(taxPayer2Name);
        taxPayer2.setCity("Grodno");
        Penalty taxPayer2Penalty = new Penalty();
        taxPayer2Penalty.setType(PenaltyType.JUST_BECAUSE);
        taxPayer2Penalty.setSize(2000d);
        taxPayer2Penalty.setDate(new Date(2001, Calendar.FEBRUARY, 28));
        ArrayList<Penalty> taxPayer2PenaltyList = new ArrayList<>();
        taxPayer2PenaltyList.add(taxPayer2Penalty);
        taxPayer2.setPenaltyList(taxPayer2PenaltyList);

        dataBase.put(ID.IDgenerator(taxPayer1), taxPayer1);
        dataBase.put(ID.IDgenerator(taxPayer2), taxPayer2);

        TaxPayer.menuBar(dataBase);
    }


}
