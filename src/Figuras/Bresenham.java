package Figuras;
import Class.Animacion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Queue;

public class Bresenham {

    private int x1, y1, x2, y2;
    private Color color;
    private Graphics g;
    private Animacion animacion;

    public Bresenham() {
    }

    public void drawBresenham(int x1, int y1, int x2, int y2, Color color, BufferedImage buffer) {
        int width = buffer.getWidth();
        int height = buffer.getHeight();

        // Verificar si los puntos de inicio y fin están dentro de los límites del buffer
        if (x1 < 0 || x1 >= width || y1 < 0 || y1 >= height || x2 < 0 || x2 >= width || y2 < 0 || y2 >= height) {
            return;
        }

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (x1 != x2 || y1 != y2) {
            buffer.setRGB(x1, y1, color.getRGB());

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }

            // Verificar si el siguiente punto está dentro de los límites del buffer
            if (x1 < 0 || x1 >= width || y1 < 0 || y1 >= height) {
                return;
            }
        }
        buffer.setRGB(x2, y2, color.getRGB());
    }

    public void fillBetweenLines(int x0, int y0, int x1, int y1, int x2, int y2, Color fillColor, BufferedImage buffer) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[buffer.getWidth()][buffer.getHeight()];

        drawBresenham(x0, y0, x1, y1, fillColor, buffer);
        drawBresenham(x0, y0, x2, y2, fillColor, buffer);

        int minX = Math.min(x0, Math.min(x1, x2));
        int maxX = Math.max(x0, Math.max(x1, x2));
        int minY = Math.min(y0, Math.min(y1, y2));
        int maxY = Math.max(y0, Math.max(y1, y2));

        queue.add(new Point(x0, y0));
        visited[x0][y0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;
            buffer.setRGB(x, y, fillColor.getRGB());

            if (x - 1 >= minX && !visited[x - 1][y]) {
                queue.add(new Point(x - 1, y));
                visited[x - 1][y] = true;
            }
            if (x + 1 <= maxX && !visited[x + 1][y]) {
                queue.add(new Point(x + 1, y));
                visited[x + 1][y] = true;
            }
            if (y - 1 >= minY && !visited[x][y - 1]) {
                queue.add(new Point(x, y - 1));
                visited[x][y - 1] = true;
            }
            if (y + 1 <= maxY && !visited[x][y + 1]) {
                queue.add(new Point(x, y + 1));
                visited[x][y + 1] = true;
            }
        }
    }

}
