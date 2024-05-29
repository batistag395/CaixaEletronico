import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BancoTest {

    @Test
    public void getSaldoContaCorrenteShouldReturnSaldoContaCorrenteValue() {
        Banco banco = new Banco(10.0, 20.0);
        double saldo = banco.getSaldoContaCorrente();
        Assertions.assertEquals(10.0, saldo);
    }
    @Test
    public void getSaldoContaPoupancaShouldReturnSaldoContaPoupancaValue() {
        Banco banco = new Banco(10.0, 20.0);
        double saldo = banco.getSaldoContaPoupanca();
        Assertions.assertEquals(20.0, saldo);
    }
}
