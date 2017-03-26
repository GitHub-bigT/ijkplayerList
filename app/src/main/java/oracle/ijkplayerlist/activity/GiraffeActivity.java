package oracle.ijkplayerlist.activity;

import oracle.ijkplayerlist.R;
import oracle.ijkplayerlist.base.BaseActivity;
import oracle.ijkplayerlist.constants.PlayerConstants;
import tcking.github.com.giraffeplayer.GiraffePlayer;

/**
 * Created by 田帅 on 2017/3/26.
 */

public class GiraffeActivity extends BaseActivity {
    private GiraffePlayer player;
    @Override
    public int initLayout() {
        return R.layout.activity_giraffe;
    }

    @Override
    public void initView() {
        player = new GiraffePlayer(this);
        player.play(PlayerConstants.VIDEO_URL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}
