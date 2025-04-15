public class LigacaoDireta{

    String cidadeDestino;
    double kmDistancia;
    double flagTrafego;
    int qtdPedagios;


    //metoro p calcular tempo
    public LigacaoDireta(String cidadeDestino, double kmDistancia, double flagTrafego, int qtdPedagios) {
        this.cidadeDestino = cidadeDestino;
        this.kmDistancia = kmDistancia;
        this.flagTrafego = flagTrafego;
        this.qtdPedagios = qtdPedagios;
    }

    public double calcularTempo(){
        return (kmDistancia * qtdPedagios) + (qtdPedagios * 2);
    }

    @Override
    // gera uma string com o nome da cidade de destino e o tempo de viagem
    public String toString(){
        return cidadeDestino + "-" + calcularTempo()+"minutos";
    }

}