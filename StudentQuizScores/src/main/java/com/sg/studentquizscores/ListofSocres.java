/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class ListofSocres {
    public int ChrisScores(){
        int L = 100;
        int C = 100;
        int G = 98;
            
        ArrayList<Integer> chrisscores = new ArrayList<>();
        
        chrisscores.add(L);
        
        chrisscores.add(C);
        
        chrisscores.add(G);
        
        Iterator<Integer> iter = chrisscores.iterator();
        
        while(iter.hasNext()){
            int current = iter.next();
            System.out.println(current);
        }
        return L + C + G / chrisscores.size();         
    }
    
    public int SavannahScores(){
        int L = 98;
        int C = 80;
        int G = 93;
        int k = 99;
        
         ArrayList<Integer> savannahscores = new ArrayList<>();
        
        savannahscores.add(L);
        
        savannahscores.add(C);
        
        savannahscores.add(G);
        
        savannahscores.add(k);
        
        Iterator<Integer> iter = savannahscores.iterator();
        
        while(iter.hasNext()){
            int current = iter.next();
            System.out.println(current);
        }
        return L + C + G + k / savannahscores.size();
    }
}
