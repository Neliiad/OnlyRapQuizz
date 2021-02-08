package com.onlyrap.quizz

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quizz.R
import kotlinx.android.synthetic.main.activity_quiz_medium.*

class QuizMedium : AppCompatActivity() {

    var quizs= ArrayList<Quiz>()
    var numberOfGoodAnswer : Int = 0
    var currentQuizIndex : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_medium)

        quizs.add(
            Quiz(
                "Question n°1/10",
                "Qui est en feat avec Freeze corleone dans rap catéchisme ?",
                "Ashe 22",
                "Alpha Wann",
                "Stavo",
                "Roi heenok",
                2
            )
        )
        quizs.add(
            Quiz(
                "Question n°2/10",
                "Quel style fait principalement Gazo ?",
                "Drill",
                "Zumba",
                "Variété",
                "Trap",
                1
            )
        )
        quizs.add(
            Quiz(
                "Question n°3/10",
                "Qui est en feat Avec 4 keus dans MD ?",
                "Laylow",
                "Céline Dion",
                "Niska",
                "Booba",
                3
            )
        )
        quizs.add(
            Quiz(
                "Question n°4/10",
                "qui a fait 10 versions de Double Bang ?",
                "Koba laD",
                "Damso",
                "PNL",
                "Leto",
                4
            )
        )
        quizs.add(
            Quiz(
                "Question n°5/10",
                " lequel de ces artistes a sorti l’album 000",
                "Josman",
                "Yg pablo",
                "Deen burbigo",
                "Ateyaba",
                1
            )
        )

        quizs.add(
            Quiz(
                "Question n°6/10",
                "Qui est belge ?",
                "Booba",
                "Yg Pablo",
                "Jul",
                "Kekra",
                2
            )
        )
        quizs.add(
            Quiz(
                "Question n°7/10",
                "Qui a sorti paki stock ?",
                "Frenetik",
                "Pablo Excobar",
                "Ateyaba",
                "Zuukou mayzie",
                4
            )
        )
        quizs.add(
            Quiz(
                "Question n°8/10",
                "Lequel de ces sons a le plus d’écoute spotify ?",
                "Putain de salaire (kekra)",
                "Nouveau riche (leto)",
                "pyramide (Yg pablo)",
                "But en or (Kalash Criminel)",
                4
            )
        )
        quizs.add(
            Quiz(
                "Question n°9/10",
                "qui a fait l'album enna ?\n",
                "Niska",
                "PLK",
                "Alpha Wann",
                "Heuss L’enfoiré",
                2
            )
        )
        quizs.add(
            Quiz(
                "Question n°10/10",
                "qui a le plus de disques d’or ?",
                "Laylow",
                "Niska",
                "Booba",
                "Ninho",
                4
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


