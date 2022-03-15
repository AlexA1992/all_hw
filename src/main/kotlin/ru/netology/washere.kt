package ru.netology
import kotlin.math.round

var theString = ""
var hours = 0
var minutes = 0

    //главная функция, не знаю как ее назвать
fun agoToText(secondsAgo: Int): String {
    when (secondsAgo) {
        in 0..60 -> theString = "был(а) только что"
        in 61..60 * 60 -> theString = howManyMinutes(secondsAgo)
        in 60 * 60 + 1..60 * 60 * 24 - 1 -> theString = howManyHours(secondsAgo)
        in 60 * 60 * 24..60 * 60 * 48 - 1 -> theString = "был(а) сегодня"
        in 60 * 60 * 48..60 * 60 * 72 - 1 -> theString = "был(а) вчера"
        else -> theString = "был(а) давно"
    }
    return theString
}
    //считаем минуты
fun howManyMinutes(secondsAgo: Int): String {
    minutes = round((secondsAgo / 60).toDouble()).toInt()
    println(minutes)
    when {
        (minutes == 0) || (minutes % 10 == 0) || (minutes in 5..19) -> theString = "был(а) $minutes" + " минут назад"
        (minutes == 1) || (minutes % 10 == 1) -> theString = "был(а) $minutes" + " минуту назад"
        (minutes in 2..4) || (minutes % 10 in 2..4) -> theString = "был(а) $minutes" + " минуты назад"
        else -> theString = "был(а) $minutes" + " минут назад"
    }
    return theString
}
    //считаем часы
fun howManyHours(secondsAgo: Int): String {
    hours = round((secondsAgo / 60 / 60).toDouble()).toInt()
    when {
        (hours == 0) || (hours % 10 == 0) || (hours in 5..19) -> theString = "был(а) $hours" + " часов назад"
        (hours == 1) || (hours % 10 == 1) -> theString = "был(а) $hours" + " час назад"
        (hours in 2..4) || (hours % 10 in 2..4) -> theString = "был(а) $hours" + " часа назад"
        else -> theString = "был(а) $hours" + " часов назад"
    }
    return theString
}

    //здесь задаем количество секунд и больше ничего не делаем
fun main() {
    println(agoToText(3601))
}
