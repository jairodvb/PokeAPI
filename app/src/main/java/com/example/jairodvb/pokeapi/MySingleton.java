package com.example.jairodvb.pokeapi;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by jairodvb on 28/11/16.
 */

public class MySingleton {

    private static MySingleton MiInsta;
    private RequestQueue rq;
    private static Context contexto;

    private MySingleton(Context context)
    {
        contexto = context;
        rq = getRq();
    }


    public RequestQueue getRq()
    {
        if(rq == null)
        {
            rq = Volley.newRequestQueue(contexto.getApplicationContext());
        }
        return rq;
    }

    public static synchronized MySingleton getMiInsta(Context context)
    {
        if (MiInsta == null)
        {
            MiInsta = new MySingleton(context);
        }

        return MiInsta;
    }

    public <T> void addToRequestQue(Request<T> request)
    {
        rq.add(request);
    }

}
