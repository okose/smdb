package logic;

import access.GoreLevel;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

public class GoreLevelManager extends ILogic {

    public access.IAccess get(Serializable aKey) {
        return (GoreLevel)fCurrentSession.get(GoreLevel.class, aKey);
    }

    public void insert(Serializable aKey) {
        openSession();
        GoreLevel object = new GoreLevel();
        object.setTitle((String)(aKey));
            // Key is just a string for GoreLevelSeries.
        closeSession(object);
    }

    @Override
    public List getAll() {
        openSession();String hql = "from GoreLevel f order by f.Title";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        return lList;
        }
}
