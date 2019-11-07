package Adapter;
import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import com.homejek.ui.R;

import java.util.ArrayList;
import java.util.Calendar;

import Models.ProfileModel;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {



    Context context;
    private ArrayList<ProfileModel> profileModelArrayList;

    public ProfileAdapter(Context context, ArrayList<ProfileModel> profileModelArrayList) {
        this.context = context;
        this.profileModelArrayList = profileModelArrayList;
    }


    @NonNull
    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ViewHolder holder, final int position) {

        holder.inbox.setImageResource(profileModelArrayList.get(position).getInbox());
        holder.arrow.setImageResource(profileModelArrayList.get(position).getArrow());
        holder.txttrades.setText(profileModelArrayList.get(position).getTxttrades());
        holder.txthistory.setText(profileModelArrayList.get(position).getTxthistory());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("POSITION",profileModelArrayList.get(position).getTxttrades());
                if(profileModelArrayList.get(position).getTxttrades().equals("Mon Mot de passe"))
                {
                    openDialog_mdp("Mon mot de passe");

                }
                else if(profileModelArrayList.get(position).getTxttrades().equals("Mon adresse mail")){
                    openDialog_mail("Mon adresse mail");
                }
                else if(profileModelArrayList.get(position).getTxttrades().equals("Mon numéro de telephone")){
                    openDialog_num("Mon numéro de téléphone");
                }
                else if(profileModelArrayList.get(position).getTxttrades().equals("Ma date de naissance")){
                    openDialog_naissance("Ma date de naissance");
                }
                else if(profileModelArrayList.get(position).getTxttrades().equals("Mon Profil")){
                    openDialog_allprofile("Modifier mon profil");
                }

            }
        });

/*      for(int i=0; i<profileModelArrayList.size(); i++) {

            if (holder.txttrades.getText().equals("Mon Mot de passe")) {
                holder.arrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Intent intent4 = new Intent(context, CompetenceActivity.class);
                        //context.startActivity(intent4);
                        Log.e("MDP","Mon mot de passe");
                    }
                });
            }
            if (holder.txttrades.getText().equals("Mon adresse mail")) {
                holder.arrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Intent intent4 = new Intent(context, Mes_Projets.class);
                       // context.startActivity(intent4);
                        //openDialog();
                        Log.e("MDP","Mon adresse mail");
                    }
                });
            }
            if (holder.txttrades.getText().equals("Mon numéro de telephone")) {
                holder.arrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       // Intent intent4 = new Intent(context, Mes_MiniJobs.class);
                       // context.startActivity(intent4);
                        Log.e("MDP","Mon numéro de telephone");
                    }
                });
            }
            if (holder.txttrades.getText().equals("Ma date de naissance")) {
                holder.arrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Intent intent4 = new Intent(context, Mes_Formations.class);
                        // context.startActivity(intent4);
                        Log.e("MDP","Ma date de naissance");
                    }
                });
            }
            if (holder.txttrades.getText().equals("Mon Profil")) {
                holder.arrow.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        //  Intent intent4 = new Intent(context, ProfilePage.class);
                        // context.startActivity(intent4);
                        Log.e("MDP","Mon Profil");
                    }
                });
            }



        }*/

    }

    public void openDialog_mdp( String msg){
        /**
         * Dialog dans fichier a part
         */
       // Mdp_Dialog mdpDialog = new Mdp_Dialog();

       // mdpDialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "Dialog Mot de passe");

        final Dialog dialog = new Dialog(this.context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.mdp_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton1 = (Button) dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogButton2 = (Button) dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public void openDialog_mail( String msg){


        final Dialog dialog = new Dialog(this.context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.mail_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton1 = (Button) dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogButton2 = (Button) dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
    public void openDialog_num( String msg){


        final Dialog dialog = new Dialog(this.context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.num_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton1 = (Button) dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogButton2 = (Button) dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
    public void openDialog_naissance( String msg){


        final Dialog dialog = new Dialog(this.context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.naissance_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton1 = (Button) dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogButton2 = (Button) dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        final TextView naissancetxt;

        naissancetxt = (TextView) dialog.findViewById(R.id.naissance_layout);
        naissancetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog  datepicker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                naissancetxt.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datepicker.show();
            }

        });
        dialog.show();

    }

    public void openDialog_allprofile( String msg){


        final Dialog dialog = new Dialog(this.context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.modifprofil_dialog);

      //  TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
      //  text.setText(msg);

        Button dialogButton1 = (Button) dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogButton2 = (Button) dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        final TextView naissancetxt;

        naissancetxt = (TextView) dialog.findViewById(R.id.naissanceTxtprofil);
        naissancetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog  datepicker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                naissancetxt.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datepicker.show();
            }

        });
        dialog.show();

    }
    @Override
    public int getItemCount() {
        return profileModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView inbox,arrow;
        TextView txttrades,txthistory;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            inbox=itemView.findViewById(R.id.inbox);
            arrow=itemView.findViewById(R.id.arrow);
            txttrades=itemView.findViewById(R.id.txttrades);
            txthistory=itemView.findViewById(R.id.txthistory);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
