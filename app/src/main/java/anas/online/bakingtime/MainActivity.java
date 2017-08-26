package anas.online.bakingtime;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    int screenWidth;

    private RecyclerView recyclerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        screenWidth = getResources().getConfiguration().screenWidthDp;
        recyclerView = findViewById(R.id.recipes_recycler_view);
        setLayoutManager();
        recyclerView.setAdapter(new RecipesAdapter(DummyContent.ITEMS));
    }

    /* A helper method that sets the right layout based on screen width */
    private void setLayoutManager() {
        if (screenWidth <= 600) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, setColumnCount()));
        }
    }

    /*A helper method that returns the appropriate number of columns based on physical
    screen width*/
    private int setColumnCount() {
        if ((screenWidth > 600) && (screenWidth <= 840)) {
            return 2;
        } else if ((screenWidth > 840) && (screenWidth <= 1200)) {
            return 3;
        } else {
            return 4;
        }
    }
}
