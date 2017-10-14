/**
 * Created by usmannoor on 12/10/2017.
 */


import java.util.Scanner;

public class task {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Press e for encryption OR d for decryption");
        char option = in.next().charAt(0);
        switch (option) {
            case 'e':
                //encrypt
                Scanner in2 = new Scanner(System.in);
                System.out.println("Enter String to Encrypt: ");
                String plainText = in2.nextLine();
                byte[] temp = plainText.getBytes();
                byte[] plain = new byte[8];
                for (int i = 0; i < 8; i++) {
                    plain[i] = temp[i];
                }
                System.out.println("Enter key (Length - 8 alphanumberic) ");
                String key = in2.nextLine();
                byte[] temp2 = key.getBytes();
                byte[] theKey = new byte[8];
                for (int i = 0; i < 8; i++) {
                    theKey[i] = temp2[i];
                }
                DESSubkeysTest a = new DESSubkeysTest();
                try {
                    byte[][] subKeys = a.getSubkeys(theKey);
                    DESCipherTest b = new DESCipherTest();
                    byte[] cipher = b.cipherBlock(plain, subKeys);
                    String s = new String(cipher);
                    System.out.println("Cipher Text: " + s);
                } catch (Exception e) {
                    //error
                }
                break;


            case 'd':
                //decrypt
                Scanner in3 = new Scanner(System.in);
                System.out.println("Enter String to Decrypt: ");
                String cipherText = in3.nextLine();
                byte[] x = cipherText.getBytes();
                byte[] cipher = new byte[8];
                for (int i = 0; i < 8; i++) {
                    cipher[i] = x[i];
                }
                System.out.println("Enter key (Length - 8 alphanumberic) ");
                String key2 = in3.nextLine();
                byte[] x2 = key2.getBytes();
                byte[] keyFinal = new byte[8];
                for (int i = 0; i < 8; i++) {
                    keyFinal[i] = x2[i];
                }
                DESSubkeysTest y = new DESSubkeysTest();
                try {
                    byte[][] subKeys = y.getSubkeys(keyFinal);
                    DESCipherTest b = new DESCipherTest();
                    byte[] decrypted = b.cipherBlockDecrypt(cipher, subKeys);
                    String s = new String(decrypted);
                    System.out.println("Decrypted Text: " + s);
                } catch (Exception e) {
                    //error
                }
                break;

            default:
                System.out.println("Wrong Input");
                break;
        }
    }

}
