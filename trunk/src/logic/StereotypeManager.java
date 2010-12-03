package logic;

import access.Stereotype;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

public class StereotypeManager extends ILogic {

    public access.IAccess get(Serializable aKey) {
        return (Stereotype)fCurrentSession.get(Stereotype.class, aKey);
    }

    public void insert(Serializable aKey) {
        openSession();
        Stereotype object = new Stereotype();
        object.setTitle((String)(aKey));
            // Key is just a string for StereotypeSeries.
        closeSession(object);
    }

    public String printNice(Serializable aKey) {
        openSession();
        Stereotype object = (Stereotype)get(aKey);
        return (object.getIsOnlyOnePerFilm() ? "the " : "a ") + object.printKey() + " : " + object.getDescriptionShort();
    }
    @Override
    public List getAll() {
        openSession();String hql = "from Stereotype f order by f.Title";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        return lList;
        }
}
