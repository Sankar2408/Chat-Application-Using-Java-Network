import java.net.*;
import java.io.*;

class MyServer {
    public static void main(String[] args) {
        ServerSocket ss;
        try {
            ss = new ServerSocket(3500);
            System.out.println("Server Is Listening on Port: 3500");

            Socket s = ss.accept();
            System.out.println("Connected to " + s.getInetAddress());

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "";
            String response = "";

            // Server listens for messages from the client and responds
            while (!str.equals("bye")) {
                str = din.readUTF();
                System.out.println("Client says: " + str);

                response = br.readLine();
                dout.writeUTF(response);
                dout.flush();
            }

            s.close();
            ss.close();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}
