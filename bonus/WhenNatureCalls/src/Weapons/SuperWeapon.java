package Weapons;

import java.io.*;

public class SuperWeapon {
    public void setWeapon(String str) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(".//config//weapons.txt"));
    int dmg;
    while (!br.readLine().equals(str)){
            br.readLine();
    }
    dmg = Integer.parseInt(br.readLine());
    setName(str);
    setDamage(dmg);
    br.close();
    }

    private String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    private int damage;
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDamage(){
        return damage;
    }
}
