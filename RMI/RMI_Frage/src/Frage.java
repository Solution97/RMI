import java.rmi.*;

public interface Frage extends Remote {
	public String berechne(String a) throws RemoteException;
}
