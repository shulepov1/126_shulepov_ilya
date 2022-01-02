package Core;

public class Doc {
    private int sum;
    private DocType docType;
    private int date;

    public Doc(int sum, DocType docType, int date){
        this.sum = sum;
        this.docType = docType;
        this.date = date;
    }

    public int getSum(){
        return sum;
    }
}
