import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainDraw extends JComponent {

    public int x = 500;
    public int y = 500;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, 50, 50);
        g.fillRect(x, y, 50, 50);
        g.setColor(Color.BLACK);
    }

    public void moveRight() {
        if (x + 50 < 600) {
	    x = x + 10;
	    repaint();
	}
    }

    public void moveLeft() {
	if (x > 0) {
	    x = x - 10;
	    repaint();
	}
    }

    public void moveDown() {
	if (y + 50 < 600) {
	    y = y + 10;
	    repaint();
	}
    }

    public void moveUp() {
	if (y > 0) {
	    y = y - 10;
	    repaint();
	}
    }
}
