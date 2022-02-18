package prova.example.segundaprova.api
import prova.example.segundaprova.utils.Constants.Companion.BASE_URL

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:igrejaApi by lazy {
        retrofit.create(igrejaApi::class.java)
    }

}