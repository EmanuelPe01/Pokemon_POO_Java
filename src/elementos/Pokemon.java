package elementos;

public abstract class Pokemon {
    //Atributos  
    protected String nombre;
    protected String tipo;
    protected int ps; 
    private int id;
    
    //Métodos
    public Pokemon(String nombre, String tipo, int id) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ps =20;
        this.id = id;
    } 

    public abstract int getDano(int mov, String tipo);
    public abstract String getAtaques();

    @Override
    public String toString() {
        return "\nID: "+id+"\nNombre: " + nombre + "\nTipo: " + tipo + "\nPuntos de salud: " + ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }
    
    public int getPs() {
        return ps;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
    
}
