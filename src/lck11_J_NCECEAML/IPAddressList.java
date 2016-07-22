package lck11_J_NCECEAML;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//This class could change its locking policy in the future, 
// for example, if new non-atomic methods are added
class IPAddressList {

		private final List<InetAddress> ips = Collections.synchronizedList(new ArrayList<InetAddress>());
		public List<InetAddress> getList() {
			return ips; // No defensive copies required
			//as visibility is package-private
		}
		
		public void addIPAddress(InetAddress address) { 
			ips.add(address);
		} 
}


