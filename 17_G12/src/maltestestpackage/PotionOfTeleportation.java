/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;
import Stephie_build.Labyrinth;
/**
 *
 * @author Malte
 */
public class PotionOfTeleportation extends Item {

    @Override
    public String getDescription() {
        return "A flask with a clear substance within it. Smells like sunshine and happiness... Wonder what it does...";
    }

    @Override
    public String getName() {
        return "Potion Of Teleportation";
    }

    /**
     * transports the player to a random location on the map by setting current
     * location to a randomized location.
     */
    @Override
    public void useItem() {
//        currentLocation = map.goRandomRoom;
    }

    @Override
    public String getType() {
        return "Consumable";
    }

    @Override
    public int getStat() {
        return -1;
        }
    
    
}
