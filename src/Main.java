import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

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
        listaPolaznika.put("1@gmail.com", polaznik2);
        listaPolaznika.put("2@gmail.com", polaznik3);
        listaPolaznika.put("3@gmail.com", polaznik4);
        listaPolaznika.put("4@gmail.com", polaznik5);
        listaPolaznika.put("5@gmail.com", polaznik6);



        ispisMape(listaPolaznika);
        System.out.println();
        System.out.println();

        pretrazivanjePoMailu(listaPolaznika,"3@gmail.com");

        System.out.println();
        System.out.println("Broj polaznika : " + listaPolaznika.size());
        System.out.println();

        listaPolaznika.remove("1@gmail.com");

        System.out.println("Broj polaznika : " + listaPolaznika.size());
    }

    public static void pretrazivanjePoMailu(HashMap<String,Polaznik> listaPolaznika , String email){
        for(Polaznik p : listaPolaznika.values() ){
            if(Objects.equals(p.getEmail(), email)){
                System.out.println(p);
            }
        }
    }

    public static void ispisMape(HashMap<String,Polaznik> listaPolaznika){
        for(Polaznik p : listaPolaznika.values() ){
            System.out.println(p.getIme() + " : " + p.getEmail());
        }
    }


}
