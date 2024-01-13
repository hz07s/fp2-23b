public class Lancero extends Soldado{
  private int longLanza;

  public Lancero(){
    
  }

  public Lancero(Mapa map, Ejercito ej) {
    setAttackLevel(5);
    setDefenseLevel(10);
    int life = (int) (Math.random() * (8 - 5 + 1) + 5);
    setLifeLevel(life);
    setActualLife(life);
    setType("A-");
  }

  public void setLongLanza(int longLanza){
    this.longLanza = longLanza;
  }

  public int getLongLanza() {
    return longLanza;
  }

  public void schiltrom(){
    setDefenseLevel(getDefenseLevel() + 1);
  }
}