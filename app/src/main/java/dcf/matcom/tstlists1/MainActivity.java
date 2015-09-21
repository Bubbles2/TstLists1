package dcf.matcom.tstlists1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener {
    String[] foots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        foots = getResources().getStringArray(R.array.foot);
        ArrayAdapter<String > aa =new ArrayAdapter(this, android.R.layout.simple_list_item_1, foots);
        ListView lv1 = (ListView) findViewById(R.id.listView);
        lv1.setOnItemClickListener(this);
        ListView lv = (ListView) findViewById(R.id.lv1);
        lv.setAdapter(aa);
        //

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("List 2", "--- Selected-----");
            }
        });
        //
        FragmentManager fm= getFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        Frag2 f2 = new Frag2();
        ft.add(R.id.frame1,f2);
        ft.commit();
        //
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i("List 1", "--- Selected-----");
    }
}
