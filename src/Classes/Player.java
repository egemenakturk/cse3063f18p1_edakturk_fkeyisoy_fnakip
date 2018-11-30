package Classes;

public class Player {
    private String name;
    private Piece piece;
    private int squareIndex;
    private Cash cash;
    private boolean isBankrupt;


    public Player() {
    }

    public Player(String name, Piece piece, int squareIndex, Cash cash, boolean isBankrupt) {
        this.name = name;
        this.piece = piece;
        this.squareIndex = squareIndex;
        this.cash = cash;
        this.isBankrupt = isBankrupt;
    }

    public int rollDice(Die die){
        return die.rollDie() + die.rollDie();
    }

    public boolean isOutOfMoney(){
        if(cash.getAmount()<=0){
            return true;
        }
        return false;
    }



    public int getSquareIndex() {
        return squareIndex;
    }

    public void setSquareIndex(int squareIndex) {
        this.squareIndex = squareIndex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getName() {
        return name;
    }


    public Piece getPiece() {
        return piece;
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }
}
