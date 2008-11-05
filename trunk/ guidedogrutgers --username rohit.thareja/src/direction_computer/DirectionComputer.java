/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package guidedog_server;
package GuideDog_Server;
/**
 * @author Rohit Thareja
 * 
 * This class is used for computing the direction. 
 */
public class DirectionComputer {
    public DirectionComputer()
    {
        
    }
 /**
  * This is the method which is invoked to compute the direction. It contains the algorithm by which the next direction that the user, with
 * user id uid at location cx,cy needs to take . The value of the direction is returned as a string dir. The values of cx
 * and cy are recieved from the client class. The RouteRepository class generates the next locations from the route table.
 * The LocationLogger class generates the last location from the repository.It uses 3 values of previous location (lx,ly), current
  * location (cx,cy) and future location (nx,ny) to compute the direction.
  * 
  * @param uid:user id, cx: current x location, cy: current y location
  * @return String dir which holds direction which user needs to take.
 */ 
    public String giveUserInfo(int uid, int cx,int cy)
    {
        String dir = null;
        location l,n;
        int lx,ly,nx,ny;
        
        l=new location();
        n=new location();
        
        RouteRepository rr=new RouteRepository();
        LocationLogger  ll=new LocationLogger() ;
        
        l=ll.getLastLocation(uid,cx,cy);
        
        n=rr.getNextLocation(cx,cy);
        
        lx=l.x;
        ly=l.y;
        nx=n.x;
        ny=n.y;
        if(cx==lx)
        {
            if(nx<cx)
            {
                dir=new String("RIGHT");
            }
            if(nx>cx)
            {
                dir=new String("LEFT");
            }
            if(nx==cx && ny!=cy)
            {
                dir=new String("STR8");
            }
        }
        else if(cy==ly)
        {
            if(ny<cy)
            {
                dir=new String("RIGHT");
            }
            if(ny>cy)
            {
                dir=new String("LEFT");
            }
            if(ny==cy && nx!=cx)
            {
                dir=new String("STR8");
            }
        }
        return dir;
    }
}
