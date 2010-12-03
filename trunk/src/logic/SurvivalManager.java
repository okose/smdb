package logic;

import access.Survival;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

public class SurvivalManager extends ILogic {

    public access.IAccess get(Serializable aKey) {
        return (Survival)fCurrentSession.get(Survival.class, aKey);
    }

    public void insert(Serializable aKey) {
        openSession();
        Survival object = new Survival();
        closeSession(object);
    }

    @Override
    public List getAll() {
        openSession();
        String hql = "from Survival";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        return lList;
        }
}
