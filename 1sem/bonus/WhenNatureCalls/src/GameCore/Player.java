package GameCore;

import Content.Weapon;

public class Player {
    private int hp;
    public void sethp(int hp) {
        this.hp = hp;
    }
    public int gethp() {
        return hp;
    }

    private Weapon currentWeapon;
    public void setCurrentWeapon(Weapon currentWeapon){
        this.currentWeapon = currentWeapon;
    }
    public Weapon getCurrentWeapon(){
        return currentWeapon;
    }

    private int coin;
    public void setCoin(int coin){
        this.coin = coin;
    }
    public int getCoin(){
        return coin;
    }

}
