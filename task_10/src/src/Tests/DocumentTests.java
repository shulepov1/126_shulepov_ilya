package Tests;
import org.junit.*;
import Core.*;

public class DocumentTests extends Assert{
    @Test
    public void create_CreateDocumentsList_ListSizeEqualsZero(){
        DocumentsList documentsList = DocumentsList.create();
        assertEquals(0, documentsList.getDocumentsCount());
    }
    @Test
    public void addDocument_AddDocumentWithNumberAndDate_ListSizeEqualsOne(){
        DocumentsList documentsList = DocumentsList.create();
        documentsList.addDocument("number", "date");
        assertEquals(1, documentsList.getDocumentsCount());
    }
}
