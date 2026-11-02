import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //ArrayList<Polaznik> listaPolaznika = new ArrayList<>();
        //HashSet<Polaznik> listaPolaznika = new HashSet<>();
        TreeSet<Polaznik> listaPolaznika = new TreeSet<>();

        Polaznik polaznik1 = new Polaznik("Matej","Mance","1@gmail.com",2020);
        Polaznik polaznik2 = new Polaznik("Robert","Mance","1@gmail.com",2020);
        Polaznik polaznik3 = new Polaznik("Monika","Lukac","2@gmail.com",2021);
        Polaznik polaznik4 = new Polaznik("Mladen","Mance","3@gmail.com",2022);
        Polaznik polaznik5 = new Polaznik("Mirta","Petrovic","4@gmail.com",2021);
        Polaznik polaznik6 = new Polaznik("Ivan","Kovacic","5@gmail.com",2023);

        listaPolaznika.add(polaznik1);
        listaPolaznika.add(polaznik2);
        listaPolaznika.add(polaznik3);
        listaPolaznika.add(polaznik4);
        listaPolaznika.add(polaznik5);
        listaPolaznika.add(polaznik6);


        System.out.println(listaPolaznika);
        System.out.println();
        System.out.println();

        pretrazivanjePoGodiniUpisa(listaPolaznika,2021);

        System.out.println();
        System.out.println("Broj polaznika : " + listaPolaznika.size());
        System.out.println();
    }

    public static void pretrazivanjePoGodiniUpisa(TreeSet<Polaznik> listaPolaznika , int godinaUpisa){
        for(Polaznik p :  listaPolaznika ){
            if(p.getGodinaUpisa() == godinaUpisa){
                System.out.println(p);
            }
        }
    }


}
