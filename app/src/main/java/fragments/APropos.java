package fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.homejek.ui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.AProposAdapter;

public class APropos extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_apropos, container, false);
        // get the listview
        expListView = (ExpandableListView) v.findViewById(R.id.expandable);

        // preparing list data
        prepareListData();

        listAdapter = new AProposAdapter(getContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);




        return v;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Compte et moyen de paiement");
        listDataHeader.add("Payer en espèce");
        listDataHeader.add("Supprimer mon compte");
        listDataHeader.add("Système de notation");
        listDataHeader.add("Annulation");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("•\tImpossible de se connecter : Si vous ne parvenez pas à commander un service , il peut y avoir différentes explications :\n" +
                "- Vous avez un service en attente. \n" +
                "- Il n'y a aucun prestataire de service  disponible à proximité pour le moment. Veuillez patienter et réessayez de commander.\n" +
                "- Vous n'avez pas confirmé votre adresse e-mail ou votre numéro de téléphone. Vérifiez que vous avez reçu les messages de confirmation de la part de Homejek . Si ce n'est pas le cas, essayez de mettre à jour les paramètres de votre compte. \n" +
                "•\tMot de passe oublié : \n" +
                "Si vous avez oublié votre mot de passe, vous pouvez le réinitialiser en cliquant sur le lien ci-dessous. Vous devrez saisir l'adresse e-mail ou le numéro de téléphone mobile associé à votre compte Homejek.\n" +
                "\n" +
                "Vous recevrez un e-mail dans quelques minutes. Le lien pour réinitialiser votre mot de passe se trouvera dans cet e-mail. Ce lien ne peut être utilisé qu'une seule fois. Si vous n'ouvrez pas le lien dans les 10 minutes, répétez l'opération pour recevoir un nouveau lien.\n" +
                "\n" +
                "Il est recommandé de créer un mot de passe spécifique pour homejek . Veillez à ne pas communiquer votre mot de passe par e-mail ou par tout autre moyen de communication. Le service d'assistance homejek  ne vous demandera jamais votre mot de passe.\n");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Vous pouvez régler votre facture en  espece et Vous n'êtes pas tenu de laisser un pourboire à votre prestatire de service . Les pourboires sont à votre seule discrétion.\n" +

                "Homejek  a été conçu pour offrir une expérience électronique dans la plupart des villes. Le moyen de payement Homejek credits à été concu pour cela.\n");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("SUPPRIMER VOTRE COMPTE DANS L'APPLICATION\n" +
                "1. Accédez à la section « Paramètres » dans le menu de l'application\n" +
                "2. Appuyez sur « Paramètres de confidentialité ».\n" +
                "3. Appuyez sur « Supprimer le compte », puis suivez les étapes à l'écran.\n" +
                "\n" +
                "Si vous demandez la suppression de votre compte, il sera immédiatement désactivé. Au bout de 30 jours, il sera supprimé définitivement. La suppression de votre compte entraîne également la suppression définitive du crédit, des bonus et promotions ou des récompenses liés à votre compte.\n" +
                "\n" +
                "Homejek  peut conserver certaines informations après la suppression de votre compte, ainsi que la loi l'exige ou le permet.\n" +
                "\n" +
                "Si vous décidez de conserver votre compte Homejek , vous pouvez le restaurer dans les 30 jours qui suivent sa désactivation en vous connectant.\n");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");

        List<String> akash = new ArrayList<String>();
        akash.add("Les notes nous permettent de garantir des services de qualité aux clients   comme aux prestatires de services . Nous prenons les notes très au sérieux. Les prestataires de services mal notés peuvent se voir refuser l'accès à l'application Homejek.\n" +
                "\n" +
                "NOTER VOTRE prestataire de services\n" +
                "Dans l'application à la fin de chaque course ou au bas de la facture reçue par e-mail, vous avez la possibilité d'attribuer 1 à 5 étoiles à votre prestataire . Vous pouvez également laisser des commentaires plus détaillés sur le service ou le prestataire par le biais d'une liste de problèmes fréquents.\n" +
                "\n" +
                "Certains problèmes ne dépendent pas de votre prestataire . Ainsi, si vous choisissez l'un de ces motifs pour justifier une mauvaise note, cela ne comptera pas dans la note globale du chauffeur.\n" +
                ".\n" +
                "\n" +
                "COMPRENDRE LES NOTES\n" +
                "Vous ne savez pas quelle note attribuer à votre ^prestataire de services  ? Voici quelques conseils :\n" +
                "– La plupart des passagers attribuent 5 étoiles à un prestataire  s'ils n'ont pas rencontré de problème particulier.\n" +
                "– Si une seule étoile est attribuée à un prestataire , cela signifie généralement qu'il y a un sérieux problème.\n");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");
        List<String> annulation = new ArrayList<String>();
        annulation.add("L’annulation ne doit pas s’effectuer après la période de grâce ( qui est la période de 15 minute après la réservation d un service ) si cela se produit le client sera pénalisé. Apres 3 pénalité le client n aura plus accès  à son compte Homejek.\n" +
                "Si le compte du client sera hors ligne après avoir réservé il aura une période de grâce  de 15 minute avant l’annulation de sa réservation.\n");
        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), akash);
        listDataChild.put(listDataHeader.get(4), annulation);


    }

}
