# moview
Small android sample application with https://www.omdbapi.com/ usage. 

Build:
1. create apikey.properties file in project folder
2. put into apikey.properties API_KEY="XXXXXXX" where XXXXXXX is your api key for https://www.omdbapi.com/
3. that's it, project is ready for building

Used:
1. Dagger 2
2. Android Architecture Components: ViewModel
3. Retrofit 2
4. Room
5. RxJava 2
6. Adapterdelegates 4

Usage: 
1. To start new search use floating action button.
2. To view previous search tap on any item from list.

Possible TODOs:
1. String resources usage
2. Improve number of details about search result
3. Icons and theme update 
4. Modules(current package structure and dependencies structure are ready to split)
