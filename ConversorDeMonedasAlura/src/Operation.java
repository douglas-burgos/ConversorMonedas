public class Operation {
    private Double coin;
    private Double currency;

    public Double oper() {
        return this.coin * this.currency;
    }

    public Double getCoin() {
        return this.coin;
    }

    public void setCoin(Double coin) {
        this.coin = coin;
    }

    public void setCurrency(Double currency) {
        this.currency = currency;
    }
}
