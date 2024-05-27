import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema so = new Sistema();
        Transacao t = new Transacao();
        Scanner sc = new Scanner(System.in);
        ContaFisica cf = null;

        while (true) {
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            int opcaoMenuPrincipal = menuPrincipal.exibirMenuPrincipal(sc);

            switch (opcaoMenuPrincipal) {
                case 1:
                    cf = so.cadastrarContaFisica();
                    break;
                case 2:
                    cf = so.fazerLogin();
                    break;
                case 0:
                    System.out.println("Saindo da aplicação...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }

            if (cf != null) {
                boolean continuarNoMenuDaConta = true;
                while (continuarNoMenuDaConta) {
                    MenuConta menuConta = new MenuConta();
                    int opcaoMenuConta = menuConta.exibirMenuConta(sc);

                    switch (opcaoMenuConta) {
                        case 1:
                            System.out.println("Seu saldo atual é: R$" + cf.getSaldo());
                            break;
                        case 2:
                            cf.depositarFisica(t);
                            break;
                        case 3:
                            cf.sacarFisica(t);
                            break;
                        case 4:
                            cf.exibirHistoricoTransacoes();
                            break;
                        case 5:
                            cf.exibirPorCategoria();
                            break;
                        case 6:
                            cf.exibirInformacoes();
                            break;
                        case 7:
                            cf.metaFinanceira();
                            break;
                        case 8:
                            cf.definirMeta();
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            cf = null;
                            continuarNoMenuDaConta = false;
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }

                    if (continuarNoMenuDaConta) {
                        System.out.print("Deseja continuar no menu da conta? (S/N): ");
                        String resposta = sc.nextLine();

                        if (resposta.equalsIgnoreCase("N")) {
                            continuarNoMenuDaConta = false;
                        } else if (!resposta.equalsIgnoreCase("S")) {
                            System.out.println("Resposta inválida! Saindo da aplicação...");
                            return;
                        }
                    }
                }
            }
        }
    }
    static class MenuPrincipal {
        public int exibirMenuPrincipal(Scanner sc) {
            System.out.println("\nMenu Principal:");
            System.out.println("1 - Cadastro de Conta");
            System.out.println("2 - Login");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            return opcao;
        }
    }
    static class MenuConta {
        public int exibirMenuConta(Scanner sc) {
            System.out.println("\nMenu Conta:");
            System.out.println("1 - Visualizar Saldo");
            System.out.println("2 - Realizar Depósito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Visualizar Extrato");
            System.out.println("5 - Relatórios");
            System.out.println("6 - Informacoes Sobre a Conta");
            System.out.println("7 - Vizualizar Meta financeira e poupanca");
            System.out.println("8 - Definir/alterar meta Financeira");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            return opcao;
        }
    }
}
