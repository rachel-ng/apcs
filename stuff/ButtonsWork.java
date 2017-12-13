import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonsWork extends JFrame {
    private Container pane;
    private JButton b;
    private JLabel l;
    private JCheckBox c;
    private JTextField t;

    public void actionPerformed (ActionEvent e) {
	String s = e.getActionCommand();
	// System.out.println(s);
    }
    
    public ButtonsWork() {
        this.setTitle("My first GUI");
        this.setSize(400,80);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // lets you exit

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	b = new JButton("ByteMe");
	c = new JCheckBox("OverClocked");
	t = new JTextField(15);

	b.addActionListener(this);
	c.addActionListener(this);
	t.addActionListener(this);
	
      	pane.add(t);
	pane.add(c);
	pane.add(b);

    }

    public static void main(String[] args) {
        ButtonsWork g = new ButtonsWork();
        g.setVisible(true);
    }
}
