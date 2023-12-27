public class Toolstore extends NormalLocation{


    public Toolstore(Player player) {
        super(player, "Store", 2);

    }

    @Override
    boolean onLocation() {
        System.out.println("You enter the old building. The store clerk approaches you.");
        System.out.println("I have armors and weapons for sale.");
        System.out.println("1. Weapons \n2. Armor\n3. Exit Store");
        int selection = Location.input.nextInt();
        while (selection != 1 && selection !=2){
            System.out.println("That is not a valid selection. Please select again.");
            selection = Location.input.nextInt();
        }

        switch (selection){
            case 1:
                weaponMenu();
                buyWeapon();
                break;
            case 2:
                armorMenu();
                break;
            default:
                System.out.println("See you soon.");
                return true;
        }
        return true;
    }

    public void weaponMenu(){
        System.out.println("Weapons me lord:");
        for (Weapons w: Weapons.weapons()) {
            System.out.println(w.getId() + ". < Weapon: " + w.getName() + " Damage: " + w.getDmg() +
                    " Price: " + w.getPrice() + " >");
        }
    }

    public void buyWeapon(){
        System.out.println("What would you like to buy?");
        int storeSelection = input.nextInt();
        while (storeSelection < 1 || storeSelection > Weapons.weapons().length){
            System.out.println("Invalid selection. Please try again: ");
            storeSelection = input.nextInt();
        }
        Weapons selectedWeapon = Weapons.purchaseWeaponById(storeSelection);
        if (selectedWeapon != null){
            if (selectedWeapon.getPrice() > this.getPlayer().getGameClass().getMoney()){
                System.out.println("You cannot afford it sire.");
            } else {
                System.out.println("You have purchased: " + selectedWeapon.getName());
                this.getPlayer().getGameClass().setMoney(this.getPlayer().getGameClass().getMoney() - selectedWeapon.getPrice());
                System.out.println("You now have " + this.getPlayer().getGameClass().getMoney() + " coins left.");
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }


    public void armorMenu(){
        System.out.println("Armors sire:");
    }
}
