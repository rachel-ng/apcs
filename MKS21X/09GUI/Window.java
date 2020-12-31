import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private Container pane;
    private JButton b;
    private JLabel l;
    private JCheckBox c;
    private JTextField t;
    
    public Window() {
        this.setTitle("My first GUI");
        this.setSize(400,80);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // lets you exit

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	l = new JLabel("Student Name: ");
	pane.add(l); 
	b = new JButton("Submit");
	c = new JCheckBox("Kompressor!");
	t = new JTextField(15);
      	pane.add(t);
	pane.add(c);
	pane.add(b);

    }

    public static void main(String[] args) {
        Window g = new Window();
        g.setVisible(true);
    }
}
