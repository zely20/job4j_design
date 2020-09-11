package ru.job4j.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.logger.UsageLog4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    public static void main(String[] args) {
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
        } catch (IOException e) {
            LOG.error("Exception in log", e);
        }
    }
}
