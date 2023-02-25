package elementos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<Pokemon> mascotas = new ArrayList();
    static ArrayList<personaje> player = new ArrayList();
    static Scanner entrada = new Scanner (System.in);
    static int i_p = 1;
    
    public static void main(String [] args) throws Exception{
       juegoPokemon();
    }
    
    public static void llenarPokemon(){
        
        mascotas.add(new tipoAgua("Megapuño","Megapatada","Rayo burbuja","Squirtle",i_p));
        i_p++;
        mascotas.add(new tipoAgua("Golpe cabeza","Chorro de agua","Danza de lluvia","Wooper",i_p));
        i_p++;
        mascotas.add(new tipoTierra("Demolición","Replesaria","Tumba rocas","Cubone",i_p));
        i_p++;
        mascotas.add(new tipoTierra("Cara susto","Filo del abismo","Fisura", "Groudon",i_p));
        i_p++;
        mascotas.add(new tipoElectrico("Camadería","Látigo","Impactrueno","Pikachu",i_p));
        i_p++;
        mascotas.add(new tipoElectrico("Doble patada", "Látigo", "Impactrueno", "Joltcon",i_p));
    }
    
    public static void mostrarPokemon(int n){
        switch(n){
            case 1: 
                for(Pokemon t: mascotas){
                    if("Agua".equals(t.tipo))
                        System.out.println(t.toString());
                }
                break;
            case 2: 
                for(Pokemon t: mascotas){
                    if("Tierra".equals(t.tipo))
                        System.out.println(t.toString());
                }
                break;
            case 3: 
                for(Pokemon t: mascotas){
                    if("Electrico".equals(t.tipo))
                        System.out.println(t.toString());
                }
                break;
            default: 
                System.out.println("Opción inválida");
        }
    }
    
    public static void crearPersonaje() throws InputMismatchException{
        int op_t=0, op_p, i=0;
        String op, nombre=null;
        do{   
            System.out.println("\nPersonaje " + (i+1));
            System.out.print("¿Como te llamas?: ");
            nombre = entrada.nextLine();
            do{
                    do{
                        System.out.print("\n¿Que tipo de pokémon quieres escoger? : "
                                + "\n\t1.- Tipo Agua\n\t2.- Tipo Tierra\n\t3.- Tipo Electrico\n-> ");
                    try{
                        op_t = entrada.nextInt();
                    }catch(InputMismatchException ex){
                        System.out.println("Opción inválida");
                        op_t = 0;
                    }
                    if(op_t>3)
                        op_t=0;
                   entrada.nextLine();
                }while(op_t == 0);
                mostrarPokemon(op_t);
                System.out.print("\n¿Desea ver los otros pokémon? (SI/NO): ");
                op = entrada.nextLine();
                op = op.toLowerCase();
            }while(op_t>3 || "si".equals(op));
            do{
                System.out.print("¿Qué Pokémon deseas escojer? (Escribe su identificador): ");
                try{
                    op_p = entrada.nextInt();
                }catch(InputMismatchException ex){
                    System.out.println("Valor introducido rechazado");
                    op_p = 0;
                }
                if(op_p>i_p){
                    System.out.println("Opción inválida");
                    op_p = 0;
                }   
                entrada.nextLine();
            }while(op_p == 0);
            player.add(new personaje(nombre, mascotas.get(op_p-1),new mochila((int) (Math.random()*1+3))));
            i++;
        }while(i<2);
    }
    
    public static void atacarPokemon(int turno_a, int turno_b) throws InputMismatchException{
        int mov;
        do{
            System.out.print("\n¿Que ataque quieres usar?: \n-> ");
            try{
                mov=entrada.nextInt();
            }catch(InputMismatchException ex){
                System.out.println("Valor intrucido rechazado");
                mov = 0;
            }
            
            entrada.nextLine();
        }while(mov == 0);
        String tipo = player.get(turno_b).getPokemon().getTipo();
        int dano = player.get(turno_a).getPokemon().getDano(mov,tipo);
        int ps_b = player.get(turno_b).getPokemon().getPs();
        int ps_d = ps_b - dano;
        System.out.println("\nDaño infligido: " + dano);
        player.get(turno_b).getPokemon().setPs(ps_d);
    }
    
    public static boolean usarMochila(int turno){
        String op;
        boolean cura;
        System.out.print("\n¿Desea usar cura?: (SI/NO)\n-> ");
        op = entrada.nextLine();
        op = op.toLowerCase();
        int ps_a = player.get(turno).getPokemon().getPs();
        int r_ps = player.get(turno).getContenido().curar(ps_a);        
        if("si".equals(op)){
            player.get(turno).getPokemon().setPs(r_ps);
            cura = true;
        }else{
            cura = false;
        }
        System.out.println("Salud actual: " + player.get(turno).getPokemon().getPs());
        
        return cura;
    }
    
    public static void ganador(int turno){
        if(turno == 0)
            turno++;
        else 
            turno--;
        
        System.out.println("\n\n\t\t¡¡¡Gana: " + player.get(turno).getN_personaje()+"!!!");
    }
    
    public static void juegoPokemon() throws InputMismatchException{
        llenarPokemon();
        crearPersonaje();
        int turno = 0, op;
        
        do{
            System.out.println("\n\nTurno de: " + player.get(turno).getN_personaje());
            System.out.println("Pokemon: " + player.get(turno).getPokemon().getNombre());
            System.out.println("Salud: " + player.get(turno).getPokemon().getPs());
            do{
                System.out.print("\n¿Que quieres hacer?: \n\t1.- Atacar\n\t2.- Mochila\n-> ");
                try{
                   op = entrada.nextInt();
                }catch(InputMismatchException ex){
                   System.out.println("Valor introducido rechazado");
                   op = 0;
               }
                switch(op){
                   case 1: 
                           System.out.println(player.get(turno).getPokemon().getAtaques());
                       break;
                   case 2: 
                           System.out.println(player.get(turno).getContenido().toString());
                    break; 
                default:
                           if(op!=0)
                                System.out.println("Opción inválida");
                }
                entrada.nextLine();
            }while(op == 0 || op > 2);
            
            if(op == 1){
                if(turno == 0){
                    atacarPokemon(turno, (turno+1));
                    turno++;
                }
                else if(turno == 1){
                    atacarPokemon(turno, (turno-1));
                    turno--;
                }
            } else if (op == 2){
                boolean aux = usarMochila(turno);
                if(aux == true){
                    if(turno == 0)
                        turno++;
                    else if(turno == 1)
                        turno--;
                }  
            }  
        }while(player.get(turno).getPokemon().getPs()>0);
        
        ganador(turno);
    }
}
