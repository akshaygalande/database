package admin.comlab.com.database;

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

public class delete extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final databasehelper db = new databasehelper(this);
        setContentView(R.layout.delete);

        final EditText id = (EditText)findViewById(R.id.id);
        Button btndelete = (Button)findViewById(R.id.btndelete);

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.delete(id.getText().toString());
                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
