/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectwczytaniecsvanaliza.dbo;

import com.mycompany.mavenprojectwczytaniecsvanaliza.domain.Osoba;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 48514
 */
public class BazaOsob {
    private List<Osoba> osoby = new ArrayList<>();

    public void setOsoby(List<Osoba> osoby) {
        this.osoby = osoby;
    }


    public List<Osoba> getOsoby() {
        return osoby;
    }

    
}
