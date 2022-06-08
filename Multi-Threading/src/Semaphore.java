public class Semaphore {
	private int availConnections;//number of WI-FI connections
	
	Semaphore(){
		availConnections=0;
		
	}
	Semaphore(int availConnections){
		this.availConnections=availConnections;

		
	}
	//this fun connect device with router 
	//if WI-FI connections full the fun make device wait 
	public synchronized void connect(Device d) throws InterruptedException {  
		if(availConnections>0) {
			d.r.printMessage("("+d.name+")" +"("+d.type+")"+" Arrived");
		}
		availConnections--;
		if(availConnections<0) {
			d.r.printMessage("("+d.name+")" +"("+d.type+")"+" Arrived and Waiting");

			wait();
		}

		d.r.connect(d);
		
	}
	//this fun disconnect device with router and increase number of WI-FI connections again
	public synchronized void disconnect(Device d) {
		d.r.disconnect(d);
		availConnections++;
		if(availConnections<=0) {
			notify();
		}
		
	}

}