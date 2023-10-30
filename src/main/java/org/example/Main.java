package org.example;

import org.example.domain.Tablou;
import org.example.domain.TablouValidator;
import org.example.repository.Repository;
import org.example.repository.dbRepository.TablouDbRepository;
import org.example.service.TablouService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reading data from file");
        String username="postgres";
        String password="carla";
        String url="jdbc:postgresql://localhost:5432/examenpractic";
        Repository<Long, Tablou> userFileRepository3 =
                new TablouDbRepository(url,username, password,  new TablouValidator());

        userFileRepository3.findAll().forEach(x -> System.out.println(x));

        TablouService service = new TablouService(userFileRepository3);

//        System.out.println("**********Cautare tablou Nuferi Claude Monet:**********");
//        service.cautareTablou();

        System.out.println("**********Filtararea tablourilor cu tematica natura:**********");
        service.filtarareNatura();

        System.out.println("**********Filtrarea tablourilor cu tematica natura si care au celebritatea mai mare decat 8:**********");
        service.filtarareNatura8();

        System.out.println("**********Sortarea listei de tablouri dupa pictor si titlu:**********");
        service.sortareDupaPictorSiTitlu();

        System.out.println("**********Sortarea listei de tablouri dupa tematica:**********");
        service.sortareDupaTematica();

        System.out.println("**********Sortarea listei de tablouri dupa celebritate,descarescator:**********");
        service.sortareDupaCelebritateDescrescator();
    }
}

//cerinta problemei:
//Consideram enitatea Tablou(id, titlu, pictor, tematica(abstract, natura, orase, portret), celebritate)
//scrieti un program care sa respecte urmatoarele functionalitati:
//1. citirea tablourilor dintr-o baza de date(PostgreSQL) si memoralea lor intr-o lista in memorie.
//2. cautarea tabloului "nuferi claude monet" in lisya de la punctul 1
//3. filtrarea tablourilor cu tematica natura si afisarea lor in consola
//4. filtrarea tablourilor cu tematica natura care au celebritatea mai mare decat 8 su afisarea lor la cconsola.
//5. sortarea listei de tablouri dupa mai multe critetii:
//a) dupa pictor si titlu, alfabetic , crescator
//b) dupa tematica, crescator
//c) dupa celebritate, descrescator
//si afisarea la consola a fiecarei liste sortate astfel:
//a) id pictor titlu
//b) titlu pictor tematica
//c) id celebritate