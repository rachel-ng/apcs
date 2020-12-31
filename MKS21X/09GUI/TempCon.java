import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TempCon extends JFrame implements ActionListener{
    private Container pane;
    private JButton s;
    private JCheckBox c,f;
    private JTextField t;
    private JLabel l; 

    public void actionPerformed (ActionEvent e) {
        String s = e.getActionCommand();
        System.out.println(s);
        if (s.equals("Convert")) {
            if (c.isSelected()) {
		t.setText("" + CtoF(Double.parseDouble(t.getText())));
            }
	    if (f.isSelected()) {
		t.setText("" + CtoF(Double.parseDouble(t.getText())));
            }
        }

    }

    public TempCon () {
        this.setTitle("Temperature Converter");
        this.setSize(300,100);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
	s = new JButton("Convert");
        c = new JCheckBox("C to F");
	f = new JCheckBox("F to C");
	l = new JLabel("Temperature");
        t = new JTextField(15);

	s.addActionListener(this);
        c.addActionListener(this);
        f.addActionListener(this);
        t.addActionListener(this);

        pane.add(l);
        pane.add(t);
	pane.add(s);
        pane.add(c);
        pane.add(f);

    }

    public static double CtoF (double t) {
        return (t * 1.8) + 32;
    }

    public static double FtoC (double t) {
        return (t - 32) / 1.8;
    }

    public static void main(String[] args) {
        TempCon g = new TempCon();
        g.setVisible(true);
    }
}
