import java.util.Scanner

class Manager {
    private var archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    fun start() {
        while (true) {
            println("\n=== МЕНЕДЖЕР ЗАМЕТОК ===")
            println("1 - Создать архив")
            println("2 - Просмотреть архивы")
            println("3 - Выбрать архив")
            println("4 - Выход")
            print("Выберите действие: ")

            when (scanner.nextLine().trim()) {
                "1" -> createArchive()
                "2" -> displayArchives()
                "3" -> chooseArchive()
                "4" -> {
                    println("Выход из программы...")
                    return
                }
                else -> println("Неверный ввод. Попробуйте снова.")
            }
        }
    }

    fun createArchive() {
        println("Введите название архива:")
        val nameOfArchive = scanner.nextLine().trim()
        if (nameOfArchive.isEmpty()) {
            println("Ошибка: название архива не должно быть пустым.")
            return
        }
        archives.add(Archive(nameOfArchive))
        println("Архив '$nameOfArchive' создан")
    }

    fun displayArchives() {
        if (archives.isEmpty()) {
            println("Нет созданных архивов.")
            return
        }
        println("\nСписок архивов:")
        archives.forEachIndexed { index, archive ->
            println("${index + 1}. $archive (заметок: ${archive.getNotes().size})")
        }
    }

    fun chooseArchive() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов. Сначала создайте архив.")
            return
        }

        println("\nДоступные архивы:")
        archives.forEachIndexed { index, archive ->
            println("${index + 1}. $archive")
        }
        println("0 - Назад")

        print("Выберите номер архива: ")
        val input = scanner.nextLine().trim()

        try {
            val choice = input.toInt()
            if (choice == 0) return

            if (choice in 1..archives.size) {
                val selectedArchive = archives[choice - 1]
                displayNoteMenu(selectedArchive)
            } else {
                println("Неверный номер архива.")
            }
        } catch (e: NumberFormatException) {
            println("Введите число.")
        }
    }

    fun displayNoteMenu(archive: Archive) {
        while (true) {
            println("\n=== АРХИВ: ${archive.name} ===")
            println("Заметок: ${archive.getNotes().size}")
            println("1 - Создать заметку")
            println("2 - Просмотреть заметки")
            println("3 - Открыть заметку")
            println("4 - Назад")

            when (scanner.nextLine().trim()) {
                "1" -> createNote(archive)
                "2" -> showNotes(archive)
                "3" -> openNote(archive)
                "4" -> return
                else -> println("Неверный ввод. Попробуйте снова.")
            }
        }
    }

    fun createNote(archive: Archive) {
        println("Введите заголовок заметки:")
        val title = scanner.nextLine().trim()
        if (title.isEmpty()) {
            println("Заголовок не должен быть пустым.")
            return
        }

        println("Введите содержание заметки:")
        val content = scanner.nextLine().trim()

        val note = Note(title, content)
        archive.addNote(note)
        println("Заметка '$title' создана в архиве '${archive.name}'")
    }

    fun showNotes(archive: Archive) {
        val notes = archive.getNotes()
        if (notes.isEmpty()) {
            println("В этом архиве нет заметок.")
            return
        }

        println("\nЗаметки в архиве '${archive.name}':")
        notes.forEachIndexed { index, note ->
            println("${index + 1}. ${note.title}")
        }
    }

    fun openNote(archive: Archive) {
        val notes = archive.getNotes()
        if (notes.isEmpty()) {
            println("В этом архиве нет заметок.")
            return
        }

        showNotes(archive)
        print("Выберите номер заметки для просмотра (0 - назад): ")

        try {
            val choice = scanner.nextLine().trim().toInt()
            if (choice == 0) return

            if (choice in 1..notes.size) {
                val note = notes[choice - 1]
                println("\n=== ${note.title} ===")
                println(note.content)
                println("====================")
            } else {
                println("Неверный номер заметки.")
            }
        } catch (e: NumberFormatException) {
            println("Введите число.")
        }
    }
}

