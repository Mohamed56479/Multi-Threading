import java.util.Random;

public class Device extends Thread {
	String name ;
	String type ;
	Router r; //this router that device connected on it

	  
	  Device(){
		  this.name="";
		  this.type="";
		  this.r=null;
		  
	  }
	  Device(String name,String type, Router r){
		  this.name=name;
		  this.type=type;
		  this.r=r;
		  
	  }
	  public void PerformsActivity() {
		  //after login device do some activity
		  r.printMessage("Connection "+r.Lastconnection+": "+name+" Performs Online Activity");
		  try {
	            Thread.sleep(new Random().nextInt(10000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	  }
	//the thread use this fun to start 
	  
	  @Override
	    public void run() {
	        try {
				r.s.connect(this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        PerformsActivity();
	        r.s.disconnect(this);
	    }

}