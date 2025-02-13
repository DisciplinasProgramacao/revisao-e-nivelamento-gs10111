public class ProdutoNaoPerecivel extends Produto {

    public ProdutoNaoPerecivel(String Descricao, double PreçoCusto, double MargemLucro) {
        super(Descricao, PreçoCusto, MargemLucro);
    }

    public ProdutoNaoPerecivel(String Descricao, double PreçoCusto) {
        super(Descricao, PreçoCusto);
    }

    @Override
    public  double valorDeVenda(){
        return precoCusto * (1+margemLucro);
    }

    

}