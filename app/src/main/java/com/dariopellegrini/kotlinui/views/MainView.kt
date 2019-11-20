package com.dariopellegrini.kotlinui.views

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dariopellegrini.kotlinui.constants.matchParent
import com.dariopellegrini.kotlinui.constants.wrapContent
import com.dariopellegrini.kotlinui.kview.*
import com.dariopellegrini.kotlinui.ui.*
import com.dariopellegrini.kotlinui.ui.actions.onClick
import com.dariopellegrini.kotlinui.ui.actions.toast
import com.dariopellegrini.kotlinui.ui.builders.*
import com.dariopellegrini.kotlinui.ui.dimensions.dp
import com.dariopellegrini.kotlinui.ui.dimensions.margin
import com.dariopellegrini.kotlinui.ui.dimensions.params
import com.dariopellegrini.kotlinui.ui.dimensions.sp
import kotlinx.coroutines.delay
import java.util.*

class MainView: KView() {
//    var games by observable(listOf<Game>())
    var title by observable("Hello")

    override val body: ViewClosure
        get() = {
            verticalLayout {
                textView(title)
                button({
                    title = "$title Hello!"
                }) {
                    text = "Change title"
                }
                scrollView {
                    embed(RandomText(8))
                    embed(RandomText(8))
                }
            }
        }
}

suspend fun getGames(): List<Game> {
    delay(2000)
    return listOf(
        Game("Horizon Zero Dawn", "Playstation 4"),
        Game("Grand Theft Auto V", "Playstation 3"),
        Game("Final Fantasy X", "Playstation 2"),
        Game("Horizon Zero Dawn", "Playstation 4"),
        Game("Grand Theft Auto V", "Playstation 3"),
        Game("Final Fantasy X", "Playstation 2"),
        Game("Horizon Zero Dawn", "Playstation 4"),
        Game("Grand Theft Auto V", "Playstation 3"),
        Game("Final Fantasy X", "Playstation 2"),
        Game("Horizon Zero Dawn", "Playstation 4"),
        Game("Grand Theft Auto V", "Playstation 3"),
        Game("Final Fantasy X", "Playstation 2"),
        Game("Horizon Zero Dawn", "Playstation 4"),
        Game("Grand Theft Auto V", "Playstation 3"),
        Game("Final Fantasy X", "Playstation 2")
    )
}

class ListLayout(val list: List<Game>): KView() {
    override val body: ViewClosure
        get() = {
            recyclerView {
                list.forEach {
                    embed(NameRow(it.name, it.platform))
                }
            }.apply {
                setPadding(0,0,0, dp(96f))
                clipToPadding = false
            }
        }
}

class RandomText(val length: Int): KView() {
    var value: String by observable("Hello1")
    override val body: ViewClosure
        get() = {
            verticalLayout {
                textView(value)
                button({
                    value = ('A'..'z').map { it }.shuffled().subList(0, length).joinToString("")
                }) {
                    text = "Random string"
                }
            }
        }
}

class HorizontalListLayout: KView() {
    var list by observable(listOf(
        Game("Horizon Zero Dawn", "Playstation 4"),
        Game("Grand Theft Auto V", "Playstation 3"),
        Game("Final Fantasy X", "Playstation 2"),
        Game("Horizon Zero Dawn", "Playstation 4"),
        Game("Grand Theft Auto V", "Playstation 3")))

    override val body: ViewClosure
        get() = {
            val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView(linearLayoutManager) {
                list.forEach { game ->
                    verticalLayout {
                        customView {
                            ImageView(context).apply {
                                Glide.with(this).load("https://goo.gl/gEgYUd").into(this)
                            }
                        }.params(75, 150)

                        textView(game.name) {
                            textSize = 18f
                            setTextColor(Color.BLACK)
                        }.params(matchParent, wrapContent)
                            .margin(16, 16, 16, 0)

                        textView(game.platform) {
                            textSize = 16f
                            setTextColor(Color.LTGRAY)
                        }.params(matchParent, wrapContent)
                            .margin(16, 0, 16, 16)
                    }
                }
                button({
                    list = listOf(
                        Game("Horizon Zero Dawn", "Playstation 4"),
                        Game("Grand Theft Auto V", "Playstation 3"),
                        Game("Final Fantasy X", "Playstation 2"),
                        Game("Horizon Zero Dawn", "Playstation 4"),
                        Game("Grand Theft Auto V", "Playstation 3"),
                        Game("Final Fantasy X", "Playstation 2"),
                        Game("Horizon Zero Dawn", "Playstation 4"),
                        Game("Grand Theft Auto V", "Playstation 3"),
                        Game("Final Fantasy X", "Playstation 2"),
                        Game("Horizon Zero Dawn", "Playstation 4"),
                        Game("Grand Theft Auto V", "Playstation 3"),
                        Game("Final Fantasy X", "Playstation 2"),
                        Game("Horizon Zero Dawn", "Playstation 4"),
                        Game("Grand Theft Auto V", "Playstation 3"),
                        Game("Final Fantasy X", "Playstation 2")
                    )
                }) {
                    text = "Reload"
                }.params(35, matchParent)

            }.apply {
                setPadding(0,0,0, dp(96f))
                clipToPadding = false
            }
        }
}

class NameRow(val title: String, val subtitle: String): KView() {

    override val body: ViewClosure
        get() = {
            horizontalLayout {
                embed(GlideImage("https://goo.gl/gEgYUd"))

                verticalLayout {
                    textView(title) {
                        textSize = sp(14f)
                        setTextColor(Color.BLACK)
                    }.params(matchParent, wrapContent)
                            .margin(16, 16, 16, 0)

                    textView(subtitle) {
                        textSize = sp(12f)
                        setTextColor(Color.LTGRAY)
                    }.params(matchParent, wrapContent)
                            .margin(16, 0, 16, 16)

                    view {
                        setBackgroundColor(Color.DKGRAY)
                        alpha = 0.6f
                    }.params(matchParent, 1)
                }.apply {
                    gravity = Gravity.CENTER
                }
            }.onClick {
                toast(title)
            }
        }

}

class GlideImage(val src: String): KView() {
    override val body: ViewClosure
        get() = {
            customView {
                ImageView(context).apply {
                    Glide.with(this).load(src).into(this)
                }
            }.params(50, matchParent)
        }
}

class GameText(val game: Game): KView() {
    override val body: ViewClosure
        get() = {
            textView("Game: ${game.name}, Platform: ${game.platform}")
        }
}

data class Game(val name: String, val platform: String)
