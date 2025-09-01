package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	//Config de pantalla
	final int sizeOriginalTile = 16;
	final int escala = 3;
	final int sizeTile = sizeOriginalTile * escala;
	final int maxRenPantalla = 15;
	final int maxColPantalla = 26;
	final int anchoPantalla = sizeTile * maxColPantalla;
	final int altoPantalla = sizeTile * maxRenPantalla;
	
	Thread hebraJuego;
	ManejadorTeclas mT = new ManejadorTeclas();
	private int FPS = 60;
	int playerX = 100, playerY = 100, velocidadJugador = 4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(this.anchoPantalla, this.altoPantalla));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(mT);
		this.setFocusable(true);
		
	}
	public void iniciaHebraJuego() {
		hebraJuego = new Thread(this);
		hebraJuego.start();
	}
	@Override
	public void run() {
		double intervaloDibujo = 1000000000 / FPS;
		double delta = 0;
		long ultimaVez = System.nanoTime();
		long tiempoActual;
		
		while(hebraJuego != null) {
			tiempoActual = System.nanoTime();
			delta += (tiempoActual - ultimaVez) / intervaloDibujo;
			ultimaVez = tiempoActual;
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}
	public void update() {
		if(mT.getTeclaArriba()) {
			playerY -= velocidadJugador;
		}
		if(mT.getTeclaAbajo()) {
			playerY += velocidadJugador;
		}
		if(mT.getTeclaDer()) {
			playerX += velocidadJugador;
		}
		if(mT.getTeclaIzq()) {
			playerX -= velocidadJugador;
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, sizeTile, sizeTile);
		g2.dispose();
	}
}
//Metodos getter a implementar