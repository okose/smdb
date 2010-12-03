package presentation;

import access.FilmKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import util.HibernateUtil;

/** @author karl */
public class Main {
  public static void main(String[] args)
  {
      BufferedReader read =  new BufferedReader(new InputStreamReader(System.in));
      boolean lIsRunning = true;
      String lInputText, lQuery = null;
      // Manager for film seriess.
        logic.IFilmSeriesLogic lFilmSeriesMan = new logic.FilmSeriesManager();
      // Manager for films.
        logic.FilmManager lFilmMan = new logic.FilmManager();
        List<access.Film> lFilms = lFilmMan.getAll();
// Manager for weapon.
    logic.WeaponManager lWeaponM = new logic.WeaponManager();

// Get lists
    List<access.Weapon> lWeapons = lWeaponM.getAll();
// Manager for kill.
    logic.KillManager lKillM = new logic.KillManager();
    //List<access.Kill> lKills = lKillM.getAll();

      while (lIsRunning)
      {
      try {


logic.WeaponManager lWeaponMan = new logic.WeaponManager();

List<access.Weapon> objs = lWeaponMan.getAllByKills();
for(access.Weapon lSubs : objs)
    System.out.println(lWeaponMan.countKills(lSubs.getTitle()));
                System.out.println("Welcome to SMDB - Slasher Movie DataBase. Press one of these number keys and hit enter.");
          System.out.println("1. Insert Record");
          System.out.println("2. Delete Record");
          System.out.println("3. Test concurrency handling.");
          System.out.println("4. Retrieve Record");
          System.out.println("5. Retrieve All Films in FilmSeries");
          System.out.println("6. Retrieve All series with their films.");
          System.out.println("0. Exit");

          lInputText = read.readLine();
          int lMenuChoice = Integer.parseInt(lInputText);

          if (lMenuChoice == 3)
              {
              System.out.println("Enter name of filmSeries: ");
              lFilmSeriesMan.setKillerConcurrently(read.readLine(), "");
              }
          if (lMenuChoice == 4) //Print film
              {
                System.out.println("Enter name of film: ");
                lQuery = read.readLine();
                System.out.println("Enter number of film in the series: ");
                int lNum = new Integer(read.readLine());
                try {
                    // Only time we breach to access layer. Must know key type.
                    System.out.println(lFilmMan.doPrint(new access.FilmKey(lNum, lQuery)));
                    System.out.println(" was found!");
                    }
                catch (Exception e) {System.out.println("was not found because: " + e.toString());}
              }
            if (lMenuChoice == 5)
                {
                try {
                System.out.println("Enter name of filmSeries: ");
                System.out.println(lFilmSeriesMan.printFilms(read.readLine()));
                }
                catch (Exception e) {System.out.println(e.toString());}
                }
            if (lMenuChoice == 6)
            {
                                List<access.FilmSeries> lList = lFilmSeriesMan.getAll();
                for(access.FilmSeries lFilmS : lList)
                    System.out.println(lFilmSeriesMan.printFilms(lFilmS.printKey()));
            }
            if (lMenuChoice == 0)
                {
                    lIsRunning = false;
                    return;
                }
            if (lMenuChoice == 2)
                {
                System.out.println("Enter name of film series to delete: ");
                lFilmSeriesMan.delete(read.readLine());
                }
            else if (lMenuChoice == 1)
                {
                try {
                // Add a film series.
                    System.out.println("Inserting new film series: ");
                    System.out.println("title:");
                    String lSeriesKey = read.readLine();
                    lFilmSeriesMan.insert(lSeriesKey);
                        // Doesn't do this automatically to save doing it 5 times.
                    System.out.println("killer:");
                    lFilmSeriesMan.setKiller(lSeriesKey, read.readLine());
                    System.out.println("dominant theme:");
                    lFilmSeriesMan.setDominantTheme(lSeriesKey, read.readLine());

                // Now add titles to it.
                    System.out.println("Inserting new film: ");
                    access.FilmKey lFilmKey = new access.FilmKey();
                    System.out.println("title:");
                    lFilmKey.setTitle(read.readLine());
                    System.out.println("Number in series:");
                    lFilmKey.setNumberInTheSeries(new Integer(read.readLine()));
                    lFilmMan.insert(lFilmKey);
                    lFilmSeriesMan.addFilm(lSeriesKey, lFilmKey);
                        // Now the key is done, we can create it.
                        // Always open just after the insert, for the next ones.
                    System.out.println("year:");
                    lFilmMan.setYear(lFilmKey, new Integer(read.readLine()));
                    System.out.println("Runtime:");
                    lFilmMan.setRuntime(lFilmKey, new Integer(read.readLine()));
                    System.out.println("FEKTime:");
                    lFilmMan.setFEKTime(lFilmKey, new Integer(read.readLine()));
                    // Shud error if not unique.
                    System.out.println("(Number in series) of film this plot is a Sequel to:");
                    lFilmMan.setPlotIsSequelTo(lFilmKey, new Integer(read.readLine()));
                    System.out.println("MostFuckedUpMoment");
                    lFilmMan.setMostFuckedUpMoment(lFilmKey, read.readLine());
                } catch (Exception e) {System.out.println("Error not a valid argument. " + e.toString());}
                }
     } catch (IOException ex) {
                System.out.println("Error not a valid argument. " + ex.toString());
            }
      }

    HibernateUtil.getSessionFactory().close();
  }
}
