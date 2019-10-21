package Model;

public class Word {

    int Word_ID;
    int Word_key;
    String Word_Name;
    String Word_Mean;

    public Word(){

    }
    public Word(int Word_ID, String Word_Name, String Word_Mean){
        this.Word_ID = Word_ID;
        this.Word_Name = Word_Name;
        this.Word_Mean = Word_Mean;
    }
    public Word(String Word_Name, String Word_Mean, int Word_Key){
        this.Word_Name = Word_Name;
        this.Word_Mean = Word_Mean;
        this.Word_key = Word_Key;
    }
    public int getWord_key() {
        return Word_key;
    }

    public void setWord_key(int word_key) {
        Word_key = word_key;
    }
    public int getWord_ID() {
        return Word_ID;
    }

    public void setWord_ID(int word_ID) {
        Word_ID = word_ID;
    }

    public String getWord_Name() {
        return Word_Name;
    }

    public void setWord_Name(String word_Name) {
        Word_Name = word_Name;
    }

    public String getWord_Mean() {
        return Word_Mean;
    }

    public void setWord_Mean(String word_Mean) {
        Word_Mean = word_Mean;
    }
}
