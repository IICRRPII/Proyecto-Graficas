package ArchivosObj;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class ProjectionPanel  {

    public static void drawModel(BufferedImage b, Model3D model, float escala, int centerX, int centerY, Color color) {

        java.awt.Graphics g = b.getGraphics();
        g.setColor(color);
        List<Vertex> vertices = model.getVertices();
        List<Face> faces = model.getFaces();

        // Parámetros de proyección
        float scale = escala;
        float fov = 100;
        int width = b.getWidth();
        int height = b.getHeight();

        for (Face face : faces) {
            int[] xPoints = new int[face.vertexIndices.length];
            int[] yPoints = new int[face.vertexIndices.length];

            for (int i = 0; i < face.vertexIndices.length; i++) {
                Vertex v = vertices.get(face.vertexIndices[i]);
                v = Model3D.multiplicarMatriz(model.object, v);
                xPoints[i] = (int) ((v.x * fov / (v.z + fov)) * scale) + centerX;
                yPoints[i] = (int) ((v.y * fov / (v.z + fov)) * scale) + centerY;
            }

            g.fillPolygon(xPoints, yPoints, face.vertexIndices.length);
        }
    }
}

