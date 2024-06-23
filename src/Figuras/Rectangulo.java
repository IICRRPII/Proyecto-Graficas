package Figuras;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Queue;


public class Rectangulo {

    public Rectangulo() {

    }

    public void fillRectangle(int xTopLeft, int yTopLeft, int width, int height, Color fillColor, BufferedImage buffer) {
        if (buffer == null) {
            return; // Salir del método si el buffer es null
        }

        int bufferWidth = buffer.getWidth();
        int bufferHeight = buffer.getHeight();

        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[bufferWidth][bufferHeight];

        // Calcular límites del rectangulo
        int xMin = Math.max(0, xTopLeft);
        int xMax = Math.min(bufferWidth - 1, xTopLeft + width - 1);
        int yMin = Math.max(0, yTopLeft);
        int yMax = Math.min(bufferHeight - 1, yTopLeft + height - 1);

        // Agregar puntos dentro del rectangulo a la cola
        for (int y = yMin; y <= yMax; y++) {
            for (int x = xMin; x <= xMax; x++) {
                queue.add(new Point(x, y));
                visited[x][y] = true;
            }
        }

        // Rellenar el rectangulo
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;
            buffer.setRGB(x, y, fillColor.getRGB());

            // Agregar puntos vecinos no visitados dentro del rectangulo a la cola
            if (x - 1 >= xMin && !visited[x - 1][y]) {
                queue.add(new Point(x - 1, y));
                visited[x - 1][y] = true;
            }
            if (x + 1 <= xMax && !visited[x + 1][y]) {
                queue.add(new Point(x + 1, y));
                visited[x + 1][y] = true;
            }
            if (y - 1 >= yMin && !visited[x][y - 1]) {
                queue.add(new Point(x, y - 1));
                visited[x][y - 1] = true;
            }
            if (y + 1 <= yMax && !visited[x][y + 1]) {
                queue.add(new Point(x, y + 1));
                visited[x][y + 1] = true;
            }
        }
    }

    public void fillIrregularRectangle(int[] xCoords, int[] yCoords, Color fillColor, BufferedImage buffer) {
        int bufferWidth = buffer.getWidth();
        int bufferHeight = buffer.getHeight();

        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[bufferWidth][bufferHeight];
        // Calcular los limites del rectángulo irregular
        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE, yMin = Integer.MAX_VALUE, yMax = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            xMin = Math.min(xMin, xCoords[i]);
            xMax = Math.max(xMax, xCoords[i]);
            yMin = Math.min(yMin, yCoords[i]);
            yMax = Math.max(yMax, yCoords[i]);
        }

        // Agregar puntos dentro del rectangulo irregular a la cola
        for (int y = yMin; y <= yMax; y++) {
            for (int x = xMin; x <= xMax; x++) {
                if (pointInsideRectangle(x, y, xCoords, yCoords)) {
                    queue.add(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }

        // Rellenar el rectangulo irregular
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;
            buffer.setRGB(x, y, fillColor.getRGB());

            // Agregar puntos vecinos no visitados dentro del rectángulo irregular a la cola
            if (x - 1 >= xMin && !visited[x - 1][y] && pointInsideRectangle(x - 1, y, xCoords, yCoords)) {
                queue.add(new Point(x - 1, y));
                visited[x - 1][y] = true;
            }
            if (x + 1 <= xMax && !visited[x + 1][y] && pointInsideRectangle(x + 1, y, xCoords, yCoords)) {
                queue.add(new Point(x + 1, y));
                visited[x + 1][y] = true;
            }
            if (y - 1 >= yMin && !visited[x][y - 1] && pointInsideRectangle(x, y - 1, xCoords, yCoords)) {
                queue.add(new Point(x, y - 1));
                visited[x][y - 1] = true;
            }
            if (y + 1 <= yMax && !visited[x][y + 1] && pointInsideRectangle(x, y + 1, xCoords, yCoords)) {
                queue.add(new Point(x, y + 1));
                visited[x][y + 1] = true;
            }
        }
    }

    // Metodo auxiliar para verificar si un punto está dentro del rectangulo irregular
    private boolean pointInsideRectangle(int x, int y, int[] xCoords, int[] yCoords) {
        int intersections = 0;
        int nVertices = xCoords.length;

        for (int i = 0, j = nVertices - 1; i < nVertices; j = i++) {
            if ((yCoords[i] > y) != (yCoords[j] > y)
                    && (x < (xCoords[j] - xCoords[i]) * (y - yCoords[i]) / (yCoords[j] - yCoords[i]) + xCoords[i])) {
                intersections++;
            }
        }

        return intersections % 2 == 1;
    }
}
