public class Toolstore extends NormalLocation{


    public Toolstore(Player player) {
        super(player, "Store", 2);

    }

    @Override
    boolean onLocation() {
        System.out.println("You enter the old building. The store clerk approaches you.");
        System.out.println("I have armors and weapons for sale.");
        boolean showMenu = true;
        while(showMenu){

            System.out.println("1. Weapons \n2. Armor\n3. Exit Store");
            int selection = Location.input.nextInt();
            while (selection != 1 && selection !=2 && selection!= 3){
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
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you soon.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void weaponMenu(){
        System.out.println("Weapons me lord:");
        for (Weapons w: Weapons.weapons()) {
            System.out.println(w.getId() + ". < Weapon: " + w.getName() + " Damage: " + w.getDmg() +
                    " Price: " + w.getPrice() + " >");
        }
        System.out.println("0. Previous Menu");
    }

    public void buyWeapon(){
        boolean exitState = false;
        System.out.println("What would you like to buy?");
        int storeSelection = input.nextInt();
        if (storeSelection == 0){
            exitState = true;
        }
        while (storeSelection < 0 || storeSelection > Weapons.weapons().length){
            System.out.println("Invalid selection. Please try again: ");
            storeSelection = input.nextInt();
        }
        if (!exitState){
            Weapons selectedWeapon = Weapons.getWeaponById(storeSelection);
            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getGameClass().getMoney()){
                    System.out.println("You cannot afford it sire.");
                } else {
                    System.out.println("You have purchased: " + selectedWeapon.getName());
                    this.getPlayer().getGameClass().setMoney(this.getPlayer().getGameClass().getMoney() - selectedWeapon.getPrice());
                    System.out.println("You have " + this.getPlayer().getGameClass().getMoney() + " coins left.");
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }

    }

    public void armorMenu(){
        System.out.println("Armors sire:");
        for (Armors a: Armors.armors()) {
            System.out.println(a.getId() + ". < Armor: " + a.getName() + " Block: " + a.getBlock() +
                    " Price: " + a.getPrice() + " >");
        }
        System.out.println("0. Previous Menu");
    }

    public void buyArmor(){
        boolean exitState = false;
        System.out.println("What would you like to buy?");
        int storeSelection = input.nextInt();
        if (storeSelection == 0){
            exitState = true;
        }
        while (storeSelection < 0 || storeSelection > Armors.armors().length){
            System.out.println("Invalid selection. Please try again: ");
            storeSelection = input.nextInt();
        }
        if (!exitState){
            Armors selectedArmor = Armors.getArmorById(storeSelection);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getGameClass().getMoney()){
                    System.out.println("You cannot afford it sire.");
                } else {
                    System.out.println("You have purchased: " + selectedArmor.getName());
                    this.getPlayer().getGameClass().setMoney(this.getPlayer().getGameClass().getMoney() - selectedArmor.getPrice());
                    System.out.println("You have " + this.getPlayer().getGameClass().getMoney() + " coins left.");
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}
