package access;

public class Survival implements IAccess
    {
    Integer Id;

    Stereotype Stereotype;
    Film Film;
    private int versionID;
        // For detecting concurrency issues.

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
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
    }
