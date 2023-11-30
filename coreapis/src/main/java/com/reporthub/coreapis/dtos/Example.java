package com.reporthub.coreapis.dtos;

import com.reporthub.coreapis.dtos.shield.PcpCapReport;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
       /* String str = "Ant Maven Gradle";
        String errRsp =
                """
                        {"error":{"code":"DSA:V:USR:NU","description":"No active user found","id":null,"timestamp":"2023.07.07@08:34:56.273"}}
                        """;

        System.out.println(errRsp);
        byte[] byteStringArray = errRsp.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(byteStringArray);*/

     /*   String jsonFilePath = "C:\\Users\\rkuma642\\Desktop\\LENS_LOGS\\PCPPanelRoster_Community Plan_521759780_07182023035404670.json";
        File srcFile = new File(jsonFilePath);
        System.out.println(srcFile.getName());
        if (srcFile.createNewFile()) {
            System.out.println("created..");
        } else {
            System.out.println("not created...");
        }*/
/*
        Field field[] =PcpData.class.getDeclaredFields();
        System.out.println(Arrays.stream(field).map(Field::getName).collect(Collectors.toList()));*/

 /*       ObjectMapper oMapper = new ObjectMapper();

        Student obj = new Student();
        obj.setName("kumarRajamoni");
        obj.setAge(24);
        obj.setSkill("java,python");
        Map<String, Object> map = oMapper.convertValue(obj, Map.class);
        System.out.println(map);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(map.getOrDefault(entry.getKey(),""));
        }*/

/*        String downloadPath = "C:\\Users\\rkuma642\\AppData\\Local\\Temp\\";
        File targetFile = new File(downloadPath);
        String singleFileName = "AugustHelloWorld.ZIP";
        String fileType = "ZIP";
       //case-1
        File tempFile = File.createTempFile(singleFileName.substring(0, singleFileName.indexOf(".")), "."+fileType,targetFile);
        System.out.println(tempFile.getAbsolutePath());
        System.out.println(tempFile.exists());

        //case-2
        File tempFile2 = new File(targetFile, singleFileName);
        if (tempFile2.createNewFile()) {
            System.out.println("created ...");
        } else {
            System.out.println("file already exist..");
        }
        System.out.println(tempFile2.exists());
        System.out.println(tempFile2.getAbsolutePath());*/

   /*     int offset = 1;
        int LIMIT = 25;
        for (int i=1; i<=40;i++) {
            System.out.println(offset);
            offset = offset + LIMIT;
        }*/

        /*
        byte b[] = {65,97,66,98,67,100};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(b);
        System.out.println(inputStream.read());
        */

        System.out.println(getPcpCapReport() == null);

    }


    public static PcpCapReport getPcpCapReport() {
        //return PcpCapReport.builder().build();
        PcpCapReport report = null;
        return report;
    }
}
