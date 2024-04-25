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
        // Retrieve the mem_id associated with the token from your data store
        String storedMemId = getTokenMemId(token);
        
        // Check if the token exists and if it corresponds to the provided mem_id
        return storedMemId != null && storedMemId.equals(mem_id);
    }

    public static void invalidateToken(String token) {
        tokenMap.remove(token);
    }
}