package Ex2;

import java.util.List;
import java.util.Scanner;

public class MainEx2
{
    public static void main(String[] args)
    {
     List<Produs> produse=Magazin.citireCSV("C:\\Users\\adigi\\IdeaProjects\\lab3\\src\\Ex2\\produse.csv");
     Scanner scanner=new Scanner(System.in);
     int opt;

        do {
            System.out.println("\n--- Meniu Magazin ---");
            System.out.println("1. Afiseaza toate produsele");
            System.out.println("2. Afiseaza produsele expirate");
            System.out.println("3. Vinde un produs");
            System.out.println("4. Afiseaza produsul cu pretul minim");
            System.out.println("5. Salveaza produse sub cantitate minima");
            System.out.println("0. Iesire");
            System.out.print("Alege o optiune: ");
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    Magazin.afisareProd(produse);
                    break;
                case 2:
                    Magazin.afisareExpirate(produse);
                    break;
                case 3:
                    System.out.print("Introdu numele produsului: ");
                    String numeProdus = scanner.nextLine();
                    System.out.print("Cantitatea de vandut: ");
                    int cantitate = scanner.nextInt();
                    Magazin.vanzare(produse, numeProdus, cantitate);
                    System.out.println("Incasari totale: " + Magazin.getIncasari());
                    break;
                case 4:
                    Magazin.afisareMinim(produse);
                    break;
                case 5:
                    System.out.print("Introdu cantitatea minima: ");
                    int cantitateMinima = scanner.nextInt();
                    Magazin.afisareSub(produse, cantitateMinima, "C:\\Users\\adigi\\IdeaProjects\\lab3\\src\\Ex2\\produse_filtrate.csv");
                    break;
                case 0:
                    System.out.println("Iesire..");
                    break;
                default:
                    System.out.println("Optiune invalida! Incearca din nou.");
            }
        } while (opt != 0);

        scanner.close();


    }
}
