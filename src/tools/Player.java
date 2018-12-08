package tools;

import squares.PropertySquare;
import squares.PropertySquare;
import squares.Square;
import squares.StationSquare;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Piece piece;
    private int squareIndex;
    private Cash cash;
    private boolean isBankrupt;
    private boolean isInJail;
    private Board board;
    private List<PropertySquare> properties;
    private List<StationSquare> stations;


    public Player() {
        properties= new ArrayList<>();
        stations = new ArrayList<>();
    }

    public Player(String name, Piece piece, int squareIndex, Cash cash, boolean isBankrupt, boolean isInJail, Board board) {
        properties = new ArrayList<>();
        stations= new ArrayList<>();
        this.name = name;
        this.piece = piece;
        this.squareIndex = squareIndex;
        this.cash = cash;
        this.isBankrupt = isBankrupt;
        this.isInJail = isInJail;
        this.board = board;
    }


    public List<PropertySquare> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertySquare> properties) {
        this.properties = properties;
    }

    public List<StationSquare> getStations() {
        return stations;
    }

    public void setStations(List<StationSquare> stations) {
        this.stations = stations;
    }

    public boolean isInJail() {
        return isInJail;
    }

    public void setInJail(boolean inJail) {
        isInJail = inJail;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
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
