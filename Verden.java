public class Verden { 
    private Rutenett rutenett;
    public int genNr;

//a) Konstruktøren for klassen
    public Verden(int rader, int kolonner) {
        rutenett = new Rutenett(rader, kolonner);
        genNr = 0;
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }

//b) Tegn-metoden tegner rutenettet, skriver ut generasjonsnummeret og antall levende celler
    public void tegn() {
        rutenett.tegnRutenett();
        System.out.println("Generasjon: " + genNr);
        System.out.println("Antall levende: " + rutenett.antallLevende());
    }
//c) 
    public void oppdatering() {
        for (int rad = 0; rad < rutenett.antRader; rad++) {
            for (int kol = 0; kol < rutenett.antKolonner; kol++) {
                Celle celle = rutenett.hentCelle(rad, kol);
                celle.tellLevendeNaboer();
            }
        }

        for (int rad = 0; rad < rutenett.antRader; rad ++) {
            for (int kol = 0; kol < rutenett.antKolonner; kol++) {
                Celle celle = rutenett.hentCelle(rad, kol);
                celle.oppdaterStatus();
            }
        }

        genNr++;
    }

}
