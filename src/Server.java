						 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Server extends UnicastRemoteObject implements ServerIF {
	
	protected Server() throws RemoteException{
		super();
	}
	private static String name = new String();
	private String nameFile = "C:\\Users\\gkstk\\Desktop\\�ڹ�\\Server\\database\\name";
	public static void main(String[] args) {
		// main �ϳ��� ���μ��� �ϳ���. �׷��ϱ� ���μ����� main�� �����ε�?
		
		try {
			
			Server server = new Server();
				Naming.rebind("AddServer", server);
				System.out.println("Server is ready!!");
		}catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // ("����� �̸�",��ü)
		
		catch(RemoteException e){
			e.printStackTrace();
		}	
		
	}
	public int add(int a, int b) {
		System.out.println("Server's response!!!");
		return a+b;
	}
	public void save(String name) {
		try {
			// ���� ��η� �ؾ߰ڳ�. FileWriter�� �� ��° ���ڰ� ���� ���� ����, �״�� ���� ����(true) �޴� �ų�. 
			BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile));
			writer.write(name);
			writer.newLine();
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		} // DB�� �ִ� ��. �������ٰ� �ٽ� �Ѻ���.
		System.out.println("����Ǿ����ϴ�");
	}
	public String read() {
		try {
			Scanner fileSc = new Scanner(new File(nameFile));
			this.name = fileSc.next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.name;
	}
	public String select() {
		String menu = "1. �̸� �����ϱ�\n2. �̸� �ҷ�����"; 
		return menu;
	}
}
