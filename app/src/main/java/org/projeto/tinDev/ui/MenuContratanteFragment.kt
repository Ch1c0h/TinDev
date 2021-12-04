package org.projeto.tinDev.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.menu_contratante_fragment.*
import org.projeto.tinDev.R
import org.projeto.tinDev.viewmodel.MenuContratanteViewModel

class MenuContratanteFragment : Fragment() {

    companion object {
        fun newInstance() = MenuContratanteFragment()
    }

    private lateinit var viewModel: MenuContratanteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(MenuContratanteViewModel::class.java)

        return inflater.inflate(R.layout.menu_contratante_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_cadastrar_vagas.setOnClickListener {
            findNavController().navigate(R.id.action_menu_contratante_to_cadastro_vagas)
        }

        btn_visualizar_vagas.setOnClickListener {
            findNavController().navigate(R.id.action_menu_contratante_to_Listagem_vagas)
        }


    }

}