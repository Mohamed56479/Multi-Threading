import java.io.FileWriter;
import java.io.IOException;

public class Router{
	private int Numberofconnections;
	Semaphore s;
	int Lastconnection;
    Device[] connections;
	
    //default constructor
	Router(){
		Numberofconnections=0;
		s=null;
		Lastconnection=0;
		connections=null;
	}
	
	
	Router(int Numberofconnections){
		this.Numberofconnections=Numberofconnections;
		s=new Semaphore(Numberofconnections);
		connections=new Device[Numberofconnections];
		Lastconnection=0;
	}
	
	//this fun print the output logs in a file
	 public void printMessage(String message) {
	        System.out.println(message);
	        try {
	            FileWriter writer = new FileWriter("output.txt", true);
	            writer.write(message + '\n');
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	//this fun connect device with router and add device in list of connections
	public void connect(Device d) {
		for(int i=0; i<Numberofconnections; i++){
			if(connections[i]==null) {
				connections[i]=d;
				Lastconnection=i+1;
				break;
			}
		}
		printMessage("Connection "+Lastconnection  + ": " + d.name  +" Occupied");
		
		printMessage("Connection "+Lastconnection  + ": " + d.name  +" Login");
	}
	
	//this fun disconnect device with router and remove device from list of connections
	public void disconnect(Device d) {
		for(int i=0; i<connections.length; i++) {
			if(connections[i] != null && connections[i].name == d.name) {
				Lastconnection=i+1;
				connections[i]=null;
				break;
			}
		}
		printMessage("Connection " +Lastconnection + ": " + d.name  +" Logged out");
	}
}