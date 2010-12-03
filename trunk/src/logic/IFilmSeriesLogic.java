package logic;

import java.io.Serializable;

public abstract class IFilmSeriesLogic extends ILogic {

    abstract public String printFilms(String aQuery);
    abstract public void setTitle(Serializable aKey, String aQuery);
    abstract public void setKiller(Serializable aKey, String aQuery);
    abstract public void setKillerConcurrently(Serializable aKey, String aQuery);
    abstract public void setDominantTheme(Serializable aKey, String aQuery);
    abstract public void addFilm(Serializable aKey, Serializable aOtherKey);

}
