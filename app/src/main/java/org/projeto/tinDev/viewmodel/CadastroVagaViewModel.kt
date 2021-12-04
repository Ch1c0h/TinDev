package org.projeto.tinDev.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import org.projeto.tinDev.data.Vaga
import org.projeto.tinDev.data.NODE_VAGA

class CadastroVagaViewModel : ViewModel() {

    private val dbVagas = FirebaseDatabase.getInstance().getReference(NODE_VAGA)

    private val _vagas = MutableLiveData<List<Vaga>>()
    val vagas: LiveData<List<Vaga>>
        get() = _vagas

    private val _vaga = MutableLiveData<Vaga>()
    val vaga: LiveData<Vaga>
        get() = _vaga


    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result

    fun addVaga(vaga: Vaga) {
        vaga.id = dbVagas.push().key
        dbVagas.child(vaga.id!!).setValue(vaga).addOnCompleteListener {
            if(it.isSuccessful) {
                _result.value = null
            } else {
                _result.value = it.exception
            }
        }
    }

    private val childEventListener = object : ChildEventListener {
        override fun onCancelled(error: DatabaseError) { }

        override fun onChildMoved(snapshot: DataSnapshot, p1: String?) { }

        override fun onChildChanged(snapshot: DataSnapshot, p1: String?) {
            val vaga = snapshot.getValue(Vaga::class.java)
            vaga?.id = snapshot.key
            _vaga.value = vaga
        }

        override fun onChildAdded(snapshot: DataSnapshot, p1: String?) {
            val vaga = snapshot.getValue(Vaga::class.java)
            vaga?.id = snapshot.key
            _vaga.value = vaga
        }

        override fun onChildRemoved(snapshot: DataSnapshot) {
            val vaga = snapshot.getValue(Vaga::class.java)
            vaga?.id = snapshot.key
            vaga?.isDeleted = true
            _vaga.value = vaga
        }
    }

    fun getRealtimeUpdates() {
        dbVagas.addChildEventListener(childEventListener)
    }

    private val valueEventListener = object : ValueEventListener {
        override fun onCancelled(error: DatabaseError) { }

        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                val vagas = mutableListOf<Vaga>()
                for (vagaSnapshot in snapshot.children) {
                    val vaga = vagaSnapshot.getValue(Vaga::class.java)
                    vaga?.id = vagaSnapshot.key
                    vaga?.let { vagas.add(it) }
                }
                _vagas.value = vagas
            }
        }
    }

    fun fetchVagas() {
        dbVagas.addListenerForSingleValueEvent(valueEventListener)
    }

    fun updateVaga(vaga: Vaga) {
        dbVagas.child(vaga.id!!).setValue(vaga).addOnCompleteListener {
            if(it.isSuccessful) {
                _result.value = null
            } else {
                _result.value = it.exception
            }
        }
    }

    fun deleteVaga(vaga: Vaga) {
        dbVagas.child(vaga.id!!).setValue(null).addOnCompleteListener {
            if(it.isSuccessful) {
                _result.value = null
            } else {
                _result.value = it.exception
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        dbVagas.removeEventListener(childEventListener)
    }

}