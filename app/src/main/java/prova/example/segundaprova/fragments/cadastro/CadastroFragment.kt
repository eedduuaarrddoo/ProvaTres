package prova.example.segundaprova.fragments.cadastro

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_cadastro.*
import kotlinx.android.synthetic.main.fragment_cadastro.view.*
import prova.example.segundaprova.model.Igreja
import prova.example.segundaprova.R
import prova.example.segundaprova.model.IgrejaVm


class CadastroFragment : Fragment() {
  private lateinit var cadastrovm: IgrejaVm
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_cadastro, container, false)
        cadastrovm= ViewModelProvider(this).get(IgrejaVm::class.java)
        view.butaoCadastro.setOnClickListener {
            insertDataToDataBase()
        }
        return view
    }

    private fun insertDataToDataBase () {

        val nome=nome.text.toString()
        val endereco= endereco.text.toString()
        val profeta= profeta.text.toString()
        val descricao= descricao.text.toString()
        val fieis= fieis.text.toString()

if(check(nome,endereco,descricao)){
    val igreja= Igreja(0,nome,endereco,profeta,descricao, 0)
    cadastrovm.cadastraIgreja(igreja)
    findNavController().navigate((R.id.action_cadastroFragment_to_homeFragment))
        }else{Toast.makeText(requireContext(),"os campos de  Nome endereço e descriçao nao pode ficar em brnaco",Toast.LENGTH_SHORT).show()}

    }
private fun check( nome:String,endereco:String,descricao:String): Boolean {
    return!(TextUtils.isEmpty(nome) && TextUtils.isEmpty(endereco) && TextUtils.isEmpty(descricao))
}
}