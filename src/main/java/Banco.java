public class Banco {
    private double saldoContaCorrente;
    private double saldoContaPoupanca;

    public Banco(double saldoContaCorrente, double saldoContaPoupanca) {
        this.saldoContaCorrente = saldoContaCorrente;
        this.saldoContaPoupanca = saldoContaPoupanca;
    }
    public double getSaldoContaCorrente() {
        return this.saldoContaCorrente;
    }

    public double getSaldoContaPoupanca() {
        return this.saldoContaPoupanca;
    }

}
