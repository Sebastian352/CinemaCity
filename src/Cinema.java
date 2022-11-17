import java.util.ArrayList;

public class Cinema {
    ArrayList<Movie> movieList = new ArrayList<>();
    public int currentMovie = 0;

    int seatsLeft = 10;

    void buyTicket(Person person){
        if(movieList.size() > 0) {
            if (person.money > movieList.get(currentMovie).getPrice() && seatsLeft > 0) {
                person.money -= movieList.get(currentMovie).getPrice();
            } else {
                System.out.println("Not enough money");
            }
        }else {
            System.out.println("No movies to see");
        }
    }

    void buyTicket(Person person, int discount){
        if(person.money > movieList.get(currentMovie).getPrice() - discount && seatsLeft > 0){
            person.money -= (movieList.get(currentMovie).getPrice() + discount) ;
        }else{
            System.out.println("Not enough money");
        }
    }

    public void setCurrentMovie(int currentMovie) {
        this.currentMovie = currentMovie;
    }
}
