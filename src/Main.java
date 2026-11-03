import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        ArrayList<Polaznik> listaPolaznika2 = new ArrayList<>();
        ArrayList<Polaznik> listaPolaznika3 = new ArrayList<>();


        File datoteka = new File("data/polaznici.csv");
        Path path = datoteka.toPath();

        File datoteka2 = new File("data/polaznici_export.csv");
        Path path2 = datoteka2.toPath();

        File datoteka3 = new File("data/polaznici_test.csv");
        Path path3 = datoteka3.toPath();



        listaPolaznika2 = citanjeDatoteke(path3);
        System.out.println("Broj uspjesno ucitanih polaznika : "+ listaPolaznika2.size());


    }
    public static ArrayList<Polaznik> citanjeDatoteke(Path path) {
        ArrayList<Polaznik> listaPolaznika2 = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path)) {

            listaPolaznika2 = new ArrayList<>();
            String linija = "";
            int brojac = 0;

            while ((linija = br.readLine()) != null) {
                brojac++;
                if (linija.isBlank()){
                    System.out.println("Linija "+brojac+": Prazan redak");
                    continue;
                }
                String[] array = linija.split(",");
                if(array.length != 4){
                    System.out.println("Linija "+brojac+": Nepotpun CSV redak");
                    continue;
                }

                try {
                    String ime = array[0];
                    String prezime = array[1];
                    String email = array[2];
                    int godina = Integer.parseInt(array[3]);
                    Polaznik polaznik = new Polaznik(ime, prezime, email, godina);
                    listaPolaznika2.add(polaznik);
                } catch (NumberFormatException e) {
                    System.out.println("Linija "+brojac+": Neispravna godina upisa");

                }




            }
        }
        catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return listaPolaznika2;
    }

    public static void spremanjeDatoteke(List<Polaznik> listaPolaznika2 , Path path2) {
        try(BufferedWriter br = Files.newBufferedWriter(path2)){

            for(Polaznik p : listaPolaznika2){
                br.write(p.getIme()+","+p.getPrezime()+","+p.getEmail()+","+p.getGodinaUpisa());
                br.newLine();
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static boolean dodajPolaznika(List<Polaznik> listaPolaznika2 , Polaznik polaznik) {
        String email = polaznik.getEmail();
        for(Polaznik p : listaPolaznika2){
            if(p.getEmail().equals(email)){
                return false;
            }
        }
        listaPolaznika2.add(polaznik);
        return true;
    }

    public static Optional<Polaznik> pronadiPolaznika(List<Polaznik> listaPolaznika2 , String trazeniEmail) {
        Optional<Polaznik> polaznik = Optional.empty();
        for(Polaznik p : listaPolaznika2){

            if(p.getEmail().equals(trazeniEmail)){
                polaznik = Optional.of(p);
                return polaznik;
            }

        }
        return polaznik;
    }


}
