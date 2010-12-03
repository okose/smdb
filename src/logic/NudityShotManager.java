package logic;

import access.NudityShot;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

public class NudityShotManager extends ILogic {

    public access.IAccess get(Serializable aKey) {
        return (NudityShot)fCurrentSession.get(NudityShot.class, aKey);
    }

    public void insert(Serializable aKey) {
        openSession();
        NudityShot object = new NudityShot();
        closeSession(object);
    }

    @Override
    public List getAll() {
        openSession();
        String hql = "from NudityShot n order by n.Type";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        return lList;
        }
}
