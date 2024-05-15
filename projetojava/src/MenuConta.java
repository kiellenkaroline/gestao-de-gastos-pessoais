import java.util.Scanner;

class MenuConta {

    public int exibirMenuConta(Scanner sc) {
        System.out.println("\nMenu Conta:");
        System.out.println("1 - Visualizar Saldo");
        System.out.println("2 - Realizar Depósito");
        System.out.println("3 - Realizar Saque");
        System.out.println("4 - Visualizar Extrato");
        System.out.println("5 - Relatórios");
        System.out.println("0 - Sair");
        System.out.print("Digite a opção desejada: ");

        int opcao = sc.nextInt();
        sc.nextLine();

        return opcao;
    }
}