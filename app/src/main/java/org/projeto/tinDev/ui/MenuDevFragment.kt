package org.projeto.tinDev.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.projeto.tinDev.R

class MenuDevFragment : Fragment() {

    companion object {
        fun newInstance() = MenuDevFragment()
    }

    private lateinit var viewModel: MenuDevViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_dev_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuDevViewModel::class.java)
        // TODO: Use the ViewModel
    }

}