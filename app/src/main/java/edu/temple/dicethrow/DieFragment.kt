package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"
    val ROLLEDNUMBERKEY = "rolledNumber"

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    var rolledNumber = 0

    private val dieViewModel : DieViewModel by lazy{
        ViewModelProvider(requireActivity())[DieViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.let {
            it.getInt(ROLLEDNUMBERKEY).run {
                rolledNumber = this
            }
        }

            arguments?.let {
            it.getInt(DIESIDE).run {
                dieViewModel.setDieSides(this)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dieViewModel.getRolledNumber().observe(viewLifecycleOwner){
            updateView(it)
        }
    }



    private fun updateView(value: Int) {
        dieTextView.text = value.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ROLLEDNUMBERKEY, rolledNumber)
    }

    companion object{
        fun newInstance(sides: Int) : DieFragment = DieFragment().apply{
            arguments = Bundle().apply{
                putInt(DIESIDE, sides)
            }
        }
    }
}