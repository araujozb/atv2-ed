import java.util.function.Predicate;
import java.util.function.Function;

public class DoubleList<T> {


    private No<T> cmc;
    private No<T> fim;

    public DoubleList(){
        cmc = fim = null;
    }

    public void add(T vlr){
        No<T> novo = new No<>(vlr);
        if (cmc == null) {
        cmc = fim = novo;
        } else {
            fim.prox = novo;
            novo.ant = fim;
            fim = novo;
        }
    }
    public No<T> find(Predicate<T> condicao){
        No<T> atual = cmc;
        while (atual != null) {
            if (condicao.test(atual.vlr)) {
                return atual;
            }
            atual = atual.prox;
        }
        return null;
    }

    public String listar(Function<T, String> formt) {
        String answer = "";
        No<T> aux = cmc;
        while (aux != null){
            answer += formt.apply(aux.vlr) + "\n";
            aux = aux.prox;
        }
        return answer;
    }

    public No<T> getCmc(){
        return cmc;
    }
}
