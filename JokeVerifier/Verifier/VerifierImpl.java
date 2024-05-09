package JokeServer.JokeVerifier.Verifier;

import JokeServer.Database.DBConfig;
import JokeServer.JokeVerifier.Model.Verifier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifierImpl extends DBConfig implements VerifierInt {

    private Connection c = getCon();

    @Override
    public void addWord(Verifier verifier) {
        try (PreparedStatement ps = c.prepareStatement("INSERT INTO joke_verifier(Word) VALUES(?)")) {

            ps.setString(1, verifier.getWord());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nWord added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean retrieveAndVerifyWords(String sentence) {
        try (PreparedStatement ps = c.prepareStatement("SELECT * FROM joke_verifier");
             ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                String word = rs.getString("Word");

                if (sentence.contains(word)){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
