package org.projeto.tinDev.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.menu_cadastro_fragment.*
import org.projeto.tinDev.R
import org.projeto.tinDev.viewmodel.MenuCadastroViewModel

class MenuCadastroFragment : Fragment() {

    companion object {
        fun newInstance() = MenuCadastroFragment()
    }

    private lateinit var viewModel: MenuCadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(MenuCadastroViewModel::class.java)

        return inflater.inflate(R.layout.menu_cadastro_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_perfil_contratante.setOnClickListener {
            findNavController().navigate(R.id.action_perfil_cadastro_to_Cadastro_contratante)
        }

        btn_perfil_dev.setOnClickListener {
            findNavController().navigate(R.id.action_Menu_cadastro_to_perfil_dev)
        }

    }

}