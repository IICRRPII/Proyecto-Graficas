package Class;

import ArchivosObj.Model3D;
import ArchivosObj.ProjectionPanel;
import Dibujos.Casa;
import Figuras.PrismaRectangular;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Animacion extends JFrame implements Runnable{
    private BufferedImage buffer;
    private Graphics bufferGraphics;
    private Casa casa = new Casa("src/Figuras/BGTest3.png");
    private double t = 0;
    List<Model3D> models;
    PrismaRectangular prisma = new PrismaRectangular(150, 100, 25, -50);


    public Animacion() throws IOException {
        setTitle("Reproducir animacion");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        bufferGraphics = buffer.getGraphics();
        bufferGraphics.clearRect(0, 0, getWidth(), getHeight());

        models = new ArrayList<>();
        Model3D michi = new Model3D();
        michi.readFromFile("src/Figuras/Arch.obj");
        double[][] m = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        michi.setObject(m);

        models.add(michi);

        setVisible(true);
        this.run();
        repaint();
    }

    public void PutPixel(int x, int y, Color a, Graphics g) {
        buffer.setRGB(x, y, a.getRGB());
    }

    public void paint(Graphics g) {
        g.drawImage(buffer, 0, 0, this);
        // Dibujar prisma
//        prisma.dibujar(100, 50, Color.WHITE, buffer);
    }

    public void actualizarVentana() {
        repaint();
    }

    public void iniciarPrimesaEscena1(){
        dibujarElementos1(buffer);
    }

    public void dibujarElementos1(BufferedImage buffer){
//        casa.paintComponents(bufferGraphics);
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            //test angulos
            //model.rotacion.x = t * 10;
           // model.rotacion.y = t * 10;
           //Arco angulos
           model.rotacion.x = t*10;
            model.rotacion.y = 90;
            model.rotacion.z = 90;
            model.posicion.x = 10;
            
           /* model.rotacion.x = 90;
            model.rotacion.y = 360;
            model.rotacion.z = t*10;*/
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model);
        }
        repaint();
    }

    @Override
    public void run() {
        while (true){

            try {
                dibujarElementos1(buffer);
                t++;
                sleep(33);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
