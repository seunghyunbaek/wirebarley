package bset.hyun.wirebarley

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_selected_list.view.*

class MainActivity : AppCompatActivity() {


    private lateinit var receivingCountry: TextView
    private lateinit var exchangeRate: TextView
    private lateinit var checkTime: TextView
    private lateinit var remittanceAmout: TextView
    private lateinit var receivedAmount: TextView
    private lateinit var recycler: RecyclerView

//    private var viewModelFactory: ViewModelProvider.AndroidViewModelFactory? = null
//    private val viewModelstore: ViewModelStore = ViewModelStore()

//    private lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if(viewModelFactory == null) {
//            viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
//        }
//
//        mainViewModel = ViewModelProvider(this, viewModelFactory!!).get(MainViewModel::class.java)

        receivingCountry = findViewById(R.id.text_receiving_country2)
        exchangeRate = findViewById(R.id.text_exchange_rate2)
        checkTime = findViewById(R.id.text_check_time2)
        receivedAmount = findViewById(R.id.text_received_amount)

        remittanceAmout = findViewById(R.id.edit_amount)
        remittanceAmout.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })


        recycler = findViewById(R.id.recyclerview)
        recycler.adapter = RecyclerAdapter()
        recycler.layoutManager = LinearLayoutManager(applicationContext)

        receivedAmount.text = getString(R.string.received_amount, 100, "KRW")
    }

    fun setObserver() {
//        mainViewModel.receivingCountry.observe(this, Observer { receivingCountry.text = it })
//        mainViewModel.checkTime.observe(this, Observer{ checkTime.text = it})
//        mainViewModel.exchangeRate.observe(this, Observer{ exchangeRate.text = it})
//        mainViewModel.receivedAmount.observe(this, Observer { receivedAmount.text = it })
    }

//    override fun getViewModelStore(): ViewModelStore {
//        return viewModelstore
//    }


    inner class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

        private val array = arrayOf("한국(KRW)", "일본(JPY)", "필리핀(PHP)")
        private var selectedPosition = 0

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val viewHolder = LayoutInflater.from(applicationContext).inflate(R.layout.item_list, parent, false)
            return RecyclerViewHolder(viewHolder)
        }

        override fun getItemCount(): Int = array.size

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
//            mainViewModel.receivingCountry.value = array[position]
            (holder.itemView as TextView).text = array[position].toString()
        }

        inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val selectedItem = itemView.item_selected
        }
    }
}
