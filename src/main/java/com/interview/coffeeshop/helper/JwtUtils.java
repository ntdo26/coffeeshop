package com.interview.coffeeshop.helper;

import java.util.List;
import java.util.Random;

/*
I do not time to integrate with JWT. So i use this class to assume that
we have jwt and can get some properties from jwt.
 */
public class JwtUtils {

    private final static Random RANDOM = new Random();
    private final static List<String> MOCK_USER_IDS = List.of(
            "e6826fca-49d8-4725-abf1-dc22b101b1f2",
            "cd594625-007f-4be0-a52c-5cf8f09e3d39",
            "0b1bf2d5-4d74-41e9-ad33-0d606b35639c",
            "9a5cf910-0d39-4678-aad2-65e83a20c587"
    );

    // TODO : it should extract userId from JWT
    public static String getUserId() {
        return MOCK_USER_IDS.get(RANDOM.nextInt(MOCK_USER_IDS.size()));
    }

}
