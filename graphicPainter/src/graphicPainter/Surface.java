package graphicPainter;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Surface extends JPanel {
	//private static final long serialVersionUID = 1L;
	
//	public Surface() {
//
//	}
	
	@Override
    public void paintComponent(Graphics arg0) {//Малює зміни
        super.paintComponent(arg0);


        arg0.translate((int)Main.space.x, (int)Main.space.y);//Двигає все шо є на екрані

        arg0.drawLine(-(int)Main.space.x, this.getHeight() / 2, this.getWidth() - (int)Main.space.x, this.getHeight() / 2);//Ось x
        arg0.drawLine(this.getWidth() / 2,  -(int)Main.space.y, this.getWidth() / 2, this.getHeight() - (int)Main.space.y);//Ось Y

       // System.out.println(Main.space.zoom);
        //System.out.println(Math.sqrt(-10));
        
        for(int i = 0; i < this.getWidth() / Main.space.zoom; i++) {//цикл шо малює поділки
            if (i > 0) {
                if(i % (int)(32 / Main.space.zoom) == 0) {
                    arg0.drawLine((int) (this.getWidth() / 2 + i * Main.space.zoom), this.getHeight() / 2 - 8, (int) (this.getWidth() / 2 + i * Main.space.zoom), this.getHeight() / 2 + 8);
                    arg0.drawString(Integer.toString(i), (int) (this.getWidth() / 2 + i * Main.space.zoom), (int) (this.getHeight() / 2 + 20));
                }
            }
        }
        
        for(int i = 0; i < this.getHeight() / Main.space.zoom; i++) {
            if (i > 0) {
                if(i % (int)(32 / Main.space.zoom) == 0) {
                    arg0.drawLine(this.getWidth() / 2 - 8, (int)(this.getHeight() / 2 + i * Main.space.zoom), this.getWidth() / 2 + 8, (int)(this.getHeight() / 2 + i * Main.space.zoom));
                    arg0.drawString(Integer.toString(-i), (int) (this.getWidth() / 2 + 20), (int) (this.getHeight() / 2 + i * Main.space.zoom));
                }
            }
        }
        
        arg0.setColor(new Color(0x4baa24));
        
        for(int i = 0; i < this.getWidth() / Main.space.zoom; i++) {
            if (i > 0) {
                if(i % (int)(32 / Main.space.zoom) == 0) {
                    arg0.drawLine((int)(this.getWidth() / 2 - i * Main.space.zoom), this.getHeight() / 2 - 8, (int)(this.getWidth() / 2 - i * Main.space.zoom), this.getHeight() / 2 + 8);
                    arg0.drawString(Integer.toString(-i), (int) (this.getWidth() / 2 - i * Main.space.zoom), (int) (this.getHeight() / 2 + 20));
                }
            }
        }
        
        for(int i = 0; i < this.getHeight() / Main.space.zoom; i++) {
            if (i > 0) {
                if(i % (int)(32 / Main.space.zoom) == 0) {
                    arg0.drawLine(this.getWidth() / 2 - 8, (int)(this.getHeight() / 2 - i * Main.space.zoom), this.getWidth() / 2 + 8, (int)(this.getHeight() / 2 - i * Main.space.zoom));
                    arg0.drawString(Integer.toString(i), (int) (this.getWidth() / 2 + 20), (int) (this.getHeight() / 2 - i * Main.space.zoom));
                }
            }
        }

        int lastI = 0;
        int lastJ = 0;
        boolean hasLast = false;
        
        arg0.setColor(new Color(0xff4424));
        
        for(int i = 0; i < this.getWidth(); i++) {   //малює графік
    		int j =  (int)Math.round(this.getHeight() / 2 - functionTilling(i - (this.getWidth() / 2)));//находить значення у
    			
			if(hasLast) {//малює по точкам
    			arg0.drawLine(i, j, lastI, lastJ);
			}
			
			lastI = i;
			lastJ = j;
			hasLast = true;
        }
	}
	
	public double functionTilling(double x) {//збільшує фунцію
		return Main.function(x / Main.space.zoom) * Main.space.zoom;
	}
	
	
	
	
}