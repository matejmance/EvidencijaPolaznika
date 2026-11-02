import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;


public class Main {
    public static void main(String[] args) {
        //ArrayList<Polaznik> listaPolaznika = new ArrayList<>();
        //HashSet<Polaznik> listaPolaznika = new HashSet<>();
        //TreeSet<Polaznik> listaPolaznika = new TreeSet<>();

        HashMap<String, Polaznik> listaPolaznika = new HashMap<>();

        Polaznik polaznik1 = new Polaznik("Matej","Mance","1@gmail.com",2020);
        Polaznik polaznik2 = new Polaznik("Robert","Mance","1@gmail.com",2020);
        Polaznik polaznik3 = new Polaznik("Monika","Lukac","2@gmail.com",2021);
        Polaznik polaznik4 = new Polaznik("Mladen","Mance","3@gmail.com",2022);
        Polaznik polaznik5 = new Polaznik("Mirta","Petrovic","4@gmail.com",2021);
        Polaznik polaznik6 = new Polaznik("Ivan","Kovacic","5@gmail.com",2023);

        listaPolaznika.put("1@gmail.com", polaznik1);
        listaPolaznika.put("6@gmail.com", polaznik2);
        listaPolaznika.put("2@gmail.com", polaznik3);
        listaPolaznika.put("3@gmail.com", polaznik4);
        listaPolaznika.put("4@gmail.com", polaznik5);
        listaPolaznika.put("5@gmail.com", polaznik6);


        listaPolaznika.values().stream()
                .filter(godina -> godina.getGodinaUpisa() == 2021)
                .forEach(System.out::println);

        listaPolaznika.values().stream()
                .map(Polaznik::getEmail)
                .forEach(System.out::println);

        listaPolaznika.values().stream()
                .filter(godina -> godina.getGodinaUpisa() == 2020)
                .map(Polaznik::getIme)
                .forEach(System.out::println);















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


}
