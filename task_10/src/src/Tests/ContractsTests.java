package Tests;
import org.junit.*;
import Core.*;

public class ContractsTests extends Assert{
    @Test
    public void create_CreateContract_ContractsListSizeEqualsZero(){
        ContractManager contract = ContractManager.create();
        assertEquals(0, contract.getContractsCount());
    }
    @Test
    public void addContract_AddContractWithNumberAndDate_ContractsListSizeEqualsOne(){
        ContractManager contractsList = ContractManager.create();
        contractsList.addContract("1", "20220101");
        contractsList.addContract(null, "20220101");
        assertEquals(2, contractsList.getContractsCount());
    }
}
