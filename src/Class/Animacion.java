package Class;

import ArchivosObj.Model3D;
import ArchivosObj.ProjectionPanel;
import Dibujos.Casa;
import Figuras.PrismaRectangular;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Animacion extends JFrame implements Runnable{
    private BufferedImage buffer;
    private Graphics bufferGraphics;
    private Casa casa = new Casa("src/Figuras/BGTest3.png");
    private double t = 0;
    
    List<Model3D> models;
    List<Model3D> extras;
    List<Model3D> ships;
    List<Model3D> missiles;
    List<Model3D> fires;
    List<Model3D> explosions;
    List<Model3D> lastShip;
    PrismaRectangular prisma = new PrismaRectangular(150, 100, 25, -50);

    boolean gate = true;
    boolean gate2 = true;
    double delay_shoots = 0.15;
    
    double control = 0;
    double control2 = 0;
    double control3 = 0;
    double control4 = 40;
    double control5 = 1.5;
    double control6 = 5;
    
    int[] distanciasX = {100, 500, 100, 500, 100, 500};
    int[] distanciasZ = {-50, -50, 00, 00, 50, 50};
    
    double extras1 = 0;
    double extras2 = 0;
    double extras3 = 35;
    
    public Animacion() throws IOException {
        setTitle("Proyecto Animado");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        bufferGraphics = buffer.getGraphics();
        bufferGraphics.clearRect(0, 0, getWidth(), getHeight());

        models = new ArrayList<>();
        extras = new ArrayList<>();
        ships = new ArrayList<>();
        missiles = new ArrayList<>();
        fires = new ArrayList<>();
        explosions = new ArrayList<>();
        lastShip = new ArrayList<>();
        
        Model3D objeto = new Model3D();
        objeto.readFromFile("src/Figuras/tinker.obj");
        double[][] m = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto.setObject(m);
        models.add(objeto);
        
        Model3D nave = new Model3D();
        nave.readFromFile("src/Figuras/nave2.obj");
        double[][] n = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        nave.setObject(n);
        ships.add(nave);
        
        Model3D objeto2 = new Model3D();
        objeto2.readFromFile("src/Figuras/obelisco.obj");
        double[][] m2 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto2.setObject(m2);
        
        Model3D objeto3 = new Model3D();
        objeto3.readFromFile("src/Figuras/obelisco.obj");
        double[][] m3 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto3.setObject(m3);
        
        Model3D objeto4 = new Model3D();
        objeto4.readFromFile("src/Figuras/obelisco.obj");
        double[][] m4 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto4.setObject(m4);
        
        Model3D objeto5 = new Model3D();
        objeto5.readFromFile("src/Figuras/obelisco.obj");
        double[][] m5 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto5.setObject(m5);
        
        Model3D objeto6 = new Model3D();
        objeto6.readFromFile("src/Figuras/obelisco.obj");
        double[][] m6 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto6.setObject(m6);
        
        Model3D objeto7 = new Model3D();
        objeto7.readFromFile("src/Figuras/obelisco.obj");
        double[][] m7 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto7.setObject(m7);
        
        
        extras.add(objeto2);
        extras.add(objeto3);
        extras.add(objeto4);
        extras.add(objeto5);
        extras.add(objeto6);
        extras.add(objeto7);
        
        Model3D objeto8 = new Model3D();
        objeto8.readFromFile("src/Figuras/misil.obj");
        double[][] m8 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto8.setObject(m8);
        
        missiles.add(objeto8);
        
        Model3D fire1 = new Model3D();
        fire1.readFromFile("src/Figuras/misil.obj");
        double[][] f1 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        fire1.setObject(f1);
        
        Model3D fire2 = new Model3D();
        fire2.readFromFile("src/Figuras/misil.obj");
        double[][] f2 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        fire2.setObject(f2);
        
        Model3D fire3 = new Model3D();
        fire3.readFromFile("src/Figuras/misil.obj");
        double[][] f3 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        fire3.setObject(f3);
        
        Model3D fire4 = new Model3D();
        fire4.readFromFile("src/Figuras/misil.obj");
        double[][] f4 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        fire4.setObject(f4);
        
        Model3D fire5 = new Model3D();
        fire5.readFromFile("src/Figuras/misil.obj");
        double[][] f5 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        fire5.setObject(f5);
        
        fires.add(fire1);
        fires.add(fire2);
        fires.add(fire3);
        fires.add(fire4);
        fires.add(fire5);
        
        Model3D explosion = new Model3D();
        explosion.readFromFile("src/Figuras/explosion.obj");
        double[][] e = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        explosion.setObject(e);
        explosions.add(explosion);
        
        Model3D lastnave = new Model3D();
        lastnave.readFromFile("src/Figuras/nave2.obj");
        double[][] ln = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        lastnave.setObject(ln);
        lastShip.add(lastnave);

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
            //model.rotacion.x = t * 1;
            model.rotacion.x = 90;
            model.rotacion.y = 25;
            model.posicion.y = 100 + t*-.8;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float)(t*.02), 300, 300);
        }
        
        for (Model3D ship : ships) {
            ship.posicion.z = -50;
            ship.makeMatrix();
        }
        
        repaint();
    }
    
    public void dibujarElementos2(BufferedImage buffer){
//        casa.paintComponents(bufferGraphics);
        control -= .01;
        extras1 += .015;
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float)(control), 300, 300);
        }
        
        int i = 0;
        for (Model3D extra : extras) {
            extra.rotacion.x = 90;
            extra.posicion.z = distanciasZ[i];
            extra.posicion.y += 1;
            
            extra.makeMatrix();
            ProjectionPanel.drawModel(buffer, extra, (float)extras1, distanciasX[i], 300);
            i++;
        }
        
        repaint();
    }
    
    public void dibujarElementos3(BufferedImage buffer){
//        casa.paintComponents(bufferGraphics);
        control = 0;
        control2++;
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            //model.rotacion.x = t * 1;
            model.rotacion.x = 90;
            //model.rotacion.y = t * 1;
            model.rotacion.y = 25 + control2*.6;
            model.posicion.x = control2*1.4;
            model.posicion.y = control2*-1;

            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, 1.5f, 300, 300);
        }
        
        int i = 0;
        for (Model3D extra : extras) {
            extra.posicion.y += 3.5;
            extra.posicion.x += control2*.01;
            
            extra.makeMatrix();
            ProjectionPanel.drawModel(buffer, extra, (float) (extras1+control2*.02), distanciasX[i], 300);
            i++;
        }
        
        extras2 += .06;
        for (Model3D missile : missiles) {
            missile.rotacion.x = 180;
            missile.rotacion.y = 90;
            missile.posicion.y += .5;
            missile.posicion.x += control2*.01;
            
            missile.makeMatrix();
            ProjectionPanel.drawModel(buffer, missile, (float)extras2, 300, 400);
        }
        repaint();
    }
    
    public void dibujarElementos4(BufferedImage buffer){
//        casa.paintComponents(bufferGraphics);
        control2 -= 4;
        control -= .5;
        control4 -= .5;
        if(control4<0) control4 = 0;
        
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            //model.rotacion.x = t * 1;
            model.rotacion.y = 25 + control2*.6;
            model.posicion.x = control*1.4;
            control3 = model.posicion.y;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, 1.5f, 300, 300);
        }
        
        if(t>295){
            for (Model3D ship : ships) {
                ship.rotacion.x = 90;
                ship.posicion.x += .02;
                ship.posicion.y += .05;


                ship.makeMatrix();
                buffer.getGraphics().drawString("t= " + t,100,100);
                ProjectionPanel.drawModel(buffer, ship, (float)control4, 400, 120);
            }
        }
        
        repaint();
    }
    
    public void dibujarElementos5(BufferedImage buffer){
//        casa.paintComponents(bufferGraphics);
        control += .5;
        control3 += .6;
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            model.posicion.y = control3*1.4;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, 1.5f, 300, (int) control);
        }
        
        extras2 += .02;
        int i = 0;
        
        int[] missileY = {50, 150, 250, 350};
        for (Model3D missile : missiles) {
            missile.rotacion.x = 180;
            missile.rotacion.y = 90;
            missile.posicion.y -= .5;
            missile.posicion.z -= .1;
            
            missile.makeMatrix();
            ProjectionPanel.drawModel(buffer, missile, (float)extras2, 280, missileY[i]);
            i++;
        }
        repaint();
    }
    
    public void dibujarElementos6(BufferedImage buffer){
        control5 -=.005;
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            model.posicion.y -= .7;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        extras1 += 0.18;
        for (Model3D extra : extras) {
            extra.rotacion.x = 200;
            extra.rotacion.y = 90;
            extra.posicion.y += .05;
            extra.posicion.z -= 1;
            
            extra.makeMatrix();
            ProjectionPanel.drawModel(buffer, extra, (float)extras1, 300, 300);
        }
        repaint();
    }
    
    public void dibujarElementos7(BufferedImage buffer){
        
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            model.rotacion.x += .3;
            model.rotacion.y += .2;
            model.posicion.x += 2;
            model.posicion.y -= 1;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        extras1 += 0.10;
        for (Model3D extra : extras) {
            extra.rotacion.x = 200;
            extra.rotacion.y = 90;
            extra.posicion.y += .05;
            extra.posicion.z -= 1;
            
            extra.makeMatrix();
            ProjectionPanel.drawModel(buffer, extra, (float)extras1, 500, 300);
        }
        repaint();
    }
    
    public void dibujarElementos8(BufferedImage buffer){
        control5 +=.006; 
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            model.rotacion.x -= .3;
            model.rotacion.y -= .2;
            model.posicion.x -= 2;
            model.posicion.y += 1;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        repaint();
    }
    
    public void dibujarElementos9(BufferedImage buffer){ 
        extras1 += .008;
        control5 += .0001;
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            model.rotacion.y -=.012;
            model.rotacion.x += 0.03;
            model.posicion.y -= .01;

            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int[] dX = {100, 500};
        int i = 0;
        for (Model3D extra : extras) {
            extra.rotacion.x = 90;
            extra.posicion.y += .5;
            
            extra.makeMatrix();
            ProjectionPanel.drawModel(buffer, extra, (float)extras1, dX[i], 300);
            i++;
        }
        
        i = 0;
        int[] nX = {100, 200, 300};
        int[] nY = {-100, 00, -100};
        control2 += 0.2;
        extras3 -= .005;
        for (Model3D ship : ships) {
            ship.rotacion.x = 90;
            ship.posicion.x += .0005;
            ship.posicion.y += .03;
            ship.posicion.z = control2;
            
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX[i], nY[i]);
            i++;
        }
        
        repaint();
    }
    
    public void dibujarElementos10(BufferedImage buffer){ 
        control5 += .0001;
       
        casa.FondoPantalla(buffer);
        for(Model3D model: models){
            model.rotacion.x -= .05;
            model.posicion.y += .001;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int i = 0;
        int[] nX = {100, 200, 300};
        int[] nY = {-100, 00, -100};
        extras3 -= .0005;
        for (Model3D ship : ships) {
            ship.rotacion.x = 90;
            ship.rotacion.y += .02;
            ship.posicion.x += .0001;
            ship.posicion.y -= .001;
            
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX[i], nY[i]);
            i++;
        }
        
        Model3D fire = fires.get(0);
            fire.rotacion.x = 10;
            fire.rotacion.y = 90;
            
            fire.posicion.y -= 1;
            fire.posicion.z += 1;
            
            fire.makeMatrix();
            ProjectionPanel.drawModel(buffer, fire, (float) (control5+.001), 300, (int) control);
        
        
        repaint();
    }
    
    public void dibujarElementos11(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        
        for(Model3D model: models){
            model.rotacion.y += .08;
            model.posicion.x += .4;
            model.posicion.y -= .6;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int i = 0;
        int[] nX = {100, 300};
        int[] nY = {-100, -100};
        double[] direction = {-2, .3};
        extras3 -= .0005;
        for (Model3D ship : ships) {
            ship.rotacion.x = 90;
            ship.rotacion.y += .5*direction[i];
            ship.posicion.x += .05*direction[i];
            ship.posicion.y -= .001;
            
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX[i], nY[i]);
            i++;
        }
        
        if(t<1615){
        Model3D explosion = explosions.get(0);
            explosion.rotacion.x = 90;
            explosion.rotacion.y -= .02;
            
            explosion.makeMatrix();
            ProjectionPanel.drawModel(buffer, explosion, (float).8, 280, 250);
        }
        repaint();
    }
    
    public void dibujarElementos12(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        
        control5 -= .001;
        for(Model3D model: models){
            
            model.rotacion.y -= .004;
            model.posicion.x -= .002;
            model.posicion.y += .002;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int nX = 300;
        int nY = -100;
        extras3 -= .0005;
        Model3D ship = ships.get(1);
            ship.rotacion.x = 90;
            ship.rotacion.y -= .02;
            ship.posicion.x += .03;
            ship.posicion.y -= .002;
            
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX, nY);
            
        control3-=.05;    
        Model3D fire = fires.get(0);
            fire.rotacion.x -= .1;
            fire.rotacion.y = 90;
            
            fire.posicion.y += .5;
            fire.posicion.z += 1;
            
            fire.makeMatrix();
            ProjectionPanel.drawModel(buffer, fire, (float) (control3), 500, 100);
                
        repaint();
    }
    
    public void dibujarElementos13(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        
        control5 -= .001;
        for(Model3D model: models){
            
            model.rotacion.y -= .004;
            model.posicion.x -= .002;
            model.posicion.y += .002;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int nX = 300;
        int nY = -100;
        extras3 -= .0005;
        Model3D ship = ships.get(1);
            ship.rotacion.x = 90;
            ship.rotacion.y -= .07;
            ship.posicion.x += .03;
            ship.posicion.y -= .01;
            
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX, nY);
            
        control3-=.05;    
        for (int i=0; i<2; i++) {
            Model3D fire = fires.get(i);
            fire.rotacion.x -= .1;
            fire.rotacion.y = 90;
            
            fire.posicion.y += .5 + delay_shoots;
            fire.posicion.z += 1 + delay_shoots;
            
            fire.makeMatrix();
            ProjectionPanel.drawModel(buffer, fire, (float) (control3), 500, 100);
        }
                
        repaint();
    }
    
    public void dibujarElementos14(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        
        control5 -= .001;
        for(Model3D model: models){
            
            model.rotacion.y -= .004;
            model.posicion.x -= .002;
            model.posicion.y += .002;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int nX = 300;
        int nY = -100;
        extras3 -= .0005;
        Model3D ship = ships.get(1);
            ship.rotacion.x = 90;
            ship.rotacion.y += .065;
            ship.posicion.x += .035;
            ship.posicion.y -= .025;
            
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX, nY);
            
        control3-=.05;    
        for (int i=0; i<3; i++) {
            Model3D fire = fires.get(i);
            fire.rotacion.x -= .1;
            fire.rotacion.y = 90;
            
            fire.posicion.y += .6 + delay_shoots;
            fire.posicion.z += 1 + delay_shoots;
            
            fire.makeMatrix();
            ProjectionPanel.drawModel(buffer, fire, (float) (control3+delay_shoots), 500, 100);
        }
                
        repaint();
    }
    
    public void dibujarElementos15(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        
        control5 += .001;
        for(Model3D model: models){
            
            model.rotacion.y -= .04;
            model.posicion.x -= .3;
            model.posicion.y += .4;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int nX = 300;
        int nY = -100;
        extras3 += .0005;
        Model3D ship = ships.get(1);
            ship.rotacion.x = 90;
            ship.rotacion.y -= 1.2;
            ship.posicion.x -= .02;
            ship.posicion.y += .015;
            ship.posicion.z -= .09;
            
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX, nY);
                
        repaint();
    }
    
    public void dibujarElementos16(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        control4 += .01;
        control5 -= .001;
        control3 = 0;
        for(Model3D model: models){
            
            model.rotacion.y += .04;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int nX = 300;
        int nY = -100;
        extras3 += .0004;
        Model3D ship = ships.get(1);
            ship.posicion.x += .005;
            ship.posicion.y -= .005;
        
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX, nY);
                
        int i = 0;
        int[] dY = {00, 400};
        int[] dAlignment = {-1, 1};
        for (Model3D extra : extras) {
            extra.rotacion.y = 90;
            extra.posicion.y += .04*dAlignment[i];
            extra.posicion.z -=.05;
            
            extra.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, extra, (float) control4, 000, dY[i]);
            i++;
        }
    
        repaint();
    }
    
    public void dibujarElementos17(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        control4 += .001;
        control5 -= .0001;
        for(Model3D model: models){
            
            model.rotacion.y += .02;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int nX = 300;
        int nY = -100;
        extras3 += .0001;
        Model3D ship = ships.get(1);
            ship.posicion.x += .001;
            ship.posicion.y -= .001;
        
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX, nY);
        
        control3 += .1;
        control6 -= .015;
        Model3D fire = fires.get(0);
            fire.rotacion.x -= .1;
            fire.rotacion.y = 110 + control3;
            
            fire.posicion.x += .1;
            fire.posicion.y += .2;
            fire.posicion.z = 10;
            
            fire.makeMatrix();
            ProjectionPanel.drawModel(buffer, fire, (float) (control6), 280, 300);
        
    
        repaint();
    }
    
    public void dibujarElementos18(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        control4 += .001;
        control5 -= .0001;
        for(Model3D model: models){
            
            model.rotacion.y += .02;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        int nX = 300;
        int nY = -100;
        extras3 += .0001;
        Model3D ship = ships.get(1);
            ship.posicion.x += .001;
            ship.posicion.y -= .001;
        
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, nX, nY);
        
        control6 -= .01;
        Model3D fire = fires.get(0);
            fire.rotacion.x -= .1;
            fire.rotacion.y = 110+control3;
            
            fire.posicion.x += 1.2;
            fire.posicion.y -= 1.2;
            
            
            fire.makeMatrix();
            ProjectionPanel.drawModel(buffer, fire, (float) (control6), 280, 300);
        
    
        repaint();
    }
    
    public void dibujarElementos19(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        control4 += .001;
        control5 -= .0001;
        for(Model3D model: models){
            
            model.rotacion.y += .02;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        extras3 += .0001;
        Model3D ship = ships.get(1);
            ship.rotacion.y -= .2;
            ship.posicion.x += .0005;
            ship.posicion.y -= .0005;
        
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)extras3, 300, -100);
            
            
        Model3D ship2 = ships.get(0);
            ship2.rotacion.y = 0;
            ship.rotacion.x = 90;
            ship2.posicion.x += .3;
        
            ship2.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship2, (float)extras3, 0, -100);
            
        Model3D fire = fires.get(0);
            fire.rotacion.x -= .1;
            fire.rotacion.y = 110+control3;
            fire.posicion.y += .09;
            
            fire.makeMatrix();
            ProjectionPanel.drawModel(buffer, fire, (float) (control6), 280, 300);
    
        repaint();
    }
    
    public void dibujarElementos20(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        control4 += .001;
        control5 -= .0001;
        control3 = 0;
        for(Model3D model: models){
            
            model.rotacion.y += .02;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        
        if(t<3370){
        Model3D explosion = explosions.get(0);
            explosion.rotacion.x = 90;
            explosion.rotacion.y -= .02;
            
            explosion.makeMatrix();
            ProjectionPanel.drawModel(buffer, explosion, (float)1.5, 500, 100);
        }
    
        repaint();
    }
    
    public void dibujarElementos21(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        control4 += .001;
        control5 -= .0001;
        for(Model3D model: models){
            
            model.rotacion.y += .02;
            
            model.makeMatrix();
            buffer.getGraphics().drawString("t= " + t,100,100);
            ProjectionPanel.drawModel(buffer, model, (float) control5, 300, (int) control);
        }
        
        control3+=.8;
        Model3D ship = lastShip.get(0);
            ship.rotacion.y = 180;
            ship.rotacion.x = 270;
            ship.posicion.x += .0005;
            ship.posicion.y -= .0005;
        
            ship.makeMatrix();
            ProjectionPanel.drawModel(buffer, ship, (float)control3, 600, 400);
            
        repaint();
    }
    
    public void dibujarElementos22(BufferedImage buffer){         
        casa.FondoPantalla(buffer);
        Model3D explosion = explosions.get(0);
            explosion.rotacion.x = 90;
            explosion.rotacion.y -= .02;
            
            explosion.makeMatrix();
            ProjectionPanel.drawModel(buffer, explosion, (float)2.5, 300, 300);
            
        repaint();
    }

   @Override
    public void run() {
        while (true){
            try {
                if(t<121){
                    dibujarElementos1(buffer);
                    control = t*.02;
                }
                
                if(t>121 && t<201){
                    dibujarElementos2(buffer);
                }
                
                if(t>201 && t<271){
                    dibujarElementos3(buffer);
                    control = control2;
                }
                if(t>271 && t<439)dibujarElementos4(buffer);
                if(t>439 && t<441) reset();
                if(t>441 && t<601)dibujarElementos5(buffer);
                if(t>601 && t<679)dibujarElementos6(buffer);
                if(t>679 && t<681) resetFigura();
                if(t>681 && t<771)dibujarElementos7(buffer);
                if(t>771 && t<861)dibujarElementos8(buffer);
                if(t>861 && t<863) resetFigura2();
                if(t>863 && t<1401)dibujarElementos9(buffer);
                if(t>1401 && t<1601) dibujarElementos10(buffer);
                if(t>1601 && t<1851){
                    resetFigura3();
                    dibujarElementos11(buffer);
                }
                if(t>1851 && t<1881)dibujarElementos12(buffer);
                if(t>1881 && t<1901)dibujarElementos13(buffer);
                if(t>1901 && t<2081)dibujarElementos14(buffer);
                if(t>2081 && t<2406){
                    resetFigura4();
                    dibujarElementos15(buffer);
                }
                if(t>2406 && t<2901)dibujarElementos16(buffer);
                if(t>2901 && t<3051)dibujarElementos17(buffer);
                if(t>3051 && t<3171)dibujarElementos18(buffer);
                if(t>3171 && t<3346) dibujarElementos19(buffer);
                if(t>3346 && t<3371)dibujarElementos20(buffer);
                if(t>3371 && t<3450)dibujarElementos21(buffer);
                if(t>3450 && t<3500)dibujarElementos22(buffer);
                
                t++;
                sleep(12);
                //sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException ex) {
                Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void reset() throws IOException{
        control = 300;
        control2 = 0;
        control3 += 20;
        extras1 = 0;
        extras2 = 0;
        
        extras.clear();
        Model3D objeto = new Model3D();
        
        try {
            objeto.readFromFile("src/Figuras/arch.obj");
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        double[][] m = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto.setObject(m);
        extras.add(objeto);
     
        missiles.clear();
        Model3D missile1 = new Model3D();
        missile1.readFromFile("src/Figuras/misil.obj");
        double[][] m1 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        missile1.setObject(m1);
        missiles.add(missile1);
        
        Model3D missile2 = new Model3D();
        missile2.readFromFile("src/Figuras/misil.obj");
        double[][] m2 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        missile2.setObject(m2);
        missiles.add(missile2);
        
        Model3D missile3 = new Model3D();
        missile3.readFromFile("src/Figuras/misil.obj");
        double[][] m3 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        missile3.setObject(m3);
        missiles.add(missile3);
        
        Model3D missile4 = new Model3D();
        missile4.readFromFile("src/Figuras/misil.obj");
        double[][] m4 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        missile4.setObject(m4);
        missiles.add(missile4);
    }
    
    public void resetFigura(){    
        extras1 = 0;
        extras.clear();
        Model3D objeto = new Model3D();
        
        try {
            objeto.readFromFile("src/Figuras/arch.obj");
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        double[][] m = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto.setObject(m);
        extras.add(objeto);
        
        missiles.clear();
        Model3D missile = new Model3D();
        
        try {
            missile.readFromFile("src/Figuras/misil.obj");
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        double[][] n = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        missile.setObject(n);
        missiles.add(missile);
        
        ships.clear();
        Model3D nave = new Model3D();
        try {
            nave.readFromFile("src/Figuras/nave2.obj");
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        double[][] m2 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        nave.setObject(m2);
        ships.add(nave);
    }
    
    public void resetFigura2(){
        control2 = -20;
        control3 = 10;
        control4 = 0;
        extras1 = 0;
        extras.clear();
        
        Model3D objeto2 = new Model3D();
        try {
            objeto2.readFromFile("src/Figuras/torre.obj");
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        double[][] m2 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto2.setObject(m2);
        
        Model3D objeto3 = new Model3D();
        try {
            objeto3.readFromFile("src/Figuras/torre.obj");
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        double[][] m3 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        objeto3.setObject(m3);
        
        extras.add(objeto2);
        extras.add(objeto3);
        
        ships.clear();
        Model3D nave = new Model3D();
        try {
            nave.readFromFile("src/Figuras/nave2.obj");
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        double[][] n = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        nave.setObject(n);
        ships.add(nave);
        
        Model3D nave2 = new Model3D();
        try {
            nave2.readFromFile("src/Figuras/nave2.obj");
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        double[][] n2 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        nave2.setObject(n2);
        ships.add(nave2);
        
        Model3D nave3 = new Model3D();
        try {
            nave3.readFromFile("src/Figuras/nave2.obj");
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        double[][] n3 = {
                {1,0,0,10},
                {0,1,0,0},
                {0,0,1,10},
                {0,0,0,1}
        };
        nave3.setObject(n3);
        ships.add(nave3);
    }
    
    public void resetFigura3(){
        if(gate == true){
            ships.remove(1);
            fires.remove(0);
            gate = false;
        }
    }
    
    public void resetFigura4() throws IOException{
        if(gate2 == true){
            fires.remove(2);
            fires.remove(1);
            fires.remove(0);
            control2 = 0;
            control3 = 0;
            control4 = 0;
            
            extras.clear();
            Model3D objeto = new Model3D();
            objeto.readFromFile("src/Figuras/obelisco.obj");
            double[][] m = {
                    {1,0,0,10},
                    {0,1,0,0},
                    {0,0,1,10},
                    {0,0,0,1}
            };
            objeto.setObject(m);
            
            Model3D objeto2 = new Model3D();
            objeto2.readFromFile("src/Figuras/obelisco.obj");
            double[][] m2 = {
                    {1,0,0,10},
                    {0,1,0,0},
                    {0,0,1,10},
                    {0,0,0,1}
            };
            objeto2.setObject(m2);
            extras.add(objeto);
            extras.add(objeto2);
            
            explosions.clear();
            Model3D explosion = new Model3D();
            explosion.readFromFile("src/Figuras/explosion.obj");
            double[][] e = {
                    {1,0,0,10},
                    {0,1,0,0},
                    {0,0,1,10},
                    {0,0,0,1}
            };
            explosion.setObject(e);
            explosions.add(explosion);
            
            gate2 = false;
            gate = true;
        }
        
        
    }
}
