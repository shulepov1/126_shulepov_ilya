package Core;

import java.util.HashMap;

public class Contract {
    private final int date;
    private HashMap<Integer, Doc> docsList = new HashMap<Integer, Doc>();

    public Contract(int date) {
        this.date = date;
    }

    public void registerDocument(int sum, int number, DocType docType, int date){
        if (sum > 0 && number > 0 && String.valueOf(date).length() == 8) {
            docsList.put(number, new Doc(sum, docType, date));
        }
    }
    public int getDocumentsListSize(){
        return docsList.size();
    }
}
