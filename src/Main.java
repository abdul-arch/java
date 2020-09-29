
package morpion;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;h
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cadre extends JPanel  implements  MouseListener {

    private static final long serialVersionUID = 7173552915505185444L;
    public Color couleur=Color.WHITE;

    public Cadre(int x,int y){

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(this);
        this.x=x;this.y=y;
    }

    public int x,y;


    public static short lesCases[][]={{-1,-2,-3},{-4,-5,-6},{-7,-8,-9}};
    public static short nbr=0;
    public static boolean fini=false;
    public static boolean gagne=false;
    public static short croixOuRond=0;


    public boolean gagne(){
        return ((lesCases[0][0]==lesCases[0][1])&&(lesCases[0][0]==lesCases[0][2]))
                ||((lesCases[1][0]==lesCases[1][1])&&(lesCases[1][0]==lesCases[1][2]))
                ||((lesCases[2][0]==lesCases[2][1])&&(lesCases[2][0]==lesCases[2][2]))
                ||((lesCases[0][0]==lesCases[1][0])&&(lesCases[0][0]==lesCases[2][0]))
                ||((lesCases[0][1]==lesCases[1][1])&&(lesCases[0][1]==lesCases[2][1]))
                ||((lesCases[0][2]==lesCases[1][2])&&(lesCases[0][2]==lesCases[2][2]))
                ||((lesCases[0][0]==lesCases[1][1])&&(lesCases[0][0]==lesCases[2][2]))
                ||((lesCases[0][2]==lesCases[1][1])&&(lesCases[0][2]==lesCases[2][0]));
    }
    public void changeCase(){
        lesCases[x][y]=croixOuRond;
        nbr++;
        if (croixOuRond==0){
            couleur=Color.RED;
            croixOuRond=1;
        }
        else{
            couleur=Color.GREEN;
            croixOuRond=0;
        }
        repaint();
    }

    public void mouseClicked(MouseEvent e) {
        if (!fini){
            if ((lesCases[x][y]>0)||(lesCases[x][y]==croixOuRond)){
                changeCase();
                if (gagne()){
                    System.out.println("gagné");
                    gagne=true;
                    fini=true;
                }
                else if (nbr==9){
                    fini=true;
                    gagne=false;
                }
            }
            System.out.println("clic"+croixOuRond+" "+couleur);
        }
    }
    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void paintComponent(Graphics g){
        Rectangle r=g.getClipBounds();
        g.setColor(couleur);
        g.fillRect(0,0,r.width,r.height);
        g.drawString("HelloWord",10,10);
    }

}



    }
}
