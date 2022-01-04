package Weapons;

public class Weapon_Knife extends SuperWeapon {
    /*Нож - дефолтное оружие и задается в начале игры, по какой-то причине при попытке
    передать его игру с конфига неправильно работают панели UI
     */
    public Weapon_Knife() {
        setName("Нож");
        setDamage(5);
    }
}
