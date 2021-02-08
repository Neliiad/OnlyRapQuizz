package com.onlyrap.quizz

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quizz.R
import kotlinx.android.synthetic.main.activity_quiz_medium.*

class QuizHard : AppCompatActivity() {



    var quizs= ArrayList<Quiz>()
    var numberOfGoodAnswer : Int = 0
    var currentQuizIndex : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_hard)
        quizs.add(
                Quiz(
                        "Question n°1/10",
                        "À quelle date qalf est-il sorti ?",
                        "18 septembre 2020",
                        "18 octobre 2020",
                        "4 septembre 2020",
                        "11 septembre 2020",
                        1
                )
        )
        quizs.add(
                Quiz(
                        "Question n°2/10",
                        "Qui a fait l’album Kolaf ?",
                        "La fève",
                        "Khali",
                        "6osy",
                        "Stavo",
                        1
                )
        )
        quizs.add(
                Quiz(
                        "Question n°3/10",
                        "lequel de ces musiques a le plus d’écoute sur spotify ?",
                        "apdl (alpha wann)",
                        "AVM (yg pablo )",
                        "BPM (damso)",
                        "Capuche (PNL)",
                        2
                )
        )
        quizs.add(
                Quiz(
                        "Question n°4/10",
                        "Qui a composé 2 frères ?\n",
                        "Junior a la prod",
                        "BBP",
                        "Vice beats",
                        "Adsaa Beatz",
                        2
                )
        )
        quizs.add(
                Quiz(
                        "Question n°5/10",
                        "Comment s’appelle l’ep Kosei?",
                        "Violence",
                        "Fast life",
                        "Paradise",
                        "spooky season ",
                        4
                )
        )

        quizs.add(
                Quiz(
                        "Question n°6/10",
                        "Combien de titres contient l’album trinity de laylow ?",
                        "20",
                        "22",
                        "18",
                        "15",
                        2
                )
        )
        quizs.add(
                Quiz(
                        "Question n°7/10",
                        "Qui a sorti old boy ?",
                        "6osy",
                        "Jäde",
                        "NKP",
                        "Eli.n.e",
                        3
                )
        )
        quizs.add(
                Quiz(
                        "Question n°8/10",
                        "Combien de titres contient Horion de Rouhnaa ?",
                        "16",
                        "19",
                        "12",
                        "20",
                        1
                )
        )
        quizs.add(
                Quiz(
                        "Question n°9/10",
                        "Combien d’album Captaine Roshi a sorti en 2020 ?",
                        "1",
                        "2",
                        "3",
                        "4",
                        3
                )
        )
        quizs.add(
                Quiz(
                        "Question n°10/10",
                        "Comment s’appelle l’album de Tedax Max ?",
                        "Forme Olympique",
                        "Blue Cheese",
                        "Période d’essai",
                        "Kolaf",
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

