import java.net.*;
import java.io.*;

class MyClient {
    public static void main(String[] args) {
        try {
            System.out.println("Connecting to Server on Port: 3500");
            Socket cs = new Socket("127.0.0.1", 3500);
            System.out.println("Connected to Server");
            DataInputStream din = new DataInputStream(cs.getInputStream());
            DataOutputStream dout = new DataOutputStream(cs.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "", response = "";
            while (!str.equals("bye")) {
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                response = din.readUTF();
                System.out.println("Server says: " + response);
            }

            cs.close();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}
