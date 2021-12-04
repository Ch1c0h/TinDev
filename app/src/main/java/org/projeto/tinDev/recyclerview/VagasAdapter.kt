package org.projeto.tinDev.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lista_vagas_fragment.view.*
import kotlinx.android.synthetic.main.recycler_view_authors.view.*
import kotlinx.android.synthetic.main.recycler_view_authors.view.button_delete
import kotlinx.android.synthetic.main.recycler_view_authors.view.button_edit
import org.projeto.tinDev.R
import org.projeto.tinDev.data.Vaga

class VagasAdapter : RecyclerView.Adapter<VagasAdapter.ListaVagasViewModel>() {
    private var vagas = mutableListOf<Vaga>()
    var listener: RecyclerViewClickListenerVaga? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListaVagasViewModel(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.lista_vagas_fragment, parent, false)
        )

    override fun getItemCount() = vagas.size

    override fun onBindViewHolder(holder: ListaVagasViewModel, position: Int) {
        holder.view.titulo_da_vaga.text = vagas[position].titulo
        holder.view.button_edit.setOnClickListener {
            listener?.onRecyclerViewItemClicked(it, vagas[position])
        }
        holder.view.button_delete.setOnClickListener {
            listener?.onRecyclerViewItemClicked(it, vagas[position])
        }
    }

    fun setVagas(vagas: List<Vaga>) {
        this.vagas = vagas as MutableList<Vaga>
        notifyDataSetChanged()
    }

    fun addVaga(vaga: Vaga) {

        if (!vagas.contains(vaga)){
            vagas.add(vaga)
        } else {

            val index = vagas.indexOf(vaga)
            if (vaga.isDeleted) {
                vagas.removeAt(index)
            } else {
                vagas[index] = vaga
            }
        }
        notifyDataSetChanged()
    }

    class ListaVagasViewModel(val view: View) : RecyclerView.ViewHolder(view)
}