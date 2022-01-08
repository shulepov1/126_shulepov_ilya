package Core;

import java.util.ArrayList;
import java.util.HashMap;

public class ContractManager {
    private HashMap<Integer, Contract> contractsList;

    public HashMap<Integer, Contract> getContractsList(){
        return contractsList;
    }

    private ContractManager(){
        contractsList = new HashMap<>();
    }

    public void addContract(Integer number, Integer date) throws Exception{
            if (contractsList.containsKey(number)) {
                throw new Exception("Договор с таким номером уже заключён");
            } else {
                if (number > 0 && String.valueOf(date).length() == 8) {
                    contractsList.put(number, new Contract(date));
                    System.out.println("Договор " + number + " был успешно заключён.");
                } else {
                    throw new Exception("Введённые данные некорректны.");
                }
            }
    }

    public static ContractManager create(){
        return new ContractManager();
    }

    public int getContractsCount(){
        return contractsList.size();
    }

    public void registerDocument(int sum, int number, DocType docType, int contractNumber, int date) throws Exception{
        if (contractsList.get(contractNumber).getListOfPayments().contains(number)) {
            throw new Exception("Документ с таким номером уже существует");
        }
        else {
            if (sum > 0 && number > 0 && contractNumber > 0 && String.valueOf(date).length() == 8) {
                contractsList.get(contractNumber).registerDocument(sum, number, docType, date);
                System.out.println(docType + " на сумму " + sum + " был успешно произведён");
            } else {
                throw new Exception("Введённые данные некоректны");
            }
        }
        System.out.println();
    }

    public HashMap<Integer, Integer> getListOfContractsWithPayments(){
        HashMap<Integer, Integer> cons = new HashMap<>();
        contractsList.forEach((k ,v ) -> cons.put(k , v.getSumOfPayments()));
        return cons;
    }

    public ArrayList<Integer> getListOfAllPayments(){
        ArrayList<ArrayList<Integer>> pays = new ArrayList<>();
        contractsList.forEach((k ,v ) -> pays.add(v.getListOfPayments()));
        ArrayList<Integer> payments = new ArrayList<>();
        for (ArrayList<Integer> pay : pays) {
            payments.addAll(pay);
        }
        return payments;
    }
}
