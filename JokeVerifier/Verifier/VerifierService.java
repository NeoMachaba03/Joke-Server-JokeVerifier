package JokeServer.JokeVerifier.Verifier;

import JokeServer.JokeVerifier.Model.Verifier;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VerifierService {

    private VerifierImpl verifierImpl = new VerifierImpl();
    private Scanner input = new Scanner(System.in);

    public void addWord(){
        System.out.print("Enter a word: ");
        while (true){
            try {
                String word = input.nextLine();

                Verifier verifier = new Verifier(0,word);
                verifierImpl.addWord(verifier);

                System.out.println("\nDo you want to add another word?(Yes/No)");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("Yes")){
                    System.out.print("Enter a word: ");
                } else if (choice.equalsIgnoreCase("No")) {
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("\nInvalid entry!!! Please try again");
            }
        }
    }
}
