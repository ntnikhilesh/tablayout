package com.example.dell.otp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MessageScreen extends AppCompatActivity {

    private OkHttpClient mClient = new OkHttpClient();
    private Context mContext;
    Button msend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_screen);

        mContext = getApplicationContext();
        msend=(Button)findViewById(R.id.button_send);
        msend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    post(mContext.getString(R.string.backend_url), new  Callback(){

                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                   // mTo.setText("");
                                    //mBody.setText("");
                                    Toast.makeText(getApplicationContext(),"SMS Sent!",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Call post(String url, Callback callback) throws IOException{
        RequestBody formBody = new FormBody.Builder()
                .add("To", "+918979813525")
                .add("Body", "Hello nik")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call response = mClient.newCall(request);
        response.enqueue(callback);
        return response;
    }
}
