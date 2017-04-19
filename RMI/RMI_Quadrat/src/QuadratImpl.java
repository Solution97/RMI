import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class QuadratImpl implements Quadrat {

	@Override
	public long berechne(long a) throws RemoteException {
		return a * a;
	}
	
	public static void main(String[] args) {
		/*if (System.getSecurityManager() == null) {
	        System.setSecurityManager(new SecurityManager());
	    }*/
		
		try {			
			// Create a Hello remote object
			QuadratImpl h = new QuadratImpl();
			Quadrat h_stub = (Quadrat) UnicastRemoteObject.exportObject(h, 0);

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
