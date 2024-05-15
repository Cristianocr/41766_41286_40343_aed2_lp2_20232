package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.Random;

public class ORCIDGenerator {
    public static String generateUniqueORCID(String nome, String sobrenome) {
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        String initials = (nome.substring(0, 1) + sobrenome.substring(0, 1)).toUpperCase();
        return initials + "-" + randomNumber;
    }
}
