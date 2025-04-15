public class Cidade {
    
    String nomeCidade;
    DoubleList<LigacaoDireta> ligacoesDiretas;
    
    public Cidade(String nome) {
        this.nomeCidade = nome;
        ligacoesDiretas = new DoubleList<>();
    }

    @Override
    public String toString(){
        String ligacoes = ligacoesDiretas.listar(LigacaoDireta::toString);
        
        return "Cidade: " + nomeCidade + (ligacoes.isEmpty()? "\n Sem ligacoes diretas" : "\n Ligacoes diretas: " + ligacoes);

    }
}
