package edu.eci.arsw.blacklistvalidator;

import java.util.LinkedList;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class Threads extends Thread {

	private static final int BLACK_LIST_ALARM_COUNT = 5;
	public static Integer count = 0;
	public static Integer checkedListsCount = 0;
	public static LinkedList<Integer> blackListOcurrences = new LinkedList<>();

	public static boolean flag = true;

	private Integer n1;
	private Integer n2;
	private String ipaddress;
	private HostBlacklistsDataSourceFacade skds;
	private int personal;

	public Threads(int n1, int n2, String ipaddress, HostBlacklistsDataSourceFacade skds) {
		this.n1 = n1;
		this.n2 = n2;
		this.ipaddress = ipaddress;
		this.skds = skds;
	}

	@Override
	public void run() {
//		System.out.println(n1+" "+n2);
		personal = 0;
		for (int i = n1; i < n2 && Threads.count < Threads.BLACK_LIST_ALARM_COUNT; i++) {
			personal++;
			synchronized (checkedListsCount) {
				checkedListsCount++;
			}
			if (skds.isInBlackListServer(i, ipaddress)) {
				synchronized (count) {
					count++;
				}
				synchronized (blackListOcurrences) {
					blackListOcurrences.add(i);
				}

			}
		}
//		System.out.println(count);
		if (count >= BLACK_LIST_ALARM_COUNT) {
//			System.out.println("Hola");
			flag = false;
		}
		System.out.println(personal);
	}

	public LinkedList<Integer> ask() {

		return null;

	}

}
