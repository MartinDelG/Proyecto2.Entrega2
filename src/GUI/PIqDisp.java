package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PIqDisp extends JPanel{
	int [][] matrizDispo;
	public PIqDisp(int [][] matrizDispo) {
		// TODO Auto-generated constructor stub
		this.matrizDispo = matrizDispo;
	}
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        for (int i = 0; i < 12; i++) {
	            for (int j = 0; j < 30; j++) {
	                int x = j * 25;
	                int y = i * 25;
	                g.drawRect(x, y, 25, 25);
	                
	                if (matrizDispo[i][j]==100) {
	                	g.setColor(new Color(65, 105, 150)); 
	                	g.fillRect(x, y, 25, 25);
	                }
	                else if (matrizDispo[i][j]!=100 && matrizDispo[i][j]!=0) {
	                	g.setColor(new Color(65, 105, 150)); 
	                	g.setColor(new Color(65, 105, 225)); 
	                	g.fillRect(x, y, 25, 25);
	                }
	            }
	        }
	        
	    }
	 public void re() {
		 repaint();
	 }
	 public void camSede(int [][] matrizDispo) {
		 this.matrizDispo = matrizDispo;
	 }
}
