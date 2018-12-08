package tools;

import squares.*;

public class Board {
    private final int SIZE = 40;
    private final String[] stations = {"Gebze","Pendik","Sirkeci","Haydarpaşa"};
    private final String[] publicCorporations = {"Electric Company","Water Works"};
    //Lot names
    private final String[] lots={"Kasımpaşa","Dolapdere","Karaköy", "Sultanahmet","Ümraniye","Beşiktaş","Taksim",
            "Beyoğlu","Harbiye","Şişli","Mecidiyeköy","Erenköy","Bostancı","Caddebostan","Nişantaşı","Maçka","Teşvikiye",
            "Etiler","Levent","Bebek","Tarabya","Yeniköy"};
    private final long[] prices={60,60,100,100,120,140,140,160,180,180,200,220,220,240,260,260,280,300,300,320,350,400};
    private final long[] rents={10,10,30,30,40,50,50,55,60,60,65,70,70,75,80,80,85,90,90,100,125,150};
    private final Square[] squares = getSquares();


    public Board() {
    }

    private Square[] getSquares() {
        int stationCounter=0;
        int publicCorpCounter=0;
        int lotCounter=0;
        Square[] squares = new Square[SIZE];
        //defining squares
        for (int i = 0; i < SIZE; i++) {
            if (i == 0)
                squares[i] = new StartSquare("Start");
            else if (i == 2 || i == 17 || i == 33)
                squares[i] = new ChestSquare("Chest");
            else if (i == 7 || i == 22 || i == 36)
                squares[i] = new ChanceSquare("Chance");
            else if (i == 5 || i == 15 || i == 25 || i == 35){
                StationSquare square = new StationSquare(stations[stationCounter++]);
                square.setPrice(200);
                square.setHasOwner(false);
                squares[i] = square;
            }
            else if (i == 12 || i == 28){
                PublicCorporationSquare square = new PublicCorporationSquare(publicCorporations[publicCorpCounter++]);
                square.setPrice(150);
                square.setHasOwner(false);
                squares[i]=square;
            }
            else if (i == 4)
                squares[i] = new IncomeTaxSquare("IncomeTaxSquare");
            else if (i == 10)
                squares[i] = new JailSquare("JailSquare");
            else if (i == 20)
                squares[i] = new FreeParkingSquare("FreeParkingSquare");
            else if (i == 30)
                squares[i] = new GoToJailSquare("GoToJailSquare");
            else if (i == 38)
                squares[i] = new LuxuryTaxSquare("LuxuryTaxSquare");
            else{
                LotSquare square = new LotSquare(lots[lotCounter]);
                square.setRent(rents[lotCounter]);
                square.setPrice(prices[lotCounter++]);
                square.setHasOwner(false);
                squares[i]=square;
            }
        }
        return squares;
    }
    public Square getSquare(int index) {
        return squares[index%SIZE];
    }
}
