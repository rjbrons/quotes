package quotes;

import java.util.ArrayList;

public class Quote {
    int id;
    String starWarsQuote;
    int faction;
    ArrayList<String> tags;
    String author;
    String likes;
    String text;

    public Quote(ArrayList<String> tags, String auth, String likes, String body){
        this.tags = tags;
        this.author = auth;
        this.likes = likes;
        this.text = body;
    }

    public Quote(int id, String starWarsQuote, int faction){

        this.id = id;
        this.starWarsQuote = starWarsQuote;
        this.faction = faction;
    }

    public String getQuote(){
        if (this.author != null){
            return this.text;
        } else {
            return this.starWarsQuote;
        }
    }

    @Override
    public String toString(){
        if (this.author != null){
            return String.format("Author: %s\nQuote: %s", this.author, this.text);
        } else {
            return String.format(this.starWarsQuote);
        }
    }



}
