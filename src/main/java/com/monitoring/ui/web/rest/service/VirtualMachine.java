package com.monitoring.ui.web.rest.service;

import com.jcraft.jsch.*;
import  java.io.*;
import java.util.*;

public class VirtualMachine {
    public static void main(String[] args) {
        new VirtualMachine().getConnection();
    }

    public Session getConnection()
    {
        String user = "bk";
        String password = "12345";
        String host = "192.168.1.10";
        int port = 22;
        String remoteFile = "/home/john/test.txt";
        Session session=null;
        try {
            JSch jsch = new JSch();
             session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            System.out.println("Connection established.");
            System.out.println("Crating SFTP Channel.");
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            System.out.println("SFTP Channel created.");

            // dont need remote file
           /* InputStream inputStream = sftpChannel.get(remoteFile);

            try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }*///catch (JSchException | SftpException e)
        } catch (JSchException  e) {
            e.printStackTrace();
        }
        return session;
    }
}
