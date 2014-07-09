package org.team225.robot2014.constants;

import java.util.Hashtable;

/**
 *
 * @author Andrew
 */
public class DoubleTable extends Hashtable {
    
    public DoubleTable()
    {
        super();
    }
    
    public void put(String name, double value)
    {
        put(name, new Double(value));
    }
    
    public double get(String name)
    {
        Double d = (Double)super.get(name);
        if ( d != null )
            return d.doubleValue();
        else 
        {
            System.out.println("Request for unknown constant "+name);
            return 0;
        }
    }
    
    public int getInt(String name)
    {
        Double d = (Double)super.get(name);
        if ( d != null )
            return d.intValue();
        else 
        {
            System.out.println("Request for unknown constant "+name);
            return 0;
        }
    }
}
