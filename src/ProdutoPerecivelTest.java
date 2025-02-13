import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class ProdutoPerecivelTest {

    @Test
    public void testValorDeVendaNormal() {
        double precoCusto = 100.0;
        double margemLucro = 0.30;
        LocalDate validade = LocalDate.now().plusDays(10);
        ProdutoPerecivel produto = new ProdutoPerecivel("Produto Normal", precoCusto, margemLucro, validade);
        double expected = precoCusto * (1 + margemLucro); 
        double actual = produto.valorDeVenda();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testValorDeVendaWithDiscount() {
        double precoCusto = 100.0;
        double margemLucro = 0.30;
        LocalDate validade = LocalDate.now().plusDays(5);
        ProdutoPerecivel produto = new ProdutoPerecivel("Produto Desconto", precoCusto, margemLucro, validade);
        double basePrice = precoCusto * (1 + margemLucro); 
        double expected = basePrice * (1 - 0.25); 
        double actual = produto.valorDeVenda();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testValorDeVendaExpiredThrowsException() throws Exception {
        double precoCusto = 100.0;
        ProdutoPerecivel produto = new ProdutoPerecivel("Produto Expirado", precoCusto);
        Field validadeField = ProdutoPerecivel.class.getDeclaredField("dataDeValidade");
        validadeField.setAccessible(true);
        validadeField.set(produto, LocalDate.now().minusDays(1));

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            produto.valorDeVenda();
        });
        assertTrue(exception.getMessage().contains("Não é possível solicitar o valor de venda"));
    }
}