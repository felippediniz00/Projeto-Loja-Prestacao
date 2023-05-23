import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //1) Armazene os dados em vetores e exibana tela.
        String cliente[] = {"Ana","Luis","Bia","Ivo","Ana","Luis","Bia","Ana","Bia","Ian"};
        double valorBase[] = {400.00,700.00,200.00,900.00,500.00,800.00,100.00,600.00,300.00,150.00};
        int numPrestacoes[] = {1,2,1,3,2,3,1,3,2,1};

        for (int i = 0; i < valorBase.length; i++) {
            //System.out.println( cliente[i] + "      " + valorBase[i] + "       " + numPrestacoes[i]);
            System.out.printf("%6s %10.2f %6d \n", cliente[i], valorBase[i], numPrestacoes[i]);
            // Usei o printf para mostrar uma tabela mais organizada.
        }

        //2) Calcule o valor médio das vendas à vista, em 2 e em 3 prestações.
        double somaAvista = 0, somaEm2 = 0, somaEm3 = 0;
        double mediaA, media2, media3;
        int contA = 0, cont2 = 0, cont3 = 0;

        for (int i = 0; i < numPrestacoes.length; i++) {
            if (numPrestacoes[i] == 1) {
                somaAvista += valorBase[i]; // A atribuição ( += ) é a mesma coisa A = A + B,
                contA++;                    // ao invés de usar duas vezes o A, eu coloco somente +=.
            } else if (numPrestacoes[i] == 2) {
                somaEm2 += valorBase[i];
                cont2++;
            } else {
                somaEm3 += valorBase[i];
                cont3++;
            }
        }

        mediaA = somaAvista/contA;
        media2 = somaEm2/cont2;
        media3 = somaEm3/cont3;
        System.out.println();
        System.out.printf("A média das vendas à vista é: %.2f\n", mediaA);
        System.out.printf("A média das vendas em 2 prestações é: %.2f\n", media2);
        System.out.printf("A média das vendas em 3 prestações é: %.2f\n", media3);

        //3) Calcule a porcentagem de vendas à vista, em 2 e em 3 prestações.
        int totalA = 0, total2 = 0, total3 = 0;
        double porcentA, porcent2, porcent3;

        for (int i = 0; i < numPrestacoes.length; i++) {
            if (numPrestacoes[i] == 1) {
                totalA++;
            } else if (numPrestacoes[i] == 2) {
                total2++;
            } else {
                total3++;
            }
        }
        porcentA = totalA * 100 / numPrestacoes.length;
        porcent2 = total2 * 100 / numPrestacoes.length;
        porcent3 = total3 * 100 / numPrestacoes.length;
        System.out.println();
        System.out.println("A porcentagem de vendas à vista é: " + porcentA);
        System.out.println("A porcentagem de vendas em 2 prestações é: " + porcent2);
        System.out.println("A porcentagem de vendas em 3 prestações é: " + porcent3);

        /*4) Encontre a venda mais cara e exiba o seu valor, o nome do cliente
        e uma mensagem: “Venda à vista” ou “Venda em x prestações”, sendo que x deve valer 2 ou 3, conforme o caso.*/
        double vendaMaisCara = valorBase[0], prestacaoMaisCara = numPrestacoes[0];
        String nomeMaiorVenda = cliente[0];


        for (int i = 0; i < valorBase.length; i++) {
            if (valorBase[i] > vendaMaisCara) {
                vendaMaisCara = valorBase[i];
                nomeMaiorVenda = cliente[i];
                prestacaoMaisCara = numPrestacoes[i];
            }
        }
        System.out.println();
        System.out.println("O valor da venda mais cara é: " + vendaMaisCara);
        System.out.println("O nome do cliente é: " + nomeMaiorVenda);
        if (prestacaoMaisCara == 1) {
            System.out.println("Venda à vista!");
        } else if (prestacaoMaisCara == 2) {
            System.out.println("Venda em 2 prestações!");
        } else {
            System.out.println("Venda em 3 prestações!");
        }

        /*4) Solicite que o usuário digite o nome de um cliente
        e exiba suas compras e, em seguida, o valor total comprado.*/
        String nome = cliente[0];
        double totalComprado = 0;

        System.out.println();
        System.out.print("Digite o nome do cliente: ");
        nome = scan.next();

        for (int i = 0; i < cliente.length; i++) {
            if (nome.equals(cliente[i])) {
                System.out.printf("%.2f\n", valorBase[i]);
                totalComprado += valorBase[i];
            }
        }
        System.out.printf("O Total comprado é de: %.2f reais\n",totalComprado);
    }
}