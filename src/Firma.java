class Firma {
    private String nazwa;
    private String adres;
    private String nip;

    public Firma(String nazwa, String adres, String nip) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.nip = nip;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public String getNip() {
        return nip;
    }
}

