package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean isBye = false;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!isBye) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;

                    while (!(str = in.readLine()).isEmpty()) {
                        if (str != null) {
                            System.out.println(str);
                            if (str.contains("Bye")) {
                                isBye = true;
                            }
                        }
                    }

                    if (isBye) {
                        out.write(("Bye-Bye\"\r\n\\").getBytes());
                    }
                    out.write(("HTTP/1.1 200 OK\"\r\n\\").getBytes());
                    out.write("Hello, dear friend.".getBytes());
                }
            }
        }
    }
}
