import java.util.Scanner;

class MenuPrincipal {

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