public class Line {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    // Метод для проверки пересечения этой линии с другой
    public boolean intersects(Line other) {
        // Вычисляем векторы
        int a1 = this.y2 - this.y1;
        int b1 = this.x1 - this.x2;
        int c1 = a1*this.x1 + b1*this.y1;

        int a2 = other.y2 - other.y1;
        int b2 = other.x1 - other.x2;
        int c2 = a2*other.x1 + b2*other.y1;

        // Вычисляем детерминант
        int det = a1*b2 - a2*b1;

        if (det == 0) {
            // Линии параллельны или совпадают
            return false;
        } else {
            // Находим точку пересечения
            int x = (b2*c1 - b1*c2) / det;
            int y = (a1*c2 - a2*c1) / det;

            // Проверяем, что точка пересечения находится на обоих отрезках
            if (x >= Math.min(this.x1, this.x2) && x <= Math.max(this.x1, this.x2) &&
                    y >= Math.min(this.y1, this.y2) && y <= Math.max(this.y1, this.y2) &&
                    x >= Math.min(other.x1, other.x2) && x <= Math.max(other.x1, other.x2) &&
                    y >= Math.min(other.y1, other.y2) && y <= Math.max(other.y1, other.y2)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
