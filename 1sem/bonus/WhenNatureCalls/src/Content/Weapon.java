package Content;

import java.io.*;
import java.util.*;

public class Weapon {
    public void setWeapon(String str) throws IOException {
    Scanner sc = new Scanner(new FileReader(".//config//weapons.txt"));
    int dmg;
    while (sc.hasNextLine()){
            String nextToken = sc.nextLine();
            if (nextToken.equals(str)) {
                setName(str);
                dmg = Integer.parseInt(sc.nextLine());
                setDamage(dmg);
            }
    }
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
