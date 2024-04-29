package com.database.greatlistens.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenManager {
    private static final Map<String, String> tokenMap = new HashMap<>();

    public static String generateToken(String userId) {
        String token = UUID.randomUUID().toString();
        tokenMap.put(token, userId);
        return token;
    }

    public static String getTokenMemId(String token) {
        return tokenMap.get(token);
    }
    
    public static boolean validateToken(String token, String mem_id) {
        String storedMemId = getTokenMemId(token);
        boolean isValid = storedMemId != null && storedMemId.equals(mem_id);
        return isValid;
    }
    
    public static void invalidateToken(String token) {
        tokenMap.remove(token);
    }
}