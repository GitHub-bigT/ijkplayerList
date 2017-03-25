package oracle.ijkplayerlist.activity;

import android.net.Uri;

import oracle.ijkplayerlist.base.BaseActivity;
import oracle.ijkplayerlist.R;

import tv.danmaku.ijk.media.player.widget.IjkVideoView;

/**
 * Created by 田帅 on 2017/3/25.
 */

public class IjkPlayerActivity extends BaseActivity {

    private IjkVideoView ijk_video_view;


    @Override
    public int initLayout() {
        return R.layout.activity_ijk;
    }

    @Override
    public void initView() {
        ijk_video_view = (IjkVideoView) findViewById(R.id.ijk_video_view);
        initIjk();
    }

    private void initIjk() {
        ijk_video_view.setVideoURI(Uri.parse("http://zv.3gv.ifeng.com/live/zhongwen800k.m3u8"));
        ijk_video_view.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ijk_video_view.stopPlayback();
    }
}
