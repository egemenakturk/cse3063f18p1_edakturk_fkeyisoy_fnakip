package Classes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MonopolyGame {
    private final int NUMBER_OF_PIECES=8;
    private final int NUMBER_OF_PLAYERS=getNumberOfPlayers();
    private Die die;
    private Board board;
    private final ArrayList<Player> players = getPlayers();

    public MonopolyGame() {
        board = new Board();
        die= new Die();
    }
    public void start(){
        for (Player player : players){
            player.setSquare(0);
        }
        int iterations=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of iterations:");
        iterations= sc.nextInt();


        for(int i=1;i<=iterations;i++){

            System.out.println("***********ITERATION "+i+"**************");
            for(Player player: players){
                int dieX= die.rollDie();
                int dieY= die.rollDie();
                System.out.print("Player: "+ player.getName() + " | Piece: "+ player.getPiece().getShape()+" | Location: "+ board.getSquare(player.getSquare()).getName()+ " | Rolled dies: "+ dieX+ " and "+ dieY+ " | Die Sum: " +(dieX+dieY) );
                move(dieX+dieY,player);
                System.out.println(" | Moved location: " + board.getSquare(player.getSquare()).getName());
            }
        }


    }

    private ArrayList<Player> getPlayers() {
        Random random= new Random();
        ArrayList<Player> playerNames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String playerName;
        for(int i=0; i<NUMBER_OF_PLAYERS; i++) {
            Player player = new Player();

            int piece=random.nextInt(NUMBER_OF_PIECES);
            while(true){
                System.out.print((i+1) + "- Enter name of the player: ");
                playerName = sc.nextLine();
                player.setName(playerName);
                if(dublicateControl(playerNames,playerName)){
                    break;
                }
                System.out.print("This name is already taken.\n ");

            }
            if(!pieceCheck(playerNames,piece)){
                piece=random.nextInt(NUMBER_OF_PIECES);
            }
            player.setPiece(new Piece(piece));


            System.out.println("Player entered (" + playerName + ") piece: "+ player.getPiece().getShape());
            playerNames.add(player);
        }
        return playerNames;

    }
    private int getNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        int number_of_player=0;

        while (number_of_player<2 || number_of_player>8){
            System.out.print("Please enter the number of players(must be between 2-8):");
            number_of_player=scanner.nextInt();
            System.out.println();
        }
        return number_of_player;
    }
    private boolean dublicateControl(ArrayList<Player> players, String name){
        for(Player player : players)
            if(name.equals(player.getName())) return false;
        return true;
    }
    private boolean pieceCheck(ArrayList<Player> players, int piece){
        for (Player player: players)
            if(piece==player.getPiece().getShape())
                return false;
        return true;
    }
    public void move(int x, Player player){
        player.setSquare(player.getSquare()+x);

    }


}
