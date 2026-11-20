/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

/**
 *
 * @author ACER
 */

import backend.*;

public class TestBackend {
    public static void main(String[] args) {
        for (Kategori k : new Kategori().getAll()) {
            System.out.println(k.getIdkategori() + " " + k.getNama());
        }
        Buku b = new Buku().getById(1);
        System.out.println(b.getJudul() + " - " + b.getKategori().getNama());
    }
}