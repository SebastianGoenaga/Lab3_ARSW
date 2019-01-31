package edu.eci.arsw.blacklistvalidator;

import java.awt.List;
import java.net.URL;
import java.util.LinkedList;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class Threads extends Thread {
	
	private static final int BLACK_LIST_ALARM_COUNT = 5;
	private static int count = 0;
	public static boolean flag = true;
	
	
	public Threads(int n1, int n2, String ipaddress, HostBlacklistsDataSourceFacade skds) {
		
	}
	
	@Override
	public void run() {
		
	}
	
	public LinkedList<Integer> ask (){
		
		return null;
		
	}

}
