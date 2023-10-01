package com.labmanagement.util;

public class EmailUtils {
    public static String getVerificationEmailMessage(String name, String host, String token) {

        return "Hello " + name + ",\n\n" +
                "Your new account has been created. Please click the link below to verify your account:\n\n" +
                getVerificationUrl(host, token) + "\n\n" +
                "The support team.";
    }

    private static String getVerificationUrl(String host, String token) {
        return host + "/api/v1/users?token=" + token;
    }

}
