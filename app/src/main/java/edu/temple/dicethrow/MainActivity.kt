package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

private  val dieVieModel : DieViewModel by lazy {
    ViewModelProvider(this)[DieViewModel::class.java]
}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dieVieModel.setDieSides(20)


        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieVieModel.rollDie()
        }

    }

}