package elementos;

public class personaje {
    //Atributos 
    private String n_personaje;
    private Pokemon pokemon;
    private mochila contenido;
    
    
    //Metodos   
    public personaje(String n_personaje, Pokemon pokemon, mochila contenido){
        this.n_personaje = n_personaje;
        this.pokemon = pokemon;
        this.contenido = contenido;
    }
    
    public String getN_personaje(){
        return n_personaje;
    }
    
    public Pokemon getPokemon(){
        return pokemon;
    }
    
    public mochila getContenido(){
        return contenido;
    }

    @Override
    public String toString() {
        return "\nNombre del personaje: " + n_personaje + "\n\t\t\tPokemon elegido" + pokemon.toString() + contenido.toString() ;
    }
    
    
}
