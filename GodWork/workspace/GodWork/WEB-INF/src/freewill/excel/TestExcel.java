package freewill.excel;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestExcel {
	
	public static void main(String[] args){
		RosterExcel excel = new RosterExcel();
	    FileOutputStream os = null;
	    try{
	      os = new FileOutputStream("/home/user/tmp/test.xlsx");
	      excel.OutoutExcel(os);
	    }catch(IOException e){
	      System.out.println(e.toString());
	    }finally{
	      try {
	        os.close();
	      }catch(IOException e){
	        System.out.println(e.toString());
	      }
	    }
	}
}
