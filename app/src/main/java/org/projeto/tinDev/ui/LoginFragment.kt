package org.projeto.tinDev.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.login_fragment.*
import org.projeto.tinDev.R
import org.projeto.tinDev.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_login.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_menu_contratante)
        }

//        btn_login.setOnClickListener {
//            findNavController().navigate(R.id.action_login_to_menu_Dev)
//        }

        btn_cadastrar.setOnClickListener{
            findNavController().navigate(R.id.action_login_to_perfil_cadastro)
        }
    }

}