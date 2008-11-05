/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package guidedog_server;
//package GuideDog_Server;


/**
 *
 * @author Kavin Anburaj
 * The following class provides the location log of the user. 
 */

public class LocationLogger {

    /** This function is used to obtain the last location recorded of the user's path. 
     * It is used by the DirectionComputer to calculate the direction that the User 
     * needs to take. Based on the present location and the user id of the user
     * provided as parameters, the 
     * previous location is calculated.
       
     * @param uid:user id
     * @param cx:current x location
     * @param cy:current y location
     * @return l:previous recorded location of the user, which contains 
     * both the previous x and y co-ordinates 
     */ 
    public location getLastLocation(int uid, int cx, int cy) {
        location l=null;
        int x = 0,y = 0;
        if(cx==cy)
        {
            x=cx-1;
            y=cy;
        }
        else if(cx>cy)
        {
            x=cx-1;
            y=cy;
        }
        else if(cy>cx)
        {
            y=cy-1;
            x=cx;
        }
        l=new location(x,y);
        //throw new UnsupportedOperationException("Not yet implemented");
        return l;
    }


}
