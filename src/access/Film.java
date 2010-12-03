package access;

import java.util.Set;

public class Film implements Comparable<Film>, IAccess
    {
    FilmKey id = new FilmKey();
    int Year;
    int Runtime;
    int FEKTime;
    int PlotIsSequelTo;
    String MostFuckedUpMoment;
    FilmSeries FilmSeries;
    Set<Kill> Kills;
    Set<NudityShot> NudityShots;
    Set<Survival> Survivals;
    private int versionID;

    public Set<Survival> getSurvivals() {
        return Survivals;
    }

    public void setSurvivals(Set<Survival> Survivals) {
        this.Survivals = Survivals;
    }

    public Set<NudityShot> getNudityShots() {
        return NudityShots;
    }

    public void setNudityShots(Set<NudityShot> NudityShots) {
        this.NudityShots = NudityShots;
    }

    public Set<Kill> getKills() {
        return Kills;
    }

    public void setKills(Set<Kill> Kills) {
        this.Kills = Kills;
    }
        // For detecting concurrency issues.
    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    public String printKey() {
        String lStr = getNumberInTheSeries() + ", " + getTitle();
        return lStr;
    }

    public FilmSeries getFilmSeries() {
        return FilmSeries;
    }

    public void setFilmSeries(FilmSeries a) {
        this.FilmSeries = a;
    }

    public int getFEKTime() {
        return FEKTime;
    }

    public void setFEKTime(int FEKTime) {
        this.FEKTime = FEKTime;
    }

    public String getMostFuckedUpMoment() {
        return MostFuckedUpMoment;
    }

    public void setMostFuckedUpMoment(String MostFuckedUpMoment) {
        this.MostFuckedUpMoment = MostFuckedUpMoment;
    }

    public int getPlotIsSequelTo() {
        return PlotIsSequelTo;
    }

    public void setPlotIsSequelTo(int PlotIsSequelTo) {
        this.PlotIsSequelTo = PlotIsSequelTo;
    }

    public int getRuntime() {
        return Runtime;
    }

    public void setRuntime(int Runtime) {
        this.Runtime = Runtime;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getNumberInTheSeries() {
        return id.getNumberInTheSeries();
    }

    public void setNumberInTheSeries(int num) {
        id.setNumberInTheSeries(num);
    }

    public String getTitle() {
        return id.getTitle();
    }

    /** Also with string */
    public void setTitle(String a) {
        id.setTitle(a);
    }

    public FilmKey getid() {
        return id;
    }

    public void setid(FilmKey aVal) {
        id.setNumberInTheSeries(aVal.getNumberInTheSeries());
        id.setTitle(aVal.getTitle());
    }

    public int compareTo(Film o1) {
        if (getNumberInTheSeries() < o1.getNumberInTheSeries())
            return -1;
        else if (getNumberInTheSeries() == o1.getNumberInTheSeries())
            return 0;
        else
            return 1;
        }
    }
