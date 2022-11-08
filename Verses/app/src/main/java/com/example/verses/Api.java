package com.example.verses;

import com.example.verses.Verses.Verse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* Interface to defines requests & their EndPoints*/
/* It manage Api usage*/
public interface Api {

    String BASE_URL="http://api.alquran.cloud/v1/ayah/"; /* Api doc: BaseURL used in every Api request */

    /* GET request (rootThatWillBeAddedToBaseURL) */
    /* It returns with JSON array of Hero; so we stores it in List<Hero> */
    @GET("87")
    Call<Verse> getConstantVerse();

    @GET("{verseNumber}")
    Call<Verse> getDynamicVerse(@Path("verseNumber") int verseNumber);

}
