/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import acquaintance.IGameConstants;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Stephanie
 */
public class RenderEngine implements IGameConstants{
    public static Image renderMiniMapView(Room[][] maze) {
        String north = Labyrinth.Direction.N.direction;
        String south = Labyrinth.Direction.S.direction;
        String east = Labyrinth.Direction.E.direction;
        String west = Labyrinth.Direction.W.direction;
        try {             
        int mazeSize = maze.length;
            //set basic canves
            int size = 181* mazeSize;
            BufferedImage renderedView = new BufferedImage(size,size,BufferedImage.TYPE_INT_ARGB);
            Graphics2D graph = renderedView.createGraphics();
            for(int row = 0; row < mazeSize; row++){
                for(int col = 0; col < mazeSize; col++){
                    Room room = maze[row][col];
                    if(!room.isPlayerVissited()) continue;
                    BufferedImage tile; // stars as a blank imagae
                    switch (room.getExits().length)
                    {
                            case 1:
                                // <editor-fold defaultstate="collapsed" desc="dead ends">
                                if(room.getExits()[0].equals(north))
                                {
                                    //dead end exit north
                                    tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[9]));  
                                    break;
                                }
                                else if (room.getExits()[0].equals(south))
                                {
                                    //dead end exit sout
                                    tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[12]));  
                                    break;
                                }
                                else if (room.getExits()[0].equals(east))
                                {
                                    //dead end exit east
                                     tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[11]));  
                                    break;
                                }
                                else 
                                {
                                    //dead end ext west
                                    tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[10]));  
                                    break;
                                }
                                // </editor-fold>
                            case 2:
                                // <editor-fold defaultstate="collapsed" desc="Straigths and corners">
                                if((room.getExits()[0].equals(north) || room.getExits()[0].equals(south)) 
                                    && (room.getExits()[1].equals(north) || room.getExits()[1].equals(south)))
                                {
                                    //straigt room north south
                                     tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[14]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(east) || room.getExits()[0].equals(west)) 
                                    && (room.getExits()[1].equals(east) || room.getExits()[1].equals(west)))
                                {
                                    //straigt room east west
                                     tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[13]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(east)) 
                                    && (room.getExits()[1].equals(north) || room.getExits()[1].equals(east)))
                                {
                                    //cornor room exits north and east
                                     tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[2]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(west)) 
                                    && (room.getExits()[1].equals(north) || room.getExits()[1].equals(west)))
                                {
                                    //cornor room exits north and west
                                    tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[3]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(south) || room.getExits()[0].equals(east)) 
                                    && (room.getExits()[1].equals(south) || room.getExits()[1].equals(east)))
                                {
                                    //cornor room exits south and east
                                    tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[0]));  
                                    break;
                                }
                                else
                                {
                                    //cornor room exits south and west
                                     tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[1]));  
                                    break;
                                }
                                // </editor-fold>
                            case 3:
                                // <editor-fold defaultstate="collapsed" desc="T Rooms">
                                if((room.getExits()[0].equals(north) || room.getExits()[0].equals(south) || room.getExits()[0].equals(east)) 
                                            && (room.getExits()[1].equals(north) || room.getExits()[1].equals(south) || room.getExits()[1].equals(east))
                                        && (room.getExits()[2].equals(north) || room.getExits()[2].equals(south) || room.getExits()[2].equals(east)))
                                {
                                    //T-room exits north, south and east
                                    tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[4]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(south) || room.getExits()[0].equals(west)) 
                                            && (room.getExits()[1].equals(north) || room.getExits()[1].equals(south) || room.getExits()[1].equals(west))
                                        && (room.getExits()[2].equals(north) || room.getExits()[2].equals(south) || room.getExits()[2].equals(west)))
                                {
                                    //T-room exits north, south and west
                                    tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[5]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(east) || room.getExits()[0].equals(west)) 
                                            && (room.getExits()[1].equals(north) || room.getExits()[1].equals(east) || room.getExits()[1].equals(west))
                                        && (room.getExits()[2].equals(north) || room.getExits()[2].equals(east) || room.getExits()[2].equals(west)))
                                {
                                    //T-room exits north, east and west
                                    tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[7]));  
                                    break;
                                }
                                else 
                                {
                                    //T-room exits south, east and west
                                     tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[6]));  
                                    break;
                                }
                                // </editor-fold>
                            default:
                                //croos roads
                                tile = ImageIO.read(new File(DIR_MINIMAP+FILENAME_PICTURES_MINIMAP[8]));  
                                break;
                    } 
                    graph.drawImage(tile, 181*row, 181*col,null);   
                    if(room.getPlayer() != null)
                    {
                        tile = ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_TOKEN[0])); 
                        graph.drawImage(tile, 181*row, 181*col,null);  
                    }
                    if(room.getMonster()!= null)
                        if(room.getMonster().getMapCode()=='Z')
                        {
                            tile = ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_TOKEN[2])); 
                            graph.drawImage(tile, 181*row, 181*col,null);  
                        }
                        else
                        {
                            tile = ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_TOKEN[1])); 
                            graph.drawImage(tile, 181*row, 181*col,null);  
                        }    
                }
            }
            return SwingFXUtils.toFXImage(renderedView,null);         
        } 
        catch (IOException ex) {
            System.out.println("Error happened in Rendering");
            System.out.println("message: "+ex.getMessage());
        }
        return null;        
    }
    public static Image renderMazeView(Player player) {
        try {
            //set basic canves
            BufferedImage renderedView = ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[0])); 
            // gets the rooms that we need to render.
            Room currentRoom = player.getCurrentRoom();                         // get the current room 
            Room nextRoom = currentRoom.getExit(player.getFacing().direction);  // get the room next to it.
            Room SideR_Room = currentRoom.getExit(player.getFacing().right.direction);
            Room SideL_Room = currentRoom.getExit(player.getFacing().left.direction);            
            
            Graphics2D graph = renderedView.createGraphics();                   // makes the graphics opject to draw to. 
            BufferedImage tile;                                                 // image to be drawn.            
            // stars with the back room
            // <editor-fold defaultstate="collapsed" desc="back room.">
            if(nextRoom != null){
                // <editor-fold defaultstate="collapsed" desc="draw room.">
                
                 // draws the rest of the template
                tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[7])); // gets Outer Template img
                graph.drawImage(tile, 0,0,null);// draws picture
                
                // checks for Left exit
                if(nextRoom.getExit(player.getFacing().left.direction) != null)
                {   // gets outher left img
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[8]));
                    graph.drawImage(tile, 0,0,null);// draws picture
                }
                else
                {   // gets outher no left img
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[11])); 
                    graph.drawImage(tile, 0,0,null);// draws picture
                }        
                // checks for a rigth exit
                if(nextRoom.getExit(player.getFacing().right.direction) != null)
                {   // gets outher rigth img
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[9])); 
                    graph.drawImage(tile, 0,0,null);// draws picture
                }
                else
                {   // gets outher no rigth img
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[12])); 
                    graph.drawImage(tile, 0,0,null);// draws picture
                }
                
                 // draws the rest of the template
                tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[7])); // gets Outer Template img
                graph.drawImage(tile, 0,0,null);// draws picture
                
                
                if(nextRoom.getExit(player.getFacing().left.direction) != null)
                {   
                }
                else
                {   // gets outher no left img
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[11])); 
                    graph.drawImage(tile, 0,0,null);// draws picture
                }        
                // checks for a rigth exit
                if(nextRoom.getExit(player.getFacing().right.direction) != null)
                {   
                }
                else
                {   // gets outher no rigth img
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[12])); 
                    graph.drawImage(tile, 0,0,null);// draws picture
                }
                
                // checks if there is a exit straigth ahead
                if(nextRoom.getExit(player.getFacing().direction) != null)
                {   // gets outher forward img
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[13]));
                    graph.drawImage(tile, 0,0,null);// draws picture
                }
                else
                {   // gets outher no forward img
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[10]));
                    graph.drawImage(tile, 0,0,null); // draws picture
                } 
               
                
                // </editor-fold>  
                // <editor-fold defaultstate="collapsed" desc="draw Door.">
                if(nextRoom.hasDoor(Labyrinth.Direction.S.direction))                 // checks if there is a door in the room.
                {                       
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[3])); // iner dead end
                    graph.drawImage(tile, 0,0,null);  // draws next room template;
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[2])); // outher door forward
                    graph.drawImage(tile, 0,0,null);
                }    
                Room NextSideR_Room = nextRoom.getExit(player.getFacing().right.direction);
                if(NextSideR_Room != null)
                    if(NextSideR_Room.hasDoor(Labyrinth.Direction.S.direction))                 // checks if there is a door in the room.
                    {                       
                        tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[12])); // iner dead end
                        graph.drawImage(tile, 0,0,null);  // draws next room template;
                        tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[7])); // outher door rigth
                        graph.drawImage(tile, 0,0,null);
                    }                                 
                // </editor-fold>   
                // <editor-fold defaultstate="collapsed" desc="draw Chests.">        
                                 
                if(nextRoom.hasItems())                                              // checks the room has Items.
                {
                    if(isDebug)
                        System.out.println("found "+nextRoom.itemList().length+" items on next room tile");
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[0])); // gets innerChest img.
                    graph.drawImage(tile, 0,0,null); 
                }                
                // </editor-fold>                
                // <editor-fold defaultstate="collapsed" desc="draw monsters.">
                Monster m =(Monster)nextRoom.getMonster();                     // gets monsters to draw.
                if(m !=null)                                                    // checks if there is a actual monsters to draw.
                {                    
                    if(m.isBoss())                                              // checks the type.
                    {
                        if(isDebug)
                            System.out.println("found a boss on next room tile");
                        tile =ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR[4])); // outher template
                        graph.drawImage(tile, 0,0,null);  // draws next room template;   
                    }
                    else
                    {   
                        if(isDebug)
                            System.out.println("found a minion on next room tile");
                        tile =ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR[3])); // outher template
                        graph.drawImage(tile, 0,0,null);  // draws next room template;   
                    }
                }
                GhostWanderer g =(GhostWanderer)nextRoom.getGhoust();                     // gets monsters to draw.
                if(g !=null)                                                    // checks if there is a actual monsters to draw.
                { 
                    if(isDebug)
                        System.out.println("found a ghoust on next room tile");
                    tile =ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR[5])); // gets outher ghoust img 
                    graph.drawImage(tile, 0,0,null);  // draws 

                }
                // </editor-fold>                     
            }            
            else
            {   // gets InnerNoForward img
                tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[4]));
                graph.drawImage(tile, 0,0,null);  // draws
            }
            // </editor-fold>      
            // then the front room            
            // <editor-fold defaultstate="collapsed" desc="front room.">
            // <editor-fold defaultstate="collapsed" desc="draw room.">
            
             // checks if there is a left exit
            if(currentRoom.getExit(player.getFacing().left.direction) != null)
            {   // get the inndr left img
                tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[2])); 
                graph.drawImage(tile, 0,0,null); // draws 
            }
            else 
            {   // get the inner no left img
                tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[5]));
                graph.drawImage(tile, 0,0,null); // draws
            }
            // checks if there is a rigth exit
            if(currentRoom.getExit(player.getFacing().right.direction) != null)
            {   // get the inner rigth img
                tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[3])); 
                graph.drawImage(tile, 0,0,null); // draws 
            }
            else 
            {   // get the inner no rigth img
                tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[6]));
                graph.drawImage(tile, 0,0,null); // draws
            }  
            
            // gets inner template img
            if(currentRoom.getExit(player.getFacing().opposite.direction) != null)
            {
                tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[1])); 
                graph.drawImage(tile, 0,0,null); // draw
            }
            else
            {
                tile =ImageIO.read(new File(DIR_MAZEVIEW_MALTE+MALTES_TILES[0])); 
                graph.drawImage(tile, 0,0,null); // draw    
            }
            
            
            // checks if there is a left exit
            if(currentRoom.getExit(player.getFacing().left.direction) != null)
            {   // get the inndr left img
                
            }
            else 
            {   // get the inner no left img
                tile =ImageIO.read(new File(DIR_MAZEVIEW_MALTE+MALTES_TILES[1]));
                graph.drawImage(tile, 0,0,null); // draws
            }
            // checks if there is a rigth exit
            if(currentRoom.getExit(player.getFacing().right.direction) != null)
            {   // get the inner rigth img
            }
            else 
            {   // get the inner no rigth img
                tile =ImageIO.read(new File(DIR_MAZEVIEW_MALTE+MALTES_TILES[2]));
                graph.drawImage(tile, 0,0,null); // draws
            }  
           if(nextRoom == null)
            {   // gets InnerNoForward img
                tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[4]));
                graph.drawImage(tile, 0,0,null);  // draws
            }
           
            
            // </editor-fold>
            // <editor-fold defaultstate="collapsed" desc="draw Door.">
            if(SideR_Room != null)
            {
                if (isDebug)
                    System.out.println("Found a Room to the rigth (Højre) from current room");
                if(SideR_Room.hasDoor(Labyrinth.Direction.S.direction))                 // checks if there is a door in the room.
                {
                    if (isDebug)
                        System.out.println("drawn a Door");
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_MALTE+MALTES_TILES[2])); // iner dead end
                    graph.drawImage(tile, 0,0,null);  // draws next room template;
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[5])); // outher door forward
                    graph.drawImage(tile, 0,0,null);
                }
            }
            if(SideL_Room !=null)
            {
                if (isDebug)
                    System.out.println("Found a Room to the Left (Venstre) from current room");
                if(SideL_Room.hasDoor(Labyrinth.Direction.S.direction))                 // checks if there is a door in the room.
                {
                    if (isDebug)
                        System.out.println("drawn a Door");
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_MALTE+MALTES_TILES[1])); // iner dead end
                    graph.drawImage(tile, 0,0,null);  // draws next room template;
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[4])); // outher door forward
                    graph.drawImage(tile, 0,0,null);
                } 
            }
            if(nextRoom != null)
            {
                if(nextRoom.hasDoor(Labyrinth.Direction.S.direction))
                {
                    if (isDebug)
                        System.out.println("drawn a Door");
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[4])); // iner dead end
                    graph.drawImage(tile, 0,0,null);  // draws next room template;
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[3])); // outher door forward
                    graph.drawImage(tile, 0,0,null);
                }
            }                
            // </editor-fold>
            // <editor-fold defaultstate="collapsed" desc="draw Chests.">        

            if(currentRoom.hasItems())                                          // checks the room has Items.
            {
                if(isDebug)System.out.println("found "+currentRoom.itemList().length+" items on current room tile");
                // gets innerChest img.
                tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[1])); 
                graph.drawImage(tile, 0,0,null);  // Draw
            }                
            // </editor-fold>
            // <editor-fold defaultstate="collapsed" desc="draw monsters.">
            Monster m =(Monster) currentRoom.getMonster();                      // gets monsters to draw.
            if(m !=null)                                                        // checks if there is a actual monsters to draw.
            {                    
                if(m.isBoss())                                                  // checks the type.
                {
                    if(isDebug)System.out.println("found a boss on current room tile");
                    // gets inner zuul img
                    tile =ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR[1])); 
                    graph.drawImage(tile, 0,0,null);  // draws next room template;   
                }
                else
                {   
                    if(isDebug)System.out.println("found a minion on next room tile");
                    // gets inner miniun
                    tile =ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR[0]));
                    graph.drawImage(tile, 0,0,null);  // draws next room template;   
                }
            }
            GhostWanderer g =(GhostWanderer)currentRoom.getGhoust();            // gets monsters to draw.
            if(g !=null)                                                        // checks if there is a actual monsters to draw.
            { 
                if(isDebug)System.out.println("found a ghoust on next room tile");
                tile =ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR[2])); // gets outher ghoust img 
                graph.drawImage(tile, 0,0,null);  // draws 

            }
            // </editor-fold>       
            // </editor-fold>   
            // compass
            // <editor-fold defaultstate="collapsed" desc="draw Compass.">
            switch(player.getFacing())
            {
                case E:
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[9])); 
                    graph.drawImage(tile, 0,0,null);  // draws next room template; 
                    break;
                case S:
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[11])); 
                    graph.drawImage(tile, 0,0,null);  // draws next room template; 
                    break;
                case N:
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[10])); 
                    graph.drawImage(tile, 0,0,null);  // draws next room template;
                    break;
                case W:
                    tile =ImageIO.read(new File(DIR_MAZEVIEW_OBJECTS+FILENAME_PICTURES_MAZE_OBJECTS[12])); 
                    graph.drawImage(tile, 0,0,null);  // draws next room template; 
                    break;
            }
            // </editor-fold>   
            return SwingFXUtils.toFXImage(renderedView,null);            
        } 
        catch (IOException ex) { 
            System.out.println("Error happened in Rendering");
            System.out.println("message: "+ex.getMessage());           
        }
        return null;
    }
    public static Image renderBattleView(Player player,Monster monster) {
        try {
            //set basic canves
            BufferedImage renderedView = new BufferedImage(700, 600,BufferedImage.TYPE_INT_ARGB); // ImageIO.read(new File(DIR_MAZEVIEW_LABYRITH+FILENAME_PICTURES_MAZE[0])); 
    
            Room currentRoom = player.getCurrentRoom();                         // get the current room 
            Room nextRoom = currentRoom.getExit(player.getFacing().direction);  // get the room next to it.
            
            Graphics2D graph = renderedView.createGraphics();                   // makes the graphics opject to draw to. 
            BufferedImage tile;                                                 // image to be drawn.
            
            // gets player
            tile = ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR_BATTLE[4])); 
            graph.drawImage(tile, 0,0,null);  // draws
            // gets healthbar frame
            tile = ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR_BATTLE[0])); 
            graph.drawImage(tile, 0,0,null);  // draws
            if(monster.isBoss())
            {
                tile = ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR_BATTLE[2])); 
                graph.drawImage(tile, 0,0,null);  // draws
            }
            else
            {
                tile = ImageIO.read(new File(DIR_CHARACTORS+FILENAME_PICTURES_CHARACTOR_BATTLE[1])); 
                graph.drawImage(tile, 0,0,null);  // draws
            }
            return SwingFXUtils.toFXImage(renderedView,null);       
        }
        catch(IOException ex)
        {
            System.out.println("Error happened in Rendering");
            System.out.println("message: "+ex.getMessage());           
        }       
        return null;
    }
}        

   
