package Game;

import Game.Pieces.Pawn;


import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.util.*;

public class Square implements MouseInputListener {
    static int h = 100;
    static int w = 100;
    static int xPos, yPos;
    static String[] letters= {"A","B","C","D","E","F","G","H"};
    static String[] intLetters= {"8","7","6","5","4","3","2","1"};
    static Image [] Pieces = new Image[12];
     static ImageIcon i = new ImageIcon(Objects.requireNonNull(Square.class.getResource("pawn.png")));
    static ImageIcon i1 = new ImageIcon(Objects.requireNonNull(Square.class.getResource("blackPawn.png")));
     static Image img = i.getImage().getScaledInstance(50, 80, Image.SCALE_SMOOTH);
    static Image img1 = i1.getImage().getScaledInstance(50, 80, Image.SCALE_SMOOTH);
    static Pawn p, p1;
    static SortedMap<Integer, Integer> coordinatesW = new TreeMap<>();
    static SortedMap<Integer, Integer> coordinatesB = new TreeMap<>();
    static SortedMap<String, SortedMap<Integer, Integer>> pawnPosW = new TreeMap<>();
    static SortedMap<String, SortedMap<Integer, Integer>> pawnPosB = new TreeMap<>();
     static String pName = "Pawn";
    static String nameW;
    static String  nameB;
    static boolean hasPiece;
    public Square(){
        System.out.println("Square class is called");

    }

    public static JPanel draw(int x, int y, boolean isWhite) {
        return new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                if (isWhite) g2d.setColor(Color.white.darker());
                else g2d.setColor(Color.darkGray.darker());
                g2d.fillRect(x * 100, y * 100, w, h);
                g2d.setColor(Color.orange.darker());
                g2d.setFont(g2d.getFont().deriveFont(20f));
                if(y == 7  && x< 8){
                    g2d.drawString(letters[x],(x*100)+40, 800+20);
                }
                if(x==7){
                    g2d.drawString(intLetters[y],800+10, (y*100)+50);
                }
                if(y==1 && x<8){
//                  black pawns
                    nameW =  pName.concat(String.valueOf(x+1) + "black");
                    p1 = new Pawn(String.valueOf(x), x, y, img1);
                    try { g.drawImage(img1, x*100+20, y*100+10, this);}
                    catch(Exception e){ System.out.println("Draw Image has failed bitch:  ");}
                    coordinatesB.put(x,y);
                    pawnPosB.put(nameW,coordinatesB);
                }
                if(y==6 && x< 8){
                    nameB =  pName.concat(String.valueOf(x+1) + "white");
                    p1 = new Pawn(String.valueOf(x+8), x, y, img);
                    try { g.drawImage(img, x*100+20, y*100+10, this);}
                    catch(Exception e){ System.out.println("Draw Image has failed bitch:  ");}
                    coordinatesW.put(x,y);
                    pawnPosW.put(nameB,coordinatesW);
                }

                System.out.println("White pawns:    " + pawnPosW.values());
                System.out.println("Black pawns:    " + pawnPosB.values());


                Pieces[0] = img;
                Pieces[1] = img1;
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        int x1 = (e.getX())/100;
                        int y1 = (e.getY())/100;
                        System.out.println("yes: bitch: " + x1 + y1);
//                      on press if there is a piece or an abject
                        for(SortedMap<Integer, Integer> st: pawnPosW.values()) {
                            for(int keys: st.keySet()) {
                                for (int i2 = 0; i2 < 8; i2++){
                                    if(st.get(i2) == y1 && keys == x1){
                                        hasPiece = true;
                                        System.out.println("Hooray this shit matches " + keys);
                                    }else if(st.get(i2) != y1 && keys != x1){hasPiece = false;}

                                }
                            }
                            }

                        }});
                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        super.mouseDragged(e);
                        int xP = (e.getX())/100;
                        int yP = (e.getY())/100;
                            for(SortedMap<Integer, Integer> st: pawnPosW.values()) {
                                for(int keys: st.keySet()) {
                                    for (int i = 0; i < 8; i++){
                                        if(st.get(i) == y && keys == x){
                                            System.out.println("Hooray this shit matches " + keys);
                                            st.get(i);
                                            repaint();
                                            System.out.println("new values  " + st.get(i) + "  " + keys);
                                        }

//                                        point to remember
//                                        the pawn class will draw the Image
//                                        depending of the codition we will add the image to the Jpanel

                                    }
                                }
                            }
                        repaint();
                    }
                });
            }

    };
};

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
