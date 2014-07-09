package org.team225.robot2014.commands.catapult;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author KageRa
 */
public class ReleaseCatapult extends CatapultCommandSafetyWrapper implements Runnable {

    boolean bothCylinders;
    double timeDelay;
    
    public class CatapultShootingThread extends Thread
    {
        double delay;
        boolean bothCylinders;
        boolean done = false;
        public CatapultShootingThread(boolean bothCylinders, double timeDelay)
        {
            this.delay = timeDelay;
            this.bothCylinders = bothCylinders;
        }
        
        public boolean isFinished()
        {
            return done;
        }
        
        public void run()
        {
            if ( !catapult.isPressurized() ) // PrepShot was ran - just release latch
            {
                long delayms = (long) Math.floor(delay*1000);
                Timer t = new Timer();
                t.reset();
                t.start();
                catapult.setPressurized(true, bothCylinders);
                try {
                    Thread.sleep(delayms);
                } catch (InterruptedException ex) {
                    System.out.println("CatapultShootingThread: sleep failed!");
                    ex.printStackTrace();
                }
                System.out.println("CatapultShootingThread: Finished at "+t.get());
                System.out.println("CatapultShootingThread: Target is "+delay);
                System.out.println("CatapultShootingThread: Time Diff is "+Math.abs(t.get()-delay));
            }
            else
            {
                System.out.println("CatapultShootingThread: Already charged, releasing latch");
            }
            catapult.setLock(false);
            done = true;
        }
    }
    
    CatapultShootingThread shootThread = null;
    public ReleaseCatapult(boolean bothCylinders, double timeDelay){
        requires(catapult);
        setInterruptible(false);
        this.bothCylinders = bothCylinders;
        this.timeDelay = timeDelay;
    }
    
    protected void initialize() {
        shootThread = new CatapultShootingThread(bothCylinders, timeDelay);
        shootThread.start();
        shootThread.setPriority(Thread.NORM_PRIORITY+1);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return shootThread.isFinished();
    }

    protected void end() {
    }

    public void run() {
        
    }
    
}
