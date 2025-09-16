/*import java.util.Scanner

class MainMenu() {

    val manager = Manager()
    fun displayArchiveMenu() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("     Список архивов:     ")
            println("0 - Создать архив")
            println("1 - Открыть архив")
            println("2 - Выход")
            manager.displayArchive()

            val line = readLine() ?: ""
            try {
                val choice = line.trim().toInt()
                when (choice) {
                    0 -> manager.createArchive()
                    1 -> manager.chooseArchive()
                    2 -> {
                        println("Выход...")
                        break
                    }
                }
            } catch (e: NumberFormatException) {
                println("Недопустимый ввод. Введите число.")
            }

        }
        manager.chooseArchive()
    }

}
*/



