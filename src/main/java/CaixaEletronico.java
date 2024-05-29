public class CaixaEletronico {
    private Banco banco;

    public CaixaEletronico(Banco banco) {
        this.banco = banco;
    }

    public double getSaldo(String tipoConta) {
        if(tipoConta.equals("corrente")) {
            return this.banco.getSaldoContaCorrente();
        }else if(tipoConta.equals("poupança")) {
            return this.banco.getSaldoContaPoupanca();
        }else {
            throw new IllegalArgumentException("Tipo de conta desconhecido: " + tipoConta);
        }
    }
}
