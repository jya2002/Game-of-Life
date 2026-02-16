public class Celle {
//Instansvariablene
    public boolean levende;
    public Celle [] naboer;
    public int antNaboer;
    public int antLevendeNaboer;

//a) Konstruktøren
    public Celle() {
        levende = false;                //Status død som utgangspunkt
        naboer = new Celle[8];          //en array med åtte elementer
        antNaboer = 0;                  //initieres til 0
        antLevendeNaboer = 0;
    } 

//b) Cellen er død
    public void settDød() {
        levende = false;
    }
   
//Cellen lever
    public void settLevende() {
        levende = true;
    }

//c) Returnerer cellens status
    public boolean erLevende() {
        return levende;
    }

//d) Tegn for levende eller død celle
    public char hentStatusTegn() {

        if (levende) {
            return 'O';                 //Returnerer levende celle
        } else {
            return '.';                 //Returnerer cød celle
        }
    }

//e) Legger nabo til arrayen naboer og øker antNaboer
    public void leggTilNabo(Celle nabo) {
        if (antNaboer < 8) {
            naboer[antNaboer] = nabo;
            antNaboer++;
    }
}

//f) Teller antall levende naboer   
public void tellLevendeNaboer() {
        antLevendeNaboer = 0;

        for(int i = 0; i < antNaboer; i++) {
            if (naboer[i] != null && naboer[i].erLevende()) { //Brukte KI for hjelp her
                antLevendeNaboer++;
        }
      }
    }

//Færre enn 2 eller mer enn 3 naboer --> cellen dør
//Død celle og akkurat 3 levende naboer --> cellen lever
     public void oppdaterStatus() {

        if (levende) {
            if (antLevendeNaboer < 2 || antLevendeNaboer > 3) {
                settDød(); 
            }
        } else {
            if (antLevendeNaboer == 3) {
                settLevende();
            }
        }
    }
}
