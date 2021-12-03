package org.projeto.tinDev.recyclerview

import android.view.View
import org.projeto.tinDev.data.Author

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClicked(view: View, author: Author)
}