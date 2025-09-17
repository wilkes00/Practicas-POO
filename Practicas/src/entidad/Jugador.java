package entidad;

import Main.GamePanel;
import Main.ManejadorTeclas;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Jugador extends Entidad{
    private GamePanel gP;
    private ManejadorTeclas mT;

    public Jugador(GamePanel gP, ManejadorTeclas mT){
        this.gP = gP;
        this.mT = mT;
        configuracionInicial();
        getSpritesJugador();
    }
    public void configuracionInicial(){
        this.x = 100;
        this.y = 100;
        this.velocidad = 4;
        this.direccion = "abajo";
    }
    public void getSpritesJugador(){
        try {
            this.arriba1 = ImageIO.read(getClass().getResourceAsStream("/spritesjugador/moverArriba1.png"));
            this.arriba2 = ImageIO.read(getClass().getResourceAsStream("/spritesjugador/moverArriba2.png"));
            this.abajo1 = ImageIO.read(getClass().getResourceAsStream("/spritesjugador/moverAbajo1.png"));
            this.abajo2 = ImageIO.read(getClass().getResourceAsStream("/spritesjugador/moverAbajo2.png"));
            this.izquierda1 = ImageIO.read(getClass().getResourceAsStream("/spritesjugador/moverIzquierda1.png"));
            this.izquierda2 = ImageIO.read(getClass().getResourceAsStream("/spritesjugador/moverIzquierda2.png"));
            this.derecha1 = ImageIO.read(getClass().getResourceAsStream("/spritesjugador/moverDerecha1.png"));
            this.derecha2 = ImageIO.read(getClass().getResourceAsStream("/spritesjugador/moverDerecha2.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(mT.getTeclaArriba()) {
			setY(getY() - getVelocidad());
            this.direccion = "arriba";
		}
		if(mT.getTeclaAbajo()) {
			setY(getY() + getVelocidad());
            this.direccion = "abajo";
		}
		if(mT.getTeclaDer()) {
            setX(getX() + getVelocidad());
            this.direccion = "derecha";
        }
		if(mT.getTeclaIzq()) {
            setX(getX() - getVelocidad());
            this.direccion = "izquierda";
		}
    }
    public void draw(Graphics2D g2){
        BufferedImage sprite = null;
        switch(this.direccion){
            case "arriba":
                sprite = this.arriba1;
                break;
            case "abajo":
                sprite = this.abajo1;
                break;
            case "izquierda":
                sprite = this.izquierda1;
                break;
            case "derecha":
                sprite = this.derecha1;
                break;

        }
        g2.drawImage(sprite, getX(), getY(), gP.getTam(), gP.getTam(), gP);
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getVelocidad(){
        return this.velocidad;
    }
    public void setX(int valor){
        this.x = valor;
    }
    public void setY(int valor){
        this.y = valor;
    }
}
