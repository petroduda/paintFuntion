package graphicPainter;

import javax.swing.JFrame;
import java.util.ArrayList;


public class Main {
	volatile static boolean quit;
	volatile static Space space;
	volatile static ArrayList<Double> coeficients = null;

	public static double function(double x) {
		if(coeficients != null) {
			int i = coeficients.size();
			double result = 0;
			for(double c : coeficients) {
				result += c * Math.pow(x, i);
				i--;
			}
			return result;

		}
		return 0;
	}
	
	public static void main(String[] args) {
		Button app= new Button();//окно ввода
		app.setVisible(true);
		JFrame window = new JFrame();//окно графіка
		window.setSize(512, 512);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		space = new Space(8);
		
		Surface surface = new Surface();
		EventListener listener = new EventListener();//считує нажаті кнопки
		window.add(surface);
		window.addKeyListener(listener);

		while (true) {//визиває обновления отрисовки
			surface.updateUI();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}