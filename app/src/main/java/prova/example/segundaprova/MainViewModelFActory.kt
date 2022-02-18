package prova.example.segundaprova

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import prova.example.segundaprova.api.Repository
import prova.example.segundaprova.fragments.listar.listarVM

class MainViewModelFActory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return listarVM(repository) as T
    }
}