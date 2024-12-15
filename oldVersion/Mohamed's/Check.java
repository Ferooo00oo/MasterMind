/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

public class Check {
    
        protected static boolean IsValidCode(String code){
            if (code.length() == att.getCODE_LENGTH()) {
                code.toCharArray();// R B P R
                for (int i = 0; i < att.getCODE_LENGTH(); i++) {
                    char c = code.charAt(i);//R
                    if (att.colors[0] == c || att.colors[1] == c || att.colors[2] == c || att.colors[3] == c || att.colors[4] == c || att.colors[5] == c) {}
                    else return false ;
                }
            }
            else return false ; 
            return true ;
        }
    }