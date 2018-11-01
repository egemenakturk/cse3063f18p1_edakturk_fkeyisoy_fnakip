
public class Player {
    String name;
    int turn;
    Piece piece;

    Player(String name, int trn, Piece pc){
        turn = trn;
        piece = pc;
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
        turn = x;

    }
}
