import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class QuadratClient {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			
			System.out.println("Server Adresse eingeben:");
			String host = br.readLine();
			
			System.out.println("Zahl zum Quadrieren eingeben:");
			long zahl = Integer.parseInt(br.readLine());
			
			// Get remote object reference
			Registry registry = LocateRegistry.getRegistry(host);
			Quadrat h = (Quadrat) registry.lookup("Hello1");
			
			// Remote method invocation
			long res = h.berechne(zahl);
			System.out.println("Das Ergebnis lautet: " + res);
		} catch (Exception e) {
			System.err.println("Error on client: " + e);
		}
	}
}
