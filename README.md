# O naszej Apce
Ta aplikacja umożliwia naukę geografii za pomocą bazy pytań zamkniętych, dodatkowo użytkownik może progresować i narzucać sobie szybsze tempo ustawiając timer na pytania.
Aplikacja wyświetla wyniki po każdym Quizie.

# Funkcjonalnosc
1. Uzytkownik moze wybrac 1 z 4 odpowiedzi na wyjatkowe zamkniete pytanie
2. Uzytkownik po wybraniu odpowiedzi widzi czy byla prawidlowa
3. Uzytkownik po zakonczeniu Testu widzi ile mial poprawnych odpowiedzi
4. Uzytkownik moze startowac, resetowac i pauzowac zegar ograniczajacy czas na rozwiazanie zadania

# Uruchamianie i debugging
Jesli korzystasz z VSC, kliknij przycisk f5 na klawiaturze, program zostanie przeszukany w celu znalezienia bugow i uruchomiony.
Mozna tez uzyc pliku Quiz.jar zalaczonym w repozytorium. Aby go uruchomic wpisujemy do terminala nastepnujace polecenie: java -jar Quiz.jar
Ostatnia metoda jest reczna kompilacja:
I) javac *.java
II) java Quiz.java
 

# Rozwin ten Projekt!
Chcesz nam pomoc? Przeczytaj to!:
-->Quiz.java to klasa glowna, zawiera ona interfejs testu w formie abcd wraz ze wszystkimi guzikami do wyboru odpowiedzi, baze pytan oraz metody zmieniajace pytania i 
wyswietlajace odpowiedzi.
-->Zegar.java to klasa, ktora rozszerza Quiz o dodatkowe "feature" zegara ktory umozliwia zwiekszenie trudnosci poprzez dodanie limitu czasowego. 
Klasa ta zawiera obiekt zegara oraz metody do jego przyciskow.
-->CountdownListener.java to klasa obserwator ktora pozwala komunikowac Intefejs z zegarem przekazujac mu informacje o uplywajacym czasie.

# Autorzy
Sebastian Dechnik
Kacper Szczerba 
Mikołaj Ciuba