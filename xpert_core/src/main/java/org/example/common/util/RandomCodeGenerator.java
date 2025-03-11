package org.example.common.util;

import java.util.Random;

public class RandomCodeGenerator {

    public static String generate() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 1; i < 5; i++) {
            code.append(random.nextInt(10));
        }

        return code.toString();
    }
}
