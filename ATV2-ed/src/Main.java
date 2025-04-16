import javax.swing.JOptionPane;

public class Main {
    static DoubleList<Cidade> cidades = new DoubleList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu:\n1. Cadastrar cidades\n2. Cadastrar ligações\n3. Listar cidades\n4. Verificar ligação\n5. Ligações por tempo\n0. Sair"));

            switch (opcao) {
                case 1: cadastrarCidade(); break;
                case 2: cadastrarLigacao(); break;
                case 3: listarCidades(); break;
                case 4: verificarLigacao(); break;
                case 5: ligacoesTempoLimite(); break;
                case 0: JOptionPane.showMessageDialog(null, "Finalizando..."); break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida!"); break;
            }
        } while (opcao != 0);
    }

    static void cadastrarCidade() {
        String nome = JOptionPane.showInputDialog("Nome da Cidade:");
        cidades.add(new Cidade(nome));
    }

    static void cadastrarLigacao() {
        String origem = JOptionPane.showInputDialog("Cidade origem:");
        No<Cidade> noCidade = cidades.find(c -> c.nomeCidade.equalsIgnoreCase(origem));
        if (noCidade == null) {
            JOptionPane.showMessageDialog(null, "Cidade não encontrada.");
            return;
        }

        String destino = JOptionPane.showInputDialog("Cidade destino:");
        double distancia = Double.parseDouble(JOptionPane.showInputDialog("Distância (km):"));
        double trafego = Double.parseDouble(JOptionPane.showInputDialog("Fator tráfego (0-2):"));
        int pedagios = Integer.parseInt(JOptionPane.showInputDialog("Número de pedágios:"));

        noCidade.vlr.ligacoesDiretas.add(new LigacaoDireta(destino, distancia, trafego, pedagios));
    }

    static void listarCidades() {
        String resultado = cidades.listar(Cidade::toString);
        JOptionPane.showMessageDialog(null, resultado.isEmpty() ? "Nenhuma cidade cadastrada." : resultado);
    }

    static void verificarLigacao() {
        String origem = JOptionPane.showInputDialog("Cidade origem:");
        String destino = JOptionPane.showInputDialog("Cidade destino:");

        No<Cidade> noCidade = cidades.find(c -> c.nomeCidade.equalsIgnoreCase(origem));

        if (noCidade != null) {
            No<LigacaoDireta> ligacao = noCidade.vlr.ligacoesDiretas.find(l -> l.cidadeDestino.equalsIgnoreCase(destino));
            JOptionPane.showMessageDialog(null, ligacao != null
                ? "Tempo estimado: " + ligacao.vlr.calcularTempo() + " minutos."
                : "Ligação não encontrada.");
        } else {
            JOptionPane.showMessageDialog(null, "Cidade não encontrada.");
        }
    }

    static void ligacoesTempoLimite() {
        double limite = Double.parseDouble(JOptionPane.showInputDialog("Tempo limite (min):"));
        String resultado = "";
        No<Cidade> cidadeAtual = cidades.getCmc();

        while (cidadeAtual != null) {
            No<LigacaoDireta> ligacaoAtual = cidadeAtual.vlr.ligacoesDiretas.getCmc();
            while (ligacaoAtual != null) {
                if (ligacaoAtual.vlr.calcularTempo() <= limite)
                    resultado += cidadeAtual.vlr.nomeCidade + " → " + ligacaoAtual.vlr + "\n";
                ligacaoAtual = ligacaoAtual.prox;
            }
            cidadeAtual = cidadeAtual.prox;
        }

        JOptionPane.showMessageDialog(null, resultado.isEmpty() ? "Nenhuma ligação encontrada." : resultado);
    }
}
