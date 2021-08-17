package com.mad.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mad.myapplication.databinding.ActivityMainBinding
import com.mad.myapplication.models.AccountModel

class MainActivity : AppCompatActivity() {
    private val myAccout = AccountModel("A1234566","John", 500.00)
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myAcc = myAccout
        binding.lifecycleOwner = this
       // display()


        myAccout.balance.observe(this, Observer { newBalance -> binding.tvBalance.text = newBalance.toString()})

        binding.btnDeposit.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()

            myAccout.deposit(amount)

            //binding.tvBalance.text = myAccount.balance.toString()
        }

        binding.btnWitdraw.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()
            myAccout.withdraw(amount)

            //display()

        }
    }

   // fun display(){

    //    binding.tvAccNo.text = myAccout.accNo
    //    binding.tvName.text = myAccout.owner
    //    binding.tvBalance.text = myAccout.balance.value.toString()

   // }
}