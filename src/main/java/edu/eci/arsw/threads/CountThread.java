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
public class CountThread extends Thread {
    
	int limInf;
	int limSup;
	
	
	public CountThread(int n1, int n2) {
		limInf = n1;
		limSup = n2;
	}
	
	@Override
	public void run() {
		for (int i = limInf; i < limSup; i++) {
			System.out.println(i);
		}		
	}
	
}
