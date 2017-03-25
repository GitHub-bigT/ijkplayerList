package oracle.ijkplayerlist.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import oracle.ijkplayerlist.R;
import oracle.ijkplayerlist.adapter.RVMainAdapter;
import oracle.ijkplayerlist.base.BaseActivity;

public class MainActivity extends BaseActivity implements RVMainAdapter.OnItemClickListener {

    private RecyclerView rv_main;
    private List<String> mList;


    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        initData();
        initRecycleView();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("ijk原始");
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
