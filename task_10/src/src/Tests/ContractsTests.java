package Tests;
import org.junit.*;
import Core.*;

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
        contractsList.registerDocument(100, 1, "DocumentType", 1, 20220101);
        assertEquals(1, contractsList.getContractsList().get(1).getDocumentsListSize());
    }
}
