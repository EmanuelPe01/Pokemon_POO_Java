package elementos;

import java.util.Random;

public class tipoElectrico extends Pokemon{
    //Atributos
    private String n_ataque1;
    private String n_ataque2;
    private String n_ataqueE;
    private String debilidad;
    private Random dano = new Random();
    
    //Metodos

    public tipoElectrico(String n_ataque1, String n_ataque2, String n_ataqueE, String nombre, int id) {
        super(nombre, "Electrico", id);
        this.n_ataque1 = n_ataque1;
        this.n_ataque2 = n_ataque2;
        this.n_ataqueE = n_ataqueE;
        this.debilidad = "Tierra";
    }
    
 
    @Override 
    public int getDano(int mov, String tipo){
        int aux = 0;
        switch(mov){
            case 1:
            case 2: aux = dano.nextInt(6)+3;
                break;
            case 3: 
                    if("Agua".equals(tipo))
                        aux = dano.nextInt(12)+8;
                    else 
                        aux = dano.nextInt(8)+5;
                break;
            default:
                System.out.println("No existe ese movimiento");
        }
        return aux;    
    }
    
    @Override
    public String toString() {
        return super.toString()+"\nAtaque 1:" + n_ataque1 + "\tAtaque 2: " + n_ataque2 + 
                "\nAtaque especial (3): " + n_ataqueE + "\nDebilidad: " + debilidad+"\n";
    }
    
    
    @Override
    public String getAtaques(){
        return "\nAtaque 1: " + n_ataque1 + "\tAtaque 2: " + n_ataque2 + 
                "\nAtaque especial (3): " + n_ataqueE + "\n";
    }
}
