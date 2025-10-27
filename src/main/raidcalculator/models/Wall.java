package main.raidcalculator.models;

public class Wall extends StructuresHP {
    private Wall(String Name, int HP){
        super(Name, HP);
    }
public static final Wall WOODEN_WALL = new Wall("Wooden Wall", 250);
public static final Wall STONE_WALL = new Wall("Stone Wall", 500);
public static final Wall METAL_WALL = new Wall("Metal Wall", 1000);
public static final Wall ARMORED_WALL = new Wall("Armored Wall", 2000);
}
