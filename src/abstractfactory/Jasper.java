package abstractfactory;

public class Jasper {

    static Vaate[] vaatteet = new Vaate[4];

    private Jasper() {

    }

    public static void pueVaatteet(VaateMerkki merkki) throws Exception {

        // Luodaan oikean tehtaan instanssi
        Class<?> tehdasLuokka = Class.forName("abstractfactory." + merkki + "Tehdas");
        VaateTehdas tehdas = (VaateTehdas) tehdasLuokka.getDeclaredConstructor().newInstance();

        vaatteet[0] = tehdas.tilaaVaate(VaateTyyppi.Lippis);
        vaatteet[1] = tehdas.tilaaVaate(VaateTyyppi.Tpaita);
        vaatteet[2] = tehdas.tilaaVaate(VaateTyyppi.Farmarit);
        vaatteet[3] = tehdas.tilaaVaate(VaateTyyppi.Kengat);
    }

    public static void listaaVaatteet() {
        System.out.println("Jasperilla on päällään: ");
        for (Vaate vaate : vaatteet) {
            System.out.println(vaate);
        }
    }
}
