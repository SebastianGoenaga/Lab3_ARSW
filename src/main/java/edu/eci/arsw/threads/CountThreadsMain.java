/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        
    	CountThread cThread1 = new CountThread(0, 99);
    	CountThread cThread2 = new CountThread(99, 199);
    	CountThread cThread3 = new CountThread(199, 300);
    	
//    	cThread1.start();
//    	cThread2.start();
//    	cThread3.start();
    	
    	cThread1.run();
    	cThread2.run();
    	cThread3.run();
    	
    }
    
}

