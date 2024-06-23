package ArchivosObj;

import java.util.Arrays;


public class Face {
    public int[] vertexIndices;
    public int[] textureIndices;
    public int[] normalIndices;

    public Face(int[] vertexIndices, int[] textureIndices, int[] normalIndices) {
        this.vertexIndices = vertexIndices;
        this.textureIndices = textureIndices;
        this.normalIndices = normalIndices;
    }

    @Override
    public String toString() {
        return "Face{" +
                "vertexIndices=" + Arrays.toString(vertexIndices) +
                ", textureIndices=" + Arrays.toString(textureIndices) +
                ", normalIndices=" + Arrays.toString(normalIndices) +
                '}';
    }
}

