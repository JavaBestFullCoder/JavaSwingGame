import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player {
    private int x1, y1, width, height;

    private boolean killed = false;

    public Player(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
    }

    private int speed = 3;

    enum Direction {UP, DOWN, LEFT, RIGHT, NONE, ESC}
    private Direction playerDirection = Direction.NONE;

    public void move() {
        switch (playerDirection) {
            case UP:
                y1 -= speed;
                break;
            case DOWN:
                y1 += speed;
                break;
            case LEFT:
                x1 -= speed;
                break;
            case RIGHT:
                x1 += speed;
                break;
            case ESC:
                System.exit(3);
            case NONE:
            default:
                break;
        }
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            playerDirection = Direction.UP;
        } else if (key == KeyEvent.VK_S) {
            playerDirection = Direction.DOWN;
        } else if (key == KeyEvent.VK_A) {
            playerDirection = Direction.LEFT;
        } else if (key == KeyEvent.VK_D) {
            playerDirection = Direction.RIGHT;
        } else if (key == KeyEvent.VK_ESCAPE) {
            playerDirection = Direction.ESC;
        }
    }

    public void keyReleased(){
        playerDirection = Direction.NONE;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }
}
