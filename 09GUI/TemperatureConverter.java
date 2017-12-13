import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame {
    private Container pane;
    private JButton a;
    private JTextField t;
    private JCheckBox f;
    private JCheckBox c;
    private JLabel l;

    public TemperatureConverter() {
	this.setTitle("Temperature Converter");
	this.setSize(400,80);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayour(new FlowLayout());

	a = new JButton("Convert");
	l = new JLabel("Temperature");
	t = new JTextField(10);
	f = new JCheckBox("F to C");
	c = new JCheckBox("C to F");

	pane.add(t);
	pane.add(l);
	pane.add(f);
	pane.add(c);
    }

    
}
