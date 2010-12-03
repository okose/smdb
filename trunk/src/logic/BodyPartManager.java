package logic;

import access.BodyPart;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

public class BodyPartManager extends ILogic {

    public access.IAccess get(Serializable aKey) {
        return (BodyPart)fCurrentSession.get(BodyPart.class, aKey);
    }

    public void insert(Serializable aKey) {
        openSession();
        BodyPart object = new BodyPart();
        object.setTitle((String)aKey);
            // Key is just a string for filmSeries.
        closeSession(object);
    }

    @Override
    public List getAll() {
        openSession();
        String hql = "from BodyPart f order by f.Title";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        return lList;
        }
}
