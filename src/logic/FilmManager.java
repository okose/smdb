package logic;

import access.*;
import java.io.Serializable;
import java.util.*;
import org.hibernate.Query;

public class FilmManager extends IFilmLogic {

    public String printTitle(Serializable aKey) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        closeSession(object);
        return object.getTitle();
    }

    public List<Survival> getSurvivals(Serializable aKey) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        closeSession(object);
        List<Survival> lKL = new ArrayList<Survival>(object.getSurvivals());

        return lKL;
    }

    public List<NudityShot> getNudityShots(Serializable aKey) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        closeSession(object);
        List<NudityShot> lKL = new ArrayList<NudityShot>(object.getNudityShots());
        Collections.sort(lKL);

        return lKL;
    }

    public List<Kill> getKills(Serializable aKey) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        closeSession(object);
        List<Kill> lKL = new ArrayList<Kill>(object.getKills());
        Collections.sort(lKL);
        
        return lKL;
    }

    public String printKills(Serializable aKey) {
        openSession();
        String lOut = "";
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        lOut += object.getTitle();
        lOut += "<br/>";
        for (access.Kill obj : object.getKills())
            lOut += "    " + obj.printKey() + "<br/>";
            // To close the session with.
        closeSession(object);
        return lOut;
    }

    public Film getSpecific(Serializable aKey) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        closeSession(object);
        return object;
    }

    public access.IAccess get(Serializable aKey) {
        return (Film)fCurrentSession.get(Film.class, aKey);
    }

    public void insert(Serializable aKey) {
        openSession();
        Film object = new Film();
        object.setid((FilmKey)(aKey));
            // Key is just a string for filmSeries.
        closeSession(object);
    }

    @Override
    public void setFEKTime(Serializable aKey, int FEKTime) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        object.setFEKTime(FEKTime);
        closeSession(object);
    }

    @Override
    public void setMostFuckedUpMoment(Serializable aKey, String MostFuckedUpMoment) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        object.setMostFuckedUpMoment(MostFuckedUpMoment);
        closeSession(object);
    }

    @Override
    public void setPlotIsSequelTo(Serializable aKey, int PlotIsSequelTo) throws IllegalArgumentException  {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        if (object.getNumberInTheSeries() != PlotIsSequelTo)
            object.setPlotIsSequelTo(PlotIsSequelTo);
        else
            throw new IllegalArgumentException();
        closeSession(object);
    }

    @Override
    public void setRuntime(Serializable aKey, int Runtime) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        object.setRuntime(Runtime);
        closeSession(object);
    }

    @Override
    public void setYear(Serializable aKey, int Year) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        object.setYear(Year);
        closeSession(object);
    }

    @Override
    public void setNumberInTheSeries(Serializable aKey, int num) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        object.setNumberInTheSeries(num);
        closeSession(object);
    }

    @Override
    public void setid(Serializable aKey, Serializable aId) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        object.setid((FilmKey)(aId));
        closeSession(object);
    }


    public Integer avgKillsAsNumber(Serializable aKey) {
        openSession();
        int lSeverity = 0;
        int lAvg = 0;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.Kill obj : object.getKills())
            lSeverity += obj.getGoreLevel().getSeverity();
        closeSession(object);
        if (lSeverity != 0) // Cheap way to find out if there are any, if there
                // are we should not be dividing by 0.
            lAvg = lSeverity/countKills(aKey);
        return lAvg;
    }

    public String avgKills(Serializable aKey) {
        openSession();
        int lSeverity = 0;
        int lAvg = 0;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.Kill obj : object.getKills())
            lSeverity += obj.getGoreLevel().getSeverity();
        closeSession(object);
        if (lSeverity != 0) // Cheap way to find out if there are any, if there
                // are we should not be dividing by 0.
            lAvg = lSeverity/countKills(aKey);

        if (lAvg == 0)
            return "N/A";
        else if (lAvg == 1)
            return "Low";
        else if (lAvg == 2)
            return "Medium";
        else // 3
            return "High";
    }

    public Integer avgNudityShotsAsNumber(Serializable aKey) {
        openSession();
        int lSeverity = 0;
        int lAvg = 0;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.NudityShot obj : object.getNudityShots())
            lSeverity += obj.getSeverity();
        closeSession(object);
        if (lSeverity != 0) // Cheap way to find out if there are any, if there
                // are we should not be dividing by 0.
            lAvg = lSeverity/countNudityShots(aKey);
            return lAvg;
    }

    public String avgNudityShots(Serializable aKey) {
        openSession();
        int lSeverity = 0;
        int lAvg = 0;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.NudityShot obj : object.getNudityShots())
            lSeverity += obj.getSeverity();
        closeSession(object);
        if (lSeverity != 0) // Cheap way to find out if there are any, if there
                // are we should not be dividing by 0.
            lAvg = lSeverity/countNudityShots(aKey);

        if (lAvg == 0)
            return "N/A";
        else if (lAvg == 1)
            return "Almost";
        else if (lAvg == 2)
            return "Breasts";
        else // 3
            return "Full Frontal";
    }

    public int countVictimSexualDuringFilms(Serializable aKey) {
        openSession();
        int lOut = 0;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.Kill obj : object.getKills())
            if (obj.isIsVictimSexualDuringFilm())
                lOut++;
        closeSession(object);
        return lOut;
    }


    public boolean isHighGore(Serializable aKey) {
        openSession();
        boolean lOut = false;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.Kill obj : object.getKills())
            if (obj.getGoreLevel().getTitle().compareTo("High") == 0)
                lOut = true;
        closeSession(object);
        return lOut;
    }

    public boolean isFullFrontal(Serializable aKey) {
        openSession();
        boolean lOut = false;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.NudityShot obj : object.getNudityShots())
            if (obj.getType().compareTo("Full Frontal") == 0)
                lOut = true;
        closeSession(object);
        return lOut;
    }

    public int countNudityShots(Serializable aKey) {
        openSession();
        int lOut = 0;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.NudityShot obj : object.getNudityShots())
            lOut++;
        closeSession(object);
        return lOut;
    }

    public int countSurvivals(Serializable aKey) {
        openSession();
        int lOut = 0;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.Survival obj : object.getSurvivals())
            lOut++;
        closeSession();
        return lOut;
    }

    public int countKills(Serializable aKey) {
        openSession();
        int lOut = 0;
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        for (access.Kill obj : object.getKills())
            lOut++;
        closeSession();
        return lOut;
    }

    @Override
    public List getAll() {
        openSession();
        String hql = "from Film f order by f.id.Title";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        return lList;
        }

    @Override
    public void addKill(Serializable aKey, Serializable aOtherKey) {
        openSession();
        access.Film object = (Film)fCurrentSession.get(Film.class, aKey);
        access.Kill objectKill = (access.Kill)fCurrentSession.get(access.Kill.class, aOtherKey);
        
        object.getKills().add(objectKill);
        // bi-directional now.
        objectKill.setFilm(object);
            // Key is just a string for filmSeries.
        closeSession(object);
    }
    public List<Film> getAllOrderBy(String aField) {
        openSession();
        // Already does by title.
        String hql = "from Film f order by f.id.Title";
        Query query = fCurrentSession.createQuery(hql);
        List<Film> lList = query.list();
        closeSession();
        if (aField.compareTo("Nudity") == 0)
            Collections.sort(lList, new SortFilmByNudity());
        else if (aField.compareTo("Gore") == 0)
            Collections.sort(lList, new SortFilmByGore());

        return lList;
        }

}


class SortFilmByGore implements Comparator<Film> {

    public int compare(Film o1, Film o2) {

logic.FilmManager lFilmMan = new logic.FilmManager();
        if (lFilmMan.avgKillsAsNumber(o1.getid()) < lFilmMan.avgKillsAsNumber(o2.getid()))
            return 1;
        else if (lFilmMan.avgKillsAsNumber(o1.getid()) == lFilmMan.avgKillsAsNumber(o2.getid()))
            return (lFilmMan.countKills(o1.getid()) < lFilmMan.countKills(o2.getid())) ? 1 : -1;
        else
            return -1;
    }
}

class SortFilmByNudity implements Comparator<Film> {

    public int compare(Film o1, Film o2) {

logic.FilmManager lFilmMan = new logic.FilmManager();
        if (lFilmMan.avgNudityShotsAsNumber(o1.getid()) < lFilmMan.avgNudityShotsAsNumber(o2.getid()))
            return 1;
        else if (lFilmMan.avgNudityShotsAsNumber(o1.getid()) == lFilmMan.avgNudityShotsAsNumber(o2.getid()))
            return (lFilmMan.countNudityShots(o1.getid()) < lFilmMan.countNudityShots(o2.getid())) ? 1 : -1;
        else
            return -1;
    }
}
