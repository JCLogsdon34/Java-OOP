/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class Scores {
    public static void main(String[] args){
        ListofSocres myListofSocres = new ListofSocres();
        myListofSocres.StudentScores();
        Map<String, Object> quizscores = new HashMap<>();
        //make Integer an Object
        quizscores.put("Chris Logsdon" , ListofSocres.StudentScores());
    }
}
