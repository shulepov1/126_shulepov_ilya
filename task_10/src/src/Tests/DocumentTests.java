package Tests;
import org.junit.*;

public class DocumentTests extends Assert{
    @Test
    public void Create_CreateDocumentsList_ListSizeEqualsZero(){
        DocumentsList documentsList = DocumentsList.create();
        assertEquals(0, documentsList.getDocumentsCount());
    }
}
