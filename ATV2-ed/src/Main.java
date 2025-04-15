import javax.swing.JOptionPane;
public class Main {

    static ListaDupla<Cidade> cidades = new ListaDupla<>();

    public static void main(String[] args) {
                int opcao;
                do {
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(
                        "Menu de Opções:\n" +
                        "1. Cadastrar cidades\n" +
                        "2. Cadastrar ligações\n" +
                        "3. Listar cidades e ligações\n" +
                        "4. Verificar ligação direta e tempo\n" +
                        "5. Ligações até um limite de tempo\n" +
                        "0. Sair"));
        
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
                cidades.adicionar(new Cidade(nome));
            }
        
            static void cadastrarLigacao() {
                String origem = JOptionPane.showInputDialog("Cidade origem:");
                No<Cidade> noCidade = cidades.buscar(c -> c.nome.equalsIgnoreCase(origem));
                if (noCidade == null) {
                    JOptionPane.showMessageDialog(null, "Cidade não encontrada.");
                    return;
                }
        
                String destino = JOptionPane.showInputDialog("Cidade destino:");
                double distancia = Double.parseDouble(JOptionPane.showInputDialog("Distância (km):"));
                double trafego = Double.parseDouble(JOptionPane.showInputDialog("Fator tráfego (0-2):"));
                int pedagios = Integer.parseInt(JOptionPane.showInputDialog("Número de pedágios:"));
        
                noCidade.dado.ligacoesDiretas.adicionar(new LigacaoDireta(destino, distancia, trafego, pedagios));
            }
        
            static void listarCidades() {
                JOptionPane.showMessageDialog(null, cidades.listar(Cidade::toString));
            }
        
            static void verificarLigacao() {
                String origem = JOptionPane.showInputDialog("Cidade origem:");
                String destino = JOptionPane.showInputDialog("Cidade destino:");
                No<Cidade> noCidade = cidades.buscar(c -> c.nome.equalsIgnoreCase(origem));
                if (noCidade != null) {
                    No<LigacaoDireta> ligacao = noCidade.dado.ligacoesDiretas.buscar(l -> l.cidadeDestino.equalsIgnoreCase(destino));
                    if (ligacao != null)
                        JOptionPane.showMessageDialog(null, "Tempo estimado: " + ligacao.dado.calcularTempoEntrega() + " minutos.");
                    else
                        JOptionPane.showMessageDialog(null, "Ligação não encontrada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cidade não encontrada.");
                }
            }
        
            static void ligacoesTempoLimite() {
                double limite = Double.parseDouble(JOptionPane.showInputDialog("Tempo limite (minutos):"));
                StringBuilder resultado = new StringBuilder();
        
                No<Cidade> noCidade = cidades.getInicio();
                while (noCidade != null) {
                    No<LigacaoDireta> lig = noCidade.dado.ligacoesDiretas.getInicio();
                    while (lig != null) {
                        if (lig.dado.calcularTempoEntrega() <= limite) {
                            resultado.append(noCidade.dado.nome).append(" ").append(lig.dado).append("\n");
                        }
                        lig = lig.proximo;
                    }
                    noCidade = noCidade.proximo;
                }
        
                JOptionPane.showMessageDialog(null, resultado.length() > 0 ? resultado.toString() : "Nenhuma ligação encontrada.");
            }
        }
        
        int option;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                "MENU :D \n" 
                + "1 - Adicionar cidade \n"
    }
}
