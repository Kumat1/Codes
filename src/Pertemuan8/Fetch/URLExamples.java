package Pertemuan8.Fetch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by matt on 5/10/17.
 */
public class URLExamples {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://data.bmkg.go.id/propinsi_02_1.xml");
            URLConnection connection = url.openConnection();
            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String s;

            while((s = reader.readLine()) != null) {
                System.out.println(s);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
