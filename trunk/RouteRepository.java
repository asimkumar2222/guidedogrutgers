/** 
 * Contains the classes for main sequence of operations and flow control
 * at the server end. Connection with client is established by re-using classes
 * from java.net. Directions are fetched using the compute direction class.
 *
 */

/**  @author: Angad Kale
 * 
 * Contains the classes for handling route repositry and getting next location
 */

package guidedog_server;
//package GuideDog_Server;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RouteRepository {
   
    RouteRepository()
    {
       
        /*Connection con = null;
       
        try {
        con = DriverManager.getConnection("jdbc:oracle:GuideDog", "SYSDBA", "yogesh");
        } catch (SQLException ex) {
        Logger.getLogger(RouteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        Statement stmt = (Statement) con.createStatement();
        /*String sqlquery= new String("Select");
        ResultSet rs = (ResultSet)stmt.executeQuery("SELECT a, b, c FROM Table1");
        while (rs.next()) {
        int x = rs.getInt("a");
        String s = rs.getString("b");
        float f = rs.getFloat("c");
        }*/
    /*}
    catch
    
   

   
        (SQLException ex) {
            Logger.getLogger(RouteRepository.class.getName()).log(Level.SEVERE, null, ex);
    }
    */
        /*String sqlquery= new String("Select");
        ResultSet rs = (ResultSet)stmt.executeQuery("SELECT a, b, c FROM Table1");
        while (rs.next()) {
        int x = rs.getInt("a");
        String s = rs.getString("b");
        float f = rs.getFloat("c");
        }*/

    }
/**
 * The following function on being called calculates the next immediate location to be travelled, based on the present location. It then returns the temporary location to be reached.
 * It allows us to obtain the next location from the database.
 * It is used by the DirectionComputer class to determine the direction to be traversed.
 *
 * @param cx : current x location, cy: current y location
 * @return l : next location, which contains future values of both x and y
*/


   public location getNextLocation(int cx, int cy) {
        location l = null;
        int x = 0,y = 0;
        //throw new UnsupportedOperationException("Not yet implemented");
       
        if(cx==cy)
        {
            if(cx<5)
            x=cx+1;
            y=cy;
        }
        else if(cx>cy)
        {
            if(cx<5)
            x=cx+1;
            y=cy;
        }
        else if(cy>cx)
        {
            if(cy<5)
            y=cy+1;
            x=cx;
        }
        l=new location(x,y);
        return l;
    }
}