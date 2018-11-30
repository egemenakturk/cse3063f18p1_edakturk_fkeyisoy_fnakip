package Classes;

public class Cash {

    private long amount;

    public Cash(){
    }

    public Cash(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void addCash(long amount){
        this.amount+=amount;
    }
    public void dropCash(long amount){
        this.amount-=amount;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "cash=" + amount +
                '}';
    }
}
