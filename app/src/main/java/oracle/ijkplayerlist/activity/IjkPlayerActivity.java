package oracle.ijkplayerlist.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import oracle.ijkplayerlist.R;
import tv.danmaku.ijk.media.player.widget.IRenderView;
import tv.danmaku.ijk.media.player.widget.IjkVideoView;

/**
 * Created by 田帅 on 2017/3/25.
 */

public class IjkPlayerActivity extends Activity {

    private IjkVideoView ijk_video_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ijk);
        initView();
    }

    private void initView() {
        ijk_video_view = (IjkVideoView) findViewById(R.id.ijk_video_view);
        initIjk();
    }

    private void initIjk() {
//        ijk_video_view.setAspectRatio(IRenderView.AR_ASPECT_FIT_PARENT);
        ijk_video_view.setVideoURI(Uri.parse("http://zv.3gv.ifeng.com/live/zhongwen800k.m3u8"));
        ijk_video_view.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ijk_video_view.stopPlayback();
    }
}
