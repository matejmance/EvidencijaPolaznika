public class Polaznik {
    private String ime;
    private String prezime;
    private String email;
    private int godinaUpisa;

    public Polaznik(String ime, String prezime, String email, int godinaUpisa) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.godinaUpisa = godinaUpisa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    @Override
    public String toString() {
        return "IME: "+ime+"\nPREZIME: "+prezime+"\nEMAIL: "+email+"\nGODINA UPISA: "+godinaUpisa;
    }
}
