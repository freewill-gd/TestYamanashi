package test;


import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class TestMain {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		new TestMain();
	}

	public TestMain() {
		System.out.println("aaaa");
		List<Object> l = createList();
		//HashMap[] p = new HashMap<String, Object>[10];

		//TDto tt = new TDto();
		//TDto[] arr = new TDto[10];
		 TDto[] arr = l.toArray(new TDto[0]);
		 for (int i = 0; i < arr.length; i++) {
			 	System.out.println(arr[i].getA());
			 	System.out.println(arr[i].getB());
		 }
	}

	public List<Object> createList() {
			List<Object> ret = new ArrayList<Object>();
			for (int i = 0; i < 10; i++) {
				TDto d = new TDto();
				d.setA(13 * i);
				d.setB(100 * i);
				ret.add(d);
			}

			return ret;
	}
}
