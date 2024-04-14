import java.util.Scanner;

public class CaesarCipher{

    String cipher(String message, int offset){
        StringBuilder result = new StringBuilder();

        for(char character: message.toCharArray()){
            if(character != ' '){
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPoistion = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char)(newAlphabetPoistion + 'a');
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    String decipher(String message, int offset){
        StringBuilder result = new StringBuilder();

        for(char character: message.toCharArray()){
            if(character != ' '){
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPoistion = (originalAlphabetPosition - offset) % 26;
                char newCharacter = (char)(newAlphabetPoistion + 'a');
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Enter the text: ");
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        CaesarCipher cipher = new CaesarCipher();
        int offset = 3;

        String cipheredMessage = cipher.cipher(message, offset);
        System.out.println("Encrypted message: " + cipheredMessage);

        String decipheredMessage = cipher.decipher(cipheredMessage, offset);
        System.out.println("Decrypted message: " + decipheredMessage);
    }
}