public class No<T> { // classe p nó da lita dupla
    //<T> diz que o nó pode armazenar qualquer dado

    T vlr;
    No<T> prox, ant;

        //construtor padrão
    public No(T vlr) {
        this.vlr = vlr;
        this.ant = this.prox = null;
    }
}
