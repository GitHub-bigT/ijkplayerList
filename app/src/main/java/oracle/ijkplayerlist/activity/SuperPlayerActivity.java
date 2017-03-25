package oracle.ijkplayerlist.activity;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.superplayer.library.SuperPlayer;

import oracle.ijkplayerlist.R;
import oracle.ijkplayerlist.base.BaseActivity;
import oracle.ijkplayerlist.constants.PlayerConstants;
import oracle.ijkplayerlist.utils.ScreenUtils;

/**
 * Created by 田帅 on 2017/3/25.
 */

public class SuperPlayerActivity extends BaseActivity implements SuperPlayer.OnNetChangeListener{

    private SuperPlayer view_super_player;

    @Override
    public int initLayout() {
        return R.layout.activity_superplayer;
    }

    @Override
    public void initView() {
        view_super_player = (SuperPlayer) findViewById(R.id.view_super_player);
        /**
         * 设置player的宽高为 16:9
         */
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ScreenUtils.getScreenWidth(this),ScreenUtils.getScreenWidth(this)*9/16);
        view_super_player.setLayoutParams(lp);
        initPlayer();
    }

    private void initPlayer() {
        view_super_player.setNetChangeListener(true)//设置监听手机网络的变化
                .setOnNetChangeListener(this)//实现网络变化的回调
                .onPrepared(new SuperPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared() {
                        /**
                         * 监听视频是否已经准备完成开始播放。（可以在这里处理视频封面的显示跟隐藏）
                         */
                    }
                }).onComplete(new Runnable() {
            @Override
            public void run() {
                /**
                 * 监听视频是否已经播放完成了。（可以在这里处理视频播放完成进行的操作）
                 */
            }
        }).onInfo(new SuperPlayer.OnInfoListener() {
            @Override
            public void onInfo(int what, int extra) {
                /**
                 * 监听视频的相关信息。
                 */

            }
        }).onError(new SuperPlayer.OnErrorListener() {
            @Override
            public void onError(int what, int extra) {
                /**
                 * 监听视频播放失败的回调
                 */

            }
        }).setTitle(PlayerConstants.VIDEO_URL)//设置视频的titleName
                .play(PlayerConstants.VIDEO_URL);//开始播放视频
        view_super_player.setScaleType(SuperPlayer.SCALETYPE_FITXY);
//        view_super_player.setPlayerWH(0,view_super_player.getMeasuredHeight());//设置竖屏的时候屏幕的高度，如果不设置会切换后按照16:9的高度重置
        /**
         * 设置player翻转回来之后的宽高为16:9
         */
        view_super_player.setPlayerWH(ScreenUtils.getScreenWidth(this),ScreenUtils.getScreenWidth(this)*9/16);//设置竖屏的时候屏幕的高度，如果不设置会切换后按照16:9的高度重置
    }

    /**
     * 网络链接监听类
     */
    @Override
    public void onWifi() {
        Toast.makeText(this,"当前网络环境是WIFI",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMobile() {
        Toast.makeText(this,"当前网络环境是手机网络",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDisConnect() {
        Toast.makeText(this,"网络链接断开",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoAvailable() {
        Toast.makeText(this,"无网络链接",Toast.LENGTH_SHORT).show();
    }

    /**
     * 下面的这几个Activity的生命状态很重要
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (view_super_player != null) {
            view_super_player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (view_super_player != null) {
            view_super_player.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (view_super_player != null) {
            view_super_player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (view_super_player != null) {
            view_super_player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (view_super_player != null && view_super_player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

}
