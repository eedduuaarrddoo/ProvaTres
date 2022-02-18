package prova.example.segundaprova.api

import prova.example.segundaprova.model.Igreja
import prova.example.segundaprova.model.Post
import retrofit2.http.GET

interface igrejaApi {
    @GET("api/v1/igreja")
    suspend fun getPost(): ArrayList<Post>

}