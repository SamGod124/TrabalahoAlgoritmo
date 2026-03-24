import java.util.Scanner;

public class Main {

    static int comparacoes = 0;
    static int trocas = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vetor = new int[7];

        System.out.println("Digite 7 valores:");

        for (int i = 0; i < 7; i++) {
            vetor[i] = sc.nextInt();
        }

        System.out.println("\nEscolha o método:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Selection Sort");
        System.out.println("3 - Insertion Sort");

        int opcao = sc.nextInt();

        long inicio = System.nanoTime();

        switch (opcao) {
            case 1:
                bubbleSort(vetor);
                break;
            case 2:
                selectionSort(vetor);
                break;
            case 3:
                insertionSort(vetor);
                break;
            default:
                System.out.println("Opção inválida");
        }

        long fim = System.nanoTime();

        System.out.println("\nTempo: " + (fim - inicio) + " ns");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
    }

    // BUBBLE SORT
    public static void bubbleSort(int[] v) {
        int n = v.length;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Passo " + (i + 1) + ":");

            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;

                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    trocas++;
                }
            }
            mostrarVetor(v);
        }
    }

    // SELECTION SORT
    public static void selectionSort(int[] v) {
        int n = v.length;

        for (int i = 0; i < n - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < n; j++) {
                comparacoes++;

                if (v[j] < v[menor]) {
                    menor = j;
                }
            }

            int temp = v[i];
            v[i] = v[menor];
            v[menor] = temp;
            trocas++;

            System.out.println("Passo " + (i + 1) + ":");
            mostrarVetor(v);
        }
    }

    // INSERTION SORT
    public static void insertionSort(int[] v) {
        int n = v.length;

        for (int i = 1; i < n; i++) {
            int chave = v[i];
            int j = i - 1;

            while (j >= 0 && v[j] > chave) {
                comparacoes++;
                v[j + 1] = v[j];
                j--;
                trocas++;
            }

            v[j + 1] = chave;

            System.out.println("Passo " + i + ":");
            mostrarVetor(v);
        }
    }

    // MOSTRAR VETOR
    public static void mostrarVetor(int[] v) {
        for (int num : v) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}