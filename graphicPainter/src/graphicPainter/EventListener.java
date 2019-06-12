package graphicPainter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventListener implements KeyListener {
	private boolean[] keyCode;
	boolean keyPressed;

	
	public EventListener() {
		this.keyCode = new boolean[256];
		for (int i = 0; i < 256; i++) {
			keyCode[i] = false;
		}

		this.keyPressed = false;
	}
	
	public void keyPressed(KeyEvent event) {
		System.out.println(event.getKeyCode());
		this.keyPressed = true;
		if(event.getKeyCode() < 256) {
			this.keyCode[event.getKeyCode()] = true;
		}
		
		double offset = 4;
		
		if(event.getKeyCode() == 45) {
			if(Main.space.zoom > 4) {
				Main.space.zoom /= 1.2;
			}
		}
		else if(event.getKeyCode() == 61) {
			if(Main.space.zoom < 28) {
				Main.space.zoom *= 1.2;
			}
		}
		
		
		if(keyCode[37]) {
			Main.space.x -= offset;
		}
		else if(keyCode[39]) {
			Main.space.x += offset;
		}
		else if(keyCode[38]) {
			Main.space.y -= offset;
		}
		else if(keyCode[40]) {
			Main.space.y += offset;
		}
		
	}

	public void keyReleased(KeyEvent event) {
		this.keyPressed = false;
		if(event.getKeyCode() < 256) {
			this.keyCode[event.getKeyCode()] = false;
		}
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	public boolean getCode(int i) {
		return keyCode[i];
	}

}