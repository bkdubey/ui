package com.monitoring.ui.web.rest.service;

import com.jcraft.jsch.*;
import com.monitoring.ui.domain.ListResult;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;


public class Command {
    public static void ls()
    {
        Channel channel     = null;
        ChannelSftp channelSftp = null;
        Session session= new VirtualMachine().getConnection();
        try {
            channel = session.openChannel("sftp");

        channel.connect();
        channelSftp = (ChannelSftp)channel;
        channelSftp.cd("/");
        Vector filelist = channelSftp.ls("/");
        for(int i=0; i<filelist.size();i++) {
          //  System.out.println(filelist.get(i).toString());
            ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) filelist.get(i);
            System.out.println(entry.getFilename());
        }
        } catch (JSchException | SftpException e) {
                e.printStackTrace();
            }
    }

    public static JSONObject execute(String command)
    {
        //String jsonFormattedString = jsonStr.replaceAll("\\\\", "");

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        ListResult commandResult = new ListResult() ;

        String result="";

        try {



            Session session = new VirtualMachine().getConnection();

            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            InputStream in = channelExec.getInputStream();
            channelExec.setCommand(command);
            channelExec.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            int index = 0;
            String temp;
            while ((temp = reader.readLine()) != null) {
               // System.out.println(++index + " : " + temp);
                result=result+""+temp+"\n";
                jsonArray.put(temp);
            }
            jsonObject.put( command, jsonArray );

            channelExec.disconnect();
            session.disconnect();
            commandResult.setResult(jsonObject);

            System.out.println("Done!");
        }catch (Exception e)
        {

        }
        //return jsonObject;
        return commandResult.getResult();

    }
    public static void main(String[] args) throws  Exception {
        //ls();
       //execute("free -g");
        //System.out.println("execute result "+execute("du -s -h"));
        System.out.println("execute result "+execute("ls -lrth"));

    }
}

