public class Main {
    public static void main(String[] args) {
        ArvoreBinariaDeBusca estoque = new ArvoreBinariaDeBusca();
        estoque.inserirProduto(new Produto(200, "TV", 15));
        estoque.inserirProduto(new Produto(10, "Notebook", 5));
        estoque.inserirProduto(new Produto(20, "Mouse", 10));
        estoque.inserirProduto(new Produto(50, "Teclado", 2));
        estoque.inserirProduto(new Produto(50, "Teclado", 3));
        estoque.inserirProduto(new Produto(1, "Monitor", 5));
        estoque.inserirProduto(new Produto(700, "Cabo USB", 2));


        Produto p = estoque.buscarProduto(50);
        if (p == null) {
            System.out.println("Produto não encontrado");
        } else {
            System.out.println("Produto encontrado: " + p.getNome() + ", Quantidade: " + p.getQuantidade());
        }

        System.out.println("Lista de Produtos:");
        estoque.exibirProdutosEmOrdem();
        int codigo = 20;
        System.out.println("Removendo produto de código " + codigo);
        estoque.removerProduto(codigo);
        System.out.println("Lista de Produtos:");
        estoque.exibirProdutosEmOrdem();
        System.out.println("Prduto com maior código: " + estoque.encontrarMaiorValor().getNome() + ", Quantidade: " + p.getQuantidade());
        System.out.println("Produto com menor código: " + estoque.encontrarMenorValor().getNome() + ", Quantidade: " + p.getQuantidade());


    }
}
