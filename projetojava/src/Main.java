import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Transacao t = new Transacao();
        Cadastro cd = new Cadastro();
        Scanner sc = new Scanner(System.in);
        ContaFisica cf = null;

        while (true) {
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            int opcaoMenuPrincipal = menuPrincipal.exibirMenuPrincipal(sc);

            switch (opcaoMenuPrincipal) {
                case 1:
                    cf = cd.cadastrarContaFisica();
                    break;
                case 2:
                    cf = cd.fazerLogin();
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
                            System.out.println("Funcao ainda nao desenvolvida");
                            break;
                        case 5:
                            System.out.println("Funcao ainda nao desenvolvida");
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
}
