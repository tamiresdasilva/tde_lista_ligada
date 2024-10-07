//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada();

        //Inserções
        lista.inserirNoInicio(1);
        lista.inserirNaPosicao(1, 55);
        lista.inserirNoFinal(10);
        lista.inserirNoInicio(13);
        System.out.println("Lista após inserções: ");
        lista.exibir();

        //Atualização
        lista.atualizar(1, 3);
        System.out.println("Lista após atualizar a segunda posição com um novo valor: ");
        lista.exibir();

        //Buscas
        int v = lista.buscar(1);
        System.out.println("O elemento encontrado na posição '1' é: " + v + ".");
        int p = lista.buscarPosicao(10);
        System.out.println("Elemento '10' encontrado na posição " + p + ".");

        //Remoções
        lista.removerDoInicio();
        System.out.println("Lista após remover o primeiro elemento: ");
        lista.exibir();
        lista.removerDaPosicao(1);
        System.out.println("Lista após remover o segundo elemento: ");
        lista.exibir();
        lista.removerDoFim();
        System.out.println("Lista após remover o último elemento: ");
        lista.exibir();
        lista.removerPorValor(3);
        System.out.println("Lista após remover o elemento pelo seu valor: ");
        lista.exibir();
        }
}