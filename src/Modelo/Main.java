/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Diogo
 */
public class Main {
    
    public static void main(String[] args){
        ArrayList<Individuo> pop = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Individuo ind = new Individuo();
            pop.add(ind);
        }
        
        for(Individuo ind: pop){
            ind.colheita();
            System.out.println("\n");
        }
        
        /*
        ind.colheita();
        System.out.println(""+ind.getCromossomo());
        System.out.println("MÊS e TIPO DE COLHEITA");
        System.out.println("Talhão 1: "+ind.fatorTalhao2(1));
        System.out.println("Talhão 2: "+ind.fatorTalhao2(2));
        System.out.println("Talhão 3: "+ind.fatorTalhao2(3));
        System.out.println("Talhão 4: "+ind.fatorTalhao2(4));
        System.out.println("Talhão 5: "+ind.fatorTalhao2(5));
        System.out.println("Talhão 6: "+ind.fatorTalhao2(6));
        System.out.println("Talhão 7: "+ind.fatorTalhao2(7));
        System.out.println("Talhão 8: "+ind.fatorTalhao2(8));

        */
        
    }    
        
        
       
}
