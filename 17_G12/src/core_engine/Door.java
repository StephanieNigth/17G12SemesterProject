/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import java.io.Serializable;

/**
 *
 * @author Stephanie
 */
public class Door implements Serializable{
    private boolean Locked;
    public Door(boolean Locked)
    {        
        this.Locked = Locked;
    }
    public boolean unLock(Player p)
    {
        return false;                
    }

    public boolean isLocked() {
        return Locked;
    }
    
}