/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Soldier
public class Knight extends Soldier{
    private String[] weapons = {"sword", "spear"};
    private String currentWeapon;
    private boolean mounting;

    //Metodos constructores
    public Knight(String n, int lL, int ack, int def, int t, int ta){
        super(n, lL, ack, def, t, ta);
        this.mounting = true;
        this.currentWeapon = this.weapons[1];
        setImage("src/knight_");
    }
    public Knight(String n, int lL, int ack, int def, int t, char c, int r){
        super(n, lL, ack, def, t, c, r);
        this.mounting = true;
        this.currentWeapon = this.weapons[1];
        setImage("src/knight_");
    }
    
    //Metodos de instancia
    public String getCurrentWeapon(){
        return this.currentWeapon;
    }
    public boolean isMounting(){
        return this.mounting;
    }
    public void disassemble(){
        if (this.mounting) {
            this.mounting = false;
            this.defend();
            this.currentWeapon = this.weapons[0];
        }
    }
    public void mount(){
        if (!this.mounting) {
            this.mounting = true;
            this.currentWeapon = this.weapons[1];
            this.charge();
        }
    }
    public void charge(){
        if (this.mounting) {
            for (int i = 0; i < 3; i++)
                this.attack();
        } else {
            for (int i = 0; i < 2; i++)
                this.attack();
        }
    }

    //Obtiene los datos del caballero como una cadena de string
    public String dataFile() {
        return super.dataFile()+"\t Arma Actual: "+this.currentWeapon+"\t Montado: "+this.mounting;
    }

    //Metodo toString
    public String toString(){
        return super.toString()+"\n\nArma Actual: "+this.currentWeapon+"\nMontado: "+this.mounting;
    }
}
