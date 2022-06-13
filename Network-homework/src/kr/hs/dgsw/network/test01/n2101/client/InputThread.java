package kr.hs.dgsw.network.test01.n2101.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class InputThread extends Thread{
    Socket socket;
    public InputStream inputStream;
    BufferedReader bufferedReader;
    InputThread(Socket socket) {
        this.socket = socket;
        try {
            this.inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));
            this.start();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void run() {
        while (true) {
            try {
                String get = bufferedReader.readLine();
                if(get.equals("<<DOWNLOAD>>")) {
                    int size = this.receiveFile("C:\\Users\\DGSW\\Downloads");
                    if(size == -1) {
                        System.out.println("** ���� �ٿ�ε忡 �����Ͽ����ϴ�. **");
                    }
                    System.out.println("** �ٿ�ε� �Ϸ��߽��ϴ�. **");
                }
                else if(get.equals("<<QUESTION>>")) {
                    System.out.println(bufferedReader.readLine());
                }
                else {
                    System.out.println(get);
                }
            } catch (IOException e) {
                if(e.getMessage().equals("** ������ �ݽ��ϴ�. **")) {
                    break;
                }
            }
        }
    }

    public int receiveFile(String dir) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.inputStream);
        DataInputStream dis = new DataInputStream(bufferedInputStream);
        try {
            String fileName = dis.readUTF();
            long receiveFileSize = dis.readLong();
            FileOutputStream fos = new FileOutputStream(dir + '/' + fileName);
            int readSize = 0;
            int fileSize = 0;
            byte[] bytes = new byte[8192];
            while (true) {
                readSize = dis.read(bytes);
                fos.write(bytes, 0, readSize);
                fileSize += readSize;
                if (fileSize == receiveFileSize) {
                    break;
                }
            }
            return fileSize;
        } catch (IOException exception) {
            return -1;
        }
    }
}