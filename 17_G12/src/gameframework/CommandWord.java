package gameframework;

/**
 * @author Michael Kolling and David J. Barnes
 * @author Groupe 12
 * @version 2006.03.30
 */
public enum CommandWord
{
    /**
     * Creates Enums for each commandword
     */
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?");
    
    private String commandString;
    /**
     * Constructer
     * @param commandString 
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    /**
     * gets a string representation of the Commandword
     * @return String 
     */
    public String toString()
    {
        return commandString;
    }
}
