package com.wfs;

import com.wfs.util.HashMap;

public class MyTest {

	public static void main(String[] args) {
		HashMap<Account, String> map =new HashMap<>();
		map.put(new Account(1, "SS1", 10000) ,"A");
		map.put(new Account(2, "SS2", 10000) ,"C");
		map.put(new Account(3, "SS3", 10000) ,"B");
		map.put(new Account(4, "SS3", 10000) ,"B");
		map.put(new Account(5, "SS3", 10000) ,"B");
		map.put(new Account(6, "SS3", 10000) ,"B");
		map.put(new Account(7, "SS3", 10000) ,"B");
		map.put(new Account(8, "SS3", 10000) ,"B");
		map.put(new Account(9, "SS3", 10000) ,"B");
	}
	
	static class Account implements Comparable<Account>{
		
		int accId ;
		
		String name ;
		
		double balance ;
		
		@Override
		public int hashCode() {
			return 31;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Account other = (Account) obj;
			if (accId != other.accId)
				return false;
			return true;
		}


		public Account(int accId, String name, double balance) {
			super();
			this.accId = accId;
			this.name = name;
			this.balance = balance;
		}
		
		@Override
		public int compareTo(Account o) {
			return o.accId -this.accId;
		}
		
	}
}
