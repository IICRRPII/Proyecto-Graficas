package Dibujos;

import Figuras.PrismaRectangular;
import Figuras.Rectangulo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;



public class Casa  extends JPanel{

    FondoImagen fondoImagen;
    
    PrismaRectangular prisma = new PrismaRectangular(100, 50, 75, 200);


    public Casa(String rutaImagen){
                
                fondoImagen = new FondoImagen(rutaImagen);

    }

    public void FondoPantalla(BufferedImage buffer){
        
        fondoImagen.dibujarFondo(buffer);

        
        /*
        rectangulo.fillRectangle(0, 0, 700, 10, Color.decode("#3068a0"), buffer);
        rectangulo1.fillRectangle(0, 10, 700, 25, Color.decode("#3070a8"), buffer);
        rectangulo2.fillRectangle(0, 25, 700, 40, Color.decode("#3078b0"), buffer);
        rectangulo3.fillRectangle(0, 40, 700, 55, Color.decode("#3080b8"), buffer);
        rectangulo4.fillRectangle(0, 55, 700, 70, Color.decode("#3888b8"), buffer);
        rectangulo5.fillRectangle(0, 70, 700, 85, Color.decode("#4898b8"), buffer);
        rectangulo6.fillRectangle(0,85, 700, 170, Color.decode("#50a0b8"), buffer);
        rectangulo7.fillRectangle(0, 170, 700, 240, Color.decode("#70a0a0"), buffer);
        rectangulo8.fillRectangle(0, 240, 700, 255, Color.decode("#a5b3d0"), buffer);
        
        rectangulo9.fillRectangle(0, 255, 700, 275, Color.decode("#589878"), buffer);
        rectangulo10.fillRectangle(0, 275, 700, 295, Color.decode("#509070"), buffer);
        rectangulo11.fillRectangle(0, 295, 700, 315, Color.decode("#488868"), buffer);
        rectangulo12.fillRectangle(0, 315, 700, 340, Color.decode("#408060"), buffer);
        rectangulo13.fillRectangle(0, 340, 700, 365, Color.decode("#387858"), buffer);
        rectangulo14.fillRectangle(0, 365, 700, 390, Color.decode("#307050"), buffer);
        rectangulo15.fillRectangle(0, 390, 700, 420, Color.decode("#286848"), buffer);
        rectangulo16.fillRectangle(0, 420, 700, 460, Color.decode("#206040"), buffer);
        rectangulo17.fillRectangle(0, 460, 700, 490, Color.decode("#185838"), buffer);
        
        */
        
    }
    

    public void Casa1(BufferedImage buffer){
        //Parte de abajo
//        prisma.dibujar(g, 100, 50);
    }
}