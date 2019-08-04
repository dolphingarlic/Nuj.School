package com.example.nuj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnNewGoal;
    private ImageButton btnHelpOthers;
    private ImageButton btnGetHelp;
    private ImageButton btnAbout;
    private ArrayAdapter<String> mAdapter;
    RecyclerView goalsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Accesses the user's data and goals from the user text file and goals database
        ManageTextFile textFile = new ManageTextFile();
        textFile.readUserInfo(this);
        ManageDatabase db = new ManageDatabase(this);


        // Instantiates a user object using the user's info stored in the text file
        User user = new User(
                textFile.getUserName(),
                textFile.getBirthday(),
                textFile.getJoinedDate(),
                db.getAllGoals(),
                db.getCompletedGoals(),
                db.getOngoingGoals());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the RecyclerView to its corresponding view
        goalsRecyclerView = findViewById(R.id.recyclerViewTasks);

        // Set the layout for the RecyclerView to be a linear layout, which measures and
        // positions items within a RecyclerView into a linear list
        goalsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter and attach it to the RecyclerView
        mAdapter = new ArrayAdapter<>(this,
                R.layout.item_todo, // what view to use for the items
                R.id.task_title, // where to put the String of data
                taskList); // where to get all the data

        goalsRecyclerView.setAdapter(mAdapter); // set it as the adapter of the ListView instance

        /*
         Add a touch helper to the RecyclerView to recognize when a user swipes to delete an item.
         An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
         and uses callbacks to signal when a user is performing these actions.
         */
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            // Called when a user swipes left or right on a ViewHolder
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                // Here is where you'll implement swipe to delete

                // COMPLETED (1) Construct the URI for the item to delete
                //[Hint] Use getTag (from the adapter code) to get the id of the swiped item
                // Retrieve the id of the task to delete
                int id = (int) viewHolder.itemView.getTag();

                // Build appropriate uri with String row id appended
                String stringId = Integer.toString(id);
                Uri uri = TaskContract.TaskEntry.CONTENT_URI;
                uri = uri.buildUpon().appendPath(stringId).build();

                // COMPLETED (2) Delete a single row of data using a ContentResolver
                getContentResolver().delete(uri, null, null);

                // COMPLETED (3) Restart the loader to re-query for all tasks after a deletion
                getSupportLoaderManager().restartLoader(TASK_LOADER_ID, null, MainActivity.this);

                Toast.makeText(getBaseContext(), "yeah! you completed it!", Toast.LENGTH_SHORT).show();

            }
        }).attachToRecyclerView(goalsRecyclerView);



        // Set buttons to their corresponding views
        btnNewGoal = findViewById(R.id.btnNewGoal);
        btnHelpOthers = findViewById(R.id.btnHelpOthers);
        btnGetHelp = findViewById(R.id.btnGetHelp);
        btnAbout = findViewById(R.id.btnAbout);

        // Button click allows user to add a new goal
        btnNewGoal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                toNewGoal();
            }
        });

        // Button click takes user to Help Others screen
        btnHelpOthers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                toHelpOthers();
            }
        });

        // Button click takes user to Get Help screen
        btnGetHelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                toGetHelp();
            }
        });

        // Button click takes user to About screen
        btnAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                toAbout();
            }
        });

    }

    // This method is called after this activity has been paused or restarted.
    // Often, this is after new data has been inserted through an AddTaskActivity,
    // so this restarts the loader to re-query the underlying data for any changes.
    @Override
    protected void onResume() {
        super.onResume();

        // re-queries for all tasks
        getSupportLoaderManager().restartLoader(TASK_LOADER_ID, null, this);
    }

    private void updateUI() {

        ManageDatabase db = new ManageDatabase(this);
        ArrayList<String> goalList = new ArrayList<>();

        for (int i = 1; i <= db.getOngoingGoals().size(); i++) {
            goalList.add(db.getGoalDescription(i));
        }

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_todo,
                    R.id.task_title,
                    goalList);
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(goalList);
            mAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }

    // Links button to New Goal screen
    public void toNewGoal(){
        Intent intent = new Intent(this, NewGoal.class);
        startActivity(intent);
    }

    // Links button to Get Help screen
    public void toGetHelp(){
        Intent intent = new Intent(this, GetHelp.class);
        startActivity(intent);
    }

    // Links button to About screen
    public void toAbout(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    // Links button to Help Others screen
    public void toHelpOthers(){
        Intent intent = new Intent(this, HelpOthers.class);
        startActivity(intent);
    }

    // Stops the user from navigating back to the login screen
    @Override
    public void onBackPressed() {
    }

}
