/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondyear2_prog3lab_ass_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Abdullah Shublaq
 */

public class GUI extends JFrame implements ActionListener {

    JTextField textField = new JTextField(10);
    JButton buttons[] = new JButton[16];
    Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 16);
    int type = 0;

    public GUI() {

        /*START : TextField*/
        Dimension dimension = new Dimension(WIDTH, 30);
        textField.setPreferredSize(dimension);
        textField.setFont(font);
        add(textField, BorderLayout.NORTH);
        /*END : TextField*/

        /*START : Buttons*/
        JButton b1 = new JButton("0");
        buttons[0] = b1;
        JButton b2 = new JButton("1");
        buttons[1] = b2;
        JButton b3 = new JButton("2");
        buttons[2] = b3;
        JButton b4 = new JButton("3");
        buttons[3] = b4;
        JButton b5 = new JButton("4");
        buttons[4] = b5;
        JButton b6 = new JButton("5");
        buttons[5] = b6;
        JButton b7 = new JButton("6");
        buttons[6] = b7;
        JButton b8 = new JButton("7");
        buttons[7] = b8;
        JButton b9 = new JButton("8");
        buttons[8] = b9;
        JButton b10 = new JButton("9");
        buttons[9] = b10;
        JButton b11 = new JButton("A");
        buttons[10] = b11;
        JButton b12 = new JButton("B");
        buttons[11] = b12;
        JButton b13 = new JButton("C");
        buttons[12] = b13;
        JButton b14 = new JButton("D");
        buttons[13] = b14;
        JButton b15 = new JButton("E");
        buttons[14] = b15;
        JButton b16 = new JButton("F");
        buttons[15] = b16;
        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        for (JButton button : buttons) {
            button.setFocusPainted(false);
            //buttons ActionListener
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + "" + button.getText());
                }
            });
            panel.add(button);
        }
        add(panel, BorderLayout.CENTER);
        /*END : Buttons*/

        /*START : RadioButtons*/
        JRadioButton Bin = new JRadioButton("Bin");
        Bin.addActionListener(this);
        Bin.setFocusPainted(false);

        JRadioButton Dec = new JRadioButton("Dec");
        Dec.addActionListener(this);
        Dec.setFocusPainted(false);

        JRadioButton Hex = new JRadioButton("Hex");
        Hex.addActionListener(this);
        Hex.setFocusPainted(false);

        JRadioButton Oct = new JRadioButton("Oct");
        Oct.addActionListener(this);
        Oct.setFocusPainted(false);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(Bin);
        group.add(Dec);
        group.add(Hex);
        group.add(Oct);
        /*END : RadioButtons*/

        /*START : ClearButton*/
        JButton Clear = new JButton("C");
        Clear.setFont(font);
        Clear.setFocusPainted(false);
        Clear.setForeground(Color.red);
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        /*END : ClearButton*/

        /*START : RadioButtons & ClearButton Panel*/
        JPanel jPanel = new JPanel(new GridLayout(5, 1));
        jPanel.add(Bin);
        jPanel.add(Dec);
        jPanel.add(Hex);
        jPanel.add(Oct);
        jPanel.add(Clear);
        add(jPanel, BorderLayout.EAST);
        /*END : RadioButtons & ClearButton Panel*/

        setTitle("Conversion Calculator");
        Dimension d = new Dimension(301, 250);
        setSize(d);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Bin":
                setDefault(buttons);
                for (int i = 2; i < buttons.length; i++) {
                    buttons[i].setEnabled(false);
                }
                textField.setText(Integer.toBinaryString(toDecimal(textField.getText())));             
                type=2;
                break;
            case "Hex":
                setDefault(buttons);
                textField.setText(Integer.toHexString(toDecimal(textField.getText())));
                type=16;
                break;
            case "Dec":
                setDefault(buttons);
                for (int i = 10; i < buttons.length; i++) {
                    buttons[i].setEnabled(false);
                }
                textField.setText(toDecimal(textField.getText()).toString());
                type=10;
                break;
            case "Oct":
                setDefault(buttons);
                for (int i = 8; i < buttons.length; i++) {
                    buttons[i].setEnabled(false);
                }
                textField.setText(Integer.toOctalString(toDecimal(textField.getText())));
                type=8;
                break;               
            default:
                break;
        }
    }

    public void setDefault(JButton buttons[]) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(true);
        }
    }
    public Integer toDecimal(String text){
        if(type != 0 && !"".equals(textField.getText())){           
        System.out.println(Integer.parseInt(textField.getText(), type));
        return Integer.parseInt(textField.getText(), type);
        }else{
            return 0;
        }
    }
}
