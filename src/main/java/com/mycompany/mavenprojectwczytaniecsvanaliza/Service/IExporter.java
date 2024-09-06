/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenprojectwczytaniecsvanaliza.Service;

import com.mycompany.mavenprojectwczytaniecsvanaliza.domain.Osoba;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 48514
 */
public interface IExporter {
    void exporter(List<Osoba> osoby, String nazwaPlikuDoZapisu) throws IOException;
}
