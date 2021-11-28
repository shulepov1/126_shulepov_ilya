package task;

public class Alchemist extends BattleUnitBase{
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }
   public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
       int temp = 999999999;
       BattleUnit victim = ownTeam[0];

       for (int i = 0; i < ownTeam.length; i++) {
           if (ownTeam[i].health() < temp && ownTeam[i].health() > 0) {
               temp = ownTeam[i].health();
               victim = ownTeam[i];
           }
       }
       victim.heal(10);

       temp = 0;
       for (int i = 0; i < ownTeam.length; i++) {
           if (ownTeam[i].health() > temp && ownTeam[i].health() > 0) {
               temp = ownTeam[i].health();
               victim = ownTeam[i];
           }
       }
       victim.setStrength(victim.strength() + 1);
    }


    public void attack(BattleUnit other) {
        other.setStrength(other.strength() - 2);
        other.setMaxHealth(other.maxHealth() - 4);
    }
}
