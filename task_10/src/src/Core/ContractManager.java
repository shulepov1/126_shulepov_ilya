package Core;

import java.util.ArrayList;
import java.util.HashMap;

public class ContractManager {
    private HashMap<Integer, Contract> contractsList;

    public HashMap<Integer, Contract> getContractsList(){
        return contractsList;
    }

    private ContractManager(){
        contractsList = new HashMap<Integer, Contract>();
    }

    public void addContract(Integer number, Integer date){
        if (number != null) {
            contractsList.put(number, new Contract(date));
        }
    }

    public static ContractManager create(){
        return new ContractManager();
    }

    public int getContractsCount(){
        return contractsList.size();
    }

    public void registerDocument(int sum, int number, DocType docType, int contractNumber, int date){
        contractsList.get(contractNumber).registerDocument(sum, number, docType, date);
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
        for (int i = 0; i < pays.size(); i++){
            payments.addAll(pays.get(i));
        }
        return payments;
    }
}
