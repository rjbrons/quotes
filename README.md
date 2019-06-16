# Quotes

This app attempts to read a quote from the Star Wars quotes api,  if successful it prints that to the screen and appends it to the default quotes file.  If it cant access the api, it randomly selects a quote from the default quotes and prints that to screen.

## Struture

`App.class`   
```-public static Quote[] readFromJson(String fileName)```Takes in a filename (String) and returns an array of Quotes.  

`Quote.class`    
Has overloaded constructor to make a quote for either the Star Wars quote or the default author quotes.
  `-public String toString()` Returns a string containing the author and text of the quote.  

## Dependencies
```
dependencies {
 compile 'com.google.code.gson:gson:2.8.2'
}
```
## Clone

Follow normal git procedures usually something similar to;
```git clone <repo url>```

## Run
From the root of the gradle project:   
To run the program run.  
`./gradlew run`  
To test the program run.  
`./gradlew test`  
