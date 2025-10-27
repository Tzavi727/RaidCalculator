package main.raidcalculator.models;

public class Door extends StructuresHP {

    private Door(String Name, int HP) {
        super(Name, HP);
    }
    public static final Door WOODEN_DOOR = new Door("Wooden Door", 200);
    public static final Door SHEET_METAL = new Door("Sheet Metal Door", 250);
    public static final Door ARMORED_DOOR = new Door("Armored Door",1000);
}
