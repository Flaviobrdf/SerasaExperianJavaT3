import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Cachorro Snoop = new Cachorro(null, null, 80, "cinza", 6, 'm', 60, 20, 's');
        Snoop.description();

}
}

class Cachorro {
String name;
String race;
Float size;
String color;
int age;
char sex;
double weight;
double peso;
char hasVaccine;

public Cachorro (String name, String race, float size,  String color,
int age, char sex, double weight, double peso, char hasVaccine){
    this.name = name;
    this.race = race;
    this.size = size;
    this.color = color;
    this.age = age;
    this.sex = sex;
    this.weight = weight;
    this.peso = peso;
    this.hasVaccine = hasVaccine;
}

public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}

public char getVaine() {
    return hasVaccine;
}
public void setVacine(char hasVaccine) {
    this.hasVaccine = hasVaccine;
}

public void Latido (){
    List<String> myList = Arrays.asList("Woof-woof", "au, au", "bau, bau", "vogh, vogh", "ruff, ruff", "arf, arf", "yap, yap");
    Random latir = new Random();
    int randomitem = latir.nextInt(myList.size());
    String randomLatir = myList.get(randomitem);
    System.out.println(randomLatir);
}

public void description () {
    System.out.println(
        "Nome do cachorro: " + this.name +
        ", Raça: " + this.race +
        ", Tamanho: " + this.size +
        ", Cor: " + this.color +
        ", Idade: " + this.age +
        ", Sexo: " + this.sex +
        ", Altura: " + this.weight +
        ", Peso: " + this.peso +
        ", Vacinado: " + this.hasVaccine

    );

    double imc = peso / (weight * weight);
        if (imc > 30) {
            System.out.println("Obeso");
        }
        else if (imc >= 25.0 && imc <= 30) {
            System.out.println("Acima do peso");
        }
        else if (imc >= 18.5 && imc <= 25) {
            System.out.println("Peso normal");
        } 
        else {
            System.out.println("Abaixo do peso");
        }

        Latido ();
}
}