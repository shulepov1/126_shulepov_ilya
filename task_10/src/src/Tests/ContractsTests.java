package Tests;
import org.junit.*;
import Core.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ContractsTests extends Assert{
    @Test
    public void create_CreateContractsList_ContractsListSizeEqualsZero(){
        ContractManager contractsList = ContractManager.create();
        assertEquals(0, contractsList.getContractsCount());
    }
    @Test
    public void addContract_AddContractWithNumberAndDate_ContractsListSizeEqualsOne(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract(1, 20220101);
        contractsList.addContract(null, 20220101);
        assertEquals(1, contractsList.getContractsCount());
    }
    @Test
    public void registerDocument_RegisterDocumentToContract_DocumentRegistered(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract(1, 20220101);
        contractsList.addContract(2, 20770202);
        contractsList.registerDocument(1, 1, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(222, 1, DocType.PaymentOrder, 2, 20770202);
        assertEquals(1, contractsList.getContractsList().get(1).getDocumentsListSize());
        assertEquals(1, contractsList.getContractsList().get(2).getDocumentsListSize());
    }
    @Test
    public void getSum_getSumOfPaymentsOfSpecificContract_sumEqualsZero(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract(1, 20220101);
        assertEquals(0, contractsList.getContractsList().get(1).getSumOfPayments());
    }
    @Test
    public void getSum_getSumOfPaymentsOfSpecificContract_sumEquals1000(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract(1, 20220101);
        contractsList.registerDocument(500, 1, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(500, 1, DocType.BankOrder, 1, 20220101);
        contractsList.addContract(2, 20220101);
        contractsList.registerDocument(999, 1, DocType.BankOrder, 2, 20220101);
        contractsList.registerDocument(1, 1, DocType.BankOrder, 2, 20220101);
        assertEquals(1000, contractsList.getContractsList().get(1).getSumOfPayments());
        assertEquals(1000, contractsList.getContractsList().get(2).getSumOfPayments());
    }
    @Test
    public void deletePayment_deletePayment_AmountOfPaymentsEqualsZero(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract(1, 20220101);
        contractsList.registerDocument(500, 1, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(133, 2, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(333, 3, DocType.BankOrder, 1, 20220101);

        contractsList.getContractsList().get(1).deletePayment(1, 1, 20220101);
        contractsList.getContractsList().get(1).deletePayment(2, 1, 20220101);
        contractsList.getContractsList().get(1).deletePayment(3, 1, 20220101);
        assertEquals(0, contractsList.getContractsList().get(1).getAmountOfPayments());
    }
    @Test
    public void deletePayment_deletePayment_AmountOfPaymentsEqualsTheRightNumber(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract(1, 20220101);
        contractsList.registerDocument(500, 1, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(133, 2, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(333, 3, DocType.BankOrder, 1, 20220101);

        contractsList.addContract(2, 20220101);
        contractsList.registerDocument(11, 1, DocType.BankOrder, 2, 20220101);
        contractsList.registerDocument(22, 2, DocType.BankOrder, 2, 20220101);
        contractsList.registerDocument(33, 3, DocType.BankOrder, 2, 20220101);

        contractsList.getContractsList().get(1).deletePayment(1, 1, 20220101);
        assertEquals(2, contractsList.getContractsList().get(1).getAmountOfPayments());

        contractsList.getContractsList().get(2).deletePayment(3, 1, 20220101);
        contractsList.getContractsList().get(2).deletePayment(1, 1, 20220101);
        assertEquals(1, contractsList.getContractsList().get(2).getAmountOfPayments());
    }
    @Test
    public void getPayments_getListOfPaymentsOfSpecificContract_gotListOfPayments(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract(1, 20220101);
        contractsList.registerDocument(11, 1, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(22, 2, DocType.BankOrder, 1, 20220101);
        contractsList.registerDocument(33, 3, DocType.BankOrder, 1, 20220101);

        ArrayList<Integer> pays = new ArrayList<>();
        pays.add(11);
        pays.add(22);
        pays.add(33);

        assertEquals(pays, contractsList.getContractsList().get(1).getListOfPayments());
    }
}
