
package databasefiller;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Methods to interact with the database.
 * Some of them are never used or where used for other functions nor relevant to this package.
 * @author hugo
 */
public class MySQLAccessRotoID {
  private Connection connect = null;
  
  
/* 
This method connects to the database.
Called at the beginning of the DatabaseFiller main.
*/
  public void connect(String driver, String userPassword) throws SQLException{
      try {
          Class.forName(driver);
          this.connect=DriverManager.getConnection(userPassword);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(MySQLAccessRotoID.class.getName()).log(Level.SEVERE, null, ex);
      }
}
  
 /* public void readDataBase() throws Exception {
    try {
      
      Statement statement= this.connect.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from SANTANA.PARKS");
      writeResultSet(resultSet);
      
    } catch (Exception e) {
      throw e;
    }
  }*/
  
  public void writeParks(String parkID, String name, String city, String state, String league) throws SQLException{
      PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into  SANTANA.PARKS values (?, ?, ?, ?, ? , ?, ?)");
      // "parkID, Name, team, city, state, league, address");
      // Parameters start with 1
      preparedStatement.setString(1, parkID);
      preparedStatement.setString(2, name);
      preparedStatement.setString(3, "");
      preparedStatement.setString(4, city);
      preparedStatement.setString(5, state);
      preparedStatement.setString(6, league);
      preparedStatement.setString(7, " ");
      preparedStatement.executeUpdate();
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String parkID = resultSet.getString("parkID");
      String parkName = resultSet.getString("ParkName");
      String team = resultSet.getString("team");
      String city = resultSet.getString("city");
      String state = resultSet.getString("state");
      String league = resultSet.getString("league");
      String address = resultSet.getString("address");
      System.out.println("parkID: " + parkID);
      System.out.println("Park Name: " + parkName);
      System.out.println("team: " + team);
      System.out.println("city: " + city);
      System.out.println("state: " + state);
      System.out.println("league: " + league);
      System.out.println("address: " + address);
    }
  }
  
  public int getPitcherParkW(String playerID, String parkID) throws SQLException{
      int w=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT W from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            w = resultSet.getInt("W");
      }
      resultSet.close();
      preparedStatement.close();
      return w;
  }
    
  public int getPitcherTimeW(String playerID, String time) throws SQLException{
      int w=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT W from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            w = resultSet.getInt("W");
      }
      resultSet.close();
      preparedStatement.close();
      return w;
  }
  
  public int getPitcherParkL(String playerID, String parkID) throws SQLException{
      int l=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT L from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            l = resultSet.getInt("L");
      }
      resultSet.close();
      preparedStatement.close();
      return l;
  }
  
  public int getPitcherTimeL(String playerID, String time) throws SQLException{
      int l=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT L from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            l = resultSet.getInt("L");
      }
      resultSet.close();
      preparedStatement.close();
      return l;
  }
  
  public int getPitcherParkSV(String playerID, String parkID) throws SQLException{
      int sv=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT SV from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            sv = resultSet.getInt("SV");
      }
      resultSet.close();
      preparedStatement.close();
      return sv;
  }
  
  public int getPitcherTimeSV(String playerID, String time) throws SQLException{
      int sv=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT SV from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            sv = resultSet.getInt("SV");
      }
      resultSet.close();
      preparedStatement.close();
      return sv;
  }
  
  public int getPitcherParkGS(String playerID, String parkID) throws SQLException{
      int gs=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT GS from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            gs = resultSet.getInt("GS");
      }
      resultSet.close();
      preparedStatement.close();
      return gs;
  }
  
  public int getPitcherTimeGS(String playerID, String time) throws SQLException{
      int gs=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT GS from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            gs = resultSet.getInt("GS");
      }
      resultSet.close();
      preparedStatement.close();
      return gs;
  }
  
  public int getPitcherParkG(String playerID, String parkID) throws SQLException{
      int g=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT G from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            g = resultSet.getInt("G");
      }
      resultSet.close();
      preparedStatement.close();
      return g;
  }
  
  public int getPitcherTimeG(String playerID, String time) throws SQLException{
      int g=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT G from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            g = resultSet.getInt("G");
      }
      resultSet.close();
      preparedStatement.close();
      return g;
  }
  
  public int getHitterParkG(String playerID, String parkID) throws SQLException{
      int g=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT G from SANTANA.parkHitters WHERE parkHitters.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            g = resultSet.getInt("G");
      }
      resultSet.close();
      preparedStatement.close();
      return g;
  }
  
  public int getHitterTimeG(String playerID, String time) throws SQLException{
      int g=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT G from SANTANA.timeHitters WHERE timeHitters.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            g = resultSet.getInt("G");
      }
      resultSet.close();
      preparedStatement.close();
      return g;
  }
  
  public int getPitcherParkER(String playerID, String parkID) throws SQLException{
      int er=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT ER from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            er = resultSet.getInt("ER");
      }
      resultSet.close();
      preparedStatement.close();
      return er;
  }
  
  public int getPitcherTimeER(String playerID, String time) throws SQLException{
      int er=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT ER from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            er = resultSet.getInt("ER");
      }
      resultSet.close();
      preparedStatement.close();
      return er;
  }
  
  //---
  
  public int getPitcherTimeI(String playerID, String time) throws SQLException{
      int i=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT I from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            i = resultSet.getInt("I");
      }
      resultSet.close();
      preparedStatement.close();
      return i;
  }
  
  public int getPitcherTimeBB(String playerID, String time) throws SQLException{
      int bb=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT BB from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            bb = resultSet.getInt("BB");
      }
      resultSet.close();
      preparedStatement.close();
      return bb;
  }
  
  public int getPitcherTimeK(String playerID, String time) throws SQLException{
      int k=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT K from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            k = resultSet.getInt("K");
      }
      resultSet.close();
      preparedStatement.close();
      return k;
  }
  
  public int getPitcherTimeIW(String playerID, String time) throws SQLException{
      int iw=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT IW from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            iw = resultSet.getInt("IW");
      }
      resultSet.close();
      preparedStatement.close();
      return iw;
  }
  
  public int getPitcherTimeWP(String playerID, String time) throws SQLException{
      int wp=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT WP from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            wp = resultSet.getInt("WP");
      }
      resultSet.close();
      preparedStatement.close();
      return wp;
  }
  
  public int getPitcherTimeHBP(String playerID, String time) throws SQLException{
      int hbp=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HBP from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hbp = resultSet.getInt("HBP");
      }
      resultSet.close();
      preparedStatement.close();
      return hbp;
  }
  
  public int getPitcherTimeH(String playerID, String time) throws SQLException{
      int h=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT H from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            h = resultSet.getInt("H");
      }
      resultSet.close();
      preparedStatement.close();
      return h;
  }
  
  public int getPitcherTimeHR(String playerID, String time) throws SQLException{
      int hr=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HR from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hr = resultSet.getInt("HR");
      }
      resultSet.close();
      preparedStatement.close();
      return hr;
  }
  
  public int getPitcherTimeD(String playerID, String time) throws SQLException{
      int d=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 2B from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            d = resultSet.getInt("2B");
      }
      resultSet.close();
      preparedStatement.close();
      return d;
  }
  
  public int getPitcherTimeT(String playerID, String time) throws SQLException{
      int t=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 3B from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            t = resultSet.getInt("3B");
      }
      resultSet.close();
      preparedStatement.close();
      return t;
  }
  
  public int getPitcherTimeBF(String playerID, String time) throws SQLException{
      int bf=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT BF from SANTANA.timePitchers WHERE timePitchers.playerID=? AND time=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            bf = resultSet.getInt("BF");
      }
      resultSet.close();
      preparedStatement.close();
      return bf;
  }
  
  //---
  
  public int getPitcherParkI(String playerID, String parkID) throws SQLException{
      int i=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT I from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            i = resultSet.getInt("I");
      }
      resultSet.close();
      preparedStatement.close();
      return i;
  }
  
  public int getPitcherParkBB(String playerID, String parkID) throws SQLException{
      int bb=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT BB from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            bb = resultSet.getInt("BB");
      }
      resultSet.close();
      preparedStatement.close();
      return bb;
  }
  
  public int getPitcherParkK(String playerID, String parkID) throws SQLException{
      int k=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT K from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            k = resultSet.getInt("K");
      }
      resultSet.close();
      preparedStatement.close();
      return k;
  }
  
  public int getPitcherParkIW(String playerID, String parkID) throws SQLException{
      int iw=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT IW from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            iw = resultSet.getInt("IW");
      }
      resultSet.close();
      preparedStatement.close();
      return iw;
  }
  
  public int getPitcherParkWP(String playerID, String parkID) throws SQLException{
      int wp=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT WP from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            wp = resultSet.getInt("WP");
      }
      resultSet.close();
      preparedStatement.close();
      return wp;
  }
  
  public int getPitcherParkHBP(String playerID, String parkID) throws SQLException{
      int hbp=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HBP from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hbp = resultSet.getInt("HBP");
      }
      resultSet.close();
      preparedStatement.close();
      return hbp;
  }
  
  public int getPitcherParkH(String playerID, String parkID) throws SQLException{
      int h=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT H from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            h = resultSet.getInt("H");
      }
      resultSet.close();
      preparedStatement.close();
      return h;
  }
  
  public int getPitcherParkHR(String playerID, String time) throws SQLException{
      int hr=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HR from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hr = resultSet.getInt("HR");
      }
      resultSet.close();
      preparedStatement.close();
      return hr;
  }
  
  public int getPitcherParkD(String playerID, String parkID) throws SQLException{
      int d=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 2B from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            d = resultSet.getInt("2B");
      }
      resultSet.close();
      preparedStatement.close();
      return d;
  }
  
  public int getPitcherParkT(String playerID, String parkID) throws SQLException{
      int t=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 3B from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            t = resultSet.getInt("3B");
      }
      resultSet.close();
      preparedStatement.close();
      return t;
  }
  
  public int getPitcherParkBF(String playerID, String parkID) throws SQLException{
      int bf=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT BF from SANTANA.parkPitchers WHERE parkPitchers.playerID=? AND parkID=?");
      preparedStatement.setString(1, playerID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            bf = resultSet.getInt("BF");
      }
      resultSet.close();
      preparedStatement.close();
      return bf;
  }
  
  //----
  
  public int getMatchupsH(String hitterID, String pitcherID) throws SQLException{
      int h=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT H from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            h = resultSet.getInt("H");
      }
      resultSet.close();
      preparedStatement.close();
      return h;
  }
  
  public int getMatchupsD(String hitterID, String pitcherID) throws SQLException{
      int d=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 2B from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            d = resultSet.getInt("2B");
      }
      resultSet.close();
      preparedStatement.close();
      return d;
  }
  
  public int getMatchupsT(String hitterID, String pitcherID) throws SQLException{
      int t=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 3B from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            t = resultSet.getInt("3B");
      }
      resultSet.close();
      preparedStatement.close();
      return t;
  }
  
  public int getMatchupsHR(String hitterID, String pitcherID) throws SQLException{
      int hr=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HR from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hr = resultSet.getInt("HR");
      }
      resultSet.close();
      preparedStatement.close();
      return hr;
  }
  
  public int getMatchupsBB(String hitterID, String pitcherID) throws SQLException{
      int bb=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT BB from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            bb = resultSet.getInt("BB");
      }
      resultSet.close();
      preparedStatement.close();
      return bb;
  }
  
  public int getMatchupsIW(String hitterID, String pitcherID) throws SQLException{
      int iw=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT IW from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            iw = resultSet.getInt("IW");
      }
      resultSet.close();
      preparedStatement.close();
      return iw;
  }
  
  public int getMatchupsK(String hitterID, String pitcherID) throws SQLException{
      int k=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT K from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            k = resultSet.getInt("K");
      }
      resultSet.close();
      preparedStatement.close();
      return k;
  }
  
  public int getMatchupsHP(String hitterID, String pitcherID) throws SQLException{
      int hp=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HBP from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hp = resultSet.getInt("HBP");
      }
      resultSet.close();
      preparedStatement.close();
      return hp;
  }
  
  public int getMatchupsPA(String hitterID, String pitcherID) throws SQLException{
      int pa=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT PA from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            pa = resultSet.getInt("PA");
      }
      resultSet.close();
      preparedStatement.close();
      return pa;
  }
  
  public int getMatchupsAB(String hitterID, String pitcherID) throws SQLException{
      int ab=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT AB from SANTANA.matchups WHERE matchups.PitcherID=? AND matchups.HitterID=?");
      preparedStatement.setString(1, pitcherID);
      preparedStatement.setString(2, hitterID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            ab = resultSet.getInt("AB");
      }
      resultSet.close();
      preparedStatement.close();
      return ab;
  }
  
  public int getHitterParkPA(String hitterID, String parkID) throws SQLException{
      int pa=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT PA from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            pa = resultSet.getInt("PA");
      }
      resultSet.close();
      preparedStatement.close();
      return pa;
  }
  
  public int getHitterParkAB(String hitterID, String parkID) throws SQLException{
      int ab=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT AB from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            ab = resultSet.getInt("AB");
      }
      resultSet.close();
      preparedStatement.close();
      return ab;
  }
  
  public int getHitterParkH(String hitterID, String parkID) throws SQLException{
      int h=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT H from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            h = resultSet.getInt("H");
      }
      resultSet.close();
      preparedStatement.close();
      return h;
  }
  
  public int getHitterParkD(String hitterID, String parkID) throws SQLException{
      int d=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 2B from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            d = resultSet.getInt("2B");
      }
      resultSet.close();
      preparedStatement.close();
      return d;
  }
  
  public int getHitterParkT(String hitterID, String parkID) throws SQLException{
      int t=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 3B from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            t = resultSet.getInt("3B");
      }
      resultSet.close();
      preparedStatement.close();
      return t;
  }
  
  public int getHitterParkHR(String hitterID, String parkID) throws SQLException{
      int hr=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HR from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hr = resultSet.getInt("HR");
      }
      resultSet.close();
      preparedStatement.close();
      return hr;
  }
  
  public int getHitterParkBB(String hitterID, String parkID) throws SQLException{
      int bb=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT BB from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            bb = resultSet.getInt("BB");
      }
      resultSet.close();
      preparedStatement.close();
      return bb;
  }
  
  public int getHitterParkIW(String hitterID, String parkID) throws SQLException{
      int iw=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT IW from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            iw = resultSet.getInt("IW");
      }
      resultSet.close();
      preparedStatement.close();
      return iw;
  }
  
  public int getHitterParkHBP(String hitterID, String parkID) throws SQLException{
      int hbp=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HBP from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hbp = resultSet.getInt("HBP");
      }
      resultSet.close();
      preparedStatement.close();
      return hbp;
  }
  
  public int getHitterParkK(String hitterID, String parkID) throws SQLException{
      int k=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT K from SANTANA.parkHitters WHERE parkHitters.PlayerID=? AND parkHitters.parkID=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, parkID);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            k = resultSet.getInt("K");
      }
      resultSet.close();
      preparedStatement.close();
      return k;
  }
  
  public int getHitterTimePA(String hitterID, String time) throws SQLException{
      int pa=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT PA from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            pa = resultSet.getInt("PA");
      }
      resultSet.close();
      preparedStatement.close();
      return pa;
  }
  
  public int getHitterTimeAB(String hitterID, String time) throws SQLException{
      int ab=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT AB from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            ab = resultSet.getInt("AB");
      }
      resultSet.close();
      preparedStatement.close();
      return ab;
  }
  
  public int getHitterTimeH(String hitterID, String time) throws SQLException{
      int h=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT H from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            h = resultSet.getInt("H");
      }
      resultSet.close();
      preparedStatement.close();
      return h;
  }
  
  public int getHitterTimeD(String hitterID, String time) throws SQLException{
      int d=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 2B from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            d = resultSet.getInt("2B");
      }
      resultSet.close();
      preparedStatement.close();
      return d;
  }
  
  public int getHitterTimeT(String hitterID, String time) throws SQLException{
      int t=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT 3B from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            t = resultSet.getInt("3B");
      }
      resultSet.close();
      preparedStatement.close();
      return t;
  }
  
  public int getHitterTimeHR(String hitterID, String time) throws SQLException{
      int hr=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HR from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hr = resultSet.getInt("HR");
      }
      resultSet.close();
      preparedStatement.close();
      return hr;
  }
  
  public int getHitterTimeBB(String hitterID, String time) throws SQLException{
      int bb=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT BB from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            bb = resultSet.getInt("BB");
      }
      resultSet.close();
      preparedStatement.close();
      return bb;
  }
  
  public int getHitterTimeIW(String hitterID, String time) throws SQLException{
      int iw=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT IW from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            iw = resultSet.getInt("IW");
      }
      resultSet.close();
      preparedStatement.close();
      return iw;
  }
  
  public int getHitterTimeHBP(String hitterID, String time) throws SQLException{
      int hbp=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT HBP from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            hbp = resultSet.getInt("HBP");
      }
      resultSet.close();
      preparedStatement.close();
      return hbp;
  }
  
  public int getHitterTimeK(String hitterID, String time) throws SQLException{
      int k=-1;
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT K from SANTANA.timeHitters WHERE timeHitters.PlayerID=? AND timeHitters.time=?");
      preparedStatement.setString(1, hitterID);
      preparedStatement.setString(2, time);
      ResultSet resultSet=preparedStatement.executeQuery();
     
      while(resultSet.next()){
            k = resultSet.getInt("K");
      }
      resultSet.close();
      preparedStatement.close();
      return k;
  }
    
  public void addPitcherParkWin(String rotoID, String parkID) throws SQLException{
      
      int w=this.getPitcherParkW(rotoID, parkID);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(w<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, parkID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.W=? WHERE parkPitchers.parkID=? AND parkPitchers.playerID=?");
          
          preparedStatement.setInt(1,w+1);
          preparedStatement.setString(2,parkID);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherTimeWin(String rotoID, String time) throws SQLException{
      
      int w=this.getPitcherTimeW(rotoID, time);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(w<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, FB,I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, time);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.W=? WHERE timePitchers.time=? AND timePitchers.playerID=?");
          
          preparedStatement.setInt(1,w+1);
          preparedStatement.setString(2,time);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherParkLose(String rotoID, String parkID) throws SQLException{
      int l=this.getPitcherParkL(rotoID, parkID);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(l<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, parkID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.L=? WHERE parkPitchers.parkID=? AND parkPitchers.playerID=?");
          
          preparedStatement.setInt(1,l+1);
          preparedStatement.setString(2,parkID);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherTimeLose(String rotoID, String time) throws SQLException{
      int l=this.getPitcherTimeL(rotoID, time);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(l<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, time);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.L=? WHERE timePitchers.time=? AND timePitchers.playerID=?");
          
          preparedStatement.setInt(1,l+1);
          preparedStatement.setString(2,time);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherParkSV(String rotoID, String parkID) throws SQLException{
      int sv=this.getPitcherParkSV(rotoID, parkID);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(sv<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, parkID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.SV=? WHERE parkPitchers.parkID=? AND parkPitchers.playerID=?");
          
          preparedStatement.setInt(1,sv+1);
          preparedStatement.setString(2,parkID);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherTimeSV(String rotoID, String time) throws SQLException{
      int sv=this.getPitcherTimeSV(rotoID, time);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(sv<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, time);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.SV=? WHERE timePitchers.time=? AND timePitchers.playerID=?");
          
          preparedStatement.setInt(1,sv+1);
          preparedStatement.setString(2,time);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }

  public void addPitcherParkGS(String rotoID, String parkID) throws SQLException{
      int gs=this.getPitcherParkGS(rotoID, parkID);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(gs<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, parkID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          int g=this.getPitcherParkG(rotoID, parkID);
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.GS=?, parkPitchers.G=?  WHERE parkPitchers.parkID=? AND parkPitchers.playerID=?");
          
          preparedStatement.setInt(1,gs+1);
          preparedStatement.setInt(2,g+1);
          preparedStatement.setString(3,parkID);
          preparedStatement.setString(4,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherTimeGS(String rotoID, String time) throws SQLException{
      int gs=this.getPitcherTimeGS(rotoID, time);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(gs<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, time);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          int g=this.getPitcherTimeG(rotoID, time);
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.GS=?,timePitchers.G=?  WHERE timePitchers.time=? AND timePitchers.playerID=?");
          
          preparedStatement.setInt(1,gs+1);
          preparedStatement.setInt(2,g+1);
          preparedStatement.setString(3,time);
          preparedStatement.setString(4,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherParkG(String rotoID, String parkID) throws SQLException{
      int g=this.getPitcherParkG(rotoID, parkID);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(g<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, parkID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.G=?  WHERE parkPitchers.parkID=? AND parkPitchers.playerID=?");
          
          preparedStatement.setInt(1,g+1);
          preparedStatement.setString(2,parkID);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherTimeG(String rotoID, String time) throws SQLException{
      int g=this.getPitcherTimeG(rotoID, time);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(g<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, time);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.G=?  WHERE timePitchers.time=? AND timePitchers.playerID=?");
          
          preparedStatement.setInt(1,g+1);
          preparedStatement.setString(2,time);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addHitterParkG(String rotoID, String parkID) throws SQLException{
      int g=this.getHitterParkG(rotoID, parkID);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(g<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
          // "playerID, parkID, G, PA, AB, H, 2B, 3B, HR, RBI, BB, IBB, HBP, SB, CS, K, GDP");
          // Parameters start with 1
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, parkID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.G=?  WHERE parkHitters.parkID=? AND parkHitters.playerID=?");
          
          preparedStatement.setInt(1,g+1);
          preparedStatement.setString(2,parkID);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addHitterTimeG(String rotoID, String time) throws SQLException{
       int g=this.getHitterTimeG(rotoID, time);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(g<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
           // "playerID, parkID, G, PA, AB, H, 2B, 3B, HR, RBI, BB, IBB, HBP, SB, CS, K, GDP");
          
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, time);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.G=?  WHERE timeHitters.time=? AND timeHitters.playerID=?");
          
          preparedStatement.setInt(1,g+1);
          preparedStatement.setString(2,time);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherParkER(String rotoID, String parkID, String erNumber) throws SQLException{
      int er=this.getPitcherParkER(rotoID, parkID);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(er<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,?)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          if(er<0){
              er=0;
          }
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, parkID);
          preparedStatement.setInt(3, (er+Integer.valueOf(erNumber)));
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.ER=?  WHERE parkPitchers.parkID=? AND parkPitchers.playerID=?");
          
          if(er<0){
              er=0;
          }
          preparedStatement.setInt(1,er+(Integer.valueOf(erNumber)));
          preparedStatement.setString(2,parkID);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addPitcherTimeER(String rotoID, String time, String erNumber) throws SQLException{
      int er=this.getPitcherTimeER(rotoID, time);
      //System.out.println("playerID = " + this.getPlayerID(nameFirst, nameLast));
      if(er<0){
          PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,?)");
          // "playerID, parkID, G, GS, I, W, L, CG, SHO, SV, K, BB, IBB, WP, HBP, H, HR, 2B, 3B, R, ER");
          // Parameters start with 1
          if(er<0){
              er=0;
          }
          preparedStatement.setString(1,rotoID);
          preparedStatement.setString(2, time);
          preparedStatement.setInt(3, er+Integer.valueOf(erNumber));
          preparedStatement.executeUpdate();
          preparedStatement.close();
      
      }else{
          PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.ER=?  WHERE timePitchers.time=? AND timePitchers.playerID=?");
          
          if(er<0){
              er=0;
          }
          preparedStatement.setInt(1,er+(Integer.valueOf(erNumber)));
          preparedStatement.setString(2,time);
          preparedStatement.setString(3,rotoID);
          preparedStatement.executeUpdate();
          preparedStatement.close();
      }
  }
  
  public void addMatchResult(String hitterRotoID, String pitcherRotoID, String result) throws SQLException{
      if(result.equals("Skip")==false&&result.equals("CS")==false&&result.equals("PO")==false&&result.equals("WP")==false){
           if(result.equals("Out")){
                  // +PA, +AB
                  int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,1,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                  }else{
                        int ab=this.getMatchupsAB(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?,matchups.AB=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setString(3,hitterRotoID);
                        preparedStatement.setString(4,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
           
          if(result.equals("S")){
                 //S: +PA, +AB, +H
                 int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,1,1,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getMatchupsAB(hitterRotoID, pitcherRotoID);
                        int h=this.getMatchupsH(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?,matchups.AB=?, matchups.H=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setString(4,hitterRotoID);
                        preparedStatement.setString(5,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        preparedStatement.close();
                }
          }
          if(result.equals("D")){
              //D: +PA, +AB, +H, +D
                 int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,1,1,1,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getMatchupsAB(hitterRotoID, pitcherRotoID);
                        int h=this.getMatchupsH(hitterRotoID, pitcherRotoID);
                        int d=this.getMatchupsD(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?,matchups.AB=?, matchups.H=?, matchups.2B=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setInt(4,d+1);
                        preparedStatement.setString(5,hitterRotoID);
                        preparedStatement.setString(6,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("T")){
              //T: +PA, +AB, +H, +T
                 int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,1,1,0,1,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getMatchupsAB(hitterRotoID, pitcherRotoID);
                        int h=this.getMatchupsH(hitterRotoID, pitcherRotoID);
                        int t=this.getMatchupsT(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?,matchups.AB=?, matchups.H=?, matchups.3B=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setInt(4,t+1);
                        preparedStatement.setString(5,hitterRotoID);
                        preparedStatement.setString(6,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("HR")){
              //HR: +PA, +AB, +H, +HR
              int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,1,1,0,0,1,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getMatchupsAB(hitterRotoID, pitcherRotoID);
                        int h=this.getMatchupsH(hitterRotoID, pitcherRotoID);
                        int hr=this.getMatchupsHR(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?,matchups.AB=?, matchups.H=?, matchups.HR=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setInt(4,hr+1);
                        preparedStatement.setString(5,hitterRotoID);
                        preparedStatement.setString(6,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("W")){
              //W: +PA, +W
              int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,0,0,0,0,0,0,1,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                       int bb=this.getMatchupsBB(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?, matchups.BB=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,bb+1);
                        preparedStatement.setString(3,hitterRotoID);
                        preparedStatement.setString(4,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("K")){
              //K: +PA, +AB, +K
              int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,1,0,0,0,0,0,0,0,0,1,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int k=this.getMatchupsK(hitterRotoID, pitcherRotoID);
                        int ab=this.getMatchupsAB(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?, matchups.AB=?, matchups.K=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,k+1);
                        preparedStatement.setString(4,hitterRotoID);
                        preparedStatement.setString(5,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("HP")){
                  //HP: +PA, +HP
                  int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,0,0,0,0,0,0,0,0,1,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int hp=this.getMatchupsHP(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?, matchups.HBP=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,hp+1);
                        preparedStatement.setString(3,hitterRotoID);
                        preparedStatement.setString(4,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("IW")){
              //IW: +PA, +IW, +BB
              int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,0,0,0,0,0,0,1,1,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int iw=this.getMatchupsIW(hitterRotoID, pitcherRotoID);
                        int bb=this.getMatchupsBB(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?, matchups.IW=?, matchups.BB=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,iw+1);
                        preparedStatement.setInt(3,bb+1);
                        preparedStatement.setString(4,hitterRotoID);
                        preparedStatement.setString(5,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("E")){
              // +PA, +AB
                  int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,1,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                  }else{
                        int ab=this.getMatchupsAB(hitterRotoID, pitcherRotoID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?,matchups.AB=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setString(3,hitterRotoID);
                        preparedStatement.setString(4,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }      
          if(result.equals("SH")&&result.equals("SF")){
              // +PA, +AB
                  int pa=this.getMatchupsPA(hitterRotoID, pitcherRotoID);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.matchups values(?,?,1,0,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
                        preparedStatement.setString(1,hitterRotoID);
                        preparedStatement.setString(2,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                  }else{
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.matchups SET matchups.PA=?  WHERE matchups.hitterID=? AND matchups.pitcherID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setString(2,hitterRotoID);
                        preparedStatement.setString(3,pitcherRotoID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
      }
  }
  
  public void addPitcherParkResult(String rotoID, String parkID, String result) throws SQLException{
      //Skip. Do nothing.
      //Out,  SF, SH: +BF+I
      //S:   +BF+H
      //D: +BF+H +2B
      //T: +BF+H +3B
      //HR:+BF+H +HR
      //K: +BF+I, +K
      //W: +BF+BB
      //HP: +BF+HBP
      //IW: +BF+IW+BB
      //PO, CS: +I
      //E: +BF
      if(result.equals("Skip")==false){
           if(result.equals("Out")||result.equals("SF")||result.equals("SH")){
                  // +BF, +I
                  int bf=this.getPitcherParkBF(rotoID,parkID);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, G, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                  }else{
                        int i=this.getPitcherParkI(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE SANTANA.parkPitchers SET parkPitchers.BF=?,parkPitchers.I=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,i+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("S")){
                 //S: +BF, +H
                 int bf=this.getPitcherParkBF(rotoID, parkID);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int h=this.getPitcherParkH(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.BF=?,parkPitchers.H=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,h+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("D")){
              //D: +BF, +H, +D
                 int bf=this.getPitcherParkBF(rotoID, parkID);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int h=this.getPitcherParkH(rotoID, parkID);
                        int d=this.getPitcherParkD(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE SANTANA.parkPitchers SET parkPitchers.BF=?, parkPitchers.H=?, parkPitchers.2B=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,h+1);
                        preparedStatement.setInt(3,d+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("T")){
              //T: +PA, +AB, +H, +T
                 int bf=this.getPitcherParkBF(rotoID, parkID);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int h=this.getPitcherParkH(rotoID, parkID);
                        int t=this.getPitcherParkT(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE SANTANA.parkPitchers SET parkPitchers.BF=?, parkPitchers.H=?, parkPitchers.3B=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,h+1);
                        preparedStatement.setInt(3,t+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("HR")){
              //HR: +PA, +AB, +H, +HR
              int bf=this.getPitcherParkBF(rotoID, parkID);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int h=this.getPitcherParkH(rotoID, parkID);
                        int hr=this.getPitcherParkHR(rotoID,parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.BF=?, parkPitchers.H=?,parkPitchers.HR=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,h+1);
                        preparedStatement.setInt(3,hr+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("W")){
              //W: +BF, +BB
              int bf=this.getPitcherParkBF(rotoID, parkID);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                       int w=this.getPitcherParkBB(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.BF=?, parkPitchers.BB=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,w+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("K")){
              //K: +BF, +I, +K
              int bf=this.getPitcherParkBF(rotoID, parkID);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int k=this.getPitcherParkK(rotoID, parkID);
                        int i=this.getPitcherParkI(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.BF=?, parkPitchers.I=?, parkPitchers.K=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,i+1);
                        preparedStatement.setInt(3,k+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("HP")){
                  //HP: +BF, +HP
                  int bf=this.getPitcherParkBF(rotoID, parkID);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int hp=this.getPitcherParkHBP(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.BF=?, parkPitchers.HBP=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,hp+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("IW")){
              //IW: +BF, +IW, +BB
              int bf=this.getPitcherParkBF(rotoID, parkID);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int iw=this.getPitcherParkIW(rotoID, parkID);
                        int bb=this.getPitcherParkBB(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.BF=?, parkPitchers.IW=?, parkPitchers.BB=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,iw+1);
                        preparedStatement.setInt(3,bb+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
                
          }
          if(result.equals("E")){
              //E: BF
              int bf=this.getPitcherParkBF(rotoID, parkID);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.BF=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setString(2,rotoID);
                        preparedStatement.setString(3,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("CS")||result.equals("PO")){
              //CS or PO: +I
              int bf=this.getPitcherParkBF(rotoID, parkID);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkPitchers values(?,?,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int i=this.getPitcherParkI(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkPitchers SET parkPitchers.I=?  WHERE parkPitchers.playerID=? AND parkPitchers.parkID=?");
          
                        preparedStatement.setInt(1,i+1);
                        preparedStatement.setString(2,rotoID);
                        preparedStatement.setString(3,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
      }
  }
  
  public void addPitcherTimeResult(String rotoID, String time, String result) throws SQLException{
      //Skip. Do nothing.
      //Out, SH, SF: +BF+I
      //S:   +BF+H
      //D: +BF+H +2B
      //T: +BF+H +3B
      //HR:+BF+H +HR
      //K: +BF+I, +K
      //W: +BF+BB
      //HP: +BF+HBP
      //IW: +BF+IW +BB
      //E: +BF
      // CS and PO: +I
      if(result.equals("Skip")==false){
           if(result.equals("Out")||result.equals("SH")||result.equals("SF")){
                  // +BF, +I
                  int bf=this.getPitcherTimeBF(rotoID,time);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, G, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                  }else{
                        int i=this.getPitcherTimeI(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE SANTANA.timePitchers SET timePitchers.BF=?,timePitchers.I=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,i+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("S")){
                 //S: +BF, +H
                 int bf=this.getPitcherTimeBF(rotoID, time);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int h=this.getPitcherTimeH(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.BF=?,timePitchers.H=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,h+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("D")){
              //D: +BF, +H, +D
                 int bf=this.getPitcherTimeBF(rotoID, time);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int h=this.getPitcherTimeH(rotoID, time);
                        int d=this.getPitcherTimeD(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE SANTANA.timePitchers SET timePitchers.BF=?, timePitchers.H=?, timePitchers.2B=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,h+1);
                        preparedStatement.setInt(3,d+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("T")){
              //T: +PA, +AB, +H, +T
                 int bf=this.getPitcherTimeBF(rotoID, time);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int h=this.getPitcherTimeH(rotoID, time);
                        int t=this.getPitcherTimeT(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE SANTANA.timePitchers SET timePitchers.BF=?, timePitchers.H=?, timePitchers.3B=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,h+1);
                        preparedStatement.setInt(3,t+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("HR")){
              //HR: +PA, +AB, +H, +HR
              int bf=this.getPitcherTimeBF(rotoID, time);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int h=this.getPitcherTimeH(rotoID, time);
                        int hr=this.getPitcherTimeHR(rotoID,time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.BF=?, timePitchers.H=?,timePitchers.HR=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,h+1);
                        preparedStatement.setInt(3,hr+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("W")){
              //W: +BF, +BB
              int bf=this.getPitcherTimeBF(rotoID, time);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                       int w=this.getPitcherTimeBB(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.BF=?, timePitchers.BB=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,w+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("K")){
              //K: +BF, +I, +K
              int bf=this.getPitcherTimeBF(rotoID, time);
                 //System.out.println("BF = " + bf);
                 if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int k=this.getPitcherTimeK(rotoID, time);
                        int i=this.getPitcherTimeI(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.BF=?, timePitchers.I=?, timePitchers.K=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,i+1);
                        preparedStatement.setInt(3,k+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("HP")){
                  //HP: +BF, +HP
                  int bf=this.getPitcherTimeBF(rotoID, time);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int hp=this.getPitcherTimeHBP(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.BF=?, timePitchers.HBP=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,hp+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("IW")){
              //IW: +BF, +IW +BB
              int bf=this.getPitcherTimeBF(rotoID, time);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int iw=this.getPitcherTimeIW(rotoID, time);
                        int bb=this.getPitcherTimeBB(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.BF=?, timePitchers.IW=?, timePitchers.BB=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setInt(2,iw+1);
                        preparedStatement.setInt(3,bb+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("E")){
              //E: BF
              int bf=this.getPitcherTimeBF(rotoID, time);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.BF=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,bf+1);
                        preparedStatement.setString(2,rotoID);
                        preparedStatement.setString(3,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("CS")||result.equals("PO")){
              //CS or PO: +I
              int bf=this.getPitcherTimeBF(rotoID, time);
                  //System.out.println("BF = " + bf);
                  if(bf<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timePitchers values(?,?,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "PitcherID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int i=this.getPitcherTimeI(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timePitchers SET timePitchers.I=?  WHERE timePitchers.playerID=? AND timePitchers.time=?");
          
                        preparedStatement.setInt(1,i+1);
                        preparedStatement.setString(2,rotoID);
                        preparedStatement.setString(3,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
      }
      
  }
  
  public void addHitterParkResult(String rotoID, String parkID, String result) throws SQLException{
      //Result:
      //Skip. Do nothing.
      //Out: +PA, +AB
      //S: +PA, +AB, +H
      //D: +PA, +AB, +H, +D
      //T: +PA, +AB, +H, +T
      //HR: +PA, +AB, +H, +HR
      //W: +PA, +W
      //K: +PA, +AB, +K
      //W: +PA, +W
      //HP: +PA, +HP
      //IW: +PA, +IW
      //SH, SF: +PA
       if(result.equals("Skip")==false&&result.equals("CS")==false&&result.equals("PO")==false){
           if(result.equals("Out")||result.equals("E")){
                  // +PA, +AB
                  int pa=this.getHitterParkPA(rotoID,parkID);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, G, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                  }else{
                        int ab=this.getHitterParkAB(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=?,parkHitters.AB=?  WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("S")){
                 //S: +PA, +AB, +H
                 int pa=this.getHitterParkPA(rotoID, parkID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getHitterParkAB(rotoID, parkID);
                        int h=this.getHitterParkH(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=?,parkHitters.AB=?, parkHitters.H=?  WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("D")){
              //D: +PA, +AB, +H, +D
                 int pa=this.getHitterParkPA(rotoID, parkID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getHitterParkAB(rotoID, parkID);
                        int h=this.getHitterParkH(rotoID, parkID);
                        int d=this.getHitterParkD(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=?,parkHitters.AB=?, parkHitters.H=?, parkHitters.2B=?  WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setInt(4,d+1);
                        preparedStatement.setString(5,rotoID);
                        preparedStatement.setString(6,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("T")){
              //T: +PA, +AB, +H, +T
                 int pa=this.getHitterParkPA(rotoID, parkID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getHitterParkAB(rotoID, parkID);
                        int h=this.getHitterParkH(rotoID, parkID);
                        int t=this.getHitterParkT(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=?,parkHitters.AB=?, parkHitters.H=?, parkHitters.3B=?  WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setInt(4,t+1);
                        preparedStatement.setString(5,rotoID);
                        preparedStatement.setString(6,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("HR")){
              //HR: +PA, +AB, +H, +HR
              int pa=this.getHitterParkPA(rotoID, parkID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,1,1,0,0,1,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getHitterParkAB(rotoID, parkID);
                        int h=this.getHitterParkH(rotoID, parkID);
                        int hr=this.getHitterParkHR(rotoID,parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=?,parkHitters.AB=?, parkHitters.H=?,parkHitters.HR=?  WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setInt(4,hr+1);
                        preparedStatement.setString(5,rotoID);
                        preparedStatement.setString(6,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("W")){
              //W: +PA, +W
              int pa=this.getHitterParkPA(rotoID, parkID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                       int w=this.getHitterParkBB(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=?, parkHitters.BB=?  WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,w+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("K")){
              //K: +PA, +AB, +K
              int pa=this.getHitterParkPA(rotoID, parkID);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int k=this.getHitterParkK(rotoID, parkID);
                        int ab=this.getHitterParkAB(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=?, parkHitters.AB=?, parkHitters.K=?  WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,k+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("HP")){
                  //HP: +PA, +HP
                  int pa=this.getHitterParkPA(rotoID, parkID);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int hp=this.getHitterParkHBP(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=?, parkHitters.HBP=?  WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,hp+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("IW")){
              //IW: +PA, +IW
              int pa=this.getHitterParkPA(rotoID, parkID);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int iw=this.getHitterParkIW(rotoID, parkID);
                        int bb=this.getHitterParkBB(rotoID, parkID);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=?, parkHitters.IW=?, parkHitters.BB=?  WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,iw+1);
                        preparedStatement.setInt(3,bb+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("SH")||result.equals("SF")){
                  // +PA
                  int pa=this.getHitterParkPA(rotoID,parkID);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.parkHitters values(?,?,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, G, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                  }else{
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.parkHitters SET parkHitters.PA=? WHERE parkHitters.playerID=? AND parkHitters.parkID=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setString(2,rotoID);
                        preparedStatement.setString(3,parkID);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
      }
  }
  
  public void addHitterTimeResult(String rotoID, String time, String result) throws SQLException{
       if(result.equals("Skip")==false&&result.equals("CS")==false&&result.equals("PO")==false){
           if(result.equals("Out")||result.equals("E")){
                  // +PA, +AB
                  int pa=this.getHitterTimePA(rotoID,time);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, G, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                  }else{
                        int ab=this.getHitterTimeAB(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=?,timeHitters.AB=?  WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("S")){
                 //S: +PA, +AB, +H
                 int pa=this.getHitterTimePA(rotoID, time);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getHitterTimeAB(rotoID, time);
                        int h=this.getHitterTimeH(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=?,timeHitters.AB=?, timeHitters.H=?  WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("D")){
              //D: +PA, +AB, +H, +D
                 int pa=this.getHitterTimePA(rotoID, time);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getHitterTimeAB(rotoID, time);
                        int h=this.getHitterTimeH(rotoID, time);
                        int d=this.getHitterTimeD(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=?,timeHitters.AB=?, timeHitters.H=?, timeHitters.2B=?  WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setInt(4,d+1);
                        preparedStatement.setString(5,rotoID);
                        preparedStatement.setString(6,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("T")){
              //T: +PA, +AB, +H, +T
                 int pa=this.getHitterTimePA(rotoID, time);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getHitterTimeAB(rotoID, time);
                        int h=this.getHitterTimeH(rotoID, time);
                        int t=this.getHitterTimeT(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=?,timeHitters.AB=?, timeHitters.H=?, timeHitters.3B=?  WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setInt(4,t+1);
                        preparedStatement.setString(5,rotoID);
                        preparedStatement.setString(6,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("HR")){
              //HR: +PA, +AB, +H, +HR
              int pa=this.getHitterTimePA(rotoID, time);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,1,1,0,0,1,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int ab=this.getHitterTimeAB(rotoID, time);
                        int h=this.getHitterTimeH(rotoID, time);
                        int hr=this.getHitterTimeHR(rotoID,time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=?,timeHitters.AB=?, timeHitters.H=?,timeHitters.HR=?  WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,h+1);
                        preparedStatement.setInt(4,hr+1);
                        preparedStatement.setString(5,rotoID);
                        preparedStatement.setString(6,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("W")){
              //W: +PA, +W
              int pa=this.getHitterTimePA(rotoID, time);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                       int w=this.getHitterTimeBB(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=?, timeHitters.BB=?  WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,w+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("K")){
              //K: +PA, +AB, +K
              int pa=this.getHitterTimePA(rotoID, time);
                 //System.out.println("PA = " + pa);
                 if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int k=this.getHitterTimeK(rotoID, time);
                        int ab=this.getHitterTimeAB(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=?, timeHitters.AB=?, timeHitters.K=?  WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,ab+1);
                        preparedStatement.setInt(3,k+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("HP")){
                  //HP: +PA, +HP
                  int pa=this.getHitterTimePA(rotoID, time);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int hp=this.getHitterTimeHBP(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=?, timeHitters.HBP=?  WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,hp+1);
                        preparedStatement.setString(3,rotoID);
                        preparedStatement.setString(4,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          
          if(result.equals("IW")){
              //IW: +PA, +IW +BB
              int pa=this.getHitterTimePA(rotoID, time);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0)");
                        // "HitterID, pitcherID, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
          
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                 }else{
                        int iw=this.getHitterTimeIW(rotoID, time);
                        int bb=this.getHitterTimeBB(rotoID, time);
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=?, timeHitters.IW=?, timeHitters.BB=?  WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setInt(2,iw+1);
                        preparedStatement.setInt(3,bb+1);
                        preparedStatement.setString(4,rotoID);
                        preparedStatement.setString(5,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
          if(result.equals("SH")||result.equals("SF")){
                  // +PA
                  int pa=this.getHitterTimePA(rotoID,time);
                  //System.out.println("PA = " + pa);
                  if(pa<0){
                        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT into SANTANA.timeHitters values(?,?,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0)");
                        // "HitterID, pitcherID, G, PA, AB, H, 2B, 3B, HR, RBI, BB, IW, HBP, K, GDP");
                       
                        preparedStatement.setString(1,rotoID);
                        preparedStatement.setString(2,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
      
                  }else{
                        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Santana.timeHitters SET timeHitters.PA=? WHERE timeHitters.playerID=? AND timeHitters.time=?");
          
                        preparedStatement.setInt(1,pa+1);
                        preparedStatement.setString(2,rotoID);
                        preparedStatement.setString(3,time);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                }
          }
               
      } 

      //Result:
      //Skip. Do nothing.
      //Out: +PA, +AB
      //S: +PA, +AB, +H
      //D: +PA, +AB, +H, +D
      //T: +PA, +AB, +H, +T
      //HR: +PA, +AB, +H, +HR
      //W: +PA, +W
      //K: +PA, +AB, +K
      //W: +PA, +W
      //HP: +PA, +HP
      //IW: +PA, +IW
  }
  
  public void deleteOldRegisters() throws SQLException{
      PreparedStatement preparedStatement = connect.prepareStatement("SELECT * from SANTANA.Master");
      ResultSet resultSet=preparedStatement.executeQuery();
      String playerID="";
      String finalGame="";
      String birthYear="";
     
      while(resultSet.next()){
            playerID = resultSet.getString("playerID");
            finalGame= resultSet.getString("finalGame");
            birthYear=resultSet.getString("birthYear");
            
            if(finalGame.isEmpty()==false){
                String[] array=finalGame.split("/");
                String year=array[2];
                if(Integer.valueOf(year)<2009){
                    PreparedStatement preparedStatement2 = connect.prepareStatement("DELETE from SANTANA.Master WHERE Master.playerID=? ");
                    preparedStatement2.setString(1, playerID);
                    preparedStatement2.executeUpdate();
                }
            }
            
            if(Integer.valueOf(birthYear)<1965){
                PreparedStatement preparedStatement2 = connect.prepareStatement("DELETE from SANTANA.Master WHERE Master.playerID=? ");
                preparedStatement2.setString(1, playerID);
                preparedStatement2.executeUpdate();
                preparedStatement2.close();
            }
      }
      preparedStatement.close();
  }
  
  public void deleteBadRegisters() throws SQLException{
        PreparedStatement preparedStatement = connect.prepareStatement("DELETE from SANTANA.timePitchers WHERE timePitchers.bf=0");
        preparedStatement.executeUpdate();
        
        PreparedStatement preparedStatement2 = connect.prepareStatement("DELETE from SANTANA.parkPitchers WHERE parkPitchers.bf=0");
        preparedStatement2.executeUpdate();
        preparedStatement.close();
        preparedStatement2.close();
    }
    
  public String[] getName(String rotoPlayerID) throws SQLException{
        String name[]= new String[2];
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT nameFirst, nameLast from SANTANA.master WHERE retroID=?");
        preparedStatement.setString(1,rotoPlayerID);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            name[0] = resultSet.getString("nameFirst");
            name[1] = resultSet.getString("nameLast");
        }
        resultSet.close();
        preparedStatement.close();
        return name;
        
    }
    
  public void deleteOldTeams() throws SQLException{
        PreparedStatement preparedStatement = connect.prepareStatement("DELETE from SANTANA.teams WHERE teams.yearID<2000");
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
  public void addParkTeams() throws SQLException{
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT DISTINCT teams.park, teams.teamID from SANTANA.teams WHERE yearID='2013'");
        ResultSet resultSet=preparedStatement.executeQuery();
        String parkName="";
        String teamID="";
        
        while(resultSet.next()){
            parkName=resultSet.getString("park");
            teamID=resultSet.getString("teamID");
        
            PreparedStatement preparedStatement2 = connect.prepareStatement("UPDATE santana.parks SET parks.teamID=? WHERE parks.ParkName=?");
            preparedStatement2.setString(1,teamID);
            preparedStatement2.setString(2,parkName);
            preparedStatement2.executeUpdate();
        
            PreparedStatement preparedStatement3 = connect.prepareStatement("SELECT parks.parkName, parks.teamID FROM santana.parks WHERE parks.parkName=?");
            preparedStatement3.setString(1,parkName);
            ResultSet resultSet3=preparedStatement3.executeQuery();
        
            if(resultSet3.next()==false){
                System.out.println("NOT FOUND: "+parkName+ " "+ teamID);
            }
        }
    }
    
  public boolean isActive(String rotoPlayerID) throws SQLException{
        boolean isActive=false;
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT nameFirst from SANTANA.master WHERE retroID=?");
        preparedStatement.setString(1,rotoPlayerID);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            isActive=true;
        }
        resultSet.close();
        preparedStatement.close();
        return isActive;
    }
    
  public void printTimePitchers() throws SQLException{
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT distinct playerID from SANTANA.timePitchers");
        ResultSet resultSet=preparedStatement.executeQuery();
     
        String playerID="";
        String Time="";
        int g=0;
        int gs=0;
        int bf=0;
        int i=0;
        int w=0;
        int l=0;
        int sv=0;
        int k=0;
        int bb=0;
        int iw=0;
        int hbp=0;
        int h=0;
        int hr=0;
        int d=0;
        int t=0;
        int r=0;
        int er=0;
        
        while(resultSet.next()){
            playerID = resultSet.getString("playerID");
            PreparedStatement preparedStatement2 = connect.prepareStatement("SELECT g,gs,bf,i,w,l,sv,k,bb,iw,hbp,h,hr,2b,3b,r,er from SANTANA.timePitchers WHERE timePitchers.playerID=? AND timePitchers.time='day'");
            preparedStatement2.setString(1,playerID);
            ResultSet resultSet2=preparedStatement2.executeQuery();
            
            while(resultSet2.next()){
                  g=Integer.valueOf(resultSet2.getString("g"));
                  gs=Integer.valueOf(resultSet2.getString("gs"));
                  bf=Integer.valueOf(resultSet2.getString("bf"));
                  i=Integer.valueOf(resultSet2.getString("i"));
                  w=Integer.valueOf(resultSet2.getString("w"));
                  l=Integer.valueOf(resultSet2.getString("l"));
                  sv=Integer.valueOf(resultSet2.getString("sv"));
                  k=Integer.valueOf(resultSet2.getString("k"));
                  bb=Integer.valueOf(resultSet2.getString("bb"));
                  iw=Integer.valueOf(resultSet2.getString("iw"));
                  hbp=Integer.valueOf(resultSet2.getString("hbp"));
                  h=Integer.valueOf(resultSet2.getString("h"));
                  hr=Integer.valueOf(resultSet2.getString("hr"));
                  d=Integer.valueOf(resultSet2.getString("2b"));
                  t=Integer.valueOf(resultSet2.getString("3b"));
                  r=Integer.valueOf(resultSet2.getString("r"));
                  er=Integer.valueOf(resultSet2.getString("er"));
            }
            
            PreparedStatement preparedStatement3 = connect.prepareStatement("SELECT g,gs,bf,i,w,l,sv,k,bb,iw,hbp,h,hr,2b,3b,r,er from SANTANA.timePitchers WHERE timePitchers.playerID=? AND timePitchers.time='night'");
            preparedStatement3.setString(1,playerID);
            ResultSet resultSet3=preparedStatement3.executeQuery();
                  
            while(resultSet3.next()){
                  g=g+Integer.valueOf(resultSet3.getString("g"));
                  gs=gs+Integer.valueOf(resultSet3.getString("gs"));
                  bf=bf+Integer.valueOf(resultSet3.getString("bf"));
                  i=i+Integer.valueOf(resultSet3.getString("i"));
                  w=w+Integer.valueOf(resultSet3.getString("w"));
                  l=l+Integer.valueOf(resultSet3.getString("l"));
                  sv=sv+Integer.valueOf(resultSet3.getString("sv"));
                  k=k+Integer.valueOf(resultSet3.getString("k"));
                  bb=bb+Integer.valueOf(resultSet3.getString("bb"));
                  iw=iw+Integer.valueOf(resultSet3.getString("iw"));
                  hbp=hbp+Integer.valueOf(resultSet3.getString("hbp"));
                  h=h+Integer.valueOf(resultSet3.getString("h"));
                  hr=hr+Integer.valueOf(resultSet3.getString("hr"));
                  d=d+Integer.valueOf(resultSet3.getString("2b"));
                  t=t+Integer.valueOf(resultSet3.getString("3b"));
                  r=r+Integer.valueOf(resultSet3.getString("r"));
                  er=er+Integer.valueOf(resultSet3.getString("er"));
            }
            preparedStatement3.close();
            preparedStatement2.close();
            String name[]=this.getName(playerID);
            
            System.out.println(name[0]+" "+name[1]+":" + " g= "+ g + " gs= " + gs + " bf= "+ bf+ " i= "+ i + " w= "+ w
            + " l= "+ l + " sv= "+ sv + " k= "+ k +" bb= "+ bb + " iw= " + iw +" hbp= " + hbp + " h= "+ h + " hr= " + hr
            + " d= "+ d + " t= "+ t + "r= "+ r + " er= "+er);
         }
        preparedStatement.close();
      }
    
  public void printTimeHitters() throws SQLException{
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT distinct playerID from SANTANA.timeHitters");
        ResultSet resultSet=preparedStatement.executeQuery();
     
        String playerID="";
        String Time="";
        int g=0;
        int pa=0;
        int ab=0;
        int k=0;
        int bb=0;
        int iw=0;
        int hbp=0;
        int h=0;
        int hr=0;
        int d=0;
        int t=0;
        
        while(resultSet.next()){
            playerID = resultSet.getString("playerID");
            PreparedStatement preparedStatement2 = connect.prepareStatement("SELECT g,pa,ab,k,bb,iw,hbp,h,hr,2b,3b from SANTANA.timeHitters WHERE timeHitters.playerID=? AND timeHitters.time='day'");
            preparedStatement2.setString(1,playerID);
            ResultSet resultSet2=preparedStatement2.executeQuery();
            
            while(resultSet2.next()){
                  g=Integer.valueOf(resultSet2.getString("g"));
                  pa=Integer.valueOf(resultSet2.getString("pa"));
                  ab=Integer.valueOf(resultSet2.getString("ab"));
                  k=Integer.valueOf(resultSet2.getString("k"));
                  bb=Integer.valueOf(resultSet2.getString("bb"));
                  iw=Integer.valueOf(resultSet2.getString("iw"));
                  hbp=Integer.valueOf(resultSet2.getString("hbp"));
                  h=Integer.valueOf(resultSet2.getString("h"));
                  hr=Integer.valueOf(resultSet2.getString("hr"));
                  d=Integer.valueOf(resultSet2.getString("2b"));
                  t=Integer.valueOf(resultSet2.getString("3b"));
            }
            
            PreparedStatement preparedStatement3 = connect.prepareStatement("SELECT g,pa,ab,k,bb,iw,hbp,h,hr,2b,3b from SANTANA.timeHitters WHERE timeHitters.playerID=? AND timeHitters.time='night'");
            preparedStatement3.setString(1,playerID);
            ResultSet resultSet3=preparedStatement3.executeQuery();
                  
            while(resultSet3.next()){
                  g=g+Integer.valueOf(resultSet3.getString("g"));
                  pa=pa+Integer.valueOf(resultSet3.getString("pa"));
                  ab=ab+Integer.valueOf(resultSet3.getString("ab"));
                  k=k+Integer.valueOf(resultSet3.getString("k"));
                  bb=bb+Integer.valueOf(resultSet3.getString("bb"));
                  iw=iw+Integer.valueOf(resultSet3.getString("iw"));
                  hbp=hbp+Integer.valueOf(resultSet3.getString("hbp"));
                  h=h+Integer.valueOf(resultSet3.getString("h"));
                  hr=hr+Integer.valueOf(resultSet3.getString("hr"));
                  d=d+Integer.valueOf(resultSet3.getString("2b"));
                  t=t+Integer.valueOf(resultSet3.getString("3b"));
            }
            preparedStatement3.close();
            preparedStatement2.close();
            resultSet3.close();
            resultSet2.close();
            String name[]=this.getName(playerID);
            
            System.out.println(name[0]+" "+name[1]+":" + " g= "+ g + " pa= " + pa + " ab= "+ ab+ " k= "+ k +" bb= "+ bb + " iw= " + iw +" hbp= " + hbp + " h= "+ h + " hr= " + hr
            + " d= "+ d + " t= "+ t);
         }
        preparedStatement.close();
        resultSet.close();
      }
  
} 
