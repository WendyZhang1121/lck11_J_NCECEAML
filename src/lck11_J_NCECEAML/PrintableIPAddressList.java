package lck11_J_NCECEAML;

import java.io.IOException;
import java.net.InetAddress;

class PrintableIPAddressList extends IPAddressList {

	public void addAndPrintIPAddresses(InetAddress address) {
		synchronized (getList()) { 
			addIPAddress(address);
			InetAddress[] ia = (InetAddress[]) getList().toArray(new InetAddress[0]); // ...
		}
	}
	
	public void testCase(final InetAddress address){
		Thread test = new Thread(new Runnable() {
			public void run() {
				PrintableIPAddressList testP = new PrintableIPAddressList();
				testP.addAndPrintIPAddresses(address);
				}
			});
			   test.start();
	}
	
	public void main(String[] args) throws IOException { 
		
		InetAddress addr1 = InetAddress.getByName("127.0.0.1");	
		InetAddress addr2 = InetAddress.getByName("10.190.112.3");		

		testCase(addr1); // starts thread 1 
		testCase(addr2); // starts thread 2
	}
}