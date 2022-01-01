package Core;

public class DocumentsList {
    private int listSizeCount;
    private DocumentsList(){
        listSizeCount = 0;
    }

    public void addDocument(String number, String date){
        listSizeCount++;
    }

    public static DocumentsList create(){
        return new DocumentsList();
    }

    public int getDocumentsCount(){
        return listSizeCount;
    }
}
