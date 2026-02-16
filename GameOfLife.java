public class GameOfLife {
    public static void main(String[] args) {
        Verden verden = new Verden(8, 12);

        verden.tegn();

        for (int i = 0; i < 3; i++) {
            verden.oppdatering();
            verden.tegn();
        }
    }
}

/* Utskrift> java GameOfLife

O . . . . . . . O . O .
. . . . . . . . . . . O
. O . . . . O . O . O .
. . . O . . . . O . O .
. . . . . . . O . . O O
. . O . . . . . O . O .
. O O . . O . . . O . .
. . O O . O . O . . . O
Generasjon: 0
Antall levende: 26
. . . . . . . . . . . .
. . . . . . . O . . O O
. . . . . . . O . . O O
. . . . . . . . O . O .
. . . . . . . O O . O O
. O O . . . . . O . O O
. O . . O . O . O O O .
. O O O O . O . . . . .
Generasjon: 1
Antall levende: 28
. . . . . . . . . . . .
. . . . . . . . . . O O
. . . . . . . O O . . .
. . . . . . . . O . . .
. . . . . . . O O . . .
. O O . . . . . . . . .
O . . . O . . . O . O O
. O O O O . . O . O . .
Generasjon: 2
Antall levende: 20
. . . . . . . . . . . .
. . . . . . . . . . . .
. . . . . . . O O O . .
. . . . . . . . . O . .
. . . . . . . O O . . .
. O . . . . . O O O . .
O . . . O . . . O O O .
. O O O O . . . O O O .
Generasjon: 3
Antall levende: 22

*/