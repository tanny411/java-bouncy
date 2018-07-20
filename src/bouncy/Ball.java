package bouncy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Ball extends JPanel implements Runnable {

    int x, y, signx = 1, signy = 1, mx = 2, my = 1,xx,yy,signxx=-1,signyy=-1,myy=1,mxx=1,mod=9;
    Random rand;
    int size = 30;
    String name;
    Ball(int x, int y,int xx,int yy) {
        this.x = x;
        this.y = y;
        this.xx=xx;
        this.yy=yy;
        rand = new Random();
        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, size, size);
        g.setColor(Color.BLUE);
        g.fillOval(xx, yy, size, size);
    }
    
    
    void move() {
        int tx=x;
        int ty=y;
        x += signx * mx;
        y += signy * my;
        if (x + size>= getWidth() || x <= 0) {
            signx *= -1;
            mx = rand.nextInt() % mod ; mx=(mx+mod)%mod +1;
            x=tx+signx*mx;
        }
        if (y + size>= getHeight() || y <= 0) {
            signy *= -1;
            my = rand.nextInt() % mod ; my=(my+mod)%mod +1;
            y=ty+signy*my;
        }
    }
    void move2() {
        int tx=xx;
        int ty=yy;
        xx += signxx * mxx;
        yy += signyy * myy;
        if (xx + size>= getWidth() || xx <= 0) {
            signxx *= -1;
            mxx = rand.nextInt() % mod ; mxx=(mxx+mod)%mod +1;
            xx=tx+signxx*mxx;
        }
        if (yy + size>= getHeight() || yy <= 0) {
            signyy *= -1;
            myy = rand.nextInt() % mod ; myy=(myy+mod)%mod +1;
            yy=ty+signyy*myy;
        }
    }
    void check()
    {
        int cx1=x+size/2,cx2=xx+size/2,cy1=y+size/2,cy2=yy+size/2;
        int d=(cx1-cx2)*(cx1-cx2)+(cy1-cy2)*(cy1-cy2);
        if(d<=size*size)
        {
              signx*=-1;
              signy*=-1;
              signxx*=-1;
              signyy*=-1;
        }
    }
    @Override
    public void run() {
        while (true) {
            check();
            move();
            move2();
            
            
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
