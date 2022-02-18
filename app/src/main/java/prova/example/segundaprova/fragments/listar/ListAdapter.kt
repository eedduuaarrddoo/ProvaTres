package prova.example.segundaprova.fragments.listar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_igreja.view.*
import prova.example.segundaprova.model.Igreja
import prova.example.segundaprova.R
import prova.example.segundaprova.fragments.listar.HomeFragmentDirections
import prova.example.segundaprova.model.Post

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var listIgreja= emptyList<Igreja>()
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_igreja,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val itemAtual=listIgreja[position]
        holder.itemView.id_txt.text=itemAtual.id.toString()
        holder.itemView.nome_txt.text=itemAtual.nome
        holder.itemView.endereco_txt.text=itemAtual.endereco
        holder.itemView.profeta_txt.text=itemAtual.profeta
        holder.itemView.descricao_txt.text=itemAtual.descricao
        holder.itemView.fieis_txt.text=itemAtual.fieis.toString()

        holder.itemView.constraintigrja.setOnClickListener{
val action=HomeFragmentDirections.actionHomeFragmentToUpdateFragment(itemAtual)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listIgreja.size
    }
    fun setData(igreja:List<Igreja>){
    this.listIgreja=igreja
        notifyDataSetChanged()
    }


}