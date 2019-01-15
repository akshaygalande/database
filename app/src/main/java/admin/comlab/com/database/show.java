package admin.comlab.com.database;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 22-03-2018.
 */

public class show extends AppCompatActivity {
    ListView lstview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        databasehelper db = new databasehelper(this);

        ArrayList<String> array = new ArrayList<>();
        lstview = (ListView)findViewById(R.id.lstview);

        Cursor c = db.show();
        if(c.getCount()==0){
            Toast.makeText(getApplicationContext(),"DB Empty...",Toast.LENGTH_LONG).show();
        }
        else{
            while (c.moveToNext()){
                array.add(("ID:" + c.getString(0) + "\n" + "NAME:" + c.getString(1)));
            }
            ListAdapter lstadapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,array);
            lstview.setAdapter(lstadapter);
        }
    }
}
