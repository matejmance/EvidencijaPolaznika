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
        ArrayList<Polaznik> listaPolaznika2;


        File datoteka = new File("data/polaznici.csv");
        Path path = datoteka.toPath();

        File datoteka2 = new File("data/polaznici_export.csv");
        Path path2 = datoteka2.toPath();


        listaPolaznika2 = citanjeDatoteke(path);


        Polaznik polaznikNovi = new Polaznik("Antonio","Stjepanovic","7@gmail.com",2024);

        dodajPolaznika(listaPolaznika2,polaznikNovi);

        spremanjeDatoteke(listaPolaznika2,path2);

        System.out.println(listaPolaznika2.size());



        //ZADATAK B :

        citanjeDatoteke(path2);

        System.out.println(listaPolaznika2);


        System.out.println(pronadiPolaznika(listaPolaznika2,"1@gmail.com"));



    }
    public static ArrayList<Polaznik> citanjeDatoteke(Path path) {
        ArrayList<Polaznik> listaPolaznika2;

        try (BufferedReader br = Files.newBufferedReader(path)) {

            listaPolaznika2 = new ArrayList<>();
            String linija = "";

            while ((linija = br.readLine()) != null) {
                String[] array = linija.split(",");
                String ime = array[0];
                String prezime = array[1];
                String email = array[2];
                int godina = Integer.parseInt(array[3]);

                Polaznik polaznik = new Polaznik(ime, prezime, email, godina);
                listaPolaznika2.add(polaznik);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        boolean result = false ;
        for(Polaznik p : listaPolaznika2){
            if(p.getEmail().equals(email)){
                result = false;
            }
            else{
                result = true;
            }
        }
        if(result){
            listaPolaznika2.add(polaznik);
        }
        else {
            System.out.println("Polaznik s istom email adresom vec postoji!");
        }
        return result;
    }

    public static Optional<Polaznik> pronadiPolaznika(List<Polaznik> listaPolaznika2 , String trazeniEmail) {
        Optional<Polaznik> polaznik = Optional.empty();
        for(Polaznik p : listaPolaznika2){

            if(p.getEmail().equals(trazeniEmail)){
                polaznik = Optional.of(p);
            }

        }
        return polaznik;
    }


}
