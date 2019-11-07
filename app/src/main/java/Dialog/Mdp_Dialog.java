package Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.homejek.ui.R;

public class Mdp_Dialog extends AppCompatDialogFragment {

    private EditText newPwd;
    private EditText confirmNewPwd;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.mdp_dialog, null);
//        this.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //view.setBackgroundResource(android.R.color.transparent);
        TextView persoTitle = new TextView(this.getContext());
        persoTitle.setText("Modifier Mot de passe");
        persoTitle.setPadding(20, 30, 20, 30);
        persoTitle.setTextSize(20F);
        persoTitle.setBackground(new ColorDrawable(Color.TRANSPARENT));
        persoTitle.setTextColor(Color.parseColor("#00574B"));

        final Dialog dialog = new Dialog(getContext());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        builder.setView(view)
                //.setCustomTitle(persoTitle)
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String pwd = newPwd.getText().toString();
                        String confpwd = confirmNewPwd.getText().toString();
                        Log.e("MDP", pwd + confpwd);
                        /**
                         *
                         * METHODE DE PERSISTANCE DANS LA BASE DE DONNEES
                         */

                    }
                });

    //    newPwd = view.findViewById(R.id.mdp_dialog);
      //  confirmNewPwd = view.findViewById(R.id.mdpconfirm_dialog);
        return builder.create();

    }

}
