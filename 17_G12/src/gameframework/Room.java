package gameframework;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    /**
     * 
     * Gets the discription of the Room
     * @return Discription
     */
    public String getShortDescription()
    {
        return description;
    }
    /**
     * Gets a formated string with the description of the room and it's exists
     * @return Long Decription of the room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    /**
     * a string with all the exits of the room
     * @return Exists  
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    /**
     * 
     * @param direction you whant to go in, North, South, West and east
     * @return Room at the Exit
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}
