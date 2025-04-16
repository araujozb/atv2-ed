public class Cidade {
    
    String nomeCidade;
    DoubleList<LigacaoDireta> ligacoesDiretas;
    double distancia;
    
    public Cidade(String nome, double distancia) {
        this.nomeCidade = nome;
        this.distancia = distancia;
        ligacoesDiretas = new DoubleList<>();

    }

    @Override
    public String toString(){
        String ligacoes = ligacoesDiretas.listar(LigacaoDireta::toString);
        
        return "Cidade: " + nomeCidade + (ligacoes.isEmpty()? "\n Sem ligacoes diretas" : "\n Ligacoes diretas: " + ligacoes);

    }
}
