import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class FrageClient {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			
			System.out.println("Server Adresse eingeben:");
			String host = br.readLine();
			
			System.out.println("frage zum Quadrieren eingeben:");
			String zahl = br.readLine();
			
			// Get remote object reference
			Registry registry = LocateRegistry.getRegistry(host);
			Frage h = (Frage) registry.lookup("Hello1");
			
			// Remote method invocation
			String res = h.berechne(zahl);
			System.out.println(res);
		} catch (Exception e) {
			System.err.println("Error on client: " + e);
		}
	}
}
