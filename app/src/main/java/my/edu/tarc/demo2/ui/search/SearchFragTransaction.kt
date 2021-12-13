package my.edu.tarc.demo2.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.FragmentHomeBinding
import my.edu.tarc.demo2.databinding.FragmentSearchFragDetailsBinding
import my.edu.tarc.demo2.ui.home.HomeViewModel

class SearchFragTransaction : Fragment() {

    //View Binding
    private lateinit var searchViewModel: HomeViewModel
    private var _binding: FragmentSearchFragDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_search_frag_transaction, container, false)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun init(){

    }
}