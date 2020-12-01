package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	public static final int SERVER_PORT = 8189;

	public static Thread runConsole(DataOutputStream out) throws IOException{
		Thread thread = new Thread( () -> {
			try {
				Scanner scanner = new Scanner(System.in);
				while (true){
					String message = scanner.next();
					out.writeUTF(message);
					if(message.equals("/exit")){
						break;
					}
				}
			} catch (IOException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
		});
		thread.start();
		return (thread);
	}

	public static void main(String[] args) {

		try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT);){
			System.out.println("Ожидаем подключения...");

			Socket clientSocket = serverSocket.accept();
			System.out.println("Соединение установлено!");

			// открытие потоков для связи
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

			Thread console = null;
			console = runConsole(out);

			// цикл для постоянного прослушивания сообщений
			while(true){
				String message = in.readUTF(); //сервер считывает сообщение, переданное клиентом на сервер
				System.out.println("Сообщение пользователя: " + message);
				if(message.equals("/exit")){
					break;
				}
				out.writeUTF("Ответ от сервера: " + message.toUpperCase()); //добавляет к нему фразу «...» и отправляет обратно клиенту
			}

			System.out.println("Соединение потеряно");
		}
		catch (IOException e){
			System.out.println("Порт уже занят");
			e.printStackTrace();
		}


	}
}
