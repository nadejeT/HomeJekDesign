package Adapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.homejek.ui.MainActivity;
import com.homejek.ui.R;

import java.util.ArrayList;

import Models.HomeListView;
import fragments.BabysittingList;
import fragments.Gender;
import fragments.Home;
import fragments.RatingFrag;

public class HomeListViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<HomeListView> HomeListViewArrayList;

    public HomeListViewAdapter(Context context, ArrayList<HomeListView> HomeListViewArrayList) {
        this.context = context;
        this.HomeListViewArrayList = HomeListViewArrayList;
    }


    @Override
    public int getCount() {
        return HomeListViewArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return HomeListViewArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHoder viewHoder;
        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.homelistview, parent, false);

            viewHoder = new ViewHoder();


            viewHoder.image = (ImageView) convertView.findViewById(R.id.market);
            viewHoder.title = (TextView) convertView.findViewById(R.id.sport);
            viewHoder.description = (TextView) convertView.findViewById(R.id.desc);
            viewHoder.state = convertView.findViewById(R.id.state);
            viewHoder.stateicon = convertView.findViewById(R.id.stateicon);
            viewHoder.parentLayout = convertView.findViewById(R.id.parentlayout);

            convertView.setTag(viewHoder);

        } else {

            viewHoder = (ViewHoder) convertView.getTag();
        }


        HomeListView HomeListViewItem = (HomeListView) getItem(position);

        viewHoder.title.setText(HomeListViewItem.getTitle());
        viewHoder.description.setText(HomeListViewItem.getDescription());
        viewHoder.state.setText(HomeListViewItem.getState());

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), HomeListViewItem.getImage());
        ///////////////////IMAGEBITMAP///////////////////
        viewHoder.stateicon.setImageResource(HomeListViewItem.getStateIcon());
       viewHoder.image.setImageBitmap(getRoundedCornerBitmap(bitmap, 20));

       viewHoder.parentLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(HomeListViewArrayList.get(position).getTitle().equals("Coiffure")){
                   Log.e("COIFFURE",HomeListViewArrayList.get(position).getTitle());

                   Gender genderfrag = new Gender();
                   ((MainActivity)context).getSupportFragmentManager()
                           .beginTransaction().addToBackStack("fragment")
                           .replace(R.id.container, new fragments.Gender()).commit();

               }
               if(HomeListViewArrayList.get(position).getTitle().equals("Babysitting")){
                   Log.e("BabySitting",HomeListViewArrayList.get(position).getTitle());

                   BabysittingList babysitting = new BabysittingList();
                   ((MainActivity)context).getSupportFragmentManager()
                           .beginTransaction().addToBackStack("fragment")
                           .replace(R.id.container, new fragments.BabysittingList()).commit();

               }

               if(HomeListViewArrayList.get(position).getTitle().equals("Courses")){
                   Log.e("Rating",HomeListViewArrayList.get(position).getTitle());

                   RatingFrag ratingfrag = new RatingFrag();
                   ((MainActivity)context).getSupportFragmentManager()
                           .beginTransaction().addToBackStack("fragment")
                           .replace(R.id.container, new fragments.RatingFrag()).commit();

               }
               if(HomeListViewArrayList.get(position).getTitle().equals("Garde Malade")){
                   Log.e("Rating",HomeListViewArrayList.get(position).getTitle());

                   RatingFrag ratingfrag = new RatingFrag();
                   ((MainActivity)context).getSupportFragmentManager()
                           .beginTransaction().addToBackStack("fragment")
                           .replace(R.id.container, new fragments.GardeMaladeList()).commit();

               }
               if(HomeListViewArrayList.get(position).getTitle().equals("Nettoyage")){
                   Log.e("Rating",HomeListViewArrayList.get(position).getTitle());

                   RatingFrag ratingfrag = new RatingFrag();
                   ((MainActivity)context).getSupportFragmentManager()
                           .beginTransaction().addToBackStack("fragment")
                           .replace(R.id.container, new fragments.Nettoyage()).commit();

               }


           }
       });

        return convertView;

    }


    private class ViewHoder{

        ImageView image;
        TextView title;
        TextView description;
        ImageView stateicon;
        TextView state;
        LinearLayout parentLayout;



    }


  public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }


}
