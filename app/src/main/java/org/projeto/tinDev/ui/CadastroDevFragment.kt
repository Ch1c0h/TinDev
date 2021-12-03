package org.projeto.tinDev.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.projeto.tinDev.R
import org.projeto.tinDev.viewmodel.CadastroDevViewModel

class CadastroDevFragment : Fragment() {

    companion object {
        fun newInstance() = CadastroDevFragment()
    }

    private lateinit var viewModel: CadastroDevViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastro_dev_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CadastroDevViewModel::class.java)
        // TODO: Use the ViewModel
    }

}