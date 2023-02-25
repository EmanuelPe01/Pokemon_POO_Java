package elementos;

public class mochila {
    //Atributos
    private int curas;
    //Metodos

    public mochila(int curas) {
        this.curas = curas;
    }
    
    public int curar(int ps){
       if(curas > 0){
           curas--;
            ps += 10;
            if(ps>20)
                ps = 20;
       }else 
            System.out.println("\nSin curas");
       return ps;
    }

    @Override
    public String toString() {
        return "Mochila: " + "\tCuras: " + curas ;
    }
    
    
}
