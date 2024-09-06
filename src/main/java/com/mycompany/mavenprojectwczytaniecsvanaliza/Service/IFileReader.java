/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenprojectwczytaniecsvanaliza.Service;

import com.mycompany.mavenprojectwczytaniecsvanaliza.dbo.BazaOsob;
import java.io.IOException;

/**
 *
 * @author 48514
 */
public interface IFileReader {
    void readerFile(String nazwaPlikuDoOdczytu, BazaOsob bazaOsob) throws IOException;
}
