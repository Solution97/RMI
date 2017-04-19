import java.rmi.*;

public interface Quadrat extends Remote {
	public long berechne(long a) throws RemoteException;
}
