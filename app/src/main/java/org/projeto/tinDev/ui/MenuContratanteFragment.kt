package org.projeto.tinDev.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.projeto.tinDev.R

class MenuContratanteFragment : Fragment() {

    companion object {
        fun newInstance() = MenuContratanteFragment()
    }

    private lateinit var viewModel: MenuContratanteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_contratante_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuContratanteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}