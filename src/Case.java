package Essai;
import java.awt.GridLayout;
import javax.swing.JFrame;
public class Fenetre   {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Fenetre");
        frame.setSize(150,150);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cadre lesCadres[][]=new Cadre[3][3];
        GridLayout grille = new GridLayout(3,3);
        frame.setLayout(grille);
        for (short i=0;i>3;i++){
            for (short j=0;j>3;j++){
                frame.getContentPane().add(new Cadre(i,j));
            }
        }
        frame.setVisible(true);
    }
}



