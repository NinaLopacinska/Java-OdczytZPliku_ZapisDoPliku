/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenprojectwczytaniecsvanaliza;

import com.mycompany.mavenprojectwczytaniecsvanaliza.domain.Osoba;
import com.mycompany.mavenprojectwczytaniecsvanaliza.Service.TextFileExporter;
import com.mycompany.mavenprojectwczytaniecsvanaliza.Service.RaportGenerator;
import com.mycompany.mavenprojectwczytaniecsvanaliza.Service.IFileReader;
import com.mycompany.mavenprojectwczytaniecsvanaliza.Service.IExporter;
import com.mycompany.mavenprojectwczytaniecsvanaliza.Service.FileReaderService;
import com.mycompany.mavenprojectwczytaniecsvanaliza.dbo.BazaOsob;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 48514
 */
public class MavenprojectWczytanieCSVAnaliza {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BazaOsob bazaOsob = new BazaOsob();
        IFileReader fileReader = new FileReaderService();
        RaportGenerator raportGenerator = new RaportGenerator();
        IExporter exporter = new TextFileExporter();
        System.out.println("Witaj uzytkowniku");
        
        boolean czyWyjsc = false;
        do {
           
            System.out.println("MENU");
            System.out.println("1. Wczytaj dane z pliku csv.");
            System.out.println("2. Dokonaj analizy wczytanyych danych.");
            System.out.println("3. Zapisz wynik analizy do pliku.");
            System.out.println("4. Zamknij program.");

            int nrOpcji = scanner.nextInt();
            switch (nrOpcji) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku, z ktorego chcesz wczytac dane:");
                    String nazwaPlikuDoOdczytu = scanner.nextLine();

                    try {
                        fileReader.readerFile(nazwaPlikuDoOdczytu, bazaOsob);
                        // Wyświetl użytkowników po załadowaniu z pliku
                        for (Osoba o : bazaOsob.getOsoby()) {
                            System.out.println(o);
                        }
                    } catch (IOException e) {
                        System.err.println("Błąd: " + e.getMessage());
                    }
                    break;

                case 2:
                    raportGenerator.generujRaport(bazaOsob);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku, do ktorego chcesz zapisac dane: ");
                    String nazwaPlikuDoZapisu = scanner.nextLine();
                    
                    try {
                            exporter.exporter(bazaOsob.getOsoby(), nazwaPlikuDoZapisu+".csv");
                            System.out.println("Lista osób została zapisana do pliku: " + nazwaPlikuDoZapisu);
                        } catch (IOException e) {
                            System.err.println("Błąd podczas zapisu pliku: " + e.getMessage());
                        }
                    break;
                case 4:
                    System.out.println("Zapraszamy ponownie!");
                    czyWyjsc = true;
                    break;

                default:
                    throw new AssertionError();
            }

        } while (!czyWyjsc);

    }
}
