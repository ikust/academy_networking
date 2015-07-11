package co.infinum.okhttpclientexample;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String POKE_API = "http://pokeapi.co/api/v1/";

    private static final String POKEDEX = "pokedex/1/";

    private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPokedex();
    }

    private void getPokedex() {
        Response response = null;
        Request request = new Request.Builder().url(POKE_API + POKEDEX).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("pokedex", "failed: " + e.getMessage());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.d("pokedex", "success: " + response.body().string());
            }
        });
    }
}
