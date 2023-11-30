import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Frame extends JPanel implements ActionListener {
    Timer time = new Timer(15, this);
    JFrame frame;

    Player player = new Player(210, 210, 30, 30);

    Dangerous dangerous = new Dangerous(100, 100, 40, 40);
    int bullX = 0;
    int bullY = 0;
    Bullet bullet = new Bullet(dangerous.getX1()+dangerous.getHeight(), dangerous.getY1()+ dangerous.getWidth(), 10, 10);

    public Frame(JFrame frame){
        this.frame = frame;
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
                System.out.println(player.getX1());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased();
            }
        });
       time.start();
    }



    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());

        if(player.isKilled()) {
            g.setColor(Color.RED);
            g.drawString("Game Over!", player.getX1(), player.getY1());
        }else {
            g.setColor(Color.BLUE);
            g.fillRect(player.getX1(), player.getY1(), player.getWidth(), player.getHeight());
        }

        g.setColor(Color.RED);
        g.fillRect(dangerous.getX1(), dangerous.getY1(), dangerous.getWidth(), dangerous.getHeight());


        if (!bullet.isShoted()) {
            g.setColor(Color.white);
            g.fillRect(bullet.getX1(), bullet.getY1(), bullet.getWidth(), bullet.getHeight());
            if (dangerous.humanCheck(player.getX1(), player.getY1())) {
                bullet.shot(player.getX1(), player.getY1());
            }
        }
        if (bullet.getX1() == player.getX1() || bullet.getY1() == player.getY1()){
            player.setKilled(true);
            bullet.setShooted(true);
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        player.move();
    }
}
