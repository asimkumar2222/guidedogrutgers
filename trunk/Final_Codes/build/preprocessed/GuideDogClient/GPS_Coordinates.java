

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GuideDogClient;
import javax.microedition.location.Coordinates;

import javax.microedition.location.Criteria;
import javax.microedition.location.Location;
import javax.microedition.location.LocationException;
import javax.microedition.location.LocationProvider;

import javax.microedition.midlet.*;


/** 
 * @author: Angad Kale
 */

 /* Class for fetching GPS coordinates. It reuses classes from javax.microedition
 * .location.
 * 
 */
public class GPS_Coordinates extends MIDlet {
    
    private Location location;
    private LocationProvider locationProvider;
    private Coordinates coordinates;
    private Criteria criteria;
    
    public void getLocationInit(){
       
        
        criteria = new Criteria();
        criteria.setHorizontalAccuracy(500); 
      
        try {
            locationProvider = LocationProvider.getInstance(criteria);
        } catch (LocationException e) {
            //TODO: Handle location exception.
            return;
        }
          
    }
        
   
    public void startApp() {
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
 /** Called to read current location.
  *  @return gpsString The X and Y location coordinates (double data type) 
  * concantenated as a string.
  */
    public String GetGpsCoordinates() {
         String gpsString;
         
        
        
         
        try {
            location = locationProvider.getLocation(60);
        } catch (Exception e) {
            //TODO: Handle exception.
            return null;
        }
        
        coordinates = location.getQualifiedCoordinates();
        if (coordinates != null) {
            // Use coordinate information 
            double lat = coordinates.getLatitude();
            double lon = coordinates.getLongitude();
            gpsString = "\nLatitude : " + lat + "\nLongitude : " + lon;
           
        } else {
            gpsString =  "Location API failed";
        }
       
        try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        return gpsString;
        
        }
    
}
