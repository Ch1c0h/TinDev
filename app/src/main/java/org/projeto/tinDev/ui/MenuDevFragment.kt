package org.projeto.tinDev.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.menu_dev_fragment.*
import org.projeto.tinDev.R
import org.projeto.tinDev.viewmodel.MenuDevViewModel

class MenuDevFragment : Fragment() {

    companion object {
        fun newInstance() = MenuDevFragment()
    }

    private lateinit var viewModel: MenuDevViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(MenuDevViewModel::class.java)

        return inflater.inflate(R.layout.menu_dev_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_Dev_visualizar_vagas.setOnClickListener {
            findNavController().navigate(R.id.action_menu_dev_to_listagem)
        }

    }

}