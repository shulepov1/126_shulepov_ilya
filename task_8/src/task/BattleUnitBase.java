package task;

public abstract class BattleUnitBase implements BattleUnit{
    private String name;
    private int health, strength, armor, maxHealth, baseStrength, maxArmor;

    public BattleUnitBase(String name, int maxHealth, int baseStrength, int maxArmor){
      this.name = name;
      this.maxHealth = maxHealth;
      health = maxHealth;
      this.baseStrength = baseStrength;
      strength = baseStrength;
      this.maxArmor = maxArmor;
      armor = maxArmor;
    }

    public String name() {
        return name;
    }
    public int health() {
        return health;
    }
    public int maxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int value) {
        if(value < 0) {
            maxHealth = 0;
        }
        else {
            maxHealth = value;
        }
        if (health > maxHealth) {
            health = maxHealth;
        }

    }
    public void heal(int value) {
        if (health <= maxHealth) {
            health += value;
            if (health > maxHealth) {
                health = maxHealth;
            }
        }
        else health = maxHealth;
    }
    public void takeDamage(int value){
        health -= value;
        if (health < 0 ) {
            health = 0;
        }
    }
    public int strength() {
        return strength;
    }
    public void setStrength(int value) {
        strength = value;
    }
    public int baseStrength() {
        return baseStrength;
    }
    public int armor(){
        return armor;
    }
    public void restoreArmor(int value){
//        if (armor <= maxArmor) {
            armor += value;
            if (armor > maxArmor) {
                armor = maxArmor;
            }
//        }
//        else armor = maxArmor;
    }
    public void damageArmor(int value){
        armor -= value;
        if (armor < 0 ) {
            armor = 0;
        }
    }
    public int maxArmor(){
        return maxArmor;
    }
    public void setMaxArmor(int value){
        maxArmor = value;
        if (armor > maxArmor) {
            armor = maxArmor;
        }
    }


   public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);

   public abstract void attack(BattleUnit other);

}
