package com.example.mclane.listexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Person> people;
    private ListView peopleListView;
    ArrayAdapter<Person> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        createPeople();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, people);
        peopleListView.setAdapter(adapter);
        registerForContextMenu(peopleListView);
        peopleListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Intent person = new Intent(MainActivity.this, PersonActivity.class);
                person.putExtra("person", people.get(pos));
                startActivity(person);
            }
        });
    }

    private void createPeople() {
        people = new ArrayList<>();
        people.add(new Person("Harry Styles", "    A former singer from the band One Direction.", R.drawable.harry_styles, 2));
        people.add(new Person("Louis Tomlinson", "    A former singer of the band One Direction.", R.drawable.loius_tomlinson, 4));
        people.add(new Person("Nial Horan", "    A former singer of the band One Direction.", R.drawable.nial_horan, 3));
        people.add(new Person("Liam Payne", "    A former singer of the band One Direction.", R.drawable.liam_payne, 1));
        people.add(new Person("Zayn Malik", "    A former singer of the band One Direction.", R.drawable.zayn_malik, 7));
        people.add(new Person("Jared Kushner", "    Son-in-law of President Trump.", R.drawable.jared_kushner, 5));
        people.add(new Person("Ryan Eggold", "    An actor know for his role as Tom Keen in the Blacklist.", R.drawable.ryan_eggold, 6));
        //Collections.sort(people);
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getName().toUpperCase().compareTo(t1.getName().toUpperCase());
            }
        });

    }

    private void wireWidgets() {
        peopleListView = (ListView) findViewById(R.id.listview_person);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_sort_name:
                sortByName();
                return true;
            case R.id.menu_sort_rank:
                sortByRank();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void sortByRank() {
        Collections.sort(people);
        adapter.notifyDataSetChanged();
    }

    private void sortByName() {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getName().toUpperCase().compareTo(t1.getName().toUpperCase());
            }
        });
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }
}
