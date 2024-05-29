import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CaixaEletronicoTest {
    @Spy
    private Banco bancoSpied = new Banco(10.0, 20.0);

    private CaixaEletronico caixaEletronicoToSpy;

    @Mock
    private Banco banco;

    private CaixaEletronico caixaEletronico;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        caixaEletronico = new CaixaEletronico(banco);
        caixaEletronicoToSpy = new CaixaEletronico(bancoSpied);
    }
    @Test
    public void getSaldoShouldReturnCorrectValueIfTipoContaToBeEqualCorrente() {
        Mockito.when(banco.getSaldoContaCorrente()).thenReturn(10.0);
        double saldo = caixaEletronico.getSaldo("corrente");
        Assertions.assertEquals(10.0, saldo);
    }
    @Test
    public void getSaldoShouldReturnCorrectValueIfTipoContaToBeEqualPoupanca() {
        Mockito.when(banco.getSaldoContaPoupanca()).thenReturn(10.0);
        double saldo = caixaEletronico.getSaldo("poupança");
        Assertions.assertEquals(10.0, saldo);
    }
    @Test
    public void getSaldoShouldReturnAnExceptionIfTipoContaIsNotEqualCorrenteOrPoupanca() {
        IllegalArgumentException invalido = Assertions.assertThrows(IllegalArgumentException.class, () -> caixaEletronico.getSaldo("inválido"));
        Assertions.assertEquals("Tipo de conta desconhecido: inválido", invalido.getMessage());
    }
    @Test
    public void getSaldoShouldReturnCorrectValueIfTipoContaToBeEqualCorrenteUsingSpy() {
        Mockito.doReturn(10.0).when(bancoSpied).getSaldoContaCorrente();
        double saldo = caixaEletronicoToSpy.getSaldo("corrente");
        Assertions.assertEquals(10.0, saldo);
    }
    @Test
    public void getSaldoShouldReturnCorrectValueIfTipoContaToBeEqualPoupancaUsingSpy(){
        Mockito.when(bancoSpied.getSaldoContaPoupanca()).thenReturn(10.0);
        double saldo = caixaEletronicoToSpy.getSaldo("poupança");
        Assertions.assertEquals(10.0, saldo);
    }
}
