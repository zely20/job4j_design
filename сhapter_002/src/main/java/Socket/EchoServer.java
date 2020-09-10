package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    boolean isBye = false;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Bye")) {
                            isBye = true;
                        }
                    }
                    if (isBye) {
                        out.write(("HTTP/1.1 200 OK Server stop!!!\"\r\n\\").getBytes());
                        break;
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}
