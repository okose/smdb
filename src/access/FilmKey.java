package access;

import java.io.Serializable;


public class FilmKey implements Serializable {

    int NumberInTheSeries;
    String Title;

    public int getNumberInTheSeries() {
        return NumberInTheSeries;
    }

    public void setNumberInTheSeries(int num) {
        this.NumberInTheSeries = num;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String text) {
        this.Title = text;
    }

    public FilmKey(int aNum, String aText) {
        setNumberInTheSeries(aNum);
        setTitle(aText);
    }

    public FilmKey() {
    }


}
