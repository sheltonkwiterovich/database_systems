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
        // Log the incoming parameters for debugging
        System.out.println("Validating token: " + token + " for mem_id: " + mem_id);
    
        // Retrieve the mem_id associated with the token from your data store
        String storedMemId = getTokenMemId(token);
    
        // Log what was retrieved from the token
        System.out.println("Stored mem_id retrieved from token: " + storedMemId);
    
        // Check if the token exists and if it corresponds to the provided mem_id
        boolean isValid = storedMemId != null && storedMemId.equals(mem_id);
    
        // Log the result of the validation
        System.out.println("Token validation result: " + isValid);
    
        return isValid;
    }
    

    public static void invalidateToken(String token) {
        tokenMap.remove(token);
    }
}