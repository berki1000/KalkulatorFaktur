import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj dane sprzedawcy");
        System.out.print("Nazwa firmy: ");
        String sprzedajacyNazwa = scanner.nextLine();
        System.out.print("Adres: ");
        String sprzedajacyAdres = scanner.nextLine();
        System.out.print("NIP: ");
        String sprzedajacyNip = scanner.nextLine();
        Firma sprzedajacy = new Firma(sprzedajacyNazwa, sprzedajacyAdres, sprzedajacyNip);

        System.out.println("Podaj dane kupującego");
        System.out.print("Nazwa firmy: ");
        String kupujacyNazwa = scanner.nextLine();
        System.out.print("Adres: ");
        String kupujacyAdres = scanner.nextLine();
        System.out.print("NIP: ");
        String kupujacyNip = scanner.nextLine();
        Firma kupujacy = new Firma(kupujacyNazwa, kupujacyAdres, kupujacyNip);

        Faktura faktura = new Faktura(sprzedajacy, kupujacy);

        System.out.print("Czy chcesz dodać produkty do faktury? (Tak/Nie): ");
        String wybor = scanner.nextLine();

        while (wybor.equalsIgnoreCase("Tak")) {
            System.out.print("Podaj nazwę produktu: ");
            String nazwaProduktu = scanner.nextLine();

            double cenaProduktu = 0;
            boolean cenaPoprawna = false;
            while (!cenaPoprawna) {
                System.out.print("Podaj cenę produktu: ");
                try {
                    cenaProduktu = Double.parseDouble(scanner.nextLine());
                    cenaPoprawna = true;
                } catch (NumberFormatException e) {
                    System.out.println("Błędny format ceny. Wprowadź liczbę.");
                }
            }

            int iloscProduktu = 0;
            boolean iloscPoprawna = false;
            while (!iloscPoprawna) {
                System.out.print("Podaj ilość produktu: ");
                try {
                    iloscProduktu = Integer.parseInt(scanner.nextLine());
                    iloscPoprawna = true;
                } catch (NumberFormatException e) {
                    System.out.println("Błędny format ilości. Wprowadź liczbę całkowitą.");
                }
            }

            Produkt produkt = new Produkt(nazwaProduktu, cenaProduktu, iloscProduktu);
            faktura.dodajProdukt(produkt);

            System.out.print("Czy chcesz dodać kolejny produkt? (Tak/Nie): ");
            wybor = scanner.nextLine();
        }

        double podatek = 0;
        boolean podatekPoprawny = false;
        while (!podatekPoprawny) {
            System.out.print("Podaj wartość podatku (w formacie np. 0.23 dla 23%): ");
            try {
                podatek = Double.parseDouble(scanner.nextLine());
                podatekPoprawny = true;
            } catch (NumberFormatException e) {
                System.out.println("Błędny format podatku. Wprowadź liczbę.");
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String zaokraglonyPodatek = decimalFormat.format(podatek);


        faktura.ustawPodatek(podatek);

        faktura.generujFakture();
    }
}