package main.raidcalculator;
import java.util.Scanner;

import main.raidcalculator.models.C4;
import main.raidcalculator.models.DoorsHP;
import main.raidcalculator.models.Explosives;
import main.raidcalculator.models.Rocket;
import main.raidcalculator.models.Satchel;
import main.raidcalculator.models.services.Calc;

public class RustRaidCalculator {
    static Scanner scanner = new Scanner(System.in);

    public enum Options {
        DORAID,
        DORAIDITEM,
        LEAVE
    }

    public enum DoRaidOptions {
        SATCHEL,
        ROCKET,
        C4,
        LEAVE
    }

    public static void main(String[] args) throws Exception {
        boolean leave = true;
        while (leave) {
            cleanscreen();
            System.out.println("============================================================");
            System.out.println("This program helps you know how much material you need to do a raid in Rust");
            System.out.println("choose below what you want to do:");
            System.out.println("============================================================");
            System.out.println(
                    "1-Calculate how much explosive needed to raid each door type\n2-Calculate materials needed to craft each raid item\n3-Shutdown program");
            System.out.println("============================================================");

            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                Options[] AllOptions = Options.values();

                if (choice >= 1 && choice <= AllOptions.length) {
                    Options choicedone = AllOptions[choice - 1];
                    switch (choicedone) {
                        case DORAID:
                            DORAIDCALC();
                            cleanscreen();
                            break;
                        case DORAIDITEM:
                            raiditemcost();
                            cleanscreen();
                            break;
                        case LEAVE:
                            leave = false;
                            cleanscreen();
                            break;
                    }
                } else {
                    invalidchoice();
                }
            } catch (NumberFormatException e) {
                if (invalidchoice()) {

                }
            }
        }
        scanner.close();
    }

    public static void cleanscreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void DORAIDCALC() {
        DoorsHP choosendoor = null;
        String doorchoiceStr;
        while (true) {
            cleanscreen();
            System.out.println("============================================================");
            System.out.println("Which type of door do you want to raid ?");
            System.out.println("============================================================");
            System.out.println("1-Armored Door\n2-Metal Door\n3-Wooden Door\n4-Voltar");
            System.out.println("============================================================");
            doorchoiceStr = scanner.nextLine();
            int doorchoiceInt = Integer.parseInt(doorchoiceStr);
            if (doorchoiceInt >= 1 && doorchoiceInt <= 4) {
                switch (doorchoiceInt) {
                    case 1:
                        choosendoor = DoorsHP.ArmoredDoor;
                        break;
                    case 2:
                        choosendoor = DoorsHP.SheetMetalDoor;
                        break;
                    case 3:
                        choosendoor = DoorsHP.WoodenDoor;
                        break;
                    default:
                        return;
                }
                break;
            } else {
                invalidchoice();
            }
        }
        CalcDoorDmg(choosendoor);
    }

    public static void CalcDoorDmg(DoorsHP ChoosenDoor) {
        while (true) {
            try {
                cleanscreen();
                System.out.println("============================================================");
                System.out.printf("Calculating for the door: %s (%d HP)%n", ChoosenDoor.Name, ChoosenDoor.HP);
                System.out.println("============================================================");

                System.out.println("How many doors this type you want to raid?");
                System.out.println("============================================================");
                String AmountofDoorsStr = scanner.nextLine();
                int AmountofDoorsInt = Integer.parseInt(AmountofDoorsStr);

                if (AmountofDoorsInt == 0)
                    return;
                if (AmountofDoorsInt < 0)
                    throw new NumberFormatException();

                cleanscreen();
                System.out.println("============================================================");
                System.out.println("Which type of explosive do you want to use:");
                System.out.println("============================================================");
                System.out.println("1-Satchels\n2-Rocket\n3-C4\n4-Voltar");
                System.out.println("============================================================");
                String choice = scanner.nextLine();
                int RaidItemChoice = Integer.parseInt(choice);
                cleanscreen();

                DoRaidOptions[] AllDoRaidOptions = DoRaidOptions.values();
                if (RaidItemChoice >= 1 && RaidItemChoice < AllDoRaidOptions.length) {
                    DoRaidOptions ChoiceMadeRaid = AllDoRaidOptions[RaidItemChoice - 1];

                    Explosives ChosenExplo = null;

                    switch (ChoiceMadeRaid) {
                        case SATCHEL:
                            ChosenExplo = new Satchel();
                            break;
                        case ROCKET:
                            ChosenExplo = new Rocket();
                            ;
                            break;
                        case C4:
                            ChosenExplo = new C4();
                            ;
                            break;
                        default:
                            return;
                    }
                    int TotalHP = ChoosenDoor.HP * AmountofDoorsInt;
                    int RaidCost = (int) Math.ceil((double) TotalHP / ChosenExplo.Damage);
                    System.out.println("======================== RESULT =========================");
                    System.out.printf("To destroy %d '%s'(s), You are going to need:%n", AmountofDoorsInt,
                            ChoosenDoor.Name);
                    System.out.printf("%d Units of '%s'.%n", RaidCost, ChosenExplo.Name);
                    System.out.println("============================================================");
                    int charcoalcost = ChosenExplo.CharcoalCost * RaidCost;
                    int sulfurcost = ChosenExplo.SulfurCost * RaidCost;
                    System.out.printf("Sulfur and Charcoal needed below: %nSulfur: %d%nCharcoal: %d%n", sulfurcost,
                            charcoalcost);
                    System.out.println("============================================================");
                    scanner.nextLine();
                    return;
                } else {
                    if (invalidchoice())
                        return;
                    else
                        continue;
                }
            } catch (NumberFormatException e) {
                if (invalidchoice())
                    return;
                else
                    continue;
            }

        }
    }

    public static void raiditemcost() {
        while (true) {
            try {
                cleanscreen();
                System.out.println("============================================================");
                System.out.println("Choose the item you want to craft:");
                System.out.println("============================================================");
                System.out.println("1-Satchel\n2-C4\n3-Rockets\n4-Voltar");
                System.out.println("============================================================");
                String ItemInputStr = scanner.nextLine();
                int ItemInputInt = Integer.parseInt(ItemInputStr);
                if (ItemInputInt == 4) {
                    return;
                }
                if (ItemInputInt < 1 || ItemInputInt > 3) {
                    throw new NumberFormatException();
                }
                DoRaidOptions[] AllOptions = DoRaidOptions.values();
                Explosives ChoosenItem = null;
                if (ItemInputInt >= 1 && ItemInputInt <= AllOptions.length) {
                    switch (ItemInputInt) {
                        case 1: ChoosenItem = new Satchel(); break;
                        case 2: ChoosenItem = new C4(); break;
                        case 3: ChoosenItem = new Rocket(); break;
                        default: return;
                    }
                }
                cleanscreen();
                System.out.println("============================================================");
                System.out.println("Now type the amount that you want to craft:");
                System.out.println("============================================================");
                String AmountInputStr = scanner.nextLine();
                int AmountInputInt = Integer.parseInt(AmountInputStr);

                if (AmountInputInt <= 0) {
                    throw new NumberFormatException();
                }
                CalculateRaidCost(ChoosenItem, AmountInputInt);
                return;
            } catch (NullPointerException e) {
                if (invalidchoice()) {
                    return;
                }
            }
        }
    }

    public static boolean invalidchoice() {
        cleanscreen();
        System.out.println("============================================================");
        System.out.println(
                "Invalid choice or quantity!\nPress ENTER to try again.\nOr type 1 to return to the menu:");
        System.out.println("============================================================");
        String leave = scanner.nextLine();
        if (leave.equals("1")) {
            cleanscreen();
            return true;
        }
        cleanscreen();
        return false;
    }

    public static void CalculateRaidCost(Explosives item, int Amount) {
        cleanscreen();
        Calc mycalc = new Calc();

        int SulfurPerUnit = item.SulfurCost;
        int CharcoalPerUnit = item.CharcoalCost;

        int Totalcharcoal = mycalc.multiply(CharcoalPerUnit, Amount);
        int TotalSulfur = mycalc.multiply(SulfurPerUnit, Amount);

        System.out.println("============================================================");
        System.out.printf(
                "To craft %s %d are needed:\n============================================================\n%d-Sulfur\n%d-Charcoal%n",
                item.Name,
                Amount,
                TotalSulfur,
                Totalcharcoal);
        System.out.println("============================================================");
        System.out.println("Press ENTER to return to the menu:");
        System.out.println("============================================================");
        scanner.nextLine();
    }

}