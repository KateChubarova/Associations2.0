package com.crocodile.myapplication;

import android.content.Context;

import com.crocodile.myapplication.model.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

/**
 * Created by ekaterinachubarova on 25.08.16.
 */
public class CountryJSONSerializer {
    private Context context;
    private String fileName;

    public CountryJSONSerializer(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public void saveCountries(HashMap<Integer, Country> countries) throws JSONException, IOException {

        JSONArray countryArray = new JSONArray();
        for (int i = 0; i < 25; i++) {
            countryArray.put(countries.get(i).toJSON());
        }
        Writer writer = null;
        try {
            OutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(outputStream);
            writer.write(countryArray.toString());

        } catch (FileNotFoundException e){
        }
        finally {
            if (writer != null)
                writer.close();;
        }
    }

    public HashMap<Integer, Country> loadCountries () throws IOException, JSONException {
        HashMap<Integer, Country> countries = new HashMap<>();

        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = context.openFileInput(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonString = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                jsonString.append(line);
            }

            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();

            for (int i=0; i<array.length(); i++){
                countries.put(i, new Country(array.getJSONObject(i)));
            }

        } catch (FileNotFoundException e) {

            countries = new HashMap<>();
            int count = 25;
            Country country;
            for (int i = 0; i < count; i++) {
                country = new Country();

                if (i == 0) {
                    country.setIsOpen(Country.LEVEL_OPENED);
                }

                countries.put(i, country);
            }
        } finally {
            if (bufferedReader != null)
                bufferedReader.close();
        }

        return countries;
    }

}
