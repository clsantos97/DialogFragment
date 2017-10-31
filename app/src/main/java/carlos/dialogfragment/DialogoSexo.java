package carlos.dialogfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Dialog fragment personalizado para preguntar sexo.
 * Created by Carlos on 10/13/2017.
 */
public class DialogoSexo extends DialogFragment {
    RespuestaDialog ri;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                // set dialog icon
                .setIcon(android.R.drawable.ic_dialog_alert)
                // set Dialog Title
                .setTitle("Pregunta muy importante:")
                // Set Dialog Message
                .setMessage("¿Eres una chica?")

                // positive button
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ri.onFinishDialog("Es una chica!");
                    }
                })
                // negative button
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ri.onFinishDialog("Es un chico!");
                    }
                }).create();
    }

    /**
     * Interfaz para enviar respuesta a la main activity.
     */
    public interface RespuestaDialog{
        public void onFinishDialog(String respuesta);
    }

    @Override
    public void onAttach(Context context){ // With activity parameter is deprecated.

        // Check if the context is an activity
        if(context instanceof Activity){
            super.onAttach(context);
            ri = (RespuestaDialog)context;
        }
    }
}
