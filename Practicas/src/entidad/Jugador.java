package entidad;

import Main.GamePanel;
import Main.ManejadorTeclas;
import java.awt.Color;
import java.awt.Graphics2D;

public class Jugador extends Entidad{
    private GamePanel gP;
    private ManejadorTeclas mT;

    public Jugador(GamePanel gP, ManejadorTeclas mT){
        this.gP = gP;
        this.mT = mT;
        configuracionInicial();
    }
    public void configuracionInicial(){
        this.x = 100;
        this.y = 100;
        this.velocidad = 4;
    }
    public void update(){
        if(mT.getTeclaArriba()) {
			setY(getY() - getVelocidad());
		}
		if(mT.getTeclaAbajo()) {
			setY(getY() + getVelocidad());
		}
		if(mT.getTeclaDer()) {
            setX(getX() + getVelocidad());
        }
		if(mT.getTeclaIzq()) {
            setX(getX() - getVelocidad());
		}
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.fillRect(getX(), getY(), gP.getTam(), gP.getTam());
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
