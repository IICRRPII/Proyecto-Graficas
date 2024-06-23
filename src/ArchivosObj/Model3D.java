package ArchivosObj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model3D  {
    private List<Vertex> vertices;
    private List<Face> faces;
    public double[][] object = {
            {1,0,0,0},
            {0,1,0,0},
            {0,0,1,0},
            {0,0,0,1}
    };
    public Vertex rotacion = new Vertex(0,0,0);
    public Vertex escala = new Vertex(1,1,1);
    public Vertex posicion = new Vertex(0,0,0);



    public Model3D() {
        vertices = new ArrayList<>();
        faces = new ArrayList<>();
    }

    public double[][] getObject() {
        return object;
    }

    public void setObject(double[][] object) {
        this.object = object;
    }

    public void readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            if (tokens.length == 0) continue;

            switch (tokens[0]) {
                case "v":
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    float z = Float.parseFloat(tokens[3]);
                    vertices.add(new Vertex(x, y, z));
                    break;

                case "f":
                    int[] vertexIndices = new int[tokens.length - 1];
                    int[] textureIndices = new int[tokens.length - 1];
                    int[] normalIndices = new int[tokens.length - 1];
                    for (int i = 1; i < tokens.length; i++) {
                        String[] subTokens = tokens[i].split("/");
                        vertexIndices[i - 1] = Integer.parseInt(subTokens[0]) - 1;
                        if (subTokens.length > 1 && !subTokens[1].isEmpty()) {
                            textureIndices[i - 1] = Integer.parseInt(subTokens[1]) - 1;
                        }
                        if (subTokens.length > 2) {
                            normalIndices[i - 1] = Integer.parseInt(subTokens[2]) - 1;
                        }
                    }
                    faces.add(new Face(vertexIndices, textureIndices, normalIndices));
                    break;
            }
        }
        reader.close();
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Face> getFaces() {
        return faces;
    }

    public static Vertex multiplicarMatriz(double[][] m, Vertex vertex){
        double[] result = new double[4];
        double[] v = {vertex.x, vertex.y, vertex.z, vertex.w};

        // Multiplicación de matriz 4x4 por matriz 4x1
        for (int i = 0; i < 4; i++) {
            result[i] = 0;
            for (int j = 0; j < 4; j++) {
                result[i] += m[i][j] * v[j];
            }
        }

        return new Vertex(result[0], result[1], result[2], result[3]);
    }
    public double[][] rotarX() {
        double angulo = Math.toRadians(rotacion.x);
        double cosTheta = Math.cos(angulo);
        double sinTheta = Math.sin(angulo);

        double[][] rotX = {
                {1, 0, 0, 0},
                {0, cosTheta, -sinTheta, 0},
                {0, sinTheta, cosTheta, 0},
                {0, 0, 0, 1}
        };

        return rotX;
    }

    public double[][] rotarY() {
        double angulo = Math.toRadians(rotacion.y);

        double cosTheta = Math.cos(angulo);
        double sinTheta = Math.sin(angulo);

        double[][] rotY = {
                {cosTheta, 0, sinTheta, 0},
                {0, 1, 0, 0},
                {-sinTheta, 0, cosTheta, 0},
                {0, 0, 0, 1}
        };

        return rotY;
    }

    private double[][] unitaria() {
        return new double[][] {
            {1,0,0,0},
            {0,1,0,0},
            {0,0,1,0},
            {0,0,0,1}
        };
    }

    public double[][] rotarZ() {
        double angulo = Math.toRadians(rotacion.z);
        double cosTheta = Math.cos(angulo);
        double sinTheta = Math.sin(angulo);

        double[][] rotZ = {
                {cosTheta, -sinTheta, 0, 0},
                {sinTheta, cosTheta, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        return rotZ;
    }
    private double[][] matTras(){
        return new double[][] {
                {1,0,0, posicion.x},
                {0,1,0, posicion.y},
                {0,0,1, posicion.z},
                {0,0,0, posicion.w}
        };
    }
    
    private double[][] matEscalar() {
        return new double[][] {
                {escala.x, 0, 0, 0},
                {0, escala.y, 0, 0},
                {0, 0, escala.z, 0},
                {0, 0, 0, 1}
        };
    }

    private double[][] multiplicarMatrices(double[][] m1, double[][] m2) {
        double[][] result = new double[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return result;
    }

    public void makeMatrix() {
        double[][] m = matTras();
        m = multiplicarMatrices(m,rotarX());
        m = multiplicarMatrices(m,rotarY());
        m = multiplicarMatrices(m,rotarZ());
        m = multiplicarMatrices(m,matEscalar());
        object = m;
    }
}
