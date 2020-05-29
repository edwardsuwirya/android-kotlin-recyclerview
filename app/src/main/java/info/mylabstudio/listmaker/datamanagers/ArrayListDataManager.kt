package info.mylabstudio.listmaker.datamanagers

import info.mylabstudio.listmaker.models.Language

class ArrayListDataManager() :
    ListDataManager {
    private val listTitles = arrayListOf(
        Language("Golang"),
        Language("React"),
        Language("Android Kotlin")
    )

    override fun saveList(lang: Language) {
        listTitles.add(lang)
    }

    override fun readList(): ArrayList<Language> {
        return listTitles
    }
}