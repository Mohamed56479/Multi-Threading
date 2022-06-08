import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Network{
	public static void main(String[] args) {
		Router r=new Router();
		
		ArrayList<Device> devices = new ArrayList<>();

	     
	     //take number of connections
	     String temp = JOptionPane.showInputDialog("Entre the number of WI-FI connection");
			int numberofconnections= Integer.parseInt(temp);
	     
	     if (numberofconnections< 1) {
	    	 System.out.println("Erorr Cannot Take Number Of Connections Less Than One");
	            System.exit(0);
	        } else {
	            r = new Router(numberofconnections);
	        }
	     //take number of device
	     String temp2 = JOptionPane.showInputDialog("Entre the number of devices Client want to connect");
			int numberofdevices= Integer.parseInt(temp2);
	     
	     if ( numberofdevices < 1) {
	            System.out.println("Erorr Cannot Take Number Of Device Less Than One");
	            System.exit(0);
	            
	     } else
	           {
	    	 //this loop take the info of devices
	            for (int i = 0; i < numberofdevices; i++) {
	            	
	            	String name = JOptionPane.showInputDialog("Enter the name of device " + (i+1));
	                String Type= JOptionPane.showInputDialog("Enter the type of device " + (i+1));
	            	
	                Device d= new Device(name,Type,r);
	                devices.add(d);
	            }
	        }
	     //this loop set connection to device
	     for (int i = 0; i < devices.size(); i++) {
	            try {
	                Thread.sleep(500);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            devices.get(i).start();
	        }

	}
}