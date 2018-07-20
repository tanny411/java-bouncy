package Football;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Football {
    int counter;
    boolean kicked=false;
    synchronized void shot(int n)
    {
        while(kicked)
        {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Football.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        counter = n;
        System.out.println("Kick "+counter);
        kicked=true;
        notify();
    }
    
    synchronized void save()
    {
        while(!kicked){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Football.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        kicked=false;
        notify();
        Random r = new Random(100);
        if(r.nextInt()<50)
        {
            System.out.println("Saved "+counter);
        }
        else 
        {
            System.out.println("Goal "+counter);
        }
        
    }
}

class Goalkepeer implements Runnable{

    Football fp;
    Goalkepeer(Football fp)
    {
        this.fp = fp;
        Thread t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        for(int i=1;i<=5;i++) 
        {
            fp.save();
        }
    }
    
    
}

class Shooter implements Runnable{
    Football fp;
    Shooter(Football fp)
    {
        this.fp = fp;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
       for(int i=1;i<=5;i++) 
        {
            fp.shot(i);
        }
    }
    
}
