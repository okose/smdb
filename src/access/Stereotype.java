package access;

public class Stereotype implements IAccess
    {
    String Title;
    String DescriptionShort;
    String DescriptionLong;
    boolean IsOnlyOnePerFilm;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescriptionLong() {
        return DescriptionLong;
    }

    public void setDescriptionLong(String DescriptionLong) {
        this.DescriptionLong = DescriptionLong;
    }

    public String getDescriptionShort() {
        return DescriptionShort;
    }

    public void setDescriptionShort(String DescriptionShort) {
        this.DescriptionShort = DescriptionShort;
    }

    public boolean getIsOnlyOnePerFilm() {
        return IsOnlyOnePerFilm;
    }

    public void setIsOnlyOnePerFilm(boolean IsOnlyOnePerFilm) {
        this.IsOnlyOnePerFilm = IsOnlyOnePerFilm;
    }

    public String printKey() {
        String lStr = getTitle();
        return lStr;
    }
    }
