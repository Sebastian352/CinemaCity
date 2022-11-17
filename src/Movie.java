import java.util.Random;

public class Movie extends Cinema{

    String title;
    String subtitle;
    String tag;
    String genre;
    String[] subtitleList = {"English", "Romanian"};
    String[] tagList = {"2D", "4DX","IMAX"};
    String[] genreList = {"Action", "Comedy", "Horror"};

    Random random = new Random();

    public Movie(String title, int subtitle, int tag, int genre) {
        this.title = title;
        this.subtitle = subtitleList[subtitle-1];
        this.tag = tagList[tag-1];
        this.genre = genreList[genre-1];
    }

    public int getPrice(){
        if(this.movieList.get(currentMovie).genre.equals("Action")){
            return random.nextInt(10,15);
        }
        else if(this.movieList.get(currentMovie).genre.equals("Comedy")){
            int price = 10;
            if(this.movieList.get(currentMovie).tag.equals("4DX"))
                price += 5;
            return price;
        }
        else{
            int price = random.nextInt(15,35);
            if(this.movieList.get(currentMovie).tag.equals("IMAX") && this.movieList.get(currentMovie).subtitle.equals("English")){
                price += 10;
            }
            return price;
        }
    }
}

