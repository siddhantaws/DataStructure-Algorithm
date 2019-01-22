package com.wfs;

import java.io.Serializable;

import com.wfs.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		
		Account a1 =new Account(15789181585251256l, "KrushnaChandraMohanty", 25891485.00, 5621287927l);
		Account a2 =new Account(78915233411000147l, "HariPrasadDasSekhar", 9552127489.00, 98610483144l);
		Account a3 =new Account(42123120001747889l, "ChandanPrasadDasKhuntia", 781120248851.00, 86580317912l);
		Account a4 =new Account(171047898766600014l, "KunDanSinhaDani", 7871004785100.00, 321014520144454l);
		Account a5 =new Account(362514748596365421l, "SickyDaniPattnaik", 784122001478512.00, 330021778522l);
		Account a6 =new Account(7410525601478511454l, "SentilMasilaMohantu", 4784111478562458.00, 121202178892322l);
		Account a7 =new Account(9568956895689568l, "PuneeyMishara", 178484544984156.00, 12021782214588l);
		ConcurrentHashMap<Account,Account> hashMap =new ConcurrentHashMap<>();
		hashMap.put(a1, a1);
		hashMap.put(a2, a2);
		hashMap.put(a3, a3);
		hashMap.put(a4, a4);
		hashMap.put(a5, a5);
		hashMap.put(a6, a6);
		hashMap.put(a7, a7);
	}
	static class Account implements Serializable {
		
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -2472223798085110130L;

		private long accountNumber;
		
		private String accountName;
		
		private double balance ;
		
		private long phoneNumber;

		
		
		public Account(long accountNumber, String accountName, double balance, long phoneNumber) {
			super();
			this.accountNumber = accountNumber;
			this.accountName = accountName;
			this.balance = balance;
			this.phoneNumber = phoneNumber;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result ;
			result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
			result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
			long temp;
			temp = Double.doubleToLongBits(balance);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
			return result;
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
			if (accountName == null) {
				if (other.accountName != null)
					return false;
			} else if (!accountName.equals(other.accountName))
				return false;
			if (accountNumber != other.accountNumber)
				return false;
			if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
				return false;
			if (phoneNumber != other.phoneNumber)
				return false;
			return true;
		}

		
		
	}
}
