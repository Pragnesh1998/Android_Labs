package com.example.android_labs;


import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class ChatRoomActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    List<MessageModel> listMessage = new ArrayList<>();
    Button sendBtn;
    Button receiveBtn;
    //Database db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chatroom);

        listView = (ListView)findViewById(R.id.ListView);
        editText = (EditText)findViewById(R.id.ChatEditText);
        sendBtn = (Button)findViewById(R.id.SendBtn);
        receiveBtn = (Button)findViewById(R.id.ReceiveBtn);

        //db = new Database(this);
        //db.viewData();



        sendBtn.setOnClickListener(c -> {
            String message = editText.getText().toString();
            MessageModel model = new MessageModel(message, true);
            listMessage.add(model);
            editText.setText("");
            ChatAdapter adt = new ChatAdapter(listMessage, getApplicationContext());
            listView.setAdapter(adt);
            //db.insertData(message, true);
            //editText.setText("");
            //listMessage.clear();
           // db.viewData();
        });

        receiveBtn.setOnClickListener(c -> {
            String message = editText.getText().toString();
            MessageModel model = new MessageModel(message, false);
            listMessage.add(model);
            editText.setText("");
            ChatAdapter adt = new ChatAdapter(listMessage, getApplicationContext());
            listView.setAdapter(adt);
            //if (!message.equals("")) {
                //db.insertData(message, false);
                //editText.setText("");
                //listMessage.clear();
                //db.viewData();
           // }
       });



        Log.d("ChatRoomActivity","onCreate");

    }

    private void viewData() {
        //Cursor cursor = db.viewData();

        //if (cursor.getCount() != 0) {
            //while (cursor.moveToNext()) {
               // MessageModel model = new MessageModel(cursor.getString(1), cursor.getInt(2) == 0);
                //listMessage.add(model);
               // ChatAdapter adt = new ChatAdapter(listMessage, getApplicationContext());
                //listView.setAdapter(adt);

            }
        }
    //}



//}
