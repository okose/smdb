package logic;

import access.CauseOfDeath;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

public class CauseOfDeathManager extends ILogic {

    public access.IAccess get(Serializable aKey) {
        return (CauseOfDeath)fCurrentSession.get(CauseOfDeath.class, aKey);
    }

    public void insert(Serializable aKey) {
        openSession();
        CauseOfDeath object = new CauseOfDeath();
        object.setTitle((String)(aKey));
            // Key is just a string for CauseOfDeathSeries.
        closeSession(object);
    }
    @Override
    public List getAll() {
        openSession();String hql = "from CauseOfDeath f order by f.Title";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        return lList;
        }
}
