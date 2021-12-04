package org.projeto.tinDev.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar

import org.projeto.tinDev.R

import org.projeto.tinDev.viewmodel.ListaVagasViewModel

import kotlinx.android.synthetic.main.fragment_authors.*
import org.projeto.tinDev.data.Vaga
import org.projeto.tinDev.recyclerview.RecyclerViewClickListenerVaga
import org.projeto.tinDev.recyclerview.VagasAdapter

class ListaVagasFragment : Fragment(),
    RecyclerViewClickListenerVaga {

    private lateinit var viewModel: ListaVagasViewModel
    private val adapter =
        VagasAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(ListaVagasViewModel::class.java)

        return inflater.inflate(R.layout.lista_vagas_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        adapter.listener = this

        recycler_view_authors.adapter = adapter


        viewModel.fetchVagas()


        viewModel.getRealtimeUpdates()

        viewModel.vagas.observe(viewLifecycleOwner, Observer {
            adapter.setVagas(it)
            Snackbar.make(this.requireView(), "vaga encontrada!", Snackbar.LENGTH_SHORT).show()
        })

        viewModel.vaga.observe(viewLifecycleOwner, Observer {
            adapter.addVaga(it)
        })


        btn_add.setOnClickListener {
            CadastroVagaFragment()
                .show(childFragmentManager,"")
        }
    }

    override fun onRecyclerViewItemClicked(view: View, vaga: Vaga) {
        when (view.id) {
            R.id.button_edit -> {
                CadastroVagaFragment(

                ).show(childFragmentManager, "")
            }
            R.id.button_delete -> {
                AlertDialog.Builder(requireContext()).also {
                    it.setTitle(getString(R.string.delete_confirmation))
                    it.setPositiveButton(getString(R.string.yes)) { dialog, which ->
                        viewModel.deleteVaga(vaga)
                    }
                }.create().show()
            }
        }
    }

}