package firstprogramm;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class FirstProgramm {
    public static void main(String args[]) {
        int length = 5;
        int choose;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите в каком режиме хотите запустить программу:");
        System.out.println("1.В однопоточном режиме");
        System.out.println("2.В многопоточном режиме");
        choose = input.nextInt();
        if(choose==1){
            OneThread();
        }
        else {
            ManyThread();
        }

    }
    public static String OneThread(){
        String hash1 = "1115dd800feaacefdf481f1f9070374a2a81e27880f187396db67958b207cbad";
        String hash2 = "3a7bd3e2360a3d29eea436fcfb7e44c735d117c42d1c1835420b6b9942dd4f1b";
        String hash3 = "74e1bb62f8dabb8125a58852b63bdf6eaef667cb56ac7f7cdba6d7305c50a22f";
        long m = System.currentTimeMillis();
        System.out.println(FirstWord(hash1));
        System.out.println((Time() - m) / 1000. + " sec");
        System.out.println(SecondWord(hash2));
        System.out.println((Time() - m) / 1000. + " sec");
        System.out.println(ThirdWord(hash3));
        System.out.println((Time() - m) / 1000. + " sec");
        return null;

    }
    public static String ManyThread(){
        String hash1 = "1115dd800feaacefdf481f1f9070374a2a81e27880f187396db67958b207cbad";
        String hash2 = "3a7bd3e2360a3d29eea436fcfb7e44c735d117c42d1c1835420b6b9942dd4f1b";
        String hash3 = "74e1bb62f8dabb8125a58852b63bdf6eaef667cb56ac7f7cdba6d7305c50a22f";
        long m = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(FirstWord(hash1));
                System.out.println((Time() - m) / 1000. + " sec");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(SecondWord(hash2));
                System.out.println((Time() - m) / 1000. + " sec");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ThirdWord(hash3));
                System.out.println((Time() - m) / 1000. + " sec");
            }
        });
        thread.start();
        thread2.start();
        thread3.start();
        return null;
    }
    public static long Time() {
        long m = System.currentTimeMillis();
        return m;
    }

    public static String FirstWord(String temp1) {
        String temp = "";
        String pass = "";
        MessageDigest digest = null;
        while (!Objects.equals(temp1, temp)) {
            pass = String.valueOf(generatePswd(5));
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
            temp = bytesToHex(hash);
        }
        return pass;
    }

    public static String SecondWord(String temp1) {
        String temp = "";
        String pass = "";
        MessageDigest digest = null;
        while (!Objects.equals(temp1, temp)) {
            pass = String.valueOf(generatePswd(5));
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
            temp = bytesToHex(hash);
        }
        return pass;
    }

    public static String ThirdWord(String temp1) {
        String temp = "";
        String pass = "";
        MessageDigest digest = null;
        while (!Objects.equals(temp1, temp)) {
            pass = String.valueOf(generatePswd(5));
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
            temp = bytesToHex(hash);
        }
        return pass;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static char[] generatePswd(int len) {
        String charsCaps = "abcdefghijklmopqrstuvwxyz";
        String passSymbols = charsCaps;
        Random rnd = new Random();
        char[] password = new char[len];

        for (int i = 0; i < len; i++) {
            password[i] = passSymbols.charAt(rnd.nextInt(passSymbols.length()));
        }
        return password;

    }
}
