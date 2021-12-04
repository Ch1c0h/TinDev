package org.projeto.tinDev.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.cadastro_contratante_fragment.*
import org.projeto.tinDev.R
import org.projeto.tinDev.viewmodel.CadastroContratanteViewModel

class CadastroContratanteFragment : Fragment() {

    companion object {
        fun newInstance() = CadastroContratanteFragment()
    }

    private lateinit var viewModel: CadastroContratanteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(CadastroContratanteViewModel::class.java)
        return inflater.inflate(R.layout.cadastro_contratante_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_add_contratante.setOnClickListener {
            findNavController().navigate(R.id.action_Cadastro_Contratante_To_Login)
        }
    }

}