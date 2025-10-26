public class ExplosiveValues {
    public String Name;
    public int Damage;
    public int SulfurCost;
    public int CharcoalCost;

    public ExplosiveValues(String Name, int Damage, int SulfurCost, int CharcoalCost){
        this.Name = Name;
        this.Damage = Damage;
        this.SulfurCost = SulfurCost;
        this.CharcoalCost = CharcoalCost;
    }
    public static final ExplosiveValues satchel = new ExplosiveValues("Satchel",170,480,720);
    public static final ExplosiveValues C4 = new ExplosiveValues("C4", 250, 2200, 3000);
    public static final ExplosiveValues rocket = new ExplosiveValues("Rocket", 247, 1400, 1950);
}

