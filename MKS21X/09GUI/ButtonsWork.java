import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ButtonsWork extends JFrame implements ActionListener{
    private Container pane;
    private JButton b,b2;
    private JCheckBox c;
    private JTextField t;

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        System.out.println(s);
        if(s.equals("ByteMe")){
            //button code here
            if( c.isSelected() ){
                t.setText(t.getText().toUpperCase());
            }else{
                t.setText("What do you want?");
            }
        }
        if(s.equals("Clear")){
            //button code here
            t.setText("");
        }

    }

    public ButtonsWork() {
        this.setTitle("My first GUI");
        this.setSize(500,80);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        b = new JButton("ByteMe");
        b2 = new JButton("Clear");
        c = new JCheckBox("OverClocked");
        t = new JTextField(15);

        b.addActionListener(this);
        b2.addActionListener(this);
        t.addActionListener(this);
        c.addActionListener(this);

        pane.add(t);
        pane.add(c);
        pane.add(b);
        pane.add(b2);

    }

    public static void main(String[] args) {
        ButtonsWork g = new ButtonsWork();
        g.setVisible(true);
    }
}
