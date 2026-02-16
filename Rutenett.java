public class Rutenett {
//Instansvariabler
    public int antRader;
    public int antKolonner;
    public Celle[][] rutene;
    
//a) Konstruktør
    public Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        
//b) 2D-arrayen
        rutene = new Celle[antRader][antKolonner];
    }
    
//c) Lag en ny celle og legg den i rutenettet
    public void lagCelle(int rad, int kol) {
        Celle celle = new Celle();
        
        if (Math.random() <= 0.3333) {
            celle.settLevende();
        }
        
        rutene[rad][kol] = celle;
    }

//d) Fyll med tilfedige celler
    public void fyllMedTilfeldigeCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                lagCelle(rad, kol);
            }
        }
    }

//e) Hent celle-metoden
    public Celle hentCelle(int rad, int kol) {
        if (rad < 0 || rad >= antRader) {
            return null; 
        }
        if  (kol < 0 || kol >= antKolonner) {
            return null;
        }
        return rutene[rad][kol];
    }

//f) Tegn rutenett 
    public void tegnRutenett() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                Celle celle = hentCelle(rad, kol);
                System.out.print(celle.hentStatusTegn() + " ");
            }
        //Ny linje etter hver rad
            System.out.println(); 
        }
    }
//g) Sette naboer for hver celle
    public void settNaboer(int rad, int kol) {                     
        Celle celle = hentCelle(rad, kol);

        for (int naborad = rad - 1; naborad <= rad + 1; naborad++) {
            for (int nabokol = kol - 1; nabokol <= kol + 1; nabokol++) {

                Celle nabo = hentCelle(naborad, nabokol);

                if (nabo != null && !(naborad == rad && nabokol == kol)) { //hjelp av KI her, skrev til KI "Hva er java versjonen av is not None og and".
                    celle.leggTilNabo(nabo);
                }
            }
        }
    }

//h) Koble alle celler
    public void kobleAlleCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                settNaboer(rad, kol);
                
            }
        }
    }

//i) Antall levende celler
    public int antallLevende() {
        int antall = 0;

        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                Celle celle = hentCelle(rad, kol);
                if (celle != null && celle.erLevende()) {
                    antall++;
                }
            }
        }

        return antall;
    }
}



