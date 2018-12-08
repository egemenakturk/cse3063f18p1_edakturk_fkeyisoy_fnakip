package squares;

import tools.Player;

public abstract class Square {

    private String name;

    public Square(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void action(Player player);
}
