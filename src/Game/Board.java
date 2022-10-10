package Game;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class Board{
    JFrame board = new JFrame("Chess 2d");
    JPanel[][] squares = new JPanel[8][8]; //squares

    SortedMap <JPanel, JPanel> tilesCollection = new TreeMap<>();
    boolean white = true;
    Container c;
    int xd, yd;

    public Board() {

        this.board.setBounds(400, 150, 850, 870);
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board.setResizable(false);
        c = board.getContentPane();
        for (int y = 0; y < 8; ++y) {
            for (int x = 0; x < 8; ++x) {
                Square sq = new Square();
                squares[x][y] = Square.draw(x, y, white);
                this.c.add(squares[x][y]);
                board.setVisible(true);
                white = !white;
                squares[x][y].addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        xd = (e.getX())/100;
                        yd = (e.getY())/100;
                        System.out.println("hello this shit is hard");
                    }
                });
                squares[x][y].addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        super.mouseDragged(e);
                        xd = (e.getX())/100;
                        yd = (e.getY())/100;
                        for(int xx = 0; xx<8; xx++){
                            for(int yy= 0; yy<8; ++yy){
                              if(xx == xd && yy == yd){
                                 squares[xd][yd].repaint();
                                 board.setVisible(true);
                              }
                            }
                        }

                    }
                });
            }
            white = !white;
        }

        this.board.setVisible(true);
    }

}
