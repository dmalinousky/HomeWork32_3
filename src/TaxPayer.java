import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaxPayer {
    private ArrayList<String> name;
    private String city;
    private ArrayList<Penalty> penaltyList;

    public TaxPayer(ArrayList<String> name, String city, ArrayList<Penalty> penaltyList) {
        this.name = name;
        this.city = city;
        this.penaltyList = penaltyList;
    }

    public TaxPayer() {
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Penalty> getPenaltyList() {
        return penaltyList;
    }

    public void setPenaltyList(ArrayList<Penalty> penaltyList) {
        this.penaltyList = penaltyList;
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "name=" + name +
                ", city='" + city + '\'' +
                ", penaltyList=" + penaltyList +
                '}';
    }

    // Menu interface
    public static void menuBar(HashMap<ID, TaxPayer> dataBase) throws Exception {
        try {
            System.out.println("""
                Enter what you want to do:
                1. Print data.
                2. Add new penalty.
                3. Delete penalty.
                4. Change the data.
                5. Exit.""");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    TaxPayer.printInfo(dataBase);
                    menuBar(dataBase);
                    break;
                case 2:
                    addPenalty(dataBase);
                    menuBar(dataBase);
                    break;
                case 3:
                    deletePenalty(dataBase);
                    menuBar(dataBase);
                    break;
                case 4:
                    changeMethod(dataBase);
                    menuBar(dataBase);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Error! Try again!");
            menuBar(dataBase);
        }
    }

    // If-exists check
    public static Long ifExists(HashMap<ID, TaxPayer> dataBase) throws Exception {
        System.out.println("Provide person's id:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ID tempID = new ID();
        tempID.setIDnumber(Long.parseLong(reader.readLine()));
        Long[] idFound = new Long[]{null};
        dataBase.entrySet().forEach(x -> {
            if (x.getKey().getIDnumber() == tempID.getIDnumber()) {
                idFound[0] = tempID.getIDnumber();
            }
        });
        return idFound[0];
    }

    // Print method
    public static void printInfo(HashMap<ID, TaxPayer> dataBase) throws Exception {
        try {
            System.out.println("""
                Enter what you want to print:
                1. Print all database.
                2. Print data by person.
                3. Print data by city.
                4. Print data by penalty type.
                5. Exit to main menu.""");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    System.out.println(Arrays.toString(dataBase.entrySet().toArray()));
                    break;
                case 2:
                    Long id = TaxPayer.ifExists(dataBase);
                    if (id != null) {
                        dataBase.entrySet().forEach(x -> {
                            if (x.getKey().getIDnumber() == id.longValue()) {
                                System.out.println(x.getValue().toString());
                            }
                        });
                    }
                    break;
                case 3:
                    System.out.println("Provide city:");
                    String tempCity = reader.readLine();
                    dataBase.entrySet().forEach(x -> {
                        if (x.getValue().getCity().equals(tempCity)) {
                            System.out.println(x.getValue().toString());
                        }
                    });
                    break;
                case 4:
                    System.out.println("""
                        Choose penalty type:
                        1. Late payment.
                        2. Incorrect tax data.
                        3. Just 4 fun.""");
                    int penaltyChoice = Integer.parseInt(reader.readLine());
                    switch (penaltyChoice) {
                        case 1:
                            dataBase.entrySet().forEach(x -> {
                                for (int i = 0; i < x.getValue().getPenaltyList().size(); i++) {
                                    if (x.getValue().getPenaltyList().get(i).getType().equals(PenaltyType.LATE_PAYMENT)) {
                                        System.out.println(x.getValue().toString());
                                    }
                                }
                            });
                            break;
                        case 2:
                            dataBase.entrySet().forEach(x -> {
                                for (int i = 0; i < x.getValue().getPenaltyList().size(); i++) {
                                    if (x.getValue().getPenaltyList().get(i).getType().equals(PenaltyType.INCORRECT_TAX_DATA)) {
                                        System.out.println(x.getValue().toString());
                                    }
                                }
                            });
                            break;
                        case 3:
                            dataBase.entrySet().forEach(x -> {
                                for (int i = 0; i < x.getValue().getPenaltyList().size(); i++) {
                                    if (x.getValue().getPenaltyList().get(i).getType().equals(PenaltyType.JUST_BECAUSE)) {
                                        System.out.println(x.getValue().toString());
                                    }
                                }
                            });
                            break;
                    }
                    break;
                case 5:
                    menuBar(dataBase);
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Error! Try again!");
            menuBar(dataBase);
        }
    }

    public static void addPenalty(HashMap<ID, TaxPayer> dataBase) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Long id = TaxPayer.ifExists(dataBase);
        if (id != null) {
            dataBase.entrySet().forEach(x -> {
                if (x.getKey().getIDnumber() == id.longValue()) {
                    System.out.println(x.getValue().toString());
                    try {
                        if (x.getValue().getPenaltyList() != null) {
                            x.getValue().getPenaltyList().add(penaltyCreator());
                        } else {
                            ArrayList<Penalty> newTaxPayerPenaltyList = new ArrayList<>();
                            newTaxPayerPenaltyList.add(penaltyCreator());
                            x.getValue().setPenaltyList(newTaxPayerPenaltyList);
                        }
                    } catch (Exception exception) {
                        System.out.println("Error!");
                    }
                    System.out.println(x.getValue().toString());
                }
            });
        }
    }

    public static void deletePenalty(HashMap<ID, TaxPayer> dataBase) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Long id = TaxPayer.ifExists(dataBase);
        if (id != null) {
            dataBase.entrySet().forEach(x -> {
                if (x.getKey().getIDnumber() == id.longValue()) {
                    System.out.println(x.getValue().toString());
                    System.out.println("Which penalty you want to delete?");
                    try {
                        int penaltyNumber = Integer.parseInt(reader.readLine());
                        if (x.getValue().getPenaltyList() != null) {
                            x.getValue().getPenaltyList().remove(penaltyNumber);
                            System.out.println(x.getValue().toString());
                        } else {
                            System.out.println("There's nothing to delete.");
                            menuBar(dataBase);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void changeMethod(HashMap<ID, TaxPayer> dataBase) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("""
                What changes you want to apply:
                1. Create a new tax-payer.
                2. Change last, first or father's name.
                3. Change the city.
                4. Change penalty data.
                5. Exit to previous menu.
                """);
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    TaxPayer taxPayer = taxPayerCreator();
                    dataBase.put(ID.IDgenerator(taxPayer), taxPayer);
                    menuBar(dataBase);
                    break;
                case 2:
                    Long idForName = TaxPayer.ifExists(dataBase);
                    if (idForName != null) {
                        dataBase.entrySet().forEach(x -> {
                            if (x.getKey().getIDnumber() == idForName.longValue()) {
                                try {
                                    x.getValue().setName(nameChanger(x.getValue()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    menuBar(dataBase);
                    break;
                case 3:
                    Long idForCity = TaxPayer.ifExists(dataBase);
                    if (idForCity != null) {
                        dataBase.entrySet().forEach(x -> {
                            if (x.getKey().getIDnumber() == idForCity.longValue()) {
                                try {
                                    x.getValue().setCity(cityChanger(x.getValue()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    menuBar(dataBase);
                    break;
                case 4:
                    Long idForPenalty = TaxPayer.ifExists(dataBase);
                    if (idForPenalty != null) {
                        dataBase.entrySet().forEach(x -> {
                            if (x.getKey().getIDnumber() == idForPenalty.longValue()) {
                                try {
                                    x.getValue().setPenaltyList(penaltyChanger(x.getValue()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    menuBar(dataBase);
                    break;
                case 5 :
                    menuBar(dataBase);
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Error! Try again!");
            menuBar(dataBase);
        }
    }

    public static TaxPayer taxPayerCreator() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TaxPayer newTaxPayer = new TaxPayer();

        ArrayList<String> taxPayerName = new ArrayList<>();
        System.out.println("Provide last, first and father's name using \" \" (space):");
        String[] nameInString = reader.readLine().split(" ");
        taxPayerName.addAll(Arrays.stream(nameInString).toList());
        newTaxPayer.setName(taxPayerName);

        System.out.println("Enter the city:");
        newTaxPayer.setCity(reader.readLine());

        return newTaxPayer;
    }

    public static Penalty penaltyCreator() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Penalty penalty = new Penalty();
        System.out.println("""
                Adding new penalty. Choose penalty type:
                1. Late payment.
                2. Incorrect tax data.
                3. Just 4 fun.""");
        int penaltyType = Integer.parseInt(reader.readLine());
        switch (penaltyType) {
            case 1:
                penalty.setType(PenaltyType.LATE_PAYMENT);
                break;
            case 2:
                penalty.setType(PenaltyType.INCORRECT_TAX_DATA);
                break;
            case 3:
                penalty.setType(PenaltyType.JUST_BECAUSE);
                break;
        }
        System.out.println("Enter the size of penalty:");
        penalty.setSize(Double.parseDouble(reader.readLine()));
        penalty.setDate(Calendar.getInstance().getTime());

        return penalty;
    }

    public static ArrayList<String> nameChanger(TaxPayer taxPayer) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> newlffName = taxPayer.getName();
        System.out.println("""
                What do you want to change?
                1. Last name.
                2. First name.
                3. Father's name.""");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice) {
            case 1:
                System.out.println("Provide new last name:");
                newlffName.set(0, reader.readLine());
                break;
            case 2:
                System.out.println("Provide new first name:");
                newlffName.set(1, reader.readLine());
                break;
            case 3:
                System.out.println("Provide new father's name:");
                newlffName.set(2, reader.readLine());
                break;
        }
        return newlffName;
    }

    public static String cityChanger(TaxPayer taxPayer) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Provide new city title:");
        taxPayer.setCity(reader.readLine());
        return taxPayer.getCity();
    }

    public static ArrayList<Penalty> penaltyChanger(TaxPayer taxPayer) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Penalty> newPenaltyList = taxPayer.getPenaltyList();
        System.out.println(newPenaltyList.toString());
        System.out.println("Which penalty you want to change:");
        int penaltyNumber = Integer.parseInt(reader.readLine());
        System.out.println("""
                What do you want to change?
                1. Type.
                2. Size.""");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice) {
            case 1:
                System.out.println("""
                        Provide type:
                        1. Late payment.
                        2. Incorrect data.
                        3. Just 4 fun.""");
                int newType = Integer.parseInt(reader.readLine());
                switch (newType) {
                    case 1:
                        taxPayer.getPenaltyList().get(penaltyNumber).setType(PenaltyType.LATE_PAYMENT);
                        break;
                    case 2:
                        taxPayer.getPenaltyList().get(penaltyNumber).setType(PenaltyType.INCORRECT_TAX_DATA);
                        break;
                    case 3:
                        taxPayer.getPenaltyList().get(penaltyNumber).setType(PenaltyType.JUST_BECAUSE);
                        break;
                }
                break;
            case 2:
                System.out.println("Provide new size:");
                double newSize = Double.parseDouble(reader.readLine());
                taxPayer.getPenaltyList().get(penaltyNumber).setSize(newSize);
                break;
        }
        return newPenaltyList;
    }
}
