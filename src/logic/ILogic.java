package logic;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

public abstract class ILogic {

    public Session fCurrentSession = null;
    public org.hibernate.Transaction fCurrentTransaction = null;

    // Deep copy. Do not modify.
    public abstract List getAll();
    public abstract access.IAccess get(Serializable aKey);
    public abstract void insert(Serializable aKey);
    String print(access.IAccess object) {
        return object.printKey();
            // To close the session with.
    }
    public void delete(Serializable aKey) {
        openSession();
        access.IAccess object = get(aKey);
        fCurrentSession.delete(object);
        fCurrentSession.getTransaction().commit();
            //don't call the generic one because we can't call update.
    }
    public String doPrint(Serializable aKey) {
        openSession();
        access.IAccess object = get(aKey);
        // Now only the relevent code will be in method.
        String lOut = print(object);
        closeSession(object);
        return lOut;
    }
    public void openSession() {
        fCurrentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        fCurrentTransaction = fCurrentSession.beginTransaction();
    }
    public void closeSession() {
        try {
        fCurrentTransaction.commit();
        } catch (RuntimeException e)
            {System.out.println("COULD NOT SAVE: Someone is probably accessing this data at the same time... just try again in a sec, it's all safe. The error is: " + e.toString());}
        fCurrentSession = null;
        fCurrentTransaction = null;
        // No need for: fCurrentSession.close();
    }
    public void closeSession(access.IAccess aClass) {
        try {
        fCurrentSession.saveOrUpdate(aClass);
        } catch (RuntimeException e)
            {
            if (fCurrentTransaction != null)
                fCurrentTransaction.rollback();
             // Throw exception or display error message of transaction fail.
            System.out.println("COULD NOT SAVE: Someone is probably accessing this data at the same time... just try again in a sec, it's all safe. The error is: " + e.toString());
        return;
        }
        closeSession();
    }
    /** To do it from an id */
    public void closeSession(Serializable aKey) {
        closeSession(get(aKey));
    }
}
