package access;

public class CauseOfDeath implements IAccess
    {
    String Title;

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
