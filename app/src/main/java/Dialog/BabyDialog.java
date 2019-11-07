package Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.homejek.ui.R;

public class BabyDialog extends AppCompatDialogFragment {

    private EditText nb_enfants;
    private Spinner tranche_age_spinner;
    private Button plus_btn, moins_btn;
    private String TAG = BabyDialog.class.getSimpleName();
    private AddBabyDialogListener listener;
    int counter = 0;
    public interface AddBabyDialogListener{
        void refreshList();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.babydialog,null);

        nb_enfants = view.findViewById(R.id.nb_enfant);
        plus_btn = view.findViewById(R.id.btn_plus);
        moins_btn = view.findViewById(R.id.btn_moins);
        tranche_age_spinner = view.findViewById(R.id.baby_spinner);

        nb_enfants.setText("0");


        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                nb_enfants.setText(String.valueOf(counter));
            }
        });

        moins_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter - 1;
                nb_enfants.setText(String.valueOf(counter));
            }
        });

        builder.setView(view).setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nb_enfant_txt = nb_enfants.getText().toString();
                String tranche_age_txt = tranche_age_spinner.getSelectedItem().toString();

                Log.e("Test",nb_enfant_txt);
            }
        })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Cancel
                    }
                });
        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
           listener =(AddBabyDialogListener) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"Must implement  Dialog");
        }
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }
}
