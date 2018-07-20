
package bouncy;

import javax.swing.JFrame;

public class Bouncy {

    public static void main(String[] args) {
        JFrame frame=new JFrame("Bouncy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.add(new Ball(300,300,0,0));
    }
}
