package org.projeto.tinDev.recyclerview

import android.view.View
import org.projeto.tinDev.data.Author
import org.projeto.tinDev.data.Vaga

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClicked(view: View, author: Author)
}


interface RecyclerViewClickListenerVaga {
    fun onRecyclerViewItemClicked(view: View, vaga: Vaga)
}