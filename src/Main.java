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
        //HashSet<Polaznik> listaPolaznika = new HashSet<>();
        //TreeSet<Polaznik> listaPolaznika = new TreeSet<>();

//        HashMap<String, Polaznik> listaPolaznika = new HashMap<>();
//
//        Polaznik polaznik1 = new Polaznik("Matej","Mance","1@gmail.com",2020);
//        Polaznik polaznik2 = new Polaznik("Robert","Mance","6@gmail.com",2020);
//        Polaznik polaznik3 = new Polaznik("Monika","Lukac","2@gmail.com",2021);
//        Polaznik polaznik4 = new Polaznik("Mladen","Mance","3@gmail.com",2022);
//        Polaznik polaznik5 = new Polaznik("Mirta","Petrovic","4@gmail.com",2021);
//        Polaznik polaznik6 = new Polaznik("Ivan","Kovacic","5@gmail.com",2023);
//
//        listaPolaznika.put("1@gmail.com", polaznik1);
//        listaPolaznika.put("6@gmail.com", polaznik2);
//        listaPolaznika.put("2@gmail.com", polaznik3);
//        listaPolaznika.put("3@gmail.com", polaznik4);
//        listaPolaznika.put("4@gmail.com", polaznik5);
//        listaPolaznika.put("5@gmail.com", polaznik6);

        File datoteka = new File("data/polaznici.csv");
        Path path = datoteka.toPath();
        System.out.println(path);

        File datoteka2 = new File("data/polaznici_export.csv");
        Path path2 = datoteka2.toPath();

        //System.out.println(citanjeDatoteke(path));
        listaPolaznika2 = citanjeDatoteke(path);
        System.out.println(listaPolaznika2);

        System.out.println(listaPolaznika2.size());


        spremanjeDatoteke(listaPolaznika2, path2);

        System.out.println("Citanje iz nove datoteke: ");
        System.out.println();
        System.out.println();
        System.out.println(citanjeDatoteke(path2));
        System.out.println(citanjeDatoteke(path2).size());











    }

    public static void pretrazivanjePoMailu(HashMap<String,Polaznik> listaPolaznika , String email){
        if(listaPolaznika.containsKey(email)){
            System.out.println(listaPolaznika.get(email));
        }
        else {
            System.out.println("Korisnik ne postoji");
        }

    }

    public static void ispisMape(HashMap<String,Polaznik> listaPolaznika){
        for(Polaznik p : listaPolaznika.values() ){
            System.out.println(p.getIme() + " : " + p.getEmail());
        }
    }

    public static long brojPolaznikaPoGodini(HashMap<String,Polaznik> listaPolaznika,int godinaUpisa){
        long brojUpisanih =
                listaPolaznika.values().stream()
                        .filter(g -> g.getGodinaUpisa() == godinaUpisa)
                        .count();
        return brojUpisanih;

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


}
