package Classes;

public class Board {
    public final int SIZE = 40;
    public final Square[] squares = getSquares();

    public Board() {
    }

    private Square[] getSquares() {
        Square[] squares = new Square[SIZE];
        for (int i = 0; i < SIZE; i++) {
            if (i == 0)
                squares[i] = new Square("Start");
            else if (i == 2 || i == 17 || i == 33)
                squares[i] = new Square("Chest");
            else if (i == 7 || i == 22 || i == 36)
                squares[i] = new Square("Chance");
            else if (i == 5 || i == 15 || i == 25 || i == 35)
                squares[i] = new Square("Station");
            else if (i == 12 || i == 28)
                squares[i] = new Square("Public Corporation");
            else if (i == 4)
                squares[i] = new Square("IncomeTaxSquare");
            else if (i == 10)
                squares[i] = new Square("JailSquare");
            else if (i == 20)
                squares[i] = new Square("FreeParkingSquare");
            else if (i == 30)
                squares[i] = new Square("GoToJailSquare");
            else if (i == 38)
                squares[i] = new Square("LuxuryTaxSquare");
            else
                squares[i] = new Square("Lot");
        }
        return squares;
    }
    public Square getSquare(int index) {
        return squares[index%SIZE];
    }
}
