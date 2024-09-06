/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectwczytaniecsvanaliza.Service;

import com.mycompany.mavenprojectwczytaniecsvanaliza.domain.Osoba;
import com.mycompany.mavenprojectwczytaniecsvanaliza.Service.IRaport;
import com.mycompany.mavenprojectwczytaniecsvanaliza.dbo.BazaOsob;
import java.security.spec.NamedParameterSpec;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 *
 * @author 48514
 */
public class RaportGenerator implements IRaport{

    @Override
    public void generujRaport(BazaOsob bazaOsob) {
        OptionalDouble sredniWiek = bazaOsob.getOsoby().stream()
                .mapToDouble(Osoba :: getWiek)
                .average();
        
        String najdluzszeNzawisko = bazaOsob.getOsoby().stream()
                .map(Osoba:: getNazwisko)
                .max((n1, n2) -> Integer.compare(n1.length(), n2.length()))
                .orElse("Brak danych do porownania");
        
        List<Osoba> osobyPosortowane = bazaOsob.getOsoby().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getWiek(), o1.getWiek()))
                .collect(Collectors.toList());
        
        System.out.println("Analiza danych:");
        System.out.println("Sredni wiek wynksi: " + sredniWiek + " lat.");
        System.out.println("Najdluszym nazwiskem jest : " + najdluzszeNzawisko);
        System.out.println("Lista osob posortowana wedlug wieku malejaco: ");
        osobyPosortowane.forEach(System.out:: println);
        
    
    
    
    
    }
    
    
    
    
    
}
