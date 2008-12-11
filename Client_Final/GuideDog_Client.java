
/** 
 * @author: Angad Kale
 * 
 * 
 */

package GuideDogClient;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/** 
 * @author: Angad Kale
 */

/* Contains the classes for Main sequence of operations and flow control
 * at the client end. GPS Coordinates are fetched by calling GetGpsCoordinates 
 * method of GPS_Coordinates Class. Voice directions are played by calling
 * PlayDirections method of Voice_Directions Class. The initialization and welcome
 * audio clips are played by PlayDirections Method by passing the related filename
 * in the form of a string.
 */
 

 
public class GuideDog_Client extends MIDlet implements CommandListener {
 
    private Display display;
    private Form form;
    private Command exitCommand;
    private Command refreshCommand;
    private StringItem text;
   
    
    boolean flag_disp = true;
    String filename = "";
    private Voice_Directions voiceDirections;
    private GPS_Coordinates gpsCoordinates;
    
    
    /**
     * Constructor. Constructs the object and initializes displayables.
     */
    public GuideDog_Client() {
       
        
     
            
        
        
        
        exitCommand = new Command("Exit", Command.EXIT, 2);
        refreshCommand = new Command("Start", Command.OK, 1);
        
        voiceDirections = new Voice_Directions();
        gpsCoordinates = new GPS_Coordinates();
        
        form = new Form("GuideDog Version 1.0");
        text = new StringItem("Your position:", "\nPress \"Start to begin Navigation\"");
        form.append(text);
        display = Display.getDisplay(this);
        display.setCurrent(form);
        
        filename = "/welcome.mp3";
        voiceDirections.PlayDirection(filename);
            
            try {
                Thread.sleep(6000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            
 
        form.addCommand(exitCommand);
        form.addCommand(refreshCommand);
        
        form.setCommandListener(this);
        
         gpsCoordinates.getLocationInit();
         
        
       
    }
 
    /**
     * From MIDlet.
     * Called when the MIDlet is started.
     */
    public void startApp() {
        // No implementation required.
    }
 
    /**
     * From MIDlet.
     * Called to signal the MIDlet to enter the Paused state.
     */
    public void pauseApp() {
        // No implementation required.
    }
 
    /**
     * From MIDlet.
     * Called to signal the MIDlet to terminate.
     * @param unconditional whether the MIDlet has to be unconditionally
     * terminated
     */
    public void destroyApp(boolean unconditional) {
        // No implementation required
    }
 
    /**
     * From CommandListener.
     * Called by the system to indicate that a command has been invoked on a
     * particular displayable. It invokes the corresponding audio files by
     * calling PlayDirection and passing the corresponding filename in the form
     * of a string. 
     * @param cmd the command that was invoked
     * @param displayable the displayable where the command was invoked
     */
    public void commandAction(Command c, Displayable d) {
        if (c == refreshCommand && flag_disp) {
            flag_disp = false;
            filename = "/Initializing.mp3";
            voiceDirections.PlayDirection(filename);
            form.removeCommand(refreshCommand);
            while(true)
        {  
            
           String gpsCoodsString = gpsCoordinates.GetGpsCoordinates();
             text.setText(gpsCoodsString);}
            
        } else if (c == exitCommand) {
            filename = "/Thank_you.mp3";
            voiceDirections.PlayDirection(filename);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            notifyDestroyed();
        }
        
    }
 

    
     
}