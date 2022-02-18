package prova.example.segundaprova.fragments.listar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_igreja.view.*
import prova.example.segundaprova.R
import prova.example.segundaprova.model.Igreja
import prova.example.segundaprova.model.Post

class PostAdapter() : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    private var listIgrejaPost= emptyList<Post>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_igreja,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemAtual = listIgrejaPost[position]
        holder.itemView.id_txt.text = itemAtual.id.toString()
        holder.itemView.nome_txt.text = itemAtual.nome
        holder.itemView.profeta_txt.text = itemAtual.profeta
        holder.itemView.fieis_txt.text = itemAtual.numfieis.toString()
        holder.itemView.descricao_txt.text = itemAtual.descricao.toString()
    }

    override fun getItemCount(): Int {
        return listIgrejaPost.size
    }

    fun setDataRemote(igreja:List<Post>){
        this.listIgrejaPost=igreja
        notifyDataSetChanged()
    }

}