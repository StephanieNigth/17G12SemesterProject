/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jacobs_package;

import Stephie_build.Labyrinth;
import static Stephie_build.Labyrinth.DIR.E;
import static Stephie_build.Labyrinth.DIR.N;
import static Stephie_build.Labyrinth.DIR.S;
import static Stephie_build.Labyrinth.DIR.W;
import Stephie_build.Room;
import nicolai.Player;


/**
 *
 * @author simon
 */
public class View {
    
    private MovePlayer movePlayer;
    private final Labyrinth.DIR facing = movePlayer.getFacing();
    private Player player;

    public void View(){
        int ID = 0;
        /* ID is effectively used as the first 6 digits in binary.
        1 means door exists, each 0 means it doesn't.
        111111 - each digit respectively represents a door as following:
        (next room middle door), (next room right door), (next room left door),
        (current room middle door), (current room right door), (current room left door).
        */
        Room currentRoom = player.getCurrentRoom();
        
        if(currentRoom.getExit(facing.left.direction) != null){
            ID +=1;
        }
        if(currentRoom.getExit(facing.right.direction) != null){
            ID +=2;
        }
        
        Room nextRoom = player.getCurrentRoom().getExit(facing.direction);//TEMP does enum.toString() get the associated string in Labyrinth.DIR?
        
        if(nextRoom != null){
            if(nextRoom.getExit(facing.left.direction) != null){
                ID += 8;
            }
            if(nextRoom.getExit(facing.right.direction) != null){
                ID += 16;
            }
            //make corresponding room type(GUI) visible in the next room area, and others invisible.
            if(nextRoom.getExit(facing.direction) != null){ //perhaps we wanna see if there's a wall in front of next room?
                ID += 32;
            }
        }
        else{
            ID += 4;
        }
        //if((ID >> depth) % 2 == 1){} //used to read the bits. depth determines which bit from the right to read.
    }
}