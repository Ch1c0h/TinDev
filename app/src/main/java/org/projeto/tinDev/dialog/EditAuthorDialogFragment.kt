package org.projeto.tinDev.dialog

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
import kotlinx.android.synthetic.main.dialog_fragment_edit_author.*

import org.projeto.tinDev.R
import org.projeto.tinDev.data.Author
import org.projeto.tinDev.viewmodel.AuthorsViewModel

class EditAuthorDialogFragment(private val author: Author) : DialogFragment() {

    private lateinit var viewModel: AuthorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(AuthorsViewModel::class.java)

        return inflater.inflate(R.layout.dialog_fragment_edit_author, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Material_Light_Dialog_MinWidth)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        et_name.setText(author.name)
        et_descricao.setText(author.descricao)


        viewModel.result.observe(viewLifecycleOwner, Observer {
            val message = if (it == null) {
                getString(R.string.author_updated)
            } else {
                getString(R.string.error, it.message)
            }

            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            dismiss()
        })


        btn_edit_author.setOnClickListener {
            val name = et_name.text.toString().trim()
            val descricao = et_descricao.text.toString()
            if (name.isEmpty()) {
                input_layout_name.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }

            author.name = name
            author.descricao = descricao
            viewModel.updateAuthor(author)
        }
    }

}
