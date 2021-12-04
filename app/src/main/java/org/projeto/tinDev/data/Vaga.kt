package org.projeto.tinDev.data

import com.google.firebase.database.Exclude

data class Vaga (
    @get:Exclude
    var id: String? = null,
    var titulo: String? = null,
    var descricao: String? = null,
    @get:Exclude
    var isDeleted: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        return if (other is Vaga) {
            other.id == id
        } else false
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (titulo?.hashCode() ?: 0)
        return result
    }
}


