package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if(messageLen == 0){
            return 1;
        } else if (messageLen % rows == 0){
            return messageLen/rows;
        } else {
            return (messageLen/rows) +1;
        }
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        String[][] encryptMessage = new String[rows][determineColumns(message.length(), rows)];
        int count = 0;
        for(int i = 0; i<encryptMessage.length; i++){
            for(int j = 0; j<encryptMessage[0].length; j++){
                if(count>=message.length()){
                    encryptMessage[i][j] = "=";
                } else {
                    encryptMessage[i][j] = message.substring(count, count+1);
                    count++;
                }
            }
        }
        return encryptMessage;
    }

    public static String encryptMessage(String message, int rows){
        String encrypt = "";
        String[][] arr = generateEncryptArray(message, rows);
        for(int i = arr[0].length-1; i>=0; i--){
            for(int j = 0; j<arr.length; j++){
                encrypt += arr[j][i];
            }
        }
        return encrypt;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        String[][] decrypt = new String[rows][determineColumns(encryptedMessage.length(), rows)];
        int count = 0;
        String encrypted = "";

        for(int i = decrypt[0].length-1; i>=0; i--){
            for(int j = 0; j<decrypt.length; j++){
                if(count < encryptedMessage.length()){
                decrypt[j][i] = encryptedMessage.substring(count, count+1);
                count++;
                }
            }
        }
        for(int i = 0; i<decrypt.length; i++){
            for(int j = 0; j<decrypt[0].length; j++){
                if(decrypt[i][j] == null || decrypt[i][j].equals("=")){
                    break;
                } else {
                encrypted += decrypt[i][j];
                }
            }

        }
        return encrypted;
    }
}