/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectwczytaniecsvanaliza.Service;

import com.mycompany.mavenprojectwczytaniecsvanaliza.domain.Osoba;
import com.mycompany.mavenprojectwczytaniecsvanaliza.dbo.BazaOsob;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 48514
 */
public class FileReaderService implements IFileReader {

    @Override
    public void readerFile(String nazwaPlikuDoOdczytu, BazaOsob bazaOsob) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nazwaPlikuDoOdczytu))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dane = line.split(",");
                if (dane.length == 4) {
                    try {
                        String imie = dane[0];
                        String nazwisko = dane[1];
                        int wiek = Integer.parseInt(dane[2]);
                        String email = dane[3];

                        Osoba osoba = new Osoba(imie, nazwisko, wiek, email);
                        bazaOsob.getOsoby().add(osoba);
                    } catch (NumberFormatException e) {
                        System.err.println("Błąd w formacie wieku: " + dane[2]);
                    }
                } else {
                    System.err.println("Nieprawidłowy format danych: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas odczytu pliku: " + e.getMessage());
            throw e;
        }
    }
}
