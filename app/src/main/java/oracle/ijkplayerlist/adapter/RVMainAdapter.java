package oracle.ijkplayerlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import oracle.ijkplayerlist.R;

/**
 * Created by 田帅 on 2017/3/25.
 */

public class RVMainAdapter extends RecyclerView.Adapter<RVMainAdapter.MyViewHolder>{
    private Context context;
    private List<String> list;

    public RVMainAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder vh = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item,null));
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_rv_item.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_rv_item;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_rv_item = (TextView) itemView.findViewById(R.id.tv_rv_item);
        }
    }
}
