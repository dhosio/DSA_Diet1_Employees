import controller.Controller;

/**
 * @author <a href="mailto:d.githiomi@alustudent.com">Daniel Githiomi</a>
 */
public class App {

    /**
     * Start of the application
     * @param args Arguments passed to main method
     */
    public static void main(String[] args) {

        // Create a new App and call its run method
        run();

    }

    /**
     * Initialize the application
     */
    public static void run() {

        System.out.format("\u001B[34m%s\u001B[0m", """
                \n
                Welcome to the Employee App
                ===========================
                """);

        Controller employeeController = new Controller();

        employeeController.startApp();

        System.out.format("\u001B[34m%s", "\n\n===========================================");
        System.out.format("\u001B[34m%s", "\nThank you for using the App. Good bye.\n");
    }

}