package Monsters;

import java.io.*;

public class SuperMonster {
    public void setMonster(String str) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".//config//monsters.txt"));
        int dmg;
        int attack;
        String msg1;
        String msg2;
        String msg3;
        while (!br.readLine().equals(str)){
            br.readLine();
        }
        dmg = Integer.parseInt(br.readLine());
        attack = Integer.parseInt(br.readLine());
        msg1 = br.readLine();
        msg2 = br.readLine();
        msg3 = br.readLine();
        setName(str);
        sethp(dmg);
        setAttack(attack);
        setAttackMessage1(msg1);
        setAttackMessage2(msg2);
        setAttackMessage3(msg3);
    }

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    private int hp;
    public void sethp(int hp) {
        this.hp = hp;
    }
    public int gethp() {
        return hp;
    }

    private int attack;
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getAttack() {
        return attack;
    }

    private String attackMessage1;
    public void setAttackMessage1(String attackMessage1) {
        this.attackMessage1 = attackMessage1;
    }
    public String getAttackMessage1() {
        return attackMessage1;
    }

    private String attackMessage2;
    public void setAttackMessage2(String attackMessage2) {
        this.attackMessage2 = attackMessage2;
    }
    public String getAttackMessage2() {
        return attackMessage2;
    }

    private String attackMessage3;
    public void setAttackMessage3(String attackMessage3) {
        this.attackMessage3 = attackMessage3;
    }
    public String getAttackMessage3() {
        return attackMessage3;
    }

}
