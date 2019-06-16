package quotes;

import java.util.ArrayList;

public class Quote {
    int id;
    String starWarsQuote;
    int faction;
    String author;
    String text;

    public Quote(ArrayList<String> tags, String auth, String likes, String body){
        this.author = auth;
        this.text = body;
    }

    public Quote(int id, String starWarsQuote, int faction){
        this.text = starWarsQuote;
        this.author = "Star Wars";
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
            return String.format("Author: Star Wars\nQuote: %s", this.starWarsQuote);
        }
    }



}
