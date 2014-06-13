/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databasefiller;

/**
 *
 * @author hugo
 */
public class PlayerInfo {
    String name;
    String lastName;
    String position;
    String team;
    
    public PlayerInfo(String name, String lastName, String position, String team){
        this.name=name;
        this.lastName=lastName;
        this.position=position;
        this.team=team;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getPosition(){
        return position;
    }
    
    public String getlastTeam(){
        return team;
    }
    
}
