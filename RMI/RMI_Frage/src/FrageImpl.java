import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class FrageImpl implements Frage {

	@Override
	public String berechne(String a) throws RemoteException {
		return "Die Antwort auf deine Frage ->" +a+ "<- ist wahrscheinlich 61";
	}
	
	public static void main(String[] args) {
		/*if (System.getSecurityManager() == null) {
	        System.setSecurityManager(new SecurityManager());
	    }*/
		
		try {			
			// Create a Hello remote object
			FrageImpl h = new FrageImpl();
			Frage h_stub = (Frage) UnicastRemoteObject.exportObject(h, 0);

			//REGISTRY_PORT = 1099
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			
			// Register the remote object in RMI registry with a given identifier
			Registry registry = LocateRegistry.getRegistry();

			registry.bind("Hello1", h_stub);

			System.out.println("Server ready");
		} catch (Exception e) {
			System.err.println("Error on server :" + e);
			e.printStackTrace();
		}
	}

}
