package graphicPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Button extends JFrame {
    private JButton button = new JButton("Обрахувати");
    private JTextField input = new JTextField("",5);
    private JLabel label = new JLabel("Input:");

    public Button(){
        super ("Paint Graphic");
        this.setBounds(100,100,250,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container conteiner = this.getContentPane();
        conteiner.setLayout(new GridLayout(3,2,2,2));
        conteiner.add(label);
        conteiner.add(input);
        button.addActionListener(new ReadFunction());
        conteiner.add(button);

    }
    class ReadFunction implements ActionListener {

        public void actionPerformed (ActionEvent e){
            String message = "";
            String y2 = input.getText();
            ArrayList<String> parts = new ArrayList<String>(Arrays.asList(y2.split(",")));
            ArrayList<Double> coeficients = new ArrayList<Double>();
            for(String s : parts) {
                try {
                    coeficients.add(Double.parseDouble(s));
                } catch (Exception e1) {
                    System.out.println(s + " is NaN");
                }
            }
            Main.coeficients = coeficients;

            //String part1=
            //int y1=Integer.parseInt(y2);
            //JOptionPane.showMessageDialog(null,y1,"Output",JOptionPane.PLAIN_MESSAGE);

        }
    }

}
