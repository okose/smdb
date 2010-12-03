package access;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class FilmSeries implements IAccess
    {
    private String Title;
    private String Killer;
    private String DominantTheme;
    Set<Film> Films;
    private int versionID;
        // For detecting concurrency issues.

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    public String printKey() {
        String lStr = getTitle();
        return lStr;
    }

    public void update(String aNewKiller) {
        setKiller(aNewKiller);
    }

    // Make it ordered. (Wasteful on computation time.)
    public ArrayList<Film> getFilmsOrdered() {
        ArrayList<Film> l = new ArrayList<Film>(Films);
        Collections.sort(l);
        return l;
    }

    public Set<Film> getFilms() {
        return Films;

    }

    public void setFilms(Set<Film> aFilms) {
        try {
        this.Films = aFilms;
        }
        catch (Exception e) {System.out.println("ERROR In cast:" + e.toString()); }
    }


    public String getDominantTheme() {
        return DominantTheme;
    }

    public void setDominantTheme(String DominantTheme) {
        this.DominantTheme = DominantTheme;
    }

    public String getKiller() {
        return Killer;
    }

    public void setKiller(String Killer) {
        this.Killer = Killer;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

   }
