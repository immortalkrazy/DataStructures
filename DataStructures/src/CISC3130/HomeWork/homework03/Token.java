public class Token {

    private String fileName;
    private String word;
    private int place;

    public Token(String fileName, String word, int place) {
        super();
        this.fileName = fileName;
        this.word = word;
        this.place = place;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public int getPlace() {
        return place;
    }
    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {

        return "In file " + fileName + ", " + word + " is at position " + place + " \n";
    }



}
