package main.raidcalculator.models;
public abstract class Explosives {
    public String Name;
    public int Damage;
    public int SulfurCost;
    public int CharcoalCost;

    public Explosives(String Name, int Damage, int SulfurCost, int CharcoalCost){
        this.Name = Name;
        this.Damage = Damage;
        this.SulfurCost = SulfurCost;
        this.CharcoalCost = CharcoalCost;
    }
}

