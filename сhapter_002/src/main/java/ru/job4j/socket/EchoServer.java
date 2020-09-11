package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean isBye = false;
        String result = "";
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!isBye) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str != null) {
                            if(str.contains("?msg")){
                               result = Arrays.stream(str.split(" "))
                                        .filter(word -> word.contains("="))
                                        .map(line -> line.split("=")[1])
                                        .findFirst()
                                        .get();
                                System.out.println(str);
                            }
                           // System.out.println(str);
                            if (result.equals("Bye")) {
                                isBye = true;
                            }
                        }
                    }
                    out.write(("HTTP/1.1 200 OK\r\n\r\n").getBytes());
                    out.write(result.getBytes());
                }
            }
        }
    }
}
