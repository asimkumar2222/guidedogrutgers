/* 
 * @author: Angad Kale
 */


package GuideDogClient;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.media.*;

import java.io.*;

/** 
 * @author: Angad Kale
 */
/* Class for giving voice directions by playing an mp3 file.
 */

public class Voice_Directions extends MIDlet {
    public void startApp() {
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
    
/** 
 * This method plays mp3 file whose name is passed as an argument in the form
 * of a string. It reuses classes from javax.microedition.media.
 * @param filename This string defines the path and name of mp3
 * @throws 
 * @exception 
 */    
    
    public void PlayDirection(String filename) {
        try {
            
            InputStream in = getClass().getResourceAsStream(filename);
            System.out.println("connected from local");
            Player player = Manager.createPlayer(in, "audio/mpeg");
            
          
            player.start();

            
        } catch (Exception e) {
            showException(e);
            return;
        }
       // mDisplay.setCurrent(mMainScreen);
    }
    private void showException(Exception e) {
        Alert a = new Alert("Exception", e.toString(), null, null);
        a.setTimeout(Alert.FOREVER);
       // mDisplay.setCurrent(a, mMainScreen);
    }
    
}
