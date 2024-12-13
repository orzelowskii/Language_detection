//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String folderPath = "/Users/jakuborzelowski/Desktop/TPO/MPP3/src/trening";
        NeuronNetwork neuronNetwork = new NeuronNetwork(folderPath);
        neuronNetwork.train();
        System.out.println("Wybierz czy chcesz podac plik czy tekst");
        System.out.println("plik - 1");
        System.out.println("tekst - 2");
        System.out.println("Koniec - 3");
        System.out.print("Wybieram: ");
        Scanner scanner1 = new Scanner(System.in);
        int wybor = scanner1.nextInt();

        while(wybor != 3) {
            switch (wybor) {
                case 1:
                    System.out.print("Podaj sciezke do pliku: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String sciezka = scanner2.next();
                    neuronNetwork.classify(sciezka);
                    System.out.println("Wybierz czy chcesz podac plik czy tekst");
                    System.out.println("plik - 1");
                    System.out.println("tekst - 2");
                    System.out.println("Koniec - 3");
                    System.out.print("Wybieram: ");
                    wybor = scanner1.nextInt();
                    break;
                case 2:
                    System.out.print("Podaj tekst: ");
                    Scanner scanner3 = new Scanner(System.in);
                    String tekst = scanner3.next();
                    neuronNetwork.classifyText(tekst);
                    System.out.println("Wybierz czy chcesz podac plik czy tekst");
                    System.out.println("plik - 1");
                    System.out.println("tekst - 2");
                    System.out.println("Koniec - 3");
                    System.out.print("Wybieram: ");
                    wybor = scanner1.nextInt();
                case 3:
            }
        }

    }
}
