package com.expedia.validator.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileReader {

    /**
     * Returns the file as String
     * @param location
     * @return String value of the json file
     * @throws Exception
     */
    public static String getFile(String location) throws Exception {
        Resource resource = new ClassPathResource(location);
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }
}
