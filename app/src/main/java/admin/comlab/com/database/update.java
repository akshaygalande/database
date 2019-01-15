package admin.comlab.com.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Admin on 22-03-2018.
 */

public class update extends AppCompatActivity {
    databasehelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        db = new databasehelper(this);
        final EditText id = (EditText)findViewById(R.id.id);
        final EditText name = (EditText)findViewById(R.id.name);
        Button btnupdate = (Button)findViewById(R.id.btnupdate);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.update(id.getText().toString() , name.getText().toString());
                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();

            }
        });

    }
}
