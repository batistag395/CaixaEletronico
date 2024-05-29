import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BancoTest {
    @Mock
    private Banco banco;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void getSaldoContaCorrenteShouldReturnSaldoContaCorrenteValue() {
        Mockito.when(banco.getSaldoContaCorrente()).thenReturn(10.0);
        double saldo = banco.getSaldoContaCorrente();
        Assertions.assertEquals(10.0, saldo);
        Mockito.verify(banco, Mockito.times(1)).getSaldoContaCorrente();
    }
    @Test
    public void getSaldoContaCorrenteShouldReturnSaldoContaPoupancaValue() {
        Mockito.when(banco.getSaldoContaPoupanca()).thenReturn(10.0);
        double saldo = banco.getSaldoContaPoupanca();
        Assertions.assertEquals(10.0, saldo);
        Mockito.verify(banco, Mockito.times(1)).getSaldoContaPoupanca();
    }
}
