import tools.*;

import java.util.*;

public class MonopolyGame {
    private final int NUMBER_OF_PIECES=8;
    private final String[] pieces={"Car","Baloon", "Wheel", "Shoe", "Apple", "Plane", "Train", "Hat"};
    private int NUMBER_OF_PLAYERS;
    private Die die;
    private Board board;
    private ArrayList<Player> players;

    public MonopolyGame() {
    }
    public void start(){

        NUMBER_OF_PLAYERS = getNumberOfPlayers();
        board = new Board();
        players = getPlayers();
        die= new Die();

        initialRollDice();

        int i=0;
        int bankruptCounter=0;
        while(bankruptCounter!=NUMBER_OF_PLAYERS-1){
            bankruptCounter=0;
            System.out.println("\n***********ITERATION "+(++i)+"**************");
            for(Player player: players){
                if(player.isBankrupt()){
                    bankruptCounter++;
                    System.out.println("\nPlayer"+ (players.indexOf(player)+1)+": "+ player.getName()+ " went bankrupt");
                }
                else{
                    int dieX= die.rollDie();
                    int dieY= die.rollDie();
                    if(player.isInJail()){
                        board.getSquare(player.getSquareIndex()).action(player);
                    }
                    if(!player.isInJail()){
                        System.out.print("\nPlayer"+ (players.indexOf(player)+1)+": "+ player.getName() + " | Piece: "+ player.getPiece().getName()+
                                "\nLocation: "+ board.getSquare(player.getSquareIndex()).getName()+" | Money: "+player.getCash().getAmount() +
                                "\nRolled dice: "+ dieX+ " and "+ dieY+ " | Dice Sum: " +(dieX+dieY) +"\n");
                        move(dieX+dieY,player);
                        System.out.println("Moved location: " + board.getSquare(player.getSquareIndex()).getName());
                        board.getSquare(player.getSquareIndex()).action(player);
                    }
                }
            }
        }

        endOfTheGame();

    }
    public void endOfTheGame(){
        System.out.println();
        for(Player player: players){
            if(player.getProperties().size()>0){
                System.out.println(player.getName()+ " is won the game..");
                System.out.print(player.getName() + "s' properties: ");
                player.getProperties().forEach(propertySquare -> {
                    System.out.print(propertySquare.getName() + ": "+ propertySquare.getPrice()+ " -- ");
                });
                System.out.println();
            }
        }
    }
    public void initialRollDice(){
        boolean sorted=false;
        Map<Player,Integer> playerMap = new HashMap<>();

        for (Player player : players){
            player.setSquareIndex(0);
            int dieX= die.rollDie();
            int dieY= die.rollDie();
            int dieSum = dieX+dieY;
            playerMap.put(player,dieSum);
            System.out.println(player.getName()+" is rolling dice: " +dieX+" and "+dieY+ " Dice sum: "+ dieSum);
        }
        while(!sorted){
            sorted=true;
            int i=0,j=1;
            while(i<NUMBER_OF_PLAYERS && j<NUMBER_OF_PLAYERS){
                if(playerMap.get(players.get(i))<playerMap.get(players.get(j))){
                    Collections.swap(players,i,j);
                    sorted=false;
                }
                i++; j++;
            }
        }
        System.out.println();
        for (Player player: players){
            System.out.println("Player"+(players.indexOf(player)+1)+": "+player.getName());
        }
    }

    public ArrayList<Player> getPlayers() {
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
            while(!pieceCheck(playerNames,piece)){
                piece=random.nextInt(NUMBER_OF_PIECES);
            }
            player.setPiece(new Piece(piece,pieces[piece]));
            player.setCash(new Cash(1500));
            player.setBankrupt(false);
            player.setBoard(board);
            player.setInJail(false);


            System.out.println("Player entered (" + playerName + ") piece: "+ player.getPiece().getName());
            playerNames.add(player);
        }
        return playerNames;

    }
    public int getNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        int number_of_player=0;

        while (number_of_player<2 || number_of_player>8){
            System.out.print("Please enter the number of players(must be between 2-8):");
            number_of_player=scanner.nextInt();
            System.out.println();
        }
        return number_of_player;
    }
    public boolean dublicateControl(ArrayList<Player> players, String name){
        for(Player player : players)
            if(name.equals(player.getName())) return false;
        return true;
    }
    public boolean pieceCheck(ArrayList<Player> players, int piece){
        for (Player player: players)
            if(piece==player.getPiece().getShape())
                return false;
        return true;
    }
    public void move(int x, Player player){
        player.setSquareIndex(player.getSquareIndex()+x);

        if(player.getSquareIndex()>=40){
            System.out.println(player.getName() + " is passing the starting point. Gaining 200 cash...");
            player.getCash().addCash(200);
            player.setSquareIndex(player.getSquareIndex()%40);
        }

    }


}
