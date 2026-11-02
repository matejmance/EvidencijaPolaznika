import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        //ArrayList<Polaznik> listaPolaznika = new ArrayList<>();
        //HashSet<Polaznik> listaPolaznika = new HashSet<>();
        //TreeSet<Polaznik> listaPolaznika = new TreeSet<>();

        HashMap<String, Polaznik> listaPolaznika = new HashMap<>();

        Polaznik polaznik1 = new Polaznik("Matej","Mance","1@gmail.com",2020);
        Polaznik polaznik2 = new Polaznik("Robert","Mance","6@gmail.com",2020);
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


        Map<Integer, List<Polaznik>> mapa =
                listaPolaznika.values().stream()
                        .collect(Collectors.groupingBy(Polaznik::getGodinaUpisa));
        System.out.println(mapa);


        System.out.println();
        System.out.println();
        System.out.println();

        Map<Integer,Long> mapa2 =
                listaPolaznika.values().stream()
                        .collect(Collectors.groupingBy(g -> g.getGodinaUpisa(), Collectors.counting()));
        System.out.println(mapa2);


        System.out.println();
        System.out.println();
        System.out.println();

        Optional<Polaznik> najnoviji =
                listaPolaznika.values().stream()
                        .max(Comparator.comparingInt(Polaznik::getGodinaUpisa));
        if(najnoviji.isPresent()){
            System.out.println(najnoviji.get());
        }else{
            System.out.println("Kolekcija je prazna");
        }




































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


}
