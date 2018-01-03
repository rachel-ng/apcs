import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainDraw extends JComponent {

    public int x = 100;
    public int y = 100;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, 5, 5);
        g.fillRect(x, y, 5, 5);
        g.setColor(Color.BLACK);
    }

    public void moveRight() {
        if (x + 50 < 600) {
	    x = x + 20;
	    repaint();
	}
    }

    public void moveLeft() {
	if (x > 0) {
	    x = x - 20;
	    repaint();
	}
    }

    public void moveDown() {
	if (y + 50 < 600) {
	    y = y + 20;
	    repaint();
	}
    }

    public void moveUp() {
	if (y > 0) {
	    y = y - 20;
	    repaint();
	}
    }
}
