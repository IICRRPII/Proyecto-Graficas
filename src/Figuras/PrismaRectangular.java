package Figuras;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Queue;


public class PrismaRectangular {
    private double width;
    private double height;
    private double profundidad;
    private double distancia;  // Distancia focal
    private Bresenham bresenham = new Bresenham();

    public PrismaRectangular(double width, double height, double profundidad, double distancia) {
        this.width = width;
        this.height = height;
        this.profundidad = profundidad;
        this.distancia = distancia;
    }

    // Método para convertir coordenadas 3D a 2D usando proyección en perspectiva
    private int[] project(double x, double y, double z) {
        int[] point = new int[2];
        point[0] = (int) (x * distancia / (z + distancia));
        point[1] = (int) (y * distancia / (z + distancia));
        return point;
    }


    // Método de inundación (flood fill) para rellenar el prisma
    private void floodFill(int startX, int startY, double width, double height, double profundidad, double distancia
            , Color fillColor, BufferedImage buffer) {

    }
}
