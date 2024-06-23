/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dibujos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FondoImagen {
    private BufferedImage fondoImagen;

    public FondoImagen(String rutaImagen) {
        try {
            fondoImagen = ImageIO.read(new File(rutaImagen));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dibujarFondo(BufferedImage buffer) {
        if (fondoImagen != null) {
            Graphics g = buffer.getGraphics();
            g.drawImage(fondoImagen, 0, 0, buffer.getWidth(), buffer.getHeight(), null);
            g.dispose();
        } else {
            Graphics g = buffer.getGraphics();
            g.setColor(Color.decode("#0f3e6d"));
            g.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
            g.dispose();
        }
    }

    public BufferedImage getFondoImagen() {
        return fondoImagen;
    }

    public void setFondoImagen(BufferedImage fondoImagen) {
        this.fondoImagen = fondoImagen;
    }
}
