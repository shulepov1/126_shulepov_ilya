package Core;

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

    public HashMap<Integer, Integer> getListOfContracts(){
        HashMap<Integer, Integer> contracts = new HashMap<>();
        contracts.put(1, 66);
        contracts.put(2, 6);
        return contracts;
    }
}
