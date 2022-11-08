package com.example.verses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.verses.Verses.Verse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvAyah= findViewById(R.id.tvAyah);
        TextView tvSurah= findViewById(R.id.tvSurrah);
        Button btn=findViewById(R.id.button);
        EditText et=findViewById(R.id.editText);

        int verseNumber;

        //Call<Verse> callConstantVerse = SingletonRetrofitClient.getInstance().getApi().getConstantVerse();
        //Call<Verse> callDynamicVerse = SingletonRetrofitClient.getInstance().getApi().getDynamicVerse(3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Verse> callDynamicVerse = SingletonRetrofitClient.getInstance().getApi().getDynamicVerse(Integer.parseInt(et.getText().toString()));
                callDynamicVerse.enqueue(new Callback<Verse>() {
                    @Override
                    public void onResponse(Call<Verse> call, Response<Verse> response) {
                        Verse verse= response.body();
                        String verseString= verse.getData().getText();
                        String verseSurah= verse.getData().getSurah().getName();
                        tvAyah.setText(verseString);
                        tvSurah.setText(verseSurah);
                    }

                    @Override
                    public void onFailure(Call<Verse> call, Throwable t) {
                        tvAyah.setText("Ahhh");
                        Log.d("ahhhhhhhhhhhhhhhhhhh","");
                    }
                });
            }
        });



    }
}