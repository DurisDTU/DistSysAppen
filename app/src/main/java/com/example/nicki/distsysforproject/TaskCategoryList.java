package com.example.nicki.distsysforproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nicki.distsysforproject.src.main.java.DatabaseController.DALException;
import com.example.nicki.distsysforproject.src.main.java.DatabaseController.MySQLTaskDAO;
import com.example.nicki.distsysforproject.src.main.java.DatabaseController.TaskDTO;


import java.util.ArrayList;

/**
 * Created by nicki on 3/12/17.
 */

public class TaskCategoryList extends AppCompatActivity {
    ListView lv;
    String tag;
    MySQLTaskDAO taskDAO = new MySQLTaskDAO();
    TaskDTO taskDTO = new TaskDTO();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist);

        lv =(ListView)findViewById(R.id.tasks);
        lv.setClickable(true);
        //Get all tag through Lambda function and display them in the ListView.


        try {
            lv.setAdapter(new ArrayAdapter< String >(this, R.layout.tasklist, taskDAO.getTaskList(taskDTO.)));
        } catch (DALException e) {
            e.printStackTrace();
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {
                //Sets the tag, which determines what list will be shown in the next activity.
                setTag((String)arg0.getItemAtPosition(position));

                Intent i = new Intent(getApplicationContext(),TaskList.class);
                startActivity(i);

            }

        });
    }

    public String getTag() {
        return tag;
    }

    private void setTag(String tag) {
        this.tag = tag;
    }

    public void taskList1() throws DALException {
        for (int i = 0; i > taskDAO.getTaskList().size(); i++){

        }
    }

}
