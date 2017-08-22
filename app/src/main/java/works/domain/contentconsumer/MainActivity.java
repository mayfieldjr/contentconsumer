package works.domain.contentconsumer;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("content://works.domain.movie-provider/movie_genre");
        ContentProviderClient movieProvider = getContentResolver().acquireContentProviderClient(uri);

        try {
            Log.d(TAG, "before call: ");

            Cursor cursor = movieProvider.query(uri, null, null, null, null);

            Log.d(TAG, "after call");

        }catch (RemoteException e) {
            e.printStackTrace();
            Log.d(TAG, "remote Exeption");
        }

    }
}