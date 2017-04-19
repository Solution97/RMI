import java.rmi.*;

public interface Hello extends Remote {
	// A method provided by the
	// remore object
	public String sayHello() throws RemoteException;
}