/**
 * Created by win808mac on 8/19/16.
 */
public class Main {

    public static void main(String[] args) {
        AnimalsService service = new AnimalsService();
        MenuService menu = new MenuService();
        boolean repeat = true;


        while (repeat) {
            int action = MenuService.promptForMainMenuSelection();

            if (action == MenuService.LIST_ANIMAL) {
                        menu.displayAnimalsList(service);
            }
            else if (action == MenuService.CREATE_ANIMAL) {
                        menu.createAnimal(service);
            }
            else if (action == MenuService.VIEW_DETAILS) {
                        menu.viewDetails(service);
            }
            else if (action == MenuService.EDIT_ANIMAL) {
                        menu.editAnimal(service);
            }
            else if (action == MenuService.DELETE_ANIMAL) {
                        menu.deleteAnimal(service);
            }
            else if (action < 1 || action > 6) {
                System.out.println("\nPlease input a valid menu option (1 - 6)");
            }
            else if (action == MenuService.QUIT) {
                        repeat = menu.quit(service);
            }

        }
    }
}