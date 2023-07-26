/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrpojisteni;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Štefan
 */
public class RegistrPojisteni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        Scanner sc = new Scanner(System.in, "Windows-1250");
        DatabazePojistencu databaze = new DatabazePojistencu();
        
        String volba = "";
        
        //nekonečný cyklus s podmínkou
        while(!volba.equals("5")) {
            //funkce vypíše obrazovku
            vypisObrazovku();
            
            System.out.println();
            //možnosti uživatele
            System.out.println("Vyberte si volbu a stiskněte 'ENTER'\n");
            System.out.println("1 - Přidat nového pojištěnce? ");
            System.out.println("2 - Vypsat všechny pojištěné? ");
            System.out.println("3 - Vyhledat v databázy? ");
            System.out.println("4 - Vymazat pojištěného? ");
            System.out.println("5 - Ukončit? ");
            
            //volba/vtup - zadání uživatele
            volba = sc.nextLine();
            System.out.println();

            //reakce na volbu
            switch(volba){
                case "1" -> {
                    String jmeno = zjistiUdaje(sc, "jméno");
                    String prijmeni = zjistiUdaje(sc, "příjmení");
                    String telefon = zjistiUdaje(sc, "telefon");
                    LocalDate datumNarozeni = zjistiDatumNarozeni(sc);
                    databaze.vlozZaznam(jmeno, prijmeni, datumNarozeni, telefon);
                    System.out.println("\nPojištěnec byl přidán.");
                }
                case "2" -> {
                    vypisNalezeny(databaze.vratZaznamy());
                }    
                case "3" -> {
                    String jmeno = zjistiUdaje(sc, "jméno");
                    String prijmeni = zjistiUdaje(sc, "příjmení");
                    List<Zaznam> nalezene = databaze.hledejZaznamy(jmeno, prijmeni);
                    vypisNalezeny(nalezene);
                }
                case "4" -> {
                    String jmeno = zjistiUdaje(sc, "jméno");
                    String prijmeni = zjistiUdaje(sc, "příjmení");
                    List<Zaznam> nalezene = databaze.hledejZaznamy(jmeno, prijmeni);
                    vypisNalezeny(nalezene);
                    if(!nalezene.isEmpty()){
                        System.out.println("Opravdu si přejete pojištěné/ho vymazat?(ano/ne)");
                        String volbaVymazani = sc.nextLine().trim().toLowerCase();
                        if(volbaVymazani.equals("ano")){
                            databaze.vymazZaznamy(jmeno, prijmeni);
                            System.out.println("\nPojištěnec byl vymazán.");
                        } else {
                            System.out.println("\nPojištěnec nebyl vymazán.");
                        }
                    } 
                }
                case "5" -> System.out.println("Aplikace ukončena, krásný den.");
                default -> System.out.println("Neplatná volba, prosím stiskněte libovolnou klávesu a opakujte volbu.");
            }
        }
    }
    // Vypíše zda byli nalezeni nějací pojištěnci nebo ne 
    private static void vypisNalezeny(List<Zaznam> nalezeni){
        if(!nalezeni.isEmpty()){
            System.out.println("Databáze obsahuje tyto pojištěnce:");
            for(Zaznam z : nalezeni){
                System.out.println(z);
            }
        } else {
            System.out.println("Databáze neobsahuje žádný záznam.");
        }  
    }
    
   
    //Zjistí údaje o pojištěncích
    private static String zjistiUdaje(Scanner sc, String udaje){
        System.out.println("Zadejte " + udaje +  " pojištěného:");
        return sc.nextLine().trim();
    }
    //Zjistí datum narození pojištěného
    private static LocalDate zjistiDatumNarozeni(Scanner sc){
        System.out.println("Zadejte,prosím, datum narození pojištěného (01.01.2001):");
        LocalDate datumNarozeni = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("d'.'M'.'y"));
        return datumNarozeni;
    }

    //Vypíše úvodní obrazovku
    public final static void vypisObrazovku(){
        System.out.println("..............................");
        System.out.println("   Vítejte v programu  ");
        System.out.println(" 'Evidence pojištěných'");
        System.out.println("..............................");
            }
}

