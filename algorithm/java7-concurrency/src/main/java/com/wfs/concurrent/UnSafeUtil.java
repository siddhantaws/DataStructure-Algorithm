package com.wfs.concurrent;

import java.lang.reflect.Field;

public class UnSafeUtil {
	
	public static sun.misc.Unsafe unsafe;
	
	 static {
		   try {
			   Field singleoneInstanceField = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
			   singleoneInstanceField.setAccessible(true);
			   unsafe = (sun.misc.Unsafe) singleoneInstanceField.get(null);
	       }catch (Exception e) {
	           throw new Error(e);
	       }
	   }  
}
