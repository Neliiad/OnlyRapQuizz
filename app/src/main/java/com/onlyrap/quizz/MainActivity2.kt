package com.onlyrap.quizz

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.example.quizz.R

import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    var quizs= ArrayList<Quiz>()
    var numberOfGoodAnswer : Int = 0
    var currentQuizIndex : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        quizs.add(
            Quiz(
                "Question n°1/10",
                "Son comptabilisant le plus d’écoute sur spotify de damso : ?",
                "Mitsubishi",
                "Habitué",
                "Macarena",
                "BXL ZOO",
                3
            )
        )
        quizs.add(
            Quiz(
                "Question n°2/10",
                "Combien d'albums ont PNL ?",
                "1",
                "6",
                "3",
                "5",
                3
            )
        )
        quizs.add(
            Quiz(
                "Question n°3/10",
                "Comment s’appelle le dernier album de 13 block ?",
                "BLO",
                "BLO2",
                "BLO3",
                "4 frères",
                2
            )
        )
        quizs.add(
            Quiz(
                "Question n°4/10",
                "Lequel de ces sons booba a-t-il fait ?",
                "racli world",
                "Violet",
                "Autotune",
                "petite fille",
                4
            )
        )
        quizs.add(
            Quiz(
                "Question n°5/10",
                "Zed est un membre de ?",
                "13 block",
                "PNL",
                "Migos",
                "BDG",
                1
            )
        )

        quizs.add(
            Quiz(
                "Question n°6/10",
                "Qui a fait trinity ?",
                "Ashkidd",
                "Laylow",
                "Josman",
                "Cheb Hasn",
                2
            )
        )
        quizs.add(
            Quiz(
                "Question n°7/10",
                "Quel est le surnom d’alpha wann",
                "don pablo",
                "mon papa",
                "ratpi",
                "don dada",
                4
            )
        )
        quizs.add(
            Quiz(
                "Question n°8/10",
                " A quand date  l‘album lmf de Freeze corleone",
                "11 septembre 2020",
                "10 novembre 2018",
                "15 février 2019",
                "19 janvier 2020",
                1
            )
        )
        quizs.add(
            Quiz(
                "Question n°9/10",
                "Qui est l’artiste le plus écouté sur spotify",
                "Laylow",
                "Khali",
                "Ninho",
                "Frenetik",
                3
            )
        )
        quizs.add(
            Quiz(
                "Question n°10/10",
                "Lequel de ces sons et un son de Hamza ?",
                "God Bless ",
                "Vie",
                "On vas s’aimer",
                "Sbaart Ou Tal Adabi",
                1
            )
        )
        showQuestion(quizs.get(currentQuizIndex))
    }

    fun showQuestion(quiz : Quiz){
        txtQuestionNumber.setText(quiz.questionNumber)
        txtQuestion.setText(quiz.question)
        answer1.setText(quiz.answer1)
        answer2.setText(quiz.answer2)
        answer3.setText(quiz.answer3)
        answer4.setText(quiz.answer4)
    }

    fun handleAnswer(answerID: Int ) {
        val quiz = quizs.get(currentQuizIndex)

        if (quiz.isCorrect(answerID)) {
            numberOfGoodAnswer++
            Toast.makeText(this, "+1", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "+0", Toast.LENGTH_SHORT).show()
        }

        currentQuizIndex++

        if(currentQuizIndex >= quizs.size){
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Partie Terminée")
            alert.setMessage("tu as eu " + numberOfGoodAnswer + " de bonnes reponses")
            alert.setPositiveButton("OK"){
                dialog: DialogInterface?, which: Int ->
                finish()

            }
            alert.show()
        }

        else{
            showQuestion(quizs.get(currentQuizIndex))
        }
    }

    fun onClickAnswerOne(view: View){
         handleAnswer(1 )
    }

    fun onClickAnswerTwo(view: View){
        handleAnswer(2)
    }
    fun onClickAnswerThree(view: View){
        handleAnswer(3)
    }
    fun onClickAnswerFour(view: View){
        handleAnswer(4)
    }
}