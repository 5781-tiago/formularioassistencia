import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String sala = "";
        String equipamento = "";
        String categoria = "";
        String descricao = "";

        System.out.println("=== Pedido de assistência técnica ===");
        System.out.println("Todos os campos são obrigatórios.\n");

        while (true) {

            // Só pede os campos que ainda estão vazios (ou com erro)
            if (sala.isEmpty()) {
                System.out.print("Sala: ");
                sala = teclado.nextLine().trim();
            }

            if (equipamento.isEmpty()) {
                System.out.print("Equipamento: ");
                equipamento = teclado.nextLine().trim();
            }

            if (categoria.isEmpty()) {
                System.out.println("Categoria:");
                System.out.println("  1 - Rede");
                System.out.println("  2 - Projeção");
                System.out.println("  3 - Impressão");
                System.out.println("  4 - Outro");
                System.out.print("Escolha o número: ");
                String opcao = teclado.nextLine().trim();

                if (opcao.equals("1")) {
                    categoria = "Rede";
                } else if (opcao.equals("2")) {
                    categoria = "Projeção";
                } else if (opcao.equals("3")) {
                    categoria = "Impressão";
                } else if (opcao.equals("4")) {
                    categoria = "Outro";
                }
                // qualquer outra coisa: a categoria fica vazia e dá erro
            }

            if (descricao.isEmpty()) {
                System.out.print("Descrição da ocorrência: ");
                descricao = teclado.nextLine().trim();
            }

            // Validação: junta as mensagens de erro de todos os campos
            String erros = "";

            if (sala.isEmpty()) {
                erros = erros + "  [ERRO] Sala: indique a sala.\n";
            }
            if (equipamento.isEmpty()) {
                erros = erros + "  [ERRO] Equipamento: indique o equipamento.\n";
            }
            if (categoria.isEmpty()) {
                erros = erros + "  [ERRO] Categoria: escolha um número entre 1 e 4.\n";
            }
            if (descricao.isEmpty()) {
                erros = erros + "  [ERRO] Descrição: descreva a ocorrência.\n";
            } else if (descricao.length() < 10) {
                erros = erros + "  [ERRO] Descrição: deve ter pelo menos 10 caracteres.\n";
                descricao = ""; // para voltar a pedir
            }

            // Se não há erros, o pedido é aceite e sai do ciclo
            if (erros.isEmpty()) {
                break;
            }

            // Envio incompleto: mostra os campos em falta
            System.out.println("\n*** PEDIDO INCOMPLETO ***");
            System.out.println(erros);
            System.out.println("Corrija os campos assinalados:\n");
        }

        // Envio válido: mostra o resumo
        System.out.println("\n*** PEDIDO ACEITE ***");
        System.out.println("---------------------------------------------");
        System.out.println("Sala:                    " + sala);
        System.out.println("Equipamento:             " + equipamento);
        System.out.println("Categoria:               " + categoria);
        System.out.println("Descrição da ocorrência: " + descricao);
        System.out.println("---------------------------------------------");

        teclado.close();
    }
}
