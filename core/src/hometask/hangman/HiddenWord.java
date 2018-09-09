package hometask.hangman;

public class HiddenWord {

    private static final char PLACEHOLDER = '*';
    private String word;
    private String hiddenword;



    public static char getPLACEHOLDER() {
        return PLACEHOLDER;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHiddenword() {
        return hiddenword;
    }

    public void setHiddenword(String hiddenword) {
        this.hiddenword = hiddenword;
    }



}
