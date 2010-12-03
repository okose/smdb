package access;

public class Weapon implements IAccess, Comparable<Weapon>
    {
    String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String printKey() {
        String lStr = getTitle();
        return lStr;
    }

    public int compareTo(Weapon o) {
    logic.WeaponManager lWeaponMan = new logic.WeaponManager();

        if (lWeaponMan.countKills(getTitle()) < lWeaponMan.countKills(o.getTitle()))
            return -1;
        else
            return 1;
    }
    }
