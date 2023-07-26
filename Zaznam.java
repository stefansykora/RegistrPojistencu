/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrpojisteni;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Štefan
 */
public class Zaznam implements Comparable<Zaznam>{
    
    // jméno pojištěnce
    private String jmeno;
    
    //příjmení pojištěnce
    private String prijmeni;
    
    // datum narození pojištěnce
    private LocalDate datumNarozeni;
    
    // mobilní telefon pojištěnce
    private String telefon;
    
    // vytvoření konstruktoru (jmeno, prijmeni, vek a mobilní telefon)
    public Zaznam(String jmeno, String prijmeni, LocalDate datumNarozeni, String telefon){
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.telefon = telefon;
    }

    // vrací jméno
    public String getJmeno() {
        return jmeno;
    }

    // vrací příjmení
    public String getPrijmeni() {
        return prijmeni;
    }

    // vrací věk (datum narození)
    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    // vrací číslo mobilního telefonu
    public String getTelefon() {
        return telefon;
    }

    @Override
    public String toString(){
        return "Pan/paní " + jmeno + " " + prijmeni + "  " + getVek() + "  " + telefon;
    }

    // Porovná podle data narození a jestli se jméno a příjmení bude shodovat s jiným
    public int compareTo(Zaznam other){
        if(jmeno.equals(other.jmeno) && prijmeni.equals(other.prijmeni)){
            if(datumNarozeni.isBefore(datumNarozeni)){
                return -1;
            } if (datumNarozeni.isAfter(datumNarozeni)){
                return 1;
            }
            return 0;
        }
        return prijmeni.compareTo(other.prijmeni);
    }
    
    // vrátí věk pojištěného z data narození
    
    public int getVek(){
        return Period.between(getDatumNarozeni(), LocalDate.now()).getYears();
    }
   
}