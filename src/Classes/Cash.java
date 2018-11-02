package Classes;

public class Cash {

    private int cash;


    public Cash(){

    }

    public void setAmount (int newAmount){
        this.cash=newAmount;
    }
     public int getAmount(){
        return cash;
    }

    public void addCash(int cash){
        this.cash+=cash;
    }
    public void dropCash(int cash){
        this.cash-=cash;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "cash=" + cash +
                '}';
    }
}
