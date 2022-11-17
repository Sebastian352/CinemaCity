import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void printMenu() {
        System.out.println("0 -> Exit the add method");
        System.out.println("1 -> Add an Action Movie");
        System.out.println("2 -> Add an Comedy Movie");
        System.out.println("3 -> Add an Horror Movie");
        System.out.println("4 -> Print all movies");
        System.out.println("5 -> Set current movie");
    }
    public static void newMovie(int command,Cinema cinema){
        Scanner input = new Scanner(System.in);

        System.out.println("Movie name:");
        String title = input.nextLine();
        System.out.println("Language subtitle: 1) English 2) Romanian");
        int subtitle = input.nextInt();
        System.out.println("Movie tag: 1)2D 2)4DX 3)IMAX ");
        int tag = input.nextInt();

        Movie movie = new Movie(title,subtitle,tag,command);
        cinema.movieList.add(movie);
    }
    public static void changeCurrentMovie(Cinema cinemaRoom){
        printAllMovies(cinemaRoom);
        if(cinemaRoom.movieList.size() > 0){
            System.out.println("What movie would you like next?");
            int nextMovie = in.nextInt();
            cinemaRoom.setCurrentMovie(nextMovie);
        }else {
            System.out.println("No movies to choose from \n");
        }

    }

    public static void printAllMovies(Cinema cinemaRoom){
        if(cinemaRoom.movieList.size() > 0) {
            for (int i = 0; i < cinemaRoom.movieList.size(); i++)
                System.out.println(i + 1 + ") " + cinemaRoom.movieList.get(i).title);
        }
        else {
            System.out.println("No movies to choose from \n");
        }
    }
    public static void executeCommand(int command,Cinema cinema) {
        switch (command) {
            case 1, 2, 3 -> newMovie(command, cinema);
            case 4 -> printAllMovies(cinema);
            case 5 -> changeCurrentMovie(cinema);
            default -> System.out.println("Unknown Command");
        }
    }

    public static void addMovies(Person person,Cinema cinemaRoom){
        if(person.role.equals("Admin")) {
            int command;

            while (true) {
                printMenu();

                command = in.nextInt();
                if (command == 0)
                    break;
                executeCommand(command,cinemaRoom);
            }
        }
        else
            System.out.println("Not an admin");
    }
    public static void running(Cinema cinemaRoom){
        Person person = new Person("Admin",1000);
        Person person1 = new Person("Viewer",1000);
        Person person2 = new Person("Viewer",1000);
        Person person3 = new Person("Viewer",1000);

        addMovies(person,cinemaRoom);

        cinemaRoom.buyTicket(person);
        cinemaRoom.buyTicket(person1);
        cinemaRoom.buyTicket(person2);
        cinemaRoom.buyTicket(person3);

    }
    public static void main(String[] args) {
        Cinema cinemaRoom = new Cinema();
        running(cinemaRoom);
    }
}

