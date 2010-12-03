package access;

public class GoreLevel implements IAccess
    {
    String Title;

    public int getSeverity() {
        String str = getTitle();
        if (str.compareTo("High") == 0)
            return 3;
        else if (str.compareTo("Medium") == 0)
            return 2;
        else // "Low" is the other string.
            return 1;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String printKey() {
        String lStr = getTitle();
        return lStr;
    }
    }
