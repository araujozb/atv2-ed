public class Cidade {
    String nomeCidade;
    double distancia; // Agora você pode armazenar a distância diretamente aqui.
    DoubleList<LigacaoDireta> ligacoesDiretas;

    public Cidade(String nome, double distancia) {
        this.nomeCidade = nome;
        this.distancia = distancia;
        ligacoesDiretas = new DoubleList<>();
    }

    @Override
    public String toString() {
        String ligacoes = ligacoesDiretas.listar(LigacaoDireta::toString);
        return nomeCidade + " (" + distancia + " km)" + (ligacoes.isEmpty() ? " - Sem ligações" : "\n" + ligacoes);
    }
}
