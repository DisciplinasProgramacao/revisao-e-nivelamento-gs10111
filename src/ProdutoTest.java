

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;

// public class ProdutoTest {

//     static Produto produto;
        
    
//     @BeforeAll
//     static public void prepare(){
//         produto = new Produto("Produto teste", 100, 0.1);
//     }
    
//     @Test
//     public void calculaPrecoCorretamente(){
//         assertEquals(110.0, produto.valorDeVenda(), 0.01);
//     }

//     @Test
//     public void stringComDescricaoEValor(){
//         String desc = produto.toString();
//         assertTrue(desc.contains("Produto teste") && desc.contains("R$ 110,00"));
//     }

//     @Test
//     public void naoCriaProdutoComPrecoNegativo(){
//         assertThrows(IllegalArgumentException.class, () -> new Produto("teste", -5, 0.5));
//     }
    
//     @Test
//     public void naoCriaProdutoComMargemNegativa(){
//         assertThrows(IllegalArgumentException.class, () -> new Produto("teste", 5, -1));
//     }
// }
