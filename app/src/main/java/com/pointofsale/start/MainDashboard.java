package com.pointofsale.start;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.pointofsale.R;
import com.pointofsale.adapter.AlbumsAdapter;
import com.pointofsale.adapter.CategoriesAdapter;
import com.pointofsale.dialog.NumDialog;
import com.pointofsale.fragment.DrawerTransaction;
import com.pointofsale.fragment.Inventory;
import com.pointofsale.fragment.InvoiceFragment;
import com.pointofsale.fragment.ManageEmployee;
import com.pointofsale.fragment.ManageReason;
import com.pointofsale.fragment.OtherCharges;
import com.pointofsale.fragment.SpeedDial;
import com.pointofsale.model.Album;

import java.util.ArrayList;
import java.util.List;

public class MainDashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ImageView extra,shop,discount,discard,payment;
    ImageView nav,menu;
    static DrawerLayout drawer;
    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    ListView listView,categories;
    int x=1;
    CategoriesAdapter categoriesAdapter;
    ArrayList<String> arrayListCategories;
    static LinearLayout toolbaar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        init();
        clicks();
    }

    private void fun_firstFragment(Fragment fragment) {
        Fragment newFragment6 = fragment;
        Fragment fragment6 = newFragment6;
        FragmentTransaction fragmentTransaction6 = getFragmentManager().beginTransaction();
        fragmentTransaction6.replace(R.id.linear, fragment6, "");
        fragmentTransaction6.commitAllowingStateLoss();
    }

    public void init(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbaar1=(LinearLayout)findViewById(R.id.toolbaar1);
        listView=(ListView)findViewById(R.id.listview);
        categories=(ListView)findViewById(R.id.categories);

        extra=(ImageView)findViewById(R.id.extra);
        discard=(ImageView)findViewById(R.id.discard);
        discount=(ImageView)findViewById(R.id.discount);
        shop=(ImageView)findViewById(R.id.shop);
        payment=(ImageView)findViewById(R.id.payment);

        arrayListCategories=new ArrayList<>();
        arrayListCategories.add("All");
        arrayListCategories.add("Desert");
        arrayListCategories.add("Juice");
        arrayListCategories.add("Rice");
        arrayListCategories.add("Soft Drinks");
        arrayListCategories.add("Soups");

        categoriesAdapter= new CategoriesAdapter(this,arrayListCategories);

        categories.setAdapter(categoriesAdapter);

        nav=(ImageView)findViewById(R.id.nav);
        menu=(ImageView)findViewById(R.id.menu);

        listView=(ListView)findViewById(R.id.listview);
        categories=(ListView)findViewById(R.id.categories);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

    }

    public void clicks(){
        nav.setOnClickListener(this);
        menu.setOnClickListener(this);
        discount.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_dashboard, menu);
        return true;
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(MainDashboard.this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.main_dashboard, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.buy_now) {

            return true;
        }
        else if (id==R.id.help){

            return true;
        }
        else if (id==R.id.user_profile){

            return true;

        }
        else if (id==R.id.logout){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.invoice) {
            // Handl{}e the camera action
            if (x==1){
                drawer.closeDrawer(Gravity.LEFT);
            }
            else{
                MainDashboard.this.finish();
                startActivity(new Intent(MainDashboard.this,MainDashboard.class));
            }

           // fun_firstFragment(new InvoiceFragment());
        }
        else if (id==R.id.sales){
            x=2;
            fun_firstFragment(new Sales());

        }
        else if(id==R.id.inventory){

            x=3;
            fun_firstFragment(new Inventory());
        }

        else if(id==R.id.report){

        }
        else if (id==R.id.recipe_management){

        }
        else if (id==R.id.customer){

        }
        else if (id==R.id.customer){

        }
        else if(id==R.id.extras){

        }
        else if(id==R.id.upload){

        }
        else if (id==R.id.software_setup){

        }
        else if (id==R.id.back_office){

        }
        else if (id==R.id.activation){

        }
        else if (id==R.id.profile){

        }
        else if (id==R.id.check_update){

        }
        else if (id==R.id.about){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.nav:

        drawer.openDrawer(Gravity.LEFT);
                break;

            case R.id.menu:
                showPopup(view);
              //  MainDashboard.this.openOptionsMenu();
                break;

            case R.id.discount:

                DisplayMetrics metrics = getResources().getDisplayMetrics();
                int screenWidth = (int) (metrics.widthPixels * 0.55);
                NumDialog numDialog=new NumDialog(MainDashboard.this);
                numDialog.show();
                Window window = numDialog.getWindow();
                window.setLayout(screenWidth, ViewGroup.LayoutParams.WRAP_CONTENT);

                break;

                default:
                    break;
        }
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.cock,
                R.drawable.cock,
                R.drawable.cock,
                R.drawable.cock,
                R.drawable.cock,
                R.drawable.cock,
                R.drawable.cock,
                R.drawable.cock,
                R.drawable.cock,
                R.drawable.cock,
                R.drawable.cock};

        Album a = new Album("True Romance", 13, covers[0]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        a = new Album("Xscpae", 8, covers[1]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        a = new Album("Maroon 5", 11, covers[2]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        a = new Album("Born to Die", 12, covers[3]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        a = new Album("Honeymoon", 14, covers[4]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        a = new Album("I Need a Doctor", 1, covers[5]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        a = new Album("Loud", 11, covers[6]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        a = new Album("Legend", 14, covers[7]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        a = new Album("Hello", 11, covers[8]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        a = new Album("Greatest Hits", 17, covers[9]);
        a.setId("77");
        a.setPrice("35");
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }
    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    static public class Sales extends Fragment implements View.OnClickListener {

        Context context;
        ImageView menu,question,search,print,show_right,hide_right,nav;
        LinearLayout show_hide;
        LinearLayout past_invoice,other_charges,speed_dial,manage_reason,drawer_transaction,manage_emp,cancel_credit;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            View v = inflater.inflate(R.layout.fragment_invoice, container, false);
                context = container.getContext();

                menu = (ImageView) v.findViewById(R.id.menu);
                question = (ImageView) v.findViewById(R.id.question);
                search=(ImageView)v.findViewById(R.id.search);

                nav=(ImageView)v.findViewById(R.id.nav);
                print=(ImageView)v.findViewById(R.id.print);

                show_right=(ImageView)v.findViewById(R.id.show_right);
                hide_right=(ImageView)v.findViewById(R.id.hide_right);
                show_hide=(LinearLayout)v.findViewById(R.id.show_hide);

                past_invoice=(LinearLayout)v.findViewById(R.id.past_invoices);
                other_charges=(LinearLayout)v.findViewById(R.id.other_charges);
                speed_dial=(LinearLayout)v.findViewById(R.id.speed_dial);
                manage_reason=(LinearLayout)v.findViewById(R.id.manage_reason);
                drawer_transaction=(LinearLayout)v.findViewById(R.id.drawe_transaction);
                manage_emp=(LinearLayout)v.findViewById(R.id.manage_emp);
                cancel_credit=(LinearLayout)v.findViewById(R.id.cancel_credit);


                past_invoice.setOnClickListener(this);
                other_charges.setOnClickListener(this);
                speed_dial.setOnClickListener(this);
                manage_reason.setOnClickListener(this);
                drawer_transaction.setOnClickListener(this);
                manage_emp.setOnClickListener(this);
                cancel_credit.setOnClickListener(this);

                menu.setOnClickListener(this);
                nav.setOnClickListener(this);
                question.setOnClickListener(this);
                search.setOnClickListener(this);
                print.setOnClickListener(this);

                show_right.setOnClickListener(this);
                hide_right.setOnClickListener(this);

            return v;
        }

        public void showPopup(View v) {
            PopupMenu popup = new PopupMenu(context, v);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.main_dashboard, popup.getMenu());
            popup.show();
        }

        public void changeColor(LinearLayout linearLayout) {
            past_invoice.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
            other_charges.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
            speed_dial.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
            manage_reason.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
            drawer_transaction.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
            manage_emp.setBackgroundResource(R.drawable.rect_dark_yellow_bg);
            cancel_credit.setBackgroundResource(R.drawable.rect_dark_yellow_bg);

            linearLayout.setBackgroundResource(R.drawable.rect_light_yellow_bg);
        }

        @Override
        public void onClick(View view) {
            switch(view.getId()){

                case R.id.past_invoices:

                    changeColor(past_invoice);
                    fun_firstFragment(new Sales());
                    toolbaar1.setVisibility(View.GONE);
                    break;

                case R.id.other_charges:
                    changeColor(other_charges);
                    fun_firstFragment(new OtherCharges());
                    break;

                case R.id.speed_dial:
                    changeColor(speed_dial);
                    fun_firstFragment(new SpeedDial());
                    break;

                case R.id.manage_reason:

                    changeColor(manage_reason);
                    fun_firstFragment(new ManageReason());
                    break;

                case R.id.drawe_transaction:

                    changeColor(drawer_transaction);
                    fun_firstFragment(new DrawerTransaction());
                    break;

                case R.id.manage_emp:
                    changeColor(manage_emp);
                    fun_firstFragment(new ManageEmployee());
                    break;

                case R.id.cancel_credit:
                    changeColor(cancel_credit);
                    fun_firstFragment(new Sales());
                    toolbaar1.setVisibility(View.GONE);
                    break;

                case R.id.nav:
                    drawer.openDrawer(Gravity.LEFT);
                    break;

                case R.id.menu:
                    showPopup(view);
                    break;

                case R.id.question:

                    break;

                case R.id.search:

                    break;

                case R.id.print:

                    break;

                case R.id.show_right:
                    show_hide.setVisibility(View.VISIBLE);
                    break;

                case R.id.hide_right:

                    show_hide.setVisibility(View.GONE);
                    break;

                default:
                    break;
            }
        }

        private void fun_firstFragment(Fragment fragment) {
            Fragment newFragment6 = fragment;
            Fragment fragment6 = newFragment6;
            FragmentTransaction fragmentTransaction6 = getFragmentManager().beginTransaction();
//            fragmentTransaction6.setCustomAnimations(android.R.anim.fade_in,
//                    android.R.anim.fade_out);
            fragmentTransaction6.replace(R.id.relative, fragment6, "");
            fragmentTransaction6.commitAllowingStateLoss();
        }
    }
}