public class App {

    public static void main(String[] args) {
        EstadoCivil EstCiv = EstadoCivil.SOLTEIRO;
        System.out.println(EstCiv);
    }
}

enum EstadoCivil {
    SOLTEIRO, CASADO, SEPARADO, DIVORCIADO, VIUVO;
}