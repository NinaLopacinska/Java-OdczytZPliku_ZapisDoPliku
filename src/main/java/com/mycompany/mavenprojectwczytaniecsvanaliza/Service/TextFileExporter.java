/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectwczytaniecsvanaliza.Service;

import com.mycompany.mavenprojectwczytaniecsvanaliza.domain.Osoba;
import com.mycompany.mavenprojectwczytaniecsvanaliza.Service.IExporter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author 48514
 */
public class TextFileExporter implements IExporter {

    @Override
    public void exporter(List<Osoba> osoby, String nazwaPlikuDoZapisu) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nazwaPlikuDoZapisu))) {
            for (Osoba x : osoby) {
                writer.println(x.getImie()+","+x.getNazwisko()+","+x.getWiek()+","+x.getEmail());
            }
        }

    }

}
