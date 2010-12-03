package logic;

import access.Kill;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

public class KillManager extends ILogic {

    public access.IAccess get(Serializable aKey) {
        return (Kill)fCurrentSession.get(Kill.class, aKey);
    }

    public void insert(Serializable aKey) {
        openSession();
        Kill object = new Kill();
        closeSession(object);
    }

    @Override
    public List getAll() {
        openSession();
        String hql = "from Kill k order by k.Time";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        return lList;
        }
}
