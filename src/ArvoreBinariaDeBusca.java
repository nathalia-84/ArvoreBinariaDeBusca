public class ArvoreBinariaDeBusca {

    private No raiz;
    // Métodos para inserção, remoção, busca e exibição

    public void inserirProduto(Produto produto) {
        raiz = inserirRecursivo(raiz, produto);
    }

    private No inserirRecursivo(No raiz, Produto produto) {
        if(raiz == null) {
            raiz = new No(produto);
            return raiz;
        }
        else if(produto.codigo == raiz.produto.codigo) {
            raiz.produto.quantidade += produto.quantidade;
            return raiz;
        }
        else if(produto.codigo > raiz.produto.codigo) {
            raiz.direito = inserirRecursivo(raiz.direito, produto);
        }
        else {
            raiz.esquerdo = inserirRecursivo(raiz.esquerdo, produto);
        }
        return raiz;
    }

    public void exibirProdutosEmOrdem(){
        exibirProdutosEmOrdemRecursivo(raiz);
    }
    private void exibirProdutosEmOrdemRecursivo(No raiz){
        if (raiz != null) {
            exibirProdutosEmOrdemRecursivo(raiz.esquerdo);
            System.out.print(" " + raiz.produto.toString());
            exibirProdutosEmOrdemRecursivo(raiz.direito);
        }
    }

    public Produto buscarProduto(int codigo) {
        return buscarProdutoRecursivo(raiz, codigo);
    }

    private Produto buscarProdutoRecursivo(No raiz, int codigo) {
        if(raiz == null) {
            return null;
        }
        else if(codigo == raiz.produto.codigo) {
            return raiz.produto;
        }
        else if(codigo > raiz.produto.codigo) {
            return buscarProdutoRecursivo(raiz.direito, codigo);
        }
        else {
            return buscarProdutoRecursivo(raiz.esquerdo, codigo);
        }
    }

    public void removerProduto(int codigo) {  //20
        raiz = removerRecursivo(raiz, codigo);
    }

    private No removerRecursivo(No raiz, int codigo) {
        if(raiz == null) {
            return raiz;
        }
        else if(codigo > raiz.produto.codigo) {
            raiz.direito = removerRecursivo(raiz.direito, codigo);
        }
        else if(codigo < raiz.produto.codigo) {
            raiz.esquerdo = removerRecursivo(raiz.esquerdo, codigo);
        } else { //produto encontrado
            if (raiz.esquerdo == null && raiz.direito == null) {
                raiz = null;
            } else if (raiz.direito != null) {
                raiz.produto = sucessor(raiz);
                raiz.direito = removerRecursivo(raiz.direito, raiz.produto.codigo);
            } else {
                raiz.produto = predecessor(raiz);
                raiz.esquerdo = removerRecursivo(raiz.esquerdo, raiz.produto.codigo);
            }
        }
        return raiz;
    }


    public Produto encontrarMaiorValor(){
        return encontrarMaiorRecursivo(raiz);
    }

    private Produto encontrarMaiorRecursivo(No raiz) {
        if (raiz.direito == null) {
            return raiz.produto;
        } else {
            return encontrarMaiorRecursivo(raiz.direito);
        }

    }

    public Produto encontrarMenorValor(){
        return encontrarMenorRecursivo(raiz);
    }

    private Produto encontrarMenorRecursivo(No raiz) {
        if (raiz.esquerdo == null) {
            return raiz.produto;
        } else {
            return encontrarMenorRecursivo(raiz.esquerdo);
        }

    }


    private Produto sucessor(No raiz) {
        raiz = raiz.direito;
        while(raiz.esquerdo != null) {
            raiz = raiz.esquerdo;
        }
        return raiz.produto;
    }

    private Produto predecessor(No raiz) {
        raiz = raiz.esquerdo;
        while(raiz.direito != null) {
            raiz = raiz.direito;
        }
        return raiz.produto;
    }


}
