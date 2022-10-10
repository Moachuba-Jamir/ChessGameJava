package Game.Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Pawn extends JPanel{
    int pPosx, pPosy;
    static ImageIcon pawn;
    static Image pawnImg;
    static String Name = "Pawn";
    ArrayList<Image> pawns = new ArrayList<>();
    String pieceName;
    public Pawn(String name, int x, int y, Image pawn) {
       pieceName = Name.concat(name);
        this.pPosx = x;
        this.pPosy = y;
        pawns.add(pawn);

    }

}
