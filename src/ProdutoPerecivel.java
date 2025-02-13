import java.text.NumberFormat;
import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {

    private LocalDate dataDeValidade;
    private static double DESCRICAO = 0.25;
    private static int PRAZO_DESCONTO = 7;
    private LocalDate dataHoje = LocalDate.now();

    public ProdutoPerecivel(String desc, double precoCusto) {
        super(desc, precoCusto);
    }

    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate dataDeValidade) {
        super(desc, precoCusto, margemLucro);
        if(dataDeValidade.isBefore(dataHoje))
            throw new IllegalArgumentException("Valor de data de validade abaixo do dia de hoje");
        this.dataDeValidade = dataDeValidade;
    }
    
    @Override
    public double valorDeVenda() {
        if (dataHoje.isAfter(dataDeValidade)) {
            throw new IllegalStateException("Não é possível solicitar o valor de venda de um produto fora da data de validade.");
        }
        double valor = precoCusto * (1 + margemLucro);
        long diasParaVencimento = dataDeValidade.toEpochDay() - dataHoje.toEpochDay();
        if (diasParaVencimento <= PRAZO_DESCONTO) {
            valor *= (1 - DESCRICAO);
        }
        return valor;
    }
    
    @Override
    public String toString(){
        NumberFormat moeda = NumberFormat.getCurrencyInstance();
        return String.format("NOME: %s: %s", DESCRICAO, moeda.format(valorDeVenda()));
    }
}