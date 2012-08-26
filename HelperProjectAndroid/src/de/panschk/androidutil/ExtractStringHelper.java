package de.panschk.androidutil;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

public class ExtractStringHelper {

    public static void main (String[] args) throws IOException {
        String fileName = "C:/workspaces/git/android/de.panschk.mapquiz/src/de/panschk/mapquiz/objects/instances/LevelFactoryBonus.java";
        FileInputStream fis = new FileInputStream(fileName);
        streamToStringReplaceEntities(fis);
        fis.close();
        
    }

    private static Set<String> varNames= new HashSet<String>();
    public static void streamToStringReplaceEntities(InputStream is)
            throws IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream codeOut = new ByteArrayOutputStream();
        StringBuffer xmlOut = new StringBuffer();
        boolean inLineComment = false;
        boolean inMultilineComment = false;
        boolean inQuotes = false;
        char lastChar = ' ';
        ByteArrayOutputStream stringContent = new ByteArrayOutputStream();
        int result = bis.read();
        while (result != -1) {
            boolean inComment = inLineComment || inMultilineComment;
            byte b = (byte) result;
            // read next byte
            result = bis.read();
            boolean copyCharToBuffer = true;
            if (!inQuotes && !inComment && b == '"') {
                stringContent = new ByteArrayOutputStream();
                inQuotes = true;
                copyCharToBuffer = false;
            } else if (inQuotes && b == '"') {
                String content = stringContent.toString("UTF-8");
                String varName = makeVariableName(content);
                inQuotes = false;
                addXMLContent(varName, content, xmlOut);
                addCodeContent(varName, codeOut);
                copyCharToBuffer = false;

            } else if (inQuotes) {
                copyCharToBuffer = false;
                stringContent.write(b);

            } else if (!inComment && !inQuotes && lastChar == '/' && b == '/') {
                inLineComment = true;
            } else if (!inComment && !inQuotes && lastChar == '/' && b == '*') {
                inMultilineComment = true;
            } else if (inLineComment && b == '\n') {
                inLineComment = false;
            } else if (inMultilineComment && lastChar == '*' && b == '/') {
                inMultilineComment = false;
            }

            if (copyCharToBuffer) {
                codeOut.write(b);
            }
            lastChar = (char) b;
        }
        
        System.out.println(codeOut.toString("UTF-8"));
        System.out.println(xmlOut.toString());

    }

    private static void addCodeContent(String varName,
            ByteArrayOutputStream codeOut) throws IOException {
        String contentToAdd = "getResources().getString(R.string."+varName+")";
        byte[] bytes;
        try {
            bytes = contentToAdd.getBytes("UTF-8");
            codeOut.write(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
    }

    private static void addXMLContent(String varName, String content,
            StringBuffer xmlOut) {
        if (!varNames.contains(varName)) {
            content = content.replace("'", "\\'");
            xmlOut.append("    <string name=\"").append(varName).append("\">").append(content).append("</string>\n");
            varNames.add(varName);
        }
        
    }

    static String makeVariableName(String s) {
        s = s.replace(' ', '_');
        s = s.replaceAll("[^A-Za-z0-9_]", "").toLowerCase();
        return s;
    }

}
