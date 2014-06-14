package databasefiller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Character.isDigit;
import java.sql.SQLException;

/**
 *
 * @author hugo
 */
public class DatabaseFiller {

    public static MySQLAccessRotoID db = new MySQLAccessRotoID();
    
    public static void main(String[] args) throws IOException, Exception {
        DatabaseFiller.db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/santana?"+"user=root&password=root");
        
        //RUN!
        
        //final File[] allRosters=DatabaseFiller.getRosters(); //I think not used anymore.
        final File[] allGames=DatabaseFiller.getGames();
        
        //DatabaseFiller.setHasTable(allRosters); //I think not used anymore.
        
        for(int i =0; i<allGames.length; i++){
            DatabaseFiller.getGamesInFolder(allGames[i]);
        }
        //db.addParkTeams();
        //db.printTimeHitters();
        //Object[] keysArrays=DatabaseFiller.playersHash.keySet().toArray();
        //for(int i =0; i<keysArrays.length; i++){
            //PlayerInfo playerInfo=(PlayerInfo)DatabaseFiller.playersHash.get(keysArrays[i]);
            //System.out.println(playerInfo.name+" "+playerInfo.lastName + "-"+playerInfo.position+"-"+playerInfo.team);
        //}
        
        
        
    }
    
    public static File[] getRosters(){
        
        //final File rosters2000 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2000eve/Rosters");
        //final File rosters2001 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2001eve/Rosters");
        //final File rosters2002 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2002eve/Rosters");
        //final File rosters2003 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2003eve/Rosters");
        //final File rosters2004 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2004eve/Rosters");
        //final File rosters2005 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2005eve/Rosters");
        //final File rosters2006 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2006eve/Rosters");
        //final File rosters2007 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2007eve/Rosters");
        //final File rosters2008 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2008eve/Rosters");
        //final File rosters2009 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2009eve/Rosters");
        //final File rosters2010 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2010eve/Rosters");
        //final File rosters2011 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2011eve/Rosters");
        //final File rosters2012 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2012eve/Rosters");
        final File rosters2013 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2013eve/Rosters");
        
        File[] allRosters={rosters2013};//, rosters2001, rosters2002, rosters2003, rosters2004, rosters2005, rosters2006,rosters2007, rosters2008, rosters2009, rosters2010, rosters2011, rosters2012, rosters2013};
        
        return allRosters;
    }
    
    public static File[] getGames(){
        
        //final File games2000 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2000eve/Games");
        //final File games2001 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2001eve/Games");
        //final File games2002 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2002eve/Games");
        //final File games2003 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2003eve/Games");
        //final File games2004 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2004eve/Games");
        //final File games2005 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2005eve/Games");
        //final File games2006 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2006eve/Games");
        //final File games2007 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2007eve/Games");
        //final File games2008 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2008eve/Games");
        //final File games2009 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2009eve/Games");
        //final File games2010 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2010eve/Games");
        //final File games2011 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2011eve/Games");
        //final File games2012 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2012eve/Games");
        final File games2013 = new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/2013eve/Games");
        
        File[] allGames={games2013};//, games2001, games2002, games2003, games2004, games2005, games2006,games2007, games2008, games2009, games2010, games2011, games2012, games2013};
        
        return allGames;
    }
    
    public static void getGamesInFolder(final File folderPath) throws IOException, FileNotFoundException, SQLException{
        File currentFile;
        for (final File fileEntry : folderPath.listFiles()) {
            if(fileEntry.getName().equals(".DS_Store")==false){
               currentFile= new File(folderPath+"/"+fileEntry.getName());
               DatabaseFiller.readGameFile(currentFile);
            }
        }
    }
    
    public static void readGameFile(File filePath) throws FileNotFoundException, IOException, SQLException{
        BufferedReader br = new BufferedReader(new FileReader(filePath));
    
        String pitcherHomeID="";
        String pitcherVisitID="";
        String hitterHomeID="";
        String hitterVisitID="";
        String hitterStartID="";
        String hitterSubID="";
        String time="";
        String parkID="";
        String savePitcherID="";
        String winPitcherID="";
        String losePitcherID="";
        String erPitcherID="";
        String erNumber="";
        String result="";
        
        try {
            String line = br.readLine();
            
            while (line != null) {
                String[] currentValues = line.split(",");
                    
                  
                    //----------------------------------------------
                    //INFO 
                    if(currentValues[0].equals("info")){
                        //------------------------------------------
                        //PARK
                        if(currentValues[1].equals("site")){
                            parkID=currentValues[2];
                        }
                        //------------------------------------------
                        //TIME
                        if(currentValues[1].equals("daynight")){
                            time=currentValues[2];
                        }
                        if(currentValues.length>2){
                            if(db.isActive(currentValues[2])){
                                //-----------------------------------------
                                //WIN Pitcher.
                                if(currentValues[1].equals("wp")){
                                    if(currentValues.length==3){
                                        winPitcherID=currentValues[2];
                                        db.addPitcherParkWin(winPitcherID, parkID);
                                        db.addPitcherTimeWin(winPitcherID, time);
                                    }
                                }
                                //-----------------------------------------
                                //LOSE PITCHER
                                if(currentValues[1].equals("lp")){
                                    if(currentValues.length==3){
                                        losePitcherID=currentValues[2];
                                            db.addPitcherParkLose(losePitcherID, parkID);
                                            db.addPitcherTimeLose(losePitcherID, time);
                                    }
                                    //DO SQL
                                }
                                //------------------------------------------
                                //SAVE PITCHER
                                if(currentValues[1].equals("save")){
                                    if(currentValues.length==3){
                                        savePitcherID=currentValues[2];
                                        db.addPitcherParkSV(savePitcherID, parkID);
                                        db.addPitcherTimeSV(savePitcherID, time);
                                    }else{
                                        savePitcherID="";
                                    }
                                }
                            }
                        }
                    }
                    //----------------------------------------------
                    //START
                    if(currentValues[0].equals("start")){
                            //------------------------------------------
                            //Visiting Pitcher.
                            if(currentValues[5].equals("1")&&currentValues[3].equals("0")){
                                pitcherVisitID=currentValues[1];
                                if(db.isActive(pitcherVisitID)){
                                    db.addPitcherParkGS(pitcherVisitID, parkID);
                                    db.addPitcherTimeGS(pitcherVisitID, time);
                                }
                            }
                            //------------------------------------------
                            //Home Pitcher.
                            if(currentValues[5].equals("1")&&currentValues[3].equals("1")){
                                pitcherHomeID=currentValues[1];
                                if(db.isActive(pitcherHomeID)){
                                    db.addPitcherParkGS(pitcherHomeID, parkID);
                                    db.addPitcherTimeGS(pitcherHomeID, time);
                                }
                            }
                        
                            if(currentValues[5].equals("1")==false){
                                hitterStartID=currentValues[1];
                                if(db.isActive(hitterStartID)){
                                    db.addHitterParkG(hitterStartID, parkID);
                                    db.addHitterTimeG(hitterStartID, time);
                                }
                            }
                    }
                    //----------------------------------------------
                    //PLAY
                    if(currentValues[0].equals("play")){
                        //NO PLAY CHECK.
                        if(currentValues[6].equals("NP")==false){
                            //Home hitter, visit pitcher
                            if(currentValues[2].equals("1")){
                                hitterHomeID=currentValues[3];
                                result=currentValues[6];
                                result=DatabaseFiller.getResult(result);
                                if(db.isActive(hitterHomeID)&&db.isActive(pitcherVisitID)){
                                    db.addMatchResult(hitterHomeID, pitcherVisitID,result);
                                    db.addHitterParkResult(hitterHomeID, parkID, result);
                                    db.addHitterTimeResult(hitterHomeID, time, result);
                                    db.addPitcherParkResult(pitcherVisitID, parkID, result);
                                    db.addPitcherTimeResult(pitcherVisitID, time, result);
                                }else{
                                    if(db.isActive(hitterHomeID)){
                                        db.addHitterParkResult(hitterHomeID, parkID, result);
                                        db.addHitterTimeResult(hitterHomeID, time, result);
                                    }
                                    if(db.isActive(pitcherVisitID)){
                                        db.addPitcherParkResult(pitcherVisitID, parkID, result);
                                        db.addPitcherTimeResult(pitcherVisitID, time, result);
                                    }
                                }
                            }
                            //Visit hitter, Home pitcher
                            if(currentValues[2].equals("0")){
                                hitterVisitID=currentValues[3];
                                result=currentValues[6];
                                result=DatabaseFiller.getResult(result);
                                if(db.isActive(hitterVisitID)&&db.isActive(pitcherHomeID)){
                                    db.addMatchResult(hitterVisitID, pitcherHomeID,result);
                                    db.addHitterParkResult(hitterVisitID, parkID, result);
                                    db.addHitterTimeResult(hitterVisitID, time, result);
                                    db.addPitcherParkResult(pitcherHomeID, parkID, result);
                                    db.addPitcherTimeResult(pitcherHomeID, time, result);
                                }else{
                                    if(db.isActive(hitterVisitID)){
                                        db.addHitterParkResult(hitterVisitID, parkID, result);
                                        db.addHitterTimeResult(hitterVisitID, time, result);
                                    }
                                    if(db.isActive(pitcherHomeID)){
                                        db.addPitcherParkResult(pitcherHomeID, parkID, result);
                                        db.addPitcherTimeResult(pitcherHomeID, time, result);
                                    }
                                }
                            }
                        }
                    }
                    //----------------------------------------------
                    //SUB
                    if(currentValues[0].equals("sub")){
                        //Check position = Pitcher.
                        if(currentValues[5].equals("1")){
                            //Home pitcher.
                            if(currentValues[3].equals("1")){
                                pitcherHomeID=currentValues[1];
                                if(db.isActive(pitcherHomeID)){
                                    db.addPitcherParkG(pitcherHomeID, parkID);
                                    db.addPitcherTimeG(pitcherHomeID, time);
                                }
                            }
                            //Visit Pitcher
                            if(currentValues[3].equals("0")){
                                pitcherVisitID=currentValues[1];
                                if(db.isActive(pitcherVisitID)){
                                    db.addPitcherParkG(pitcherVisitID, parkID);
                                    db.addPitcherTimeG(pitcherVisitID, time);
                                }
                            }
                        }else{
                            hitterSubID=currentValues[1];
                            if(db.isActive(hitterSubID)){
                                db.addHitterParkG(hitterSubID, parkID);
                                db.addHitterTimeG(hitterSubID, time);
                            }
                        }
                        //Add G substitution player.
                    }
                    //---------------------------------------------
                    //DATA
                    if(currentValues[0].equals("data")){
                        //ER Pitcher.
                        if(currentValues[1].equals("er")&&(currentValues[3].equals("0")==false)){
                            erPitcherID=currentValues[2];
                            erNumber=currentValues[3];
                            if(db.isActive(erPitcherID)){
                                db.addPitcherParkER(erPitcherID, parkID,erNumber);
                                db.addPitcherTimeER(erPitcherID, time,erNumber);
                            }
                        }
                    }
                
                line = br.readLine();
            }
        } finally {
            br.close();
        }
    }

    public static String convertResult(String result){
           String originalResult=result;
           
           if(result.length()>2){
                result=result.substring(0, 2);
           }
           if(isDigit(result.charAt(0))||result.equals("FC")){
                result="Out";
                return result;
           }else if(result.equals("SB")||result.equals("PB")||result.equals("BK")||result.equals("OA")||result.equals("FL")||result.equals("DI")||result.equals("WP")){
                result="Skip";
                return result;
           }else if(result.charAt(0)=='S'||result.charAt(0)=='D'||result.charAt(0)=='T'||result.charAt(0)=='W'||result.charAt(0)=='K'||result.charAt(0)=='E'){
                result=result.substring(0, 1);
                return result;
           }else if(result.equals("HP")||result.equals("IW")||result.equals("HR")||result.equals("CS")||result.equals("PO")){
                result=result.substring(0, 2);
                return result;
           }else if(result.charAt(0)=='C'){
                System.out.println("C FOUND");
                result="Skip";
                return result;
           }else{
               result="ERROR!"+ "Original: "+originalResult+" second: "+ result;
               System.out.println(result);
               return result;
           }
                
        
    }
    
    public static String getResult(String result){
        int breakIndex=0;
        boolean isSHSF=false;
        if(result.contains("SH.")){
            return "SH";
        }
        
        if(result.contains("SF.")){
            return "SF";
        }      
        
        for(int i = 0; i<result.length(); i++){
            if((result.charAt(i)=='/')||(result.charAt(i)=='.')||(result.charAt(i)=='+')){
                breakIndex=i;
                i=result.length();
            }
        }
        
        if(breakIndex!=0){
            result=result.substring(0, breakIndex);
            return DatabaseFiller.convertResult(result);
        }else{
            return DatabaseFiller.convertResult(result);
        }
    }
    
}

