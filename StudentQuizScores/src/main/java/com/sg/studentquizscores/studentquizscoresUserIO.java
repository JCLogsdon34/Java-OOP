/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

public interface studentquizscoresUserIO {

    public interface UserIo {

        void print(String message);

        public String getUserDirections();

        public String getStudents();
        
        public String getStudent();
        
        void exit(String message);
    }

}
