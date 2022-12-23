package com.esc.springcinema.captcha;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class VerifyRecaptcha {
    public static final String url = "https://www.google.com/recaptcha/api/siteverify";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static String secret;

    public static void setSecretKey(String key) {
        secret = key;
    }

    public static boolean verify(String recaptchaResponse) throws IOException {
        if(recaptchaResponse == null || recaptchaResponse.equals("")) {
            return false;
        }
        try {
            URL obj = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) obj.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("USER_AGENT", USER_AGENT);
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            String postParam = "secret=" + secret + "&response=" + recaptchaResponse;

            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(postParam);
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();

            return jsonObject.getBoolean("success");
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
