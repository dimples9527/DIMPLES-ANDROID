package com.dimples.ui.main.book.manager;

import android.os.AsyncTask;
import android.util.Log;

import com.dimples.ui.main.book.module.BookDetailHttpServer;

import okhttp3.Response;

/**
 * @author zhongyj
 * @date 2019/3/28 9:38
 */
public class GetPatientDataManager extends AsyncTask<Object, Object, Object> {

    private static final String D_TAG = "D-GetPatientDataManager";

    /**
     * 运行在子线程中
     *
     * @param objects Object
     * @return Object
     */
    @Override
    protected Object doInBackground(Object... objects) {
        return new BookDetailHttpServer().getData(String.valueOf(objects[0]), String.valueOf(objects[1]));
    }

    /**
     * 运行在主线程，用于更新数据
     * 将数据返回到主线程
     *
     * @param o Object
     */
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Response response = (Response) o;
        Log.i(D_TAG, String.valueOf(response));
//        try {
//            Log.i(D_TAG, response.body() != null ? response.body().string() : null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}















