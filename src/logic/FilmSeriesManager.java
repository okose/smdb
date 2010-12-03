package logic;

import access.Film;
import access.FilmSeries;
import java.io.Serializable;
import java.util.*;
import org.hibernate.Query;

public class FilmSeriesManager extends IFilmSeriesLogic {


    public int countRuntime(Serializable aKey) {
        openSession();
        int lOut = 0;
        access.FilmSeries object = (FilmSeries)fCurrentSession.get(FilmSeries.class, aKey);
        for (access.Film obj : object.getFilms())
            lOut+=obj.getRuntime();
        closeSession(object);
        return lOut;
    }

    public void setTitle(Serializable aKey, String aQuery) {
        openSession();
        access.FilmSeries object = (FilmSeries)fCurrentSession.get(FilmSeries.class, aKey);
        object.setTitle(aQuery);
        closeSession(object);
    }
    public void setKiller(Serializable aKey, String aQuery) throws RuntimeException {
        openSession();
        access.FilmSeries object = (FilmSeries)fCurrentSession.get(FilmSeries.class, aKey);
        object.setKiller(aQuery);
        closeSession(object);
    }
    public void setKillerConcurrently(Serializable aKey, String aQuery) {
        openSession();
        access.FilmSeries object = (FilmSeries)fCurrentSession.get(FilmSeries.class, aKey);

        // As a test, make a new session for an object already opened in a session.
        setKiller(aKey, "UPDATING A READ CLASS (NOW STALE)");

        closeSession(object);
    }
    public void setDominantTheme(Serializable aKey, String aQuery) {
        openSession();
        access.FilmSeries object = (FilmSeries)fCurrentSession.get(FilmSeries.class, aKey);
        object.setDominantTheme(aQuery);
        closeSession(object);
    }


    public String getYearRange(Serializable aKey) {
        openSession();
        access.FilmSeries object = (FilmSeries)fCurrentSession.get(FilmSeries.class, aKey);
        closeSession(object);
        List<Film> lKL = new ArrayList<Film>(object.getFilms());
        Collections.sort(lKL);


        return (lKL.isEmpty())? "" : new Integer(lKL.get(0).getYear()).toString() + " to "
                + new Integer(lKL.get(lKL.size()-1).getYear()).toString();
    }

    public List<Film> getFilms(Serializable aKey) {
        openSession();
        access.FilmSeries object = (FilmSeries)fCurrentSession.get(FilmSeries.class, aKey);
        closeSession(object);
        List<Film> lKL = new ArrayList<Film>(object.getFilms());
        Collections.sort(lKL);

        return lKL;
    }

    public String printFilms(String aQuery) {
        openSession();
        String lOut = "";
        access.FilmSeries object = (FilmSeries)fCurrentSession.get(FilmSeries.class, aQuery);
        lOut += object.getTitle();
        lOut += "<br/>";
        for (access.Film film : object.getFilmsOrdered())
            lOut += "    " + film.printKey() + "<br/>";
            // To close the session with.
        closeSession(object);
        return lOut;
    }

    public void insert(Serializable aKey) {
        openSession();
        access.FilmSeries object = new FilmSeries();
        object.setTitle(aKey.toString());
            // Key is just a string for filmSeries.
        closeSession(object);
    }
    
    public access.IAccess get(Serializable aKey) {
        return (FilmSeries)fCurrentSession.get(FilmSeries.class, aKey);
    }

    @Override
    public void addFilm(Serializable aKey, Serializable aOtherKey) {
        openSession();
        FilmSeries object = (FilmSeries)fCurrentSession.get(FilmSeries.class, aKey);
        access.Film objectFilm = (Film)fCurrentSession.get(Film.class, aOtherKey);
        
        object.getFilms().add(objectFilm);
        // bi-directional now.
        objectFilm.setFilmSeries(object);
            // Key is just a string for filmSeries.
        closeSession(object);
    }

    @Override
    public List getAll() {
        openSession();String hql = "from FilmSeries f order by f.Title";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        return lList;
        }


}