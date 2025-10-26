package main.raidcalculator.models;
public class DoorsHP {
public String Name;
public int HP;

public DoorsHP(String Name, int HP){
    this.Name = Name;
    this.HP = HP;
}
public static DoorsHP WoodenDoor = new DoorsHP("Wooden Door",200);
public static DoorsHP SheetMetalDoor = new DoorsHP("Sheet Metal Door", 250);
public static DoorsHP ArmoredDoor = new DoorsHP("Armored Door", 1000);
}
