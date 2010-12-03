package access;

public class Kill implements Comparable<Kill>, IAccess
    {
    Integer Id;
    Integer Time;

    boolean IsNoBody;
    boolean IsOffScreen;
    boolean IsNotByKillerDirectly;
    boolean IsVictimSexualDuringFilm;

    Stereotype Stereotype;
    Weapon Weapon;
    BodyPart BodyPart;
    CauseOfDeath CauseOfDeath;
    GoreLevel GoreLevel;
    Film Film;

    public boolean isIsNoBody() {
        return IsNoBody;
    }

    public void setIsNoBody(boolean IsNoBody) {
        this.IsNoBody = IsNoBody;
    }

    public boolean isIsNotByKillerDirectly() {
        return IsNotByKillerDirectly;
    }

    public void setIsNotByKillerDirectly(boolean IsNotByKillerDirectly) {
        this.IsNotByKillerDirectly = IsNotByKillerDirectly;
    }

    public boolean isIsOffScreen() {
        return IsOffScreen;
    }

    public void setIsOffScreen(boolean IsOffScreen) {
        this.IsOffScreen = IsOffScreen;
    }

    public boolean isIsVictimSexualDuringFilm() {
        return IsVictimSexualDuringFilm;
    }

    public void setIsVictimSexualDuringFilm(boolean IsVictimSexualDuringFilm) {
        this.IsVictimSexualDuringFilm = IsVictimSexualDuringFilm;
    }

    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer Time) {
        this.Time = Time;
    }

    public BodyPart getBodyPart() {
        return BodyPart;
    }

    public void setBodyPart(BodyPart BodyPart) {
        this.BodyPart = BodyPart;
    }

    public CauseOfDeath getCauseOfDeath() {
        return CauseOfDeath;
    }

    public void setCauseOfDeath(CauseOfDeath CauseOfDeath) {
        this.CauseOfDeath = CauseOfDeath;
    }

    public GoreLevel getGoreLevel() {
        return GoreLevel;
    }

    public void setGoreLevel(GoreLevel GoreLevel) {
        this.GoreLevel = GoreLevel;
    }

    public Stereotype getStereotype() {
        return Stereotype;
    }

    public void setStereotype(Stereotype Stereotype) {
        this.Stereotype = Stereotype;
    }

    public Weapon getWeapon() {
        return Weapon;
    }

    public void setWeapon(Weapon Weapon) {
        this.Weapon = Weapon;
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

    public int compareTo(Kill o) {
        if (getTime() < o.getTime())
            return -1;
        else if (getTime() == o.getTime())
            return 0;
        else
            return 1;
    }
    }
