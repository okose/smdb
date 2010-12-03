package logic;

import java.io.Serializable;

public abstract class IFilmLogic extends ILogic {
    abstract public String printKills(Serializable aKey);
    abstract public void addKill(Serializable aKey, Serializable aOtherKey);
    abstract public void setFEKTime(Serializable aKey, int FEKTime);
    abstract public void setMostFuckedUpMoment(Serializable aKey, String MostFuckedUpMoment);
    abstract public void setPlotIsSequelTo(Serializable aKey, int PlotIsSequelTo);
    abstract public void setRuntime(Serializable aKey, int Runtime);
    abstract public void setYear(Serializable aKey, int Year);
    abstract public void setNumberInTheSeries(Serializable aKey, int num);
    abstract public void setid(Serializable aKey, Serializable aId);
}