package carlos.dialogfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Practica dialogo con respuesta usando DialogFragment
 * Created by Carlos on 10/13/2017.
 */
public class MainActivity extends AppCompatActivity implements Button.OnClickListener, DialogoSexo.RespuestaDialog {
    Button btnPreguntar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPreguntar = (Button)findViewById(R.id.btnPreguntar);
        btnPreguntar.setOnClickListener(this);
    }

    /**
     * Mostrar respuesta del dialog en un toast
     * @param respuesta
     */
    @Override
    public void onFinishDialog(String respuesta) {
        Toast toast = Toast.makeText(getApplicationContext(), respuesta,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * OnClick action para btnPreguntar (Unico boton)
     * @param view
     */
    public void onClick(View view) {
        DialogoSexo dialogSexo = new DialogoSexo();
        dialogSexo.show(getFragmentManager(), "dialog_sex");
    }
}
