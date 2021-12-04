package org.projeto.tinDev.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.cadastro_vaga_fragment.*

import org.projeto.tinDev.R
import org.projeto.tinDev.data.Vaga
import org.projeto.tinDev.viewmodel.CadastroVagaViewModel

class CadastroVagaFragment : DialogFragment() {

    private lateinit var viewModel: CadastroVagaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(CadastroVagaViewModel::class.java)

        return inflater.inflate(R.layout.cadastro_vaga_fragment, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Material_Light_Dialog_MinWidth)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel.result.observe(viewLifecycleOwner, Observer {
            val message = if (it == null) {
                getString(R.string.vaga_added)
            } else {
                getString(R.string.error, it.message)
            }

            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            dismiss()
        })


        btn_add_vaga.setOnClickListener {
            val titulo = input_titulo_vaga.text.toString().trim()
            val descricao = input_descricao_vaga.text.toString()

            if (titulo.isEmpty()) {
                input_titulo_vaga.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }

            val vaga = Vaga()
            vaga.titulo = titulo
            vaga.descricao = descricao
            viewModel.addVaga(vaga)

            findNavController().navigate(R.id.action_menu_contratante_to_Listagem_vagas)
        }
    }

}