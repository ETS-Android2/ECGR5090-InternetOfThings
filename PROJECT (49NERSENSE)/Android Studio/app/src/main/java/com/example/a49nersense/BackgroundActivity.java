package com.example.a49nersense;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundActivity extends AsyncTask<String,Void,String>  {

    Context context;
    AlertDialog alertDialog;
    BackgroundActivity (Context ctx) {this.context = ctx;}


    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String update_url = "http://192.168.0.16/49nersense/deviceControl.php";
        //String login_url = "http://192.168.0.16/49nersense/.php";
        //String reg_url = "http://192.168.0.16/49nersense/.php"

        if(type.equals("update")) {
            try {
                String action = params[1];
                URL url = new URL(update_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("action","UTF-8")+"="+URLEncoder.encode(action,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Success");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}

    /*//SharedPreferences preferences;
    //SharedPreferences.Editor editor;
    Context context;
    String flag1;

    void BackgroundTask(Context ctx){ this.context=ctx; }


    @Override
    protected String doInBackground(String... params) {

        preferences = context.getSharedPreferences("MYPREFS",Context.MODE_PRIVATE);
        editor=preferences.edit();
        editor.putString("flag","0");
        editor.commit();

        //String urlLogin="http://192.168.0.16/LoginApp/login.php";
        //String urlRegister="http://192.168.0.16/LoginApp/register.php";
        String urlGoneopen="http://192.168.0.16/49nersens/goneopen.php";

        String task= params[0];
        flag1=task;

        if(task.equals("opengone")){
            final String status =params[1];


            try {
                URL url= new URL(urlGoneopen);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream() ;
                OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                String myData= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(status,"UTF-8");
                bufferedWriter.write(myData);
                bufferedWriter.flush();
                InputStream inputStream =httpURLConnection.getInputStream();
                inputStream.close();
                editor.putString("flag","opengone");
                editor.commit();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        String flag = preferences.getString("flag","0");
        if(flag.equals("opengone")){
            Toast.makeText(context,"Garage Door 1 Open",Toast.LENGTH_LONG).show();


        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
*/
