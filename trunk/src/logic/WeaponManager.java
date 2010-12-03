package logic;

import access.Kill;
import access.Weapon;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;

public class WeaponManager extends ILogic {

    public access.IAccess get(Serializable aKey) {
        return (Weapon)fCurrentSession.get(Weapon.class, aKey);
    }

    public void insert(Serializable aKey) {
        openSession();
        Weapon object = new Weapon();
        object.setTitle((String)aKey);
            // Key is just a string for filmSeries.
        closeSession(object);
    }


    public int countKills(Serializable aKey) {
        openSession();
        int lOut = 0;
        access.Weapon object = (Weapon)fCurrentSession.get(Weapon.class, aKey);
        String hql = "from Kill k where k.Weapon like '" + object.getTitle() + "'";
        Query query = fCurrentSession.createQuery(hql);
        List<Kill> lList = query.list();
        closeSession();
        for (Kill lKill : lList)
            lOut++;
        return lOut;
    }

    public List getAllByKills() {
        openSession();
        String hql = "from Weapon";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        closeSession();
        Collections.sort(lList);
        return lList;
        }

    @Override
    public List getAll() {
        openSession();
        String hql = "from Weapon f order by f.Title";
        Query query = fCurrentSession.createQuery(hql);
        List lList = query.list();
        //Collections.sort(lList);
        closeSession();
        return lList;
        }
}
