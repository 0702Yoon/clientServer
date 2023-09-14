						 

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
	private String nameFile = "C:\\Users\\gkstk\\Desktop\\자바\\Server\\database\\name";
	public static void main(String[] args) {
		// main 하나씩 프로세스 하나임. 그러니까 프로세스는 main이 기준인듯?
		
		try {
			
			Server server = new Server();
				Naming.rebind("AddServer", server);
				System.out.println("Server is ready!!");
		}catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // ("등록할 이름",객체)
		
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
			// 절대 경로로 해야겠네. FileWriter의 두 번째 인자가 새로 적을 껀지, 그대로 적을 껀지(true) 받는 거네. 
			BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile));
			writer.write(name);
			writer.newLine();
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		} // DB에 넣는 것. 서버껐다가 다시 켜보기.
		System.out.println("저장되었습니다");
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
		String menu = "1. 이름 저장하기\n2. 이름 불러오기"; 
		return menu;
	}
}
