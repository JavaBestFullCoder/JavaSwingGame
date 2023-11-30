public class Dangerous{
    private int x1, y1, width, height;

    public Dangerous(int x1, int y1, int width, int height) {
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

    public boolean humanCheck(int humanX, int humanY){
        int centerX = x1; // Координаты центра
        int centerY = y1;

        int dx = centerX - humanX;
        int dy = centerY - humanY;

        // Если human находится в радиусе 10 пикселей от центра, делаем что-то
        return dx * dx + dy * dy <= 100 * 100;
    }
}
