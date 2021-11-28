package task;

public class ArmorDestroyer extends BattleUnitBase{

    public ArmorDestroyer(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }

    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        int temp = 0;
        BattleUnit victim = enemyTeam[0];


        for (int i = 0; i < enemyTeam.length; i++) {
            if (enemyTeam[i].maxArmor() > temp && enemyTeam[i].health() > 0) {
                temp = enemyTeam[i].maxArmor();
                victim = enemyTeam[i];
            }
        }
        if (victim.armor() > 0) {
            if (strength() * 2 > 0)
            victim.damageArmor(strength() * 2);
            else victim.damageArmor(1);
        }
        else {
           if (strength() / 4 > 0)
            victim.takeDamage(strength() / 4);
            else victim.takeDamage(1);
        }
    }


    public void attack(BattleUnit other) {
        if (other.armor() > 0) {
            if (strength() / 4 > 0) {
            other.takeDamage(strength() / 4);
            }
            else other.takeDamage(1);

            if (strength() > 0) {
                other.damageArmor(strength());
            }
            else other.damageArmor(1);
        }
        else {
            if (strength() / 2 > 0)
                other.takeDamage(strength() / 2);
            else other.takeDamage(1);
        }
    }

}
