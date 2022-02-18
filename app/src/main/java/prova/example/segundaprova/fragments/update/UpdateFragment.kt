package prova.example.segundaprova.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_cadastro.view.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import prova.example.segundaprova.R
import prova.example.segundaprova.model.Igreja
import prova.example.segundaprova.model.IgrejaVm


class UpdateFragment : Fragment() {
private val args by navArgs<UpdateFragmentArgs>()
private lateinit var uIgrejaVM:IgrejaVm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view =   inflater.inflate(R.layout.fragment_update, container, false)

        uIgrejaVM=ViewModelProvider(this).get(IgrejaVm::class.java)

        view.updatenome.setText(args.currentIgreja.nome)
        view.updateendereco.setText(args.currentIgreja.endereco)
        view.updateprofeta.setText(args.currentIgreja.profeta)
        view.updatedescricao.setText(args.currentIgreja.descricao)
        view.updatefieis.setText(args.currentIgreja.fieis.toString())

        view.updatebutao.setOnClickListener {
 updateIgreja()

        }
    return view
    }
private fun updateIgreja(){
    val nome= updatenome.text.toString()
    val endereco=updateendereco.text.toString()
    val profeta= updateprofeta.text.toString()
    val descricao= updatedescricao.text.toString()
    val fieis=Integer.parseInt(updatefieis.text.toString())

if (check(nome,endereco,descricao)){
    val updateIgreja= Igreja(args.currentIgreja.id,nome,endereco,profeta,descricao,fieis)
uIgrejaVM.updateIgreja(updateIgreja)
    Toast.makeText(requireContext(),"atualização feita",Toast.LENGTH_SHORT)
    findNavController().navigate(R.id.action_updateFragment_to_homeFragment)
}else{Toast.makeText(requireContext(),"CAMPOS EM BRANCO",Toast.LENGTH_SHORT)}

}


    private fun check( nome:String,endereco:String,descricao:String): Boolean {
        return!(TextUtils.isEmpty(nome) && TextUtils.isEmpty(endereco) && TextUtils.isEmpty(descricao))
    }
}