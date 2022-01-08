package Core;

import java.util.ArrayList;
import java.util.HashMap;

public class Contract {
    private final int date;
    private int summary;
    private int count = 0;
    private HashMap<Integer, Doc> docsList = new HashMap<Integer, Doc>();

    public Contract(int date) {
        this.date = date;
    }

    public void registerDocument(int sum, int number, DocType docType, int date) throws Exception {
            if (sum > 0 && number > 0 && String.valueOf(date).length() == 8) {
                docsList.put(number, new Doc(sum, docType, date));
                summary = summary + sum;
                count++;
            }
            else {
                throw new Exception("Введённые данные некорректны.");
            }
    }

    public int getDocumentsListSize(){
        return docsList.size();
    }

    public int getSumOfPayments(){
        return summary;
    }

    public void deletePayment(int num) throws Exception{
        if (!docsList.containsKey(num)){
            throw new Exception ("Документа с таким номером не существует");
        }
        else {
            summary = summary - docsList.get(num).getSum();
            docsList.remove(num);
            count--;
            System.out.println("Платёж был успешно удалён");
        }
    }

    public int getAmountOfPayments(){
        return count;
    }

    public ArrayList<Integer> getListOfPayments(){
    ArrayList<Integer> pays = new ArrayList<>();
    for (Doc doc : docsList.values()) {
        pays.add(doc.getSum());
    }
    return pays;
    }
}
