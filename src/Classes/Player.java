package Classes;

import Classes.Piece;

public class Player {
    private String name;
    private int turn;
    private Piece piece;
    private int square;

    public Player() {
    }

    public Player(String name, int turn, Piece piece, int square) {
        this.name = name;
        this.turn = turn;
        this.piece = piece;
        this.square = square;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    Piece getPiece(){

        return piece;
    }

    String getName(){

        return name;
    }

    int getTurn(){

        return turn;
    }

    void setTurn(int x){
        this.turn = x;
    }
}
