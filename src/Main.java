import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.add(new Frame(frame));
        frame.setVisible(true);
    }
}