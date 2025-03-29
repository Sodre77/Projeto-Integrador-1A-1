import java.util.*;

public class Cardapio {
    List<String> normais = new ArrayList<>(); //Lista de pizzas normais
    List<String> especiais = new ArrayList<>(); //Lista de pizzas especiais
    List<String> refrigerantes = new ArrayList<>(); //Lista de bebidas
    List<String> sucos = new ArrayList<>(); //Lista de sucos

    public void addNormal(String novo) {
        this.normais.add(novo);
    }

    public void addEspecial(String novo) {
        this.especiais.add(novo);
    }

    public void addRefrigerante(String novo) {
        this.refrigerantes.add(novo);
    }

    public void addSuco(String novo) {
        this.sucos.add(novo);
    }

}
