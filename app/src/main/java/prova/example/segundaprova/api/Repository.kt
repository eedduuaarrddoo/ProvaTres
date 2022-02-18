package prova.example.segundaprova.api

import prova.example.segundaprova.model.Igreja
import prova.example.segundaprova.model.Post
import java.util.ArrayList

class Repository {
    suspend fun getPost(): List<Post> {
        return RetrofitInstance.api.getPost()
    }
}