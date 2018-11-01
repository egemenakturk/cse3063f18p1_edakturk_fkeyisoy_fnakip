
public class Piece {
    int shape;
    Square square;
    int currentIndex;

    Piece(int shp, Square sqr){
        shape = shp;
        square = sqr;
    }

    int getShape(){
        return shape;
    }

    void moveTo(int x){

    }

    Square getSquare(){
        return square;
    }
}

