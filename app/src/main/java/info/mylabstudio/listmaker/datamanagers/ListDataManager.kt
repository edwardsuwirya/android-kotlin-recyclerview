package info.mylabstudio.listmaker.datamanagers

import info.mylabstudio.listmaker.models.Language

interface ListDataManager {
    fun saveList(lang: Language)
    fun readList(): ArrayList<Language>
}