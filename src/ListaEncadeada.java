public class ListaEncadeada<T> {
    private No<T> inicio = null;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public int tamanho(){
        return tamanho;
    }

    public  boolean estaVazia(){
        return tamanho == 0;
    }

    public void limpar(){
        inicio = null;
        tamanho = 0;
    }

    public void inserirNoInicio(T elemento){
        No<T> novoNo = new No<>(elemento);
        novoNo.proximo = inicio;
        inicio = novoNo;
        tamanho++;
    }

    public void inserirNoFinal(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (this.inicio == null) {
            this.inicio = novoNo;
        } else {
            No<T> noAtual;
            for(noAtual = this.inicio; noAtual.proximo != null; noAtual = noAtual.proximo) {
            }

            noAtual.proximo = novoNo;
        }
        tamanho++;
    }

    public void inserirNaPosicao(int posicao, T elemento){
        if (posicao < 0 || posicao > tamanho){
            System.out.println("A posição " + posicao + " é inválida!");
        }
        if (posicao == 0){
            inserirNoInicio(elemento);
        }
        else {
            No<T> novoNo = new No<>(elemento);
            No<T> noAtual = inicio;
            for (int i = 0; i < posicao - 1; i++){
                noAtual = noAtual.proximo;
            }
            noAtual.proximo = novoNo;
        }
        tamanho++;
    }

    public T removerDoInicio(){
        if (inicio == null){
            System.out.println("A lista está vazia!");
        }
        T valor = inicio.elemento;
        inicio = inicio.proximo;
        tamanho++;
        return valor;
    }

    public T removerDoFim(){
        if (inicio == null){
            System.out.println("A lista está vazia!");
        }
        if (inicio.proximo == null){
            T valor = inicio.elemento;
            inicio = null;
            tamanho--;
            return valor;
        }
        No<T> noAtual = inicio;
        while (noAtual.proximo.proximo != null){
            noAtual = noAtual.proximo;
        }
        T valor = (T) noAtual.proximo.elemento;
        noAtual.proximo = null;
        tamanho--;
        return valor;
    }

    public T removerDaPosicao(int posicao){
        if (posicao < 0 || posicao >= tamanho){
            System.out.println("A posição " + posicao + " é inválida.");
        }
        if (posicao == 0){
            return removerDoInicio();
        }
        No<T> noAtual = inicio;
        for (int i = 0; i < posicao - 1; i++){
            noAtual = noAtual.proximo;
        }
        T valor = (T) noAtual.proximo.elemento;
        noAtual.proximo = noAtual.proximo.proximo;
        tamanho--;
        return valor;
    }

    public T removerPorValor(T elemento){
        if (inicio == null){
            System.out.println("A lista está vazia.");
        }
        if (inicio.elemento.equals(elemento)){
            return removerDoInicio();
        }
        No<T> noAtual = inicio;
        No<T> noAnterior = null;

        while (noAtual != null && !noAtual.elemento.equals(elemento)){
            noAnterior = noAtual;
            noAtual = noAtual.proximo;
        }
        if (noAtual == null){
            System.out.println("O elemento " + elemento + " não foi encontrado.");
            return null;
        }
        noAnterior.proximo = noAtual.proximo;
        tamanho--;
        return noAtual.elemento;
    }


    public T buscar(int posicao){
        if (posicao >= tamanho || posicao < 0){
            System.out.println("A posição " + posicao + " é inválida.");
        }
        No<T> noAtual = inicio;
        for (int i = 0; i < posicao; i ++){
            noAtual = noAtual.proximo;
        }
        return noAtual.elemento;
    }

    public int buscarPosicao (T elemento){
        No<T> noAtual = inicio;
        for (int i = 0; i < tamanho; i++){
            if (noAtual.elemento.equals(elemento)){
                return i;
            }
            noAtual = noAtual.proximo;
        }
        return -1;
    }

    public void atualizar(int posicao, T novoValor){
        if (posicao < 0 || posicao >= tamanho){
            System.out.println("A posição " + posicao + " é inválida.");
            return;
        }
        No<T> noAtual = inicio;
        for (int i = 0; i < posicao; i++){
            noAtual = noAtual.proximo;
        }
        noAtual.elemento = novoValor;
    }

    public void exibir() {
        if (this.inicio == null) {
            System.out.println("A lista está vazia.");
        } else {
            for(No<T> noAtual = this.inicio; noAtual != null; noAtual = noAtual.proximo) {
                System.out.print(String.valueOf(noAtual.elemento) + " ");
            }

            System.out.println();
        }
    }
}
