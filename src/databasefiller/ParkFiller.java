/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databasefiller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author hugo
 */
public class ParkFiller {
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        final File parks=new File("/Users/hugo/Documents/Side Projects/Baseball/Raw Files/parks.txt");
        ParkFiller.readParksFile(parks);
    }
    
    public static void readParksFile(File filePath) throws FileNotFoundException, IOException, SQLException{
        MySQLAccessRotoID db = new MySQLAccessRotoID();
        db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:8889/santana?"+"user=root&password=root");
        
        BufferedReader br = new BufferedReader(new FileReader(filePath));
    
        String parkID="";
        String name="";
        String city="";
        String state="";
        String league="";
        
        try {
            String line = br.readLine();
            line = br.readLine();
            
            while (line != null) {
                String[] currentValues = line.split(",");
                parkID=currentValues[0];
                name=currentValues[1];
                city=currentValues[3];
                state=currentValues[4];
                league=currentValues[7];
                
                db.writeParks(parkID, name, city, state, league);
                //System.out.println(parkID+"-"+name+"-"+city+"-"+state+"-"+league);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
    }
}
