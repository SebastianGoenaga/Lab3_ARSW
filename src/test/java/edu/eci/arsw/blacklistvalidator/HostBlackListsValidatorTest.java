package edu.eci.arsw.blacklistvalidator;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Scanner;

import org.junit.Test;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class HostBlackListsValidatorTest {
	
	private static final int BLACK_LIST_ALARM_COUNT = 5;
	
	@Test
	public void checkHostTest() {
		
		HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();
		
		String[] ip = {"200.24.34.55", "201.24.34.55", "202.24.34.55"};
//		String[] expectedResults = {"[23, 50, 200, 500, 1000]", "[]", "[29, 10034, 20200, 31000, 70500]"};
		int[] nHilos = {10, 100, 1000};
		
		int listPerThread;
		int m;
		boolean flag;
		int n;
		String ipaddress;
		Threads hilo;
		
		for (int i = 0; i < 3; i++) {
			n = nHilos[i];
			ipaddress = ip[i];
			listPerThread = skds.getRegisteredServersCount() / n;
			m = skds.getRegisteredServersCount() - (listPerThread * n);
			flag = (m != 0) ? true : false;
			hilo = null;
			
			for (int i1 = 0; i1 < n; i1++) {
				hilo = new Threads(i1 * listPerThread, (i1 + 1) * listPerThread, ipaddress, skds);
				hilo.start();
			}
			
			if (flag) {
				Threads hilo2 = new Threads(listPerThread * n, listPerThread * n + m, ipaddress, skds);
				hilo2.start();
			}
			
			// This join unifed all threads
			try {
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Collections.sort(Threads.blackListOcurrences);
			String expected = Threads.blackListOcurrences.toString();
			Threads.resetStatics(); // Reinicia las variables estaticas de la clase Threads
			HostBlackListsValidator validator = new HostBlackListsValidator();
			String result = validator.checkHost(ip[i], nHilos[i]).toString();
			
			assertEquals(expected, result);
			
			Threads.resetStatics(); // Se prepara las variables para la siguiente iteracion
		}
		

		
		
	}

}
