package itf;



import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerIF extends Remote{
	int add(int a, int b) throws RemoteException;
	void save(String a) throws RemoteException;
	String read() throws RemoteException;
	String select() throws RemoteException;
}
