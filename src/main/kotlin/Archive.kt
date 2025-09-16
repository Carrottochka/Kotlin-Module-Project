data class Archive(val name:String/*val archives: MutableList <Notes>*/)
{
   private val notes = mutableListOf<Note>()
    fun addNote(note:Note){
        notes.add(note)
    }
    fun getNotes(): List<Note> = notes.toList()
    override fun toString(): String {
        return this.name
    }
}
