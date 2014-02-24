package com.charles.programmingpearls;

/**
 * 
 * 实现Java的sizeof方法，估算JVM给每种类型的Object分配的大小
 *
 */
public class SizeOfJavaObject {
	private static Runtime rTime = Runtime.getRuntime();

	private static void calSize() {
		runGC();

		long heap1 = 0;
		final int count = 100000;
		Object[] objs = new Object[count];

		for (int i = -1; i < count; i++) {
			Object obj = null;
//			obj = new Object(); // 8
			 obj = new Integer( i ); // 16
			// obj = new Short( (short)i ); // 16
			// obj = new Long( i ); // 16
			// obj = new Byte( (byte)0 ); // 16
			// obj = new Character( (char)i ); // 16
			// obj = new Float( i ); // 16
//			 obj = new Double( i ); // 16
			// obj = new Boolean( true ); // 16
//			 obj = new String(); // 40
			
			if (i < 0) {
				obj = null;
				runGC();
				heap1 = usedMemory(); // before memory size
			} else {
				objs[i] = obj;
			}
		}

		runGC();
		long heap2 = usedMemory(); // after memory size

		final int size = (int) Math.round((heap2 - heap1) / (double) count);
		System.out.println("heap1 = " + heap1 + "; heap2 = " + heap2);
		System.out.println("heap2-heap1 = " + (heap2 - heap1) + "; "
				+ objs[0].getClass().getSimpleName() + " size = " + size);

		for (int i = 0; i < count; i++) {
			objs[i] = null;
		}
		objs = null;
		runGC();
	}

	private static void runGC() {
		for (int i = 0; i < 4; i++) {
			long usedMem1 = usedMemory();
			long usedMem2 = Long.MAX_VALUE;

			for (int j = 0; (usedMem1 < usedMem2) && (j < 500); j++) {
				rTime.runFinalization();
				rTime.gc();
				Thread.yield();

				usedMem2 = usedMem1;
				usedMem1 = usedMemory();
			}
		}
	}

	private static long usedMemory() {
		return rTime.totalMemory() - rTime.freeMemory();
	}

	public static void main(String[] args) {
		calSize();

	}

}
