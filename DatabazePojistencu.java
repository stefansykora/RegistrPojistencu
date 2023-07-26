/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrpojisteni;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream .Collectors;
/**
 *
 * @author Štefan
 */
public class DatabazePojistencu {
    // Array List kam se budou pojištěnci ukládat
    ArrayList<Zaznam> pojistenci;
    
    // Vytvoření konstruktoru k ArrayListu
    public DatabazePojistencu(){
        pojistenci = new ArrayList<>();
    }
    
    // přidá do ArrayListu pojištěnce
    public void vlozZaznam(String jmeno, String prijmeni, LocalDate datumNarozeni, String telefon){
        pojistenci.add(new Zaznam(jmeno, prijmeni, datumNarozeni, telefon));
    }
    
    
    // najde v evidenci pojištěnců
    public List<Zaznam> hledejZaznamy(String jmeno, String prijmeni){
        return pojistenci.stream()
                         .filter(z -> jmeno.equals(z.getJmeno()) && prijmeni.equals(z.getPrijmeni()))
                         .collect(Collectors.toList());
    }

    // vymaže z evidence pojištěnců
    public void vymazZaznamy(String jmeno, String prijmeni){
        pojistenci.removeIf(z -> {
            return jmeno.equals(z.getJmeno()) && prijmeni.equals(z.getPrijmeni());
        });
    }

    // vrátí seznam pojištěnců
    public List<Zaznam> vratZaznamy(){
        Collections.sort(pojistenci);
        return Collections.unmodifiableList(pojistenci);
    }

}
