import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
class Faktura {
    private Date dataWystawienia;
    private Firma sprzedajacy;
    private Firma kupujacy;
    private List<Produkt> produkty;
    private double podatek;

    public Faktura(Firma sprzedajacy, Firma kupujacy) {
        dataWystawienia = new Date();
        this.sprzedajacy = sprzedajacy;
        this.kupujacy = kupujacy;
        this.produkty = new ArrayList<>();
        this.podatek = 0;
    }

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
    }

    public void ustawPodatek(double podatek) {
        this.podatek = podatek;
    }

    public double obliczSumeNetto() {
        double suma = 0;
        for (Produkt produkt : produkty) {
            suma += produkt.getWartosc();
        }
        return suma;
    }

    public double obliczPodatek() {
        return obliczSumeNetto() * podatek;
    }

    public double obliczSumeBrutto() {
        return obliczSumeNetto() + obliczPodatek();
    }

    public void generujFakture() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println("Faktura");
        System.out.println("Data wystawienia: " + dateFormat.format(dataWystawienia));
        System.out.println("Sprzedawca:");
        System.out.println("Nazwa firmy: " + sprzedajacy.getNazwa());
        System.out.println("Adres: " + sprzedajacy.getAdres());
        System.out.println("NIP: " + sprzedajacy.getNip());
        System.out.println(" ");
        System.out.println("Kupujący:");
        System.out.println("Nazwa firmy: " + kupujacy.getNazwa());
        System.out.println("Adres: " + kupujacy.getAdres());
        System.out.println("NIP: " + kupujacy.getNip());
        System.out.println("Produkty:");

        for (Produkt produkt : produkty) {
            System.out.println("Nazwa: " + produkt.getNazwa());
            System.out.println("Cena: " + produkt.getCena());
            System.out.println("Ilość: " + produkt.getIlosc());
            System.out.println("Wartość: " + decimalFormat.format(produkt.getWartosc()));
            System.out.println(" ");
        }

        System.out.println("Suma netto: " + decimalFormat.format(obliczSumeNetto()));
        System.out.println("Podatek (" + (podatek * 100) + "%): " + decimalFormat.format(obliczPodatek()));
        System.out.println("Suma brutto: " + decimalFormat.format(obliczSumeBrutto()));
    }
}
