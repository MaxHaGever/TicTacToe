package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    enum class Turn {
        Oes,
        Xes
    }

    private var firstTurn = Turn.Xes
    private var currentTurn = Turn.Xes
    private var boardList = mutableListOf<Button>()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()
    }

    private fun initBoard() {
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
    }

    fun boardTapped(view: View) {
        if(view !is Button)
            return
        addToBoard(view)
    }

    private fun addToBoard(button: Button) {
        if(button.text != "")
            return
        if(currentTurn == Turn.Oes){
            button.text = Oes
            currentTurn = Turn.Xes
        }
        else if(currentTurn == Turn.Xes){
            button.text = Xes
            currentTurn = Turn.Oes
        }
        setTurnLabel()
    }

    private fun setTurnLabel() {
        var turnText = ""
        if(currentTurn == Turn.Xes)
            turnText = "Turn $Xes"
        else if(currentTurn == Turn.Oes)
            turnText = "Turn $Oes"

        binding.turn.text = turnText
    }

    companion object{
        const val Oes = "0"
        const val Xes = "X"
    }

}