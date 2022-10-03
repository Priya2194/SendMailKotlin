package com.example.sendmailkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send.setOnClickListener {
            var email = email.text.toString()
            var sub = subjects.text.toString()
            var msg = message.text.toString()


            sendEmail(email, sub, msg)
        }
    }

    private fun sendEmail(email: String, sub: String, msg: String)
    {
        val intent=Intent(Intent.ACTION_SEND)
        intent.data= Uri.parse("mailto:")
        intent.type="text/plain"

        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email) )
        intent.putExtra(Intent.EXTRA_SUBJECT,sub)
        intent.putExtra(Intent.EXTRA_TEXT,msg)


        try
        {
            startActivity(Intent.createChooser(intent,"Choose Email Client..."))

        }
        catch (e:Exception)
        {
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }

    }
    /*  val addresses=email.split(",".toRegex()).toTypedArray()

      val intent=Intent(Intent.ACTION_SENDTO).apply {

          data= Uri.parse("mailto:")

          putExtra(Intent.EXTRA_EMAIL,addresses)
          putExtra(Intent.EXTRA_SUBJECT,sub)
          putExtra(Intent.EXTRA_TEXT,msg)

      }
      if (intent.resolveActivity(packageManager)!=null)
      {
          startActivity(intent)
      }
      else{
          Toast.makeText(this,"Required App is not finished",Toast.LENGTH_SHORT).show()
      }*/

}