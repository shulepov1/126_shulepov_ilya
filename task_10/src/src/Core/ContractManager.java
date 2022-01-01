package Core;

import java.util.HashMap;

public class ContractManager {
    private HashMap<String, Contract> contractsList;

    private ContractManager(){
        contractsList = new HashMap<String, Contract>();
    }

    public void addContract(String number, String date){
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
}
