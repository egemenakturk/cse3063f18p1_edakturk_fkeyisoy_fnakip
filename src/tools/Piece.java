package tools;

public class Piece {
    private int shape;
    private String name;

    public Piece(int shape, String name) {
        this.shape = shape;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShape(){
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }
}

