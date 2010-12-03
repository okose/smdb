package access;

public class NudityShot implements Comparable<NudityShot>, IAccess
    {
    Integer Id;
    Integer Time;

    String Type;
    private int versionID;
        // For detecting concurrency issues.

    Stereotype Stereotype;
    Film Film;

    public int getSeverity() {
        String str = getType();
        if (str.compareTo("Full Frontal") == 0)
            return 3;
        else if (str.compareTo("Breasts") == 0)
            return 2;
        else // "Almost" is the other string.
            return 1;
    }

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer Time) {
        this.Time = Time;
    }

    public Stereotype getStereotype() {
        return Stereotype;
    }

    public void setStereotype(Stereotype Stereotype) {
        this.Stereotype = Stereotype;
    }
    //Integer FilmNumber;

    public Film getFilm() {
        return Film;
    }

    public void setFilm(Film Film) {
        this.Film = Film;
    }

    public Integer getFilmNumber() {
        return Film.getNumberInTheSeries();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    // This one doesn't matter.
    public String printKey() {
        String lStr = getId().toString();
        return lStr;
    }

    public int compareTo(NudityShot o) {
        if (getTime() < o.getTime())
            return -1;
        else if (getTime() == o.getTime())
            return 0;
        else
            return 1;
    }
    }
