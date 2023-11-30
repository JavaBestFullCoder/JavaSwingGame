public class Bullet {
    private int x1, y1, width, height;
    private int speed = 5;

    private boolean shoted = false;

    public Bullet(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
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

    public boolean isShoted() {
        return shoted;
    }

    public void setShooted(boolean shoted) {
        this.shoted = shoted;
    }

    public void shot(int humanX, int humanY) {
        if (x1 > humanX) {
            x1 -= speed;
        } else if (x1 < humanX) {
            x1 += speed;
        }

        if (y1 > humanY) {
            y1 -= speed;
        } else if (y1 < humanY) {
            y1 += speed;
        }
    }
}
