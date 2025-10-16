package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {

    private var dieSides = 6
    private var rolledNumber : MutableLiveData<Int> = MutableLiveData()

    fun setDieSides(sides : Int) {
        if (sides > 0){
            dieSides = sides
        }
    }

    fun rollDie(){
        rolledNumber.value = (Random.nextInt(dieSides) + 1)
    }

    fun getRolledNumber() : LiveData<Int>{
        return rolledNumber
    }
}