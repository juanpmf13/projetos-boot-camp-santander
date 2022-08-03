package me.dio.soccernews;

import  android.app.Application;
public class App extends Application {
    private static App instace;

    public static App getInstance(){
        return instace;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instace =this;
    }
}
