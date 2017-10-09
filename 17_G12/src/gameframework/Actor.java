
package gameframework;

/**
 *
 * @author nicol
 */
public class Actor 
{
 private int defaultHealthPoint; 
 private int modufiedHealthPoint;
 private int defaultDefense;
 private int modifiedDefense;
 private String name;
 private int defaultDamgeOutput;
 private int modifiedDamgeOutput;
 private int level;
 private int newLevel;
 private int xp;
 private int totalXp;
 Actor(){
   
 }
 //in this constructor can you set a name, the defaultDefense and
// the DefaultDamgeOutput 
 Actor(String name,int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput){
     this.name = name;
     this.defaultHealthPoint = defaultHealthpoint;
     this.defaultDefense = defaultDefense;
     this.defaultDamgeOutput = defaultDefense;
 }
 // in this metode you can the 
    public void setDefaultHealthPoint(int defaultHealthPoint) {
        this.defaultHealthPoint = defaultHealthPoint;
    }

    public void setModufiedHealthPoint(int modufiedHealthPoint) {
        this.modufiedHealthPoint = modufiedHealthPoint;
    }
   

    public void setDefaultDefense(int defaultDefense) {
        this.defaultDefense = defaultDefense;
    }

    public void setModifiedDefense(int modifiedDefense) {
        this.modifiedDefense = modifiedDefense;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefaultDamgeOutput(int defaultDamgeOutput) {
        this.defaultDamgeOutput = defaultDamgeOutput;
    }

    public void setModifiedDamgeOutput(int modifiedDamgeOutput) {
        this.modifiedDamgeOutput = modifiedDamgeOutput;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setNewLevel(int newLevel) {
        this.newLevel = newLevel;
    }
   
    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setTotalXp(int totalXp) {
        this.totalXp = totalXp;
    }

    public int getDefaultHealthPoint() {
        return defaultHealthPoint;
    }
    // in this metode you get the modified heathPoint back
    // the modified HeahtPoint is the DefaultHealthPoint + (the level * 10)
    // therefore the higher the level the higher the healthpoint is
    // there value 10 can be modified this is just an eksample
    public int getModufiedHealthPoint() {
        return modufiedHealthPoint = defaultHealthPoint+(level*10);
    }
    
    
    public int getDefaultDefense() {
        return defaultDefense;
    }
    // in this metode you get the modified defense back
    // the modified defense is the defaltdefense + (the level * 5)
    // therefore the higher the level the higher the defense is
    // there value 5 can be modified this is just an eksample
    public int getModifiedDefense() {
        return modifiedDefense = defaultDefense+(level*5);
    }

    public String getName() {
        return name;
    }

    public int getDefaultDamgeOutput() {
        return defaultDamgeOutput;
    }
     // in this metode you get the modified damgeOutout back
    // the modified damgeOut is the defaltDamgeOutput + (the level * 5)
    // therefore the higher the level the higher the damg is
    // there value 5 can be modified this is just an eksample
    public int getModifiedDamgeOutput() {
        return modifiedDamgeOutput = defaultDamgeOutput+(level*5);
    }

    public int getNewLevel() {
        return newLevel ;
    }
     public int getLevel() {
        return level = 1+(xp/2);
    }
  
    public int getXp() {
        return xp;
    }

    public int getTotalXp() {
        return totalXp =totalXp + xp;
    }
 
}
