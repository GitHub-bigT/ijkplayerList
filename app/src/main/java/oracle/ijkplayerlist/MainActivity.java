package oracle.ijkplayerlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import oracle.ijkplayerlist.activity.IjkPlayerActivity;
import oracle.ijkplayerlist.adapter.RVMainAdapter;

public class MainActivity extends AppCompatActivity implements RVMainAdapter.OnItemClickListener {

    private RecyclerView rv_main;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("ijk原始");
    }

    private void initView() {
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        initData();
        initRecycleView();
    }

    private void initRecycleView() {
        RVMainAdapter mAdapter = new RVMainAdapter(this, mList);
        rv_main.setLayoutManager(new LinearLayoutManager(this));
        rv_main.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            //原始ijk
            case 0:
                Intent intent = new Intent(MainActivity.this, IjkPlayerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
